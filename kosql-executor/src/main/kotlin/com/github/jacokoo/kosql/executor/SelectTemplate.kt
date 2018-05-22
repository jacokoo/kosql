package com.github.jacokoo.kosql.executor

import com.github.jacokoo.kosql.compose.Entity
import com.github.jacokoo.kosql.compose.ParameterHolder
import com.github.jacokoo.kosql.compose.SQLBuilder
import com.github.jacokoo.kosql.compose.statements.SelectStatement
import java.sql.PreparedStatement
import kotlin.reflect.KClass

typealias TemplateValue = Pair<Int, Any>

class TemplateParameterHolder(val parent: ParameterHolder, val templateValues: List<TemplateValue>): ParameterHolder {
    override fun fill(ps: PreparedStatement) {
        parent.fill(ps)
        templateValues.forEach {(index, value) -> ps.setObject(index + 1, value)}
    }
}

interface SelectTemplate {
    val statement: SelectStatement
    val sql: String
    val params: ParameterHolder
}

data class DefaultSelectTemplate(override val statement: SelectStatement, override val sql: String, override val params: ParameterHolder): SelectTemplate

interface SelectTemplateSupport {
    val builder: SQLBuilder

    fun SelectStatement.template() = builder.build(this).let { DefaultSelectTemplate(this, it.sql, it.params) }

    fun <T> execute(sql: String, params: ParameterHolder, mapper: ResultSetMapper<T>): List<T>

    fun <T> SelectTemplate.fetch(mapper: ResultSetMapper<T>, vararg values: TemplateValue) =
        execute(sql, TemplateParameterHolder(params, values.toList()), mapper)

    fun <T, R: Entity<T>> SelectTemplate.fetch(entityClass: KClass<out R>, vararg values: TemplateValue) =
        fetch(ColumnsToEntityMapper(statement.data.columns, entityClass), *values)

    fun <T> SelectTemplate.fetch(mapper: (ResultSetRow) -> T, vararg values: TemplateValue): List<T> = fetch(object: ResultSetMapper<T> {
        override fun map(rs: ResultSetRow): T = mapper(rs)
    }, *values)

    fun SelectTemplate.fetch(vararg values: TemplateValue) = fetch(SelectResultsMapper(statement.data.columns), *values)
}
