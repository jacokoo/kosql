package com.github.jacokoo.kosql.spring.jdbc

import com.github.jacokoo.kosql.compose.Composer
import com.github.jacokoo.kosql.compose.Database
import com.github.jacokoo.kosql.compose.ParameterHolder
import com.github.jacokoo.kosql.compose.SQLBuilder
import com.github.jacokoo.kosql.compose.statements.DeleteStatement
import com.github.jacokoo.kosql.compose.statements.InsertStatement
import com.github.jacokoo.kosql.compose.statements.SelectStatement
import com.github.jacokoo.kosql.compose.statements.UpdateStatement
import com.github.jacokoo.kosql.executor.ResultSetMapper
import com.github.jacokoo.kosql.executor.ResultSetRow
import com.github.jacokoo.kosql.executor.Shortcut
import com.github.jacokoo.kosql.executor.typesafe.Queries
import com.github.jacokoo.kosql.executor.typesafe.SelectTemplateSupports
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.support.GeneratedKeyHolder
import org.springframework.jdbc.support.KeyHolder
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.TransactionDefinition
import org.springframework.transaction.TransactionStatus
import org.springframework.transaction.support.DefaultTransactionDefinition
import org.springframework.transaction.support.TransactionTemplate
import java.sql.Connection
import java.sql.ResultSet
import java.sql.Statement

open class KoSQL(
    private val database: Database,
    private val jdbc: JdbcTemplate,
    private val transactionManager: PlatformTransactionManager,
    override val builder: SQLBuilder = SQLBuilder()
): Composer(), Queries, Shortcut, SelectTemplateSupports {

    fun <T> tx(
        timeout: Int = TransactionDefinition.TIMEOUT_DEFAULT,
        propagation: Int = TransactionDefinition.PROPAGATION_REQUIRED,
        isolation: Int = TransactionDefinition.ISOLATION_DEFAULT,
        readonly: Boolean = false,
        block: KoSQL.(TransactionStatus) -> T
    ) = DefaultTransactionDefinition().also {
        it.timeout = timeout
        it.propagationBehavior = propagation
        it.isolationLevel = isolation
        it.isReadOnly = readonly
    }.let { TransactionTemplate(transactionManager, it).execute { this.block(it) } }

    fun <T> readonly(block: KoSQL.(TransactionStatus) -> T) = tx(readonly = true, block = block)

    override fun execute(update: UpdateStatement): Int = builder.build(update).let { (sql, params) ->
        jdbc.update { it.prepareStatement(sql).also { params.fill(it) } }
    }

    override fun execute(delete: DeleteStatement): Int = builder.build(delete).let { (sql, context) ->
        jdbc.update { it.prepareStatement(sql).also { context.fill(it) } }
    }

    override fun <T> execute(insert: InsertStatement<T>): Pair<T, Int> = builder.build(insert).let { (sql, context) ->
        val pk = insert.data.table.primaryKey()
        if (pk.autoIncrement)
            executeInsertWithKey(sql, context).let { (key, rows) ->
                key.keyList.first().let { pk.type.fromDb(it.values.first()) } to rows
            }
        else pk.type.nullValue to executeInsert(sql, context)
    }

    override fun <T> executeBatch(insert: InsertStatement<T>): Pair<List<T>, Int> = builder.build(insert).let { (sql, context) ->
        val pk = insert.data.table.primaryKey()
        if (pk.autoIncrement)
            executeInsertWithKey(sql, context).let { (key, rows) ->
                key.keyList.map { pk.type.fromDb(it.values.first()) } to rows
            }
        else listOf<T>() to executeInsert(sql, context)
    }

    override fun <T> execute(select: SelectStatement, mapper: ResultSetMapper<T>): List<T> = builder.build(select).let { (sql, context) ->
        execute(sql, context, mapper)
    }

    override fun <T> execute(sql: String, params: ParameterHolder, mapper: ResultSetMapper<T>): List<T> =
        jdbc.execute { conn: Connection ->
            conn.prepareStatement(sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.CLOSE_CURSORS_AT_COMMIT
            ).also { params.fill(it) }.executeQuery().let {
                mutableListOf<T>().apply {
                    val row = ResultSetRow(it)
                    while (it.next()) this.add(mapper.map(row))
                }
            }
        }!!


    private fun executeInsertWithKey(sql: String, params: ParameterHolder): Pair<KeyHolder, Int> =
        GeneratedKeyHolder().let { it to jdbc.update({
            it.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS).also {
                params.fill(it)
            }
        }, it) }

    private fun executeInsert(sql: String, params: ParameterHolder): Int =
        jdbc.update { it.prepareStatement(sql).also { params.fill(it) } }
}
