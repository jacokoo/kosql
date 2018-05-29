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
data class SelectTemplate11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>(override val statement: SelectStatement<Column11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>>, override val sql: String, override val params: ParameterHolder): SelectTemplate<Column11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>>
data class SelectTemplate12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>(override val statement: SelectStatement<Column12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>>, override val sql: String, override val params: ParameterHolder): SelectTemplate<Column12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>>
data class SelectTemplate13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>(override val statement: SelectStatement<Column13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>>, override val sql: String, override val params: ParameterHolder): SelectTemplate<Column13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>>
data class SelectTemplate14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>(override val statement: SelectStatement<Column14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>>, override val sql: String, override val params: ParameterHolder): SelectTemplate<Column14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>>
data class SelectTemplate15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>(override val statement: SelectStatement<Column15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>>, override val sql: String, override val params: ParameterHolder): SelectTemplate<Column15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>>
data class SelectTemplate16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>(override val statement: SelectStatement<Column16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>>, override val sql: String, override val params: ParameterHolder): SelectTemplate<Column16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>>
data class SelectTemplate17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>(override val statement: SelectStatement<Column17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>>, override val sql: String, override val params: ParameterHolder): SelectTemplate<Column17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>>
data class SelectTemplate18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>(override val statement: SelectStatement<Column18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>>, override val sql: String, override val params: ParameterHolder): SelectTemplate<Column18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>>
data class SelectTemplate19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>(override val statement: SelectStatement<Column19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>>, override val sql: String, override val params: ParameterHolder): SelectTemplate<Column19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>>
data class SelectTemplate20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>(override val statement: SelectStatement<Column20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>>, override val sql: String, override val params: ParameterHolder): SelectTemplate<Column20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>>
data class SelectTemplate21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>(override val statement: SelectStatement<Column21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>>, override val sql: String, override val params: ParameterHolder): SelectTemplate<Column21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>>
data class SelectTemplate22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>(override val statement: SelectStatement<Column22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>>, override val sql: String, override val params: ParameterHolder): SelectTemplate<Column22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>>

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

    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> SelectStatement<Column11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>>.template() = builder.build(this).let { SelectTemplate11(this, it.sql, it.params) }
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> SelectTemplate<Column11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>>.fetch(vararg values: TemplateValue) = SelectResult11(statement.data.columns, fetch(SelectResultMapper11(statement.data.columns), *values))

    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> SelectStatement<Column12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>>.template() = builder.build(this).let { SelectTemplate12(this, it.sql, it.params) }
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> SelectTemplate<Column12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>>.fetch(vararg values: TemplateValue) = SelectResult12(statement.data.columns, fetch(SelectResultMapper12(statement.data.columns), *values))

    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> SelectStatement<Column13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>>.template() = builder.build(this).let { SelectTemplate13(this, it.sql, it.params) }
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> SelectTemplate<Column13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>>.fetch(vararg values: TemplateValue) = SelectResult13(statement.data.columns, fetch(SelectResultMapper13(statement.data.columns), *values))

    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> SelectStatement<Column14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>>.template() = builder.build(this).let { SelectTemplate14(this, it.sql, it.params) }
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> SelectTemplate<Column14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>>.fetch(vararg values: TemplateValue) = SelectResult14(statement.data.columns, fetch(SelectResultMapper14(statement.data.columns), *values))

    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> SelectStatement<Column15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>>.template() = builder.build(this).let { SelectTemplate15(this, it.sql, it.params) }
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> SelectTemplate<Column15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>>.fetch(vararg values: TemplateValue) = SelectResult15(statement.data.columns, fetch(SelectResultMapper15(statement.data.columns), *values))

    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> SelectStatement<Column16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>>.template() = builder.build(this).let { SelectTemplate16(this, it.sql, it.params) }
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> SelectTemplate<Column16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>>.fetch(vararg values: TemplateValue) = SelectResult16(statement.data.columns, fetch(SelectResultMapper16(statement.data.columns), *values))

    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> SelectStatement<Column17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>>.template() = builder.build(this).let { SelectTemplate17(this, it.sql, it.params) }
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> SelectTemplate<Column17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>>.fetch(vararg values: TemplateValue) = SelectResult17(statement.data.columns, fetch(SelectResultMapper17(statement.data.columns), *values))

    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> SelectStatement<Column18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>>.template() = builder.build(this).let { SelectTemplate18(this, it.sql, it.params) }
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> SelectTemplate<Column18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>>.fetch(vararg values: TemplateValue) = SelectResult18(statement.data.columns, fetch(SelectResultMapper18(statement.data.columns), *values))

    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> SelectStatement<Column19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>>.template() = builder.build(this).let { SelectTemplate19(this, it.sql, it.params) }
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> SelectTemplate<Column19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>>.fetch(vararg values: TemplateValue) = SelectResult19(statement.data.columns, fetch(SelectResultMapper19(statement.data.columns), *values))

    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> SelectStatement<Column20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>>.template() = builder.build(this).let { SelectTemplate20(this, it.sql, it.params) }
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> SelectTemplate<Column20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>>.fetch(vararg values: TemplateValue) = SelectResult20(statement.data.columns, fetch(SelectResultMapper20(statement.data.columns), *values))

    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> SelectStatement<Column21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>>.template() = builder.build(this).let { SelectTemplate21(this, it.sql, it.params) }
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> SelectTemplate<Column21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>>.fetch(vararg values: TemplateValue) = SelectResult21(statement.data.columns, fetch(SelectResultMapper21(statement.data.columns), *values))

    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> SelectStatement<Column22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>>.template() = builder.build(this).let { SelectTemplate22(this, it.sql, it.params) }
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> SelectTemplate<Column22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>>.fetch(vararg values: TemplateValue) = SelectResult22(statement.data.columns, fetch(SelectResultMapper22(statement.data.columns), *values))

}
