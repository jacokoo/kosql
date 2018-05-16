package com.github.jacokoo.kosql.spring.jdbc

import com.github.jacokoo.kosql.compose.Database
import com.github.jacokoo.kosql.compose.SQLBuilder
import com.github.jacokoo.kosql.compose.SQLBuilderContext
import com.github.jacokoo.kosql.compose.statements.DeleteStatement
import com.github.jacokoo.kosql.compose.statements.InsertStatement
import com.github.jacokoo.kosql.compose.statements.SelectStatement
import com.github.jacokoo.kosql.compose.statements.UpdateStatement
import com.github.jacokoo.kosql.executor.ResultSetMapper
import com.github.jacokoo.kosql.executor.ResultSetRow
import com.github.jacokoo.kosql.executor.Shortcut
import com.github.jacokoo.kosql.executor.typesafe.Queries
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.support.GeneratedKeyHolder
import org.springframework.jdbc.support.KeyHolder
import java.sql.Connection
import java.sql.ResultSet
import java.sql.Statement

open class KoSQL(
    private val database: Database,
    private val jdbc: JdbcTemplate,
    private val builder: SQLBuilder = SQLBuilder()
): Queries, Shortcut {

    override fun execute(update: UpdateStatement): Int = builder.build(update).let { (sql, context) ->
        jdbc.update { it.prepareStatement(sql).also { context.fillArguments(it) } }
    }

    override fun execute(delete: DeleteStatement): Int = builder.build(delete).let { (sql, context) ->
        jdbc.update { it.prepareStatement(sql).also { context.fillArguments(it) } }
    }

    override fun <T> execute(insert: InsertStatement<T>): Pair<T, Int> = builder.build(insert).let { (sql, context) ->
        val pk = (context.statement as InsertStatement<*>).data.table.primaryKey()
        if (pk.autoIncrement)
            executeInsertWithKey(sql, context).let { (key, rows) ->
                key.keyList.first().let { pk.type.fromDb(it.values.first()) as T } to rows
            }
        else (pk.type.nullValue as T) to executeInsert(sql, context)
    }

    override fun <T> executeBatch(insert: InsertStatement<T>): Pair<List<T>, Int> = builder.build(insert).let { (sql, context) ->
        val pk = (context.statement as InsertStatement<*>).data.table.primaryKey()
        if (pk.autoIncrement)
            executeInsertWithKey(sql, context).let { (key, rows) ->
                @Suppress("UNCHECKED_CAST")
                key.keyList.map { pk.type.fromDb(it.values.first()) as T } to rows
            }
        else listOf<T>() to executeInsert(sql, context)
    }

    override fun <T> execute(select: SelectStatement, mapper: ResultSetMapper<T>): List<T> = builder.build(select).let { (sql, context) ->
        jdbc.execute { conn: Connection ->
            conn.prepareStatement(sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.CLOSE_CURSORS_AT_COMMIT
            ).also { context.fillArguments(it) }.executeQuery().let {
                mutableListOf<T>().apply {
                    val row = ResultSetRow(it)
                    while (it.next()) this.add(mapper.map(row))
                }
            }
        }!!
    }


    private fun executeInsertWithKey(sql: String, context: SQLBuilderContext): Pair<KeyHolder, Int> =
        GeneratedKeyHolder().let { it to jdbc.update({
            it.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS).also {
                context.fillArguments(it)
            }
        }, it) }

    private fun executeInsert(sql: String, context: SQLBuilderContext): Int =
        jdbc.update { it.prepareStatement(sql).also { context.fillArguments(it) } }
}
