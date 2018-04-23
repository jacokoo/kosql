package com.github.jacokoo.kosql

import com.github.jacokoo.kosql.mapping.ResultSetMapper
import com.github.jacokoo.kosql.mapping.ResultSetRow
import com.github.jacokoo.kosql.statements.QueryPart
import com.github.jacokoo.kosql.statements.SQLBuilder
import com.github.jacokoo.kosql.statements.Selects
import com.github.jacokoo.kosql.statements.UpdatePart
import org.springframework.jdbc.core.JdbcTemplate
import java.sql.Connection
import java.sql.ResultSet
import javax.sql.DataSource


open class KoSQL(
        private val dataSource: DataSource,
        private val jdbc: JdbcTemplate,
        private val builder: SQLBuilder = SQLBuilder()
): Query(), Selects {

    operator fun <T: Table<*>, R> T.invoke(block: T.() -> R): R {
        return block()
    }

    override fun <T> execute(qp: QueryPart, mapper: ResultSetMapper<T>): List<T> {
        val (sql, context) = builder.build(qp)
        println(sql)
        return jdbc.execute { conn: Connection ->
            conn.prepareStatement(sql,
                    ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_READ_ONLY,
                    ResultSet.CLOSE_CURSORS_AT_COMMIT
            ).also {
                context.arguments.forEachIndexed {idx, value -> it.setObject(idx + 1, value)}
            }.executeQuery().let {
                mutableListOf<T>().apply {
                    val row = ResultSetRow(it)
                    while (it.next()) this.add(mapper.map(row))
                }
            }
        }!!
    }

    fun UpdatePart.execute(): Int {
        val (sql, context) = builder.build(this)
        println(sql)
        return jdbc.update {
            it.prepareStatement(sql).also {
                context.arguments.forEachIndexed {idx, value -> it.setObject(idx + 1, value)}
            }
        }
    }

}