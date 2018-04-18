package com.github.jacokoo.ksql

import com.github.jacokoo.ksql.mapping.Entity
import com.github.jacokoo.ksql.statements.QueryData
import com.github.jacokoo.ksql.statements.SQLBuilder
import com.github.jacokoo.ksql.statements.SelectResult
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

class KSQL(private val dataSource: DataSource): Query() {
    private val builder = SQLBuilder()

    fun <T1: Any> SelectResult<T1>.execute(): QueryResult1<T1> {
        val result = builder.build(this)
        val conn = dataSource.connection
        val st = conn.prepareStatement(result.sql)
        println(result.sql)
        result.context.arguments.forEachIndexed {idx, value -> st.setObject(idx + 1, value)}
        val resultSet = st.executeQuery()

        val list = mutableListOf<ResultRow<T1>>()
        while (resultSet.next()) {
            list.add(ResultRow(this.c1, this.c1.type.fromDb(resultSet.getObject(1))))
        }
        return QueryResult1(this.c1, list)
    }

    fun hello() {
        val a= SelectResult(Count<Int>(""), QueryData(listOf()))
        a.execute()
    }
}