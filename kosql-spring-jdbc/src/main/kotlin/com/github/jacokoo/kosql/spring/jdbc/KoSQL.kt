package com.github.jacokoo.kosql.spring.jdbc

import com.github.jacokoo.kosql.compose.*
import com.github.jacokoo.kosql.compose.statements.*
import com.github.jacokoo.kosql.compose.typesafe.ColumnList
import com.github.jacokoo.kosql.executor.ResultSetMapper
import com.github.jacokoo.kosql.executor.ResultSetRow
import com.github.jacokoo.kosql.executor.SelectTemplate
import com.github.jacokoo.kosql.executor.Shortcut
import com.github.jacokoo.kosql.executor.typesafe.Queries
import com.github.jacokoo.kosql.executor.typesafe.SelectTemplateSupports
import org.springframework.jdbc.core.BatchPreparedStatementSetter
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.support.GeneratedKeyHolder
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.TransactionDefinition
import org.springframework.transaction.TransactionStatus
import org.springframework.transaction.support.DefaultTransactionDefinition
import org.springframework.transaction.support.TransactionTemplate
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.Statement

open class KoSQL(
    private val database: Database,
    private val jdbc: JdbcTemplate,
    private val transactionManager: PlatformTransactionManager,
    override val builder: SQLBuilder = SQLBuilder()
): Composer(), Queries, Shortcut, SelectTemplateSupports {

    companion object {
        private val LOG = createLogger(this::class)
    }

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

    fun <T: ColumnList, R: SelectStatement<T>> template(block: KoSQL.() -> R): SelectTemplate<T> = this.block().template()

    override fun execute(update: UpdateStatement): Int = builder.build(update).let { (sql, params) ->
        LOG.debug("execute update: {}", sql)
        jdbc.update { it.prepareStatement(sql).also { params.fill(it) } }
    }

    override fun execute(delete: DeleteStatement): Int = builder.build(delete).let { (sql, context) ->
        LOG.debug("execute delete: {}", sql)
        jdbc.update { it.prepareStatement(sql).also { context.fill(it) } }
    }

    override fun <T> execute(insert: InsertStatement<T>): Pair<T, Int> = builder.build(insert).let { (sql, context) ->
        LOG.debug("execute insert: {}", sql)
        val pk = insert.data.table.primaryKey()
        if (pk.autoIncrement)
            GeneratedKeyHolder().let { it to jdbc.update({
                it.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS).also {
                    context.fill(it)
                }
            }, it) }.let { (key, rows) ->
                key.keyList.first().let { pk.type.fromDb(it.values.first()) } to rows
            }
        else pk.type.nullValue to jdbc.update { it.prepareStatement(sql).also { context.fill(it) } }
    }

    override fun <T> execute(insert: BatchInsertStatement<T>): Int = builder.build(insert).let { (sql, context) ->
        LOG.debug("execute batch insert: {}", sql)
        val params = context as BatchParameterHolder
        jdbc.batchUpdate(sql, object: BatchPreparedStatementSetter {
            override fun getBatchSize() = params.size()
            override fun setValues(ps: PreparedStatement, i: Int) = params.fill(ps, i)
        }).fold(0) {acc, item -> acc + item}
    }

    override fun <T, R: ColumnList> execute(select: SelectStatement<R>, mapper: ResultSetMapper<T>): List<T> = builder.build(select).let { (sql, context) ->
        execute(sql, context, mapper)
    }

    override fun <T> execute(sql: String, params: ParameterHolder, mapper: ResultSetMapper<T>): List<T> {
        LOG.debug("execute select: {}", sql)
        return jdbc.execute { conn: Connection ->
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
    }

}
