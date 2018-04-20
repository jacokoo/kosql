package com.github.jacokoo.kosql

import com.github.jacokoo.kosql.mapping.QueryResult1
import com.github.jacokoo.kosql.mapping.QueryResults
import com.github.jacokoo.kosql.mapping.ResultRows
import com.github.jacokoo.kosql.mapping.to1
import com.github.jacokoo.kosql.statements.*
import org.springframework.jdbc.core.JdbcTemplate
import java.sql.Connection
import java.sql.ResultSet
import javax.sql.DataSource


open class KoSQL(
        private val dataSource: DataSource,
        private val jdbc: JdbcTemplate,
        private val builder: SQLBuilder = SQLBuilder()
): Query() {

    fun SelectStatement.fetch(): QueryResults = execute(this)
    fun <T1: Any> SelectStatement1<T1>.fetch(): QueryResult1<T1> = execute(this).to1()

    protected fun execute(qp: QueryPart): QueryResults {
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
                val cs = (context.statement as QueryPart).data.columns
                var list = mutableListOf<ResultRows>()
                while (it.next()) list.add(ResultRows(cs.mapIndexed { i, c -> c.type.fromDb(it.getObject(i + 1)) }))
                QueryResults(cs, list)
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