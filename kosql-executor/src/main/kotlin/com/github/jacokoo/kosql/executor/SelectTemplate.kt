package com.github.jacokoo.kosql.executor

import com.github.jacokoo.kosql.compose.Entity
import com.github.jacokoo.kosql.compose.ParameterHolder
import com.github.jacokoo.kosql.compose.SQLBuilder
import com.github.jacokoo.kosql.compose.statements.SelectStatement
import com.github.jacokoo.kosql.compose.typesafe.ColumnList
import java.sql.PreparedStatement
import kotlin.reflect.KClass

typealias TemplateValue = Pair<Int, Any>

class TemplateParameterHolder(val parent: ParameterHolder, val templateValues: List<TemplateValue>): ParameterHolder {
    override fun param(v: Any?) {
        parent.param(v)
    }
    override fun fill(ps: PreparedStatement) {
        parent.fill(ps)
        templateValues.forEach {(index, value) -> ps.setObject(index + 1, value)}
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

    fun <T: ColumnList> SelectStatement<T>.template() = builder.build(this).let { DefaultSelectTemplate(this, it.sql, it.params) }

    fun <T> execute(sql: String, params: ParameterHolder, mapper: ResultSetMapper<T>): List<T>

    fun <T, R: ColumnList> SelectTemplate<R>.fetch(mapper: ResultSetMapper<T>, vararg values: TemplateValue) =
        execute(sql, TemplateParameterHolder(params, values.toList()), mapper)

    fun <T, R: Entity<T>, L: ColumnList> SelectTemplate<L>.fetch(entityClass: KClass<out R>, vararg values: TemplateValue) =
        fetch(ColumnsToEntityMapper(statement.data.columns, entityClass), *values)

    fun <T, R: ColumnList> SelectTemplate<R>.fetch(mapper: (ResultSetRow) -> T, vararg values: TemplateValue): List<T> = fetch(object: ResultSetMapper<T> {
        override fun map(rs: ResultSetRow): T = mapper(rs)
    }, *values)

    fun <T: ColumnList> SelectTemplate<T>.fetch(vararg values: TemplateValue) = fetch(SelectResultsMapper(statement.data.columns), *values)
}
