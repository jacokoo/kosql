package com.github.jacokoo.kosql.execute.spring.jdbc

import com.github.jacokoo.kosql.build.*
import com.github.jacokoo.kosql.compose.Compose
import com.github.jacokoo.kosql.compose.Entity
import com.github.jacokoo.kosql.compose.Table
import com.github.jacokoo.kosql.execute.sync.Use
import com.github.jacokoo.kosql.compose.result.Mapper
import com.github.jacokoo.kosql.compose.result.Row
import com.github.jacokoo.kosql.compose.statement.*
import com.github.jacokoo.kosql.execute.sync.Dao
import org.slf4j.LoggerFactory
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
    private val jdbc: JdbcTemplate,
    private val transactionManager: PlatformTransactionManager,
    private val builder: Builder,
    private val contextFactory: (Builder) -> Context = { DefaultContext(it) }
): Dao, Use, Compose() {

    companion object {
        private val LOG = LoggerFactory.getLogger(KoSQL::class.java.name.substringBefore("\$Companion"))
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
    }.let { def -> TransactionTemplate(transactionManager, def).execute { this.block(it) } }

    fun <T> readonly(block: KoSQL.(TransactionStatus) -> T) = tx(readonly = true, block = block)

    override fun <K, T : Table<K, Entity<K>>> execute(update: UpdateStatement<K, T>): Int
            = builder.build(update, contextFactory(builder)).let { result ->
        if (LOG.isDebugEnabled) {
            LOG.debug("execute update: {}", result.sql)
            LOG.debug("execute update with params: {}", result.params.joinToString(prefix = "(", postfix = ")"))
        }

        jdbc.update { result.prepare(it) }
    }

    override fun execute(delete: DeleteStatement): Int
            = builder.build(delete, contextFactory(builder)).let { result ->
        if (LOG.isDebugEnabled) {
            LOG.debug("execute delete: {}", result.sql)
            LOG.debug("execute delete with params: {}", result.params.joinToString(prefix = "(", postfix = ")"))
        }

        jdbc.update { result.prepare(it) }
    }

    override fun <T> execute(insert: InsertStatement<T>): Pair<T, Int>
            = builder.build(insert, contextFactory(builder)).let { result ->
        if (LOG.isDebugEnabled) {
            LOG.debug("execute insert: {}", result.sql)
            LOG.debug("execute insert with params: {}", result.params.joinToString(prefix = "(", postfix = ")"))
        }
        val pk = insert.data.table.primaryKey()
        if (pk.autoIncrement)
            GeneratedKeyHolder().let { holder ->
                holder to jdbc.update({ result.prepare(it, true) }, holder)
            }.let { (key, rows) ->
                key.keyList.first().let { pk.type.fromDb(it.values.first()) } to rows
            }
        else pk.type.nullValue to jdbc.update { result.prepare(it) }
    }

    override fun <T> execute(insert: BatchInsertStatement<T>): Int
            = builder.build(insert, contextFactory(builder)).let { result ->
        if (LOG.isDebugEnabled) {
            LOG.debug("execute insert: {}", result.sql)
            LOG.debug("execute insert with params: {}", result.params.joinToString(prefix = "(", postfix = ")"))
        }
        jdbc.batchUpdate(result.sql, object: BatchPreparedStatementSetter {
            override fun getBatchSize(): Int = result.params.size
            override fun setValues(ps: PreparedStatement, i: Int) {
                (result.params[i] as List<Any?>).forEach { ps.setObject(i + 1, it) }
            }
        }).fold(0) {acc, item -> acc + item}
    }

    override fun <T, R : ColumnList> execute(select: SelectStatement<R>, mapper: Mapper<T>): List<T>
            = builder.build(select, contextFactory(builder)).let { result ->
        if (LOG.isDebugEnabled) {
            LOG.debug("execute select: {}", result.sql)
            LOG.debug("execute select with params: {}", result.params.joinToString(prefix = "(", postfix = ")"))
        }

        jdbc.execute { conn: Connection ->
            conn.prepareStatement(
                result.sql,
                ResultSet.TYPE_FORWARD_ONLY,
                ResultSet.CONCUR_READ_ONLY,
                ResultSet.CLOSE_CURSORS_AT_COMMIT
            ).apply { fill(result) }.executeQuery().let {
                mutableListOf<T>().apply {
                    val row = Row({i -> it.getObject(i + 1)}, select.data.columns)
                    while (it.next()) this.add(mapper.map(row))
                }
            }
        }
    }

    private fun BuildResult.prepare(conn: Connection, withKey: Boolean = false) = (
        if (withKey) conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        else conn.prepareStatement(sql)
    ).also { it.fill(this) }

    private fun PreparedStatement.fill(result: BuildResult) {
        result.params.forEachIndexed { idx, it -> setObject(idx + 1, it) }
    }
}

