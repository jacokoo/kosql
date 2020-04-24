package com.github.jacokoo.kosql.executor

import com.github.jacokoo.kosql.compose.*
import com.github.jacokoo.kosql.compose.statements.SelectStatement
import com.github.jacokoo.kosql.compose.typesafe.ColumnList
import java.sql.PreparedStatement
import kotlin.reflect.KClass

typealias TemplateValue = Pair<Int, Any?>

class TemplateParameterHolder(val parent: ParameterHolder, val templateValues: List<TemplateValue>): ParameterHolder {
    override fun param(v: Pair<Any?, (Any?) -> Any?>) {
        parent.param(v)
    }
    override fun fill(ps: PreparedStatement) {
        parent.fill(ps)
        if (LOG.isDebugEnabled) {
            if (templateValues.isNotEmpty()) {
                LOG.debug("override template params: {}", templateValues.map { "${it.first} - ${it.second}" }.joinToString())
            }

            val nv = templateValues.filter { it.second == null }
            if (nv.isNotEmpty()) {
                LOG.debug("override ignored: {}", nv.map { "${it.first} - ${it.second}" }.joinToString())
            }

        }
        val params = parent as DefaultParameterHolder
        templateValues.filter { it.second != null }.forEach {(index, value) -> ps.setObject(index + 1, params.getToDb(index)(value))}
    }

    companion object {
        private val LOG = createLogger(this::class)
    }
}

interface SelectTemplate<T: ColumnList> {
    val statement: SelectStatement<T>
    val sql: String
    val params: ParameterHolder
}

data class DefaultSelectTemplate<T: ColumnList>(override val statement: SelectStatement<T>, override val sql: String, override val params: ParameterHolder): SelectTemplate<T>

interface SelectTemplateSupport {
    val builder: SQLBuilder

    fun <T: ColumnList> SelectStatement<T>.template(): SelectTemplate<T> = builder.build(this).let { DefaultSelectTemplate(this, it.sql, it.params) }

    fun <T> execute(sql: String, cols: ColumnList, params: ParameterHolder, mapper: ResultSetMapper<T>): List<T>

    fun <T, R: ColumnList> SelectTemplate<R>.fetch(mapper: ResultSetMapper<T>, vararg values: TemplateValue) =
        execute(sql, statement.data.columns, TemplateParameterHolder(params, values.toList()), mapper)

    fun <T, R: Entity<T>, L: ColumnList> SelectTemplate<L>.fetch(table: Table<T, R>, vararg values: TemplateValue) =
        fetch({ it.into(table) }, *values)

    fun <T, R: ColumnList> SelectTemplate<R>.fetch(mapper: (ResultSetRow) -> T, vararg values: TemplateValue) = fetch(object: ResultSetMapper<T> {
        override fun map(rs: ResultSetRow): T = mapper(rs)
    }, *values)

    fun <T: ColumnList> SelectTemplate<T>.fetch(vararg values: TemplateValue) = fetch(SelectResultsMapper(statement.data.columns), *values)
}
