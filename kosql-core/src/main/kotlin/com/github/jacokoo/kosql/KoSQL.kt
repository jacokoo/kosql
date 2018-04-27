package com.github.jacokoo.kosql

import com.github.jacokoo.kosql.mapping.*
import com.github.jacokoo.kosql.statements.*
import com.github.jacokoo.kosql.typesafe.Selects
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
): Query(), Selects, Shortcuts {

    override fun <T> execute(qp: QueryPart, mapper: ResultSetMapper<T>): List<T> =
        builder.build(qp).let { (sql, context) ->
            println(sql)
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

    fun UpdatePart.execute(): Int =
        builder.build(this).let { (sql, context) ->
            println(sql)
            jdbc.update { it.prepareStatement(sql).also { context.fillArguments(it) } }
        }

    fun <T> InsertPart<T>.executeBatch(): Pair<List<T>, Int> = executeBatchInsert(this)

    fun <T> InsertPart<T>.execute(): Pair<T, Int> = executeInsert(this)

    fun <T> executeBatchInsert(part: InsertPart<T>): Pair<List<T>, Int> =
        builder.build(part).let { (sql, context) ->
            println(sql)
            val pk = (context.statement as InsertPart<*>).data.table.primaryKey()
            if (pk.autoIncrement)
                executeInsertWithKey(sql, context).let { (key, rows) ->
                    @Suppress("UNCHECKED_CAST")
                    key.keyList.map { pk.type.fromDb(it.values.first()) as T } to rows
                }
            else listOf<T>() to executeInsert(sql, context)
        }

    @Suppress("UNCHECKED_CAST")
    override fun <T> executeInsert(part: InsertPart<T>): Pair<T, Int> =
        builder.build(part).let { (sql, context) ->
            println(sql)
            val pk = (context.statement as InsertPart<*>).data.table.primaryKey()
            if (pk.autoIncrement)
                executeInsertWithKey(sql, context).let { (key, rows) ->
                    key.keyList.first().let { pk.type.fromDb(it.values.first()) as T } to rows
                }
            else (pk.type.nullValue as T) to executeInsert(sql, context)
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