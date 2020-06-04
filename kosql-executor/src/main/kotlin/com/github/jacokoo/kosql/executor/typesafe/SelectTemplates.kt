package com.github.jacokoo.kosql.executor.typesafe

import com.github.jacokoo.kosql.compose.ParameterHolder
import com.github.jacokoo.kosql.compose.statements.SelectStatement
import com.github.jacokoo.kosql.compose.typesafe.*
import com.github.jacokoo.kosql.executor.SelectTemplate
import com.github.jacokoo.kosql.executor.SelectTemplateSupport
import com.github.jacokoo.kosql.executor.TemplateValue

data class SelectTemplate1<T1>(override val statement: SelectStatement<Column1<T1>>, override val sql: String, override val params: ParameterHolder): SelectTemplate<Column1<T1>>
data class SelectTemplate2<T1, T2>(override val statement: SelectStatement<Column2<T1, T2>>, override val sql: String, override val params: ParameterHolder): SelectTemplate<Column2<T1, T2>>
data class SelectTemplate3<T1, T2, T3>(override val statement: SelectStatement<Column3<T1, T2, T3>>, override val sql: String, override val params: ParameterHolder): SelectTemplate<Column3<T1, T2, T3>>
data class SelectTemplate4<T1, T2, T3, T4>(override val statement: SelectStatement<Column4<T1, T2, T3, T4>>, override val sql: String, override val params: ParameterHolder): SelectTemplate<Column4<T1, T2, T3, T4>>
data class SelectTemplate5<T1, T2, T3, T4, T5>(override val statement: SelectStatement<Column5<T1, T2, T3, T4, T5>>, override val sql: String, override val params: ParameterHolder): SelectTemplate<Column5<T1, T2, T3, T4, T5>>
data class SelectTemplate6<T1, T2, T3, T4, T5, T6>(override val statement: SelectStatement<Column6<T1, T2, T3, T4, T5, T6>>, override val sql: String, override val params: ParameterHolder): SelectTemplate<Column6<T1, T2, T3, T4, T5, T6>>
data class SelectTemplate7<T1, T2, T3, T4, T5, T6, T7>(override val statement: SelectStatement<Column7<T1, T2, T3, T4, T5, T6, T7>>, override val sql: String, override val params: ParameterHolder): SelectTemplate<Column7<T1, T2, T3, T4, T5, T6, T7>>
data class SelectTemplate8<T1, T2, T3, T4, T5, T6, T7, T8>(override val statement: SelectStatement<Column8<T1, T2, T3, T4, T5, T6, T7, T8>>, override val sql: String, override val params: ParameterHolder): SelectTemplate<Column8<T1, T2, T3, T4, T5, T6, T7, T8>>
data class SelectTemplate9<T1, T2, T3, T4, T5, T6, T7, T8, T9>(override val statement: SelectStatement<Column9<T1, T2, T3, T4, T5, T6, T7, T8, T9>>, override val sql: String, override val params: ParameterHolder): SelectTemplate<Column9<T1, T2, T3, T4, T5, T6, T7, T8, T9>>
data class SelectTemplate10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>(override val statement: SelectStatement<Column10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>>, override val sql: String, override val params: ParameterHolder): SelectTemplate<Column10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>>

interface SelectTemplateSupports: SelectTemplateSupport {
    fun <T1> SelectStatement<Column1<T1>>.template() = builder.build(this).let { SelectTemplate1(this, it.sql, it.params) }
    fun <T1> SelectTemplate<Column1<T1>>.fetch(vararg values: TemplateValue) = SelectResult1(statement.data.columns, fetch(SelectResultMapper1(statement.data.columns), *values))

    fun <T1, T2> SelectStatement<Column2<T1, T2>>.template() = builder.build(this).let { SelectTemplate2(this, it.sql, it.params) }
    fun <T1, T2> SelectTemplate<Column2<T1, T2>>.fetch(vararg values: TemplateValue) = SelectResult2(statement.data.columns, fetch(SelectResultMapper2(statement.data.columns), *values))

    fun <T1, T2, T3> SelectStatement<Column3<T1, T2, T3>>.template() = builder.build(this).let { SelectTemplate3(this, it.sql, it.params) }
    fun <T1, T2, T3> SelectTemplate<Column3<T1, T2, T3>>.fetch(vararg values: TemplateValue) = SelectResult3(statement.data.columns, fetch(SelectResultMapper3(statement.data.columns), *values))

    fun <T1, T2, T3, T4> SelectStatement<Column4<T1, T2, T3, T4>>.template() = builder.build(this).let { SelectTemplate4(this, it.sql, it.params) }
    fun <T1, T2, T3, T4> SelectTemplate<Column4<T1, T2, T3, T4>>.fetch(vararg values: TemplateValue) = SelectResult4(statement.data.columns, fetch(SelectResultMapper4(statement.data.columns), *values))

    fun <T1, T2, T3, T4, T5> SelectStatement<Column5<T1, T2, T3, T4, T5>>.template() = builder.build(this).let { SelectTemplate5(this, it.sql, it.params) }
    fun <T1, T2, T3, T4, T5> SelectTemplate<Column5<T1, T2, T3, T4, T5>>.fetch(vararg values: TemplateValue) = SelectResult5(statement.data.columns, fetch(SelectResultMapper5(statement.data.columns), *values))

    fun <T1, T2, T3, T4, T5, T6> SelectStatement<Column6<T1, T2, T3, T4, T5, T6>>.template() = builder.build(this).let { SelectTemplate6(this, it.sql, it.params) }
    fun <T1, T2, T3, T4, T5, T6> SelectTemplate<Column6<T1, T2, T3, T4, T5, T6>>.fetch(vararg values: TemplateValue) = SelectResult6(statement.data.columns, fetch(SelectResultMapper6(statement.data.columns), *values))

    fun <T1, T2, T3, T4, T5, T6, T7> SelectStatement<Column7<T1, T2, T3, T4, T5, T6, T7>>.template() = builder.build(this).let { SelectTemplate7(this, it.sql, it.params) }
    fun <T1, T2, T3, T4, T5, T6, T7> SelectTemplate<Column7<T1, T2, T3, T4, T5, T6, T7>>.fetch(vararg values: TemplateValue) = SelectResult7(statement.data.columns, fetch(SelectResultMapper7(statement.data.columns), *values))

    fun <T1, T2, T3, T4, T5, T6, T7, T8> SelectStatement<Column8<T1, T2, T3, T4, T5, T6, T7, T8>>.template() = builder.build(this).let { SelectTemplate8(this, it.sql, it.params) }
    fun <T1, T2, T3, T4, T5, T6, T7, T8> SelectTemplate<Column8<T1, T2, T3, T4, T5, T6, T7, T8>>.fetch(vararg values: TemplateValue) = SelectResult8(statement.data.columns, fetch(SelectResultMapper8(statement.data.columns), *values))

    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9> SelectStatement<Column9<T1, T2, T3, T4, T5, T6, T7, T8, T9>>.template() = builder.build(this).let { SelectTemplate9(this, it.sql, it.params) }
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9> SelectTemplate<Column9<T1, T2, T3, T4, T5, T6, T7, T8, T9>>.fetch(vararg values: TemplateValue) = SelectResult9(statement.data.columns, fetch(SelectResultMapper9(statement.data.columns), *values))

    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> SelectStatement<Column10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>>.template() = builder.build(this).let { SelectTemplate10(this, it.sql, it.params) }
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> SelectTemplate<Column10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>>.fetch(vararg values: TemplateValue) = SelectResult10(statement.data.columns, fetch(SelectResultMapper10(statement.data.columns), *values))

}
