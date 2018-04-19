package com.github.jacokoo.kosql

import com.github.jacokoo.kosql.mapping.Entity
import com.github.jacokoo.kosql.statements.SQLBuilder
import com.github.jacokoo.kosql.statements.SelectResult
import com.github.jacokoo.kosql.statements.UpdatePart
import org.springframework.jdbc.core.JdbcTemplate
import java.sql.Connection
import java.sql.ResultSet
import javax.sql.DataSource
import kotlin.reflect.KClass

class ResultRow<out T1: Any>(private val c1: Column<T1>, private val v: T1) {
    fun component1() = v

    fun <T: Entity<*>>into(clazz: KClass<T>): T {
        val entity = c1.table.create()
        if (!clazz.isInstance(entity)) throw RuntimeException("xxx")
        entity[c1.name] = v
        return entity as T
    }
}

class QueryResult1<T1: Any>(private val c1: Column<T1>, val data: List<ResultRow<T1>>) {
    fun <T: Entity<*>> into(clazz: KClass<T>): List<T> = data.map { it.into(clazz) }
}

class KoSQL(private val dataSource: DataSource, private val jdbc: JdbcTemplate): Query() {
    private val builder = SQLBuilder()

    fun <T1: Any> SelectResult<T1>.execute(): QueryResult1<T1> {
        val result = builder.build(this)
        println(result.sql)
        return jdbc.execute {conn: Connection ->
            val st = conn.prepareStatement(result.sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY, ResultSet.CLOSE_CURSORS_AT_COMMIT)
            result.context.arguments.forEachIndexed {idx, value -> st.setObject(idx + 1, value)}
            val resultSet = st.executeQuery()
            val list = mutableListOf<ResultRow<T1>>()
            while (resultSet.next()) {
                list.add(ResultRow(this.c1, this.c1.type.fromDb(resultSet.getObject(1))))
            }
             QueryResult1(this.c1, list)
        }
    }

    fun UpdatePart.execute(): Int {
        val result = builder.build(this)
        println(result.sql)
        return jdbc.update {
            val st = it.prepareStatement(result.sql)
            result.context.arguments.forEachIndexed {idx, value -> st.setObject(idx + 1, value)}
            st
        }
    }

    fun <S: Any, T: SelectResult<S>> query(block: KoSQL.() -> T): QueryResult1<S> {
        val a = block() as SelectResult<S>
        return a.execute()
    }

    fun <T: UpdatePart> update(block: KoSQL.() -> T): Int {
        return block().execute()
    }

}