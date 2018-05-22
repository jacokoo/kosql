package com.github.jacokoo.kosql.executor.typesafe

import com.github.jacokoo.kosql.compose.ParameterHolder
import com.github.jacokoo.kosql.compose.typesafe.*
import com.github.jacokoo.kosql.executor.SelectTemplate
import com.github.jacokoo.kosql.executor.SelectTemplateSupport
import com.github.jacokoo.kosql.executor.TemplateValue

data class SelectTemplate1<T1>(override val statement: SelectStatement1<T1>, override val sql: String, override val params: ParameterHolder): SelectTemplate
data class SelectTemplate2<T1, T2>(override val statement: SelectStatement2<T1, T2>, override val sql: String, override val params: ParameterHolder): SelectTemplate
data class SelectTemplate3<T1, T2, T3>(override val statement: SelectStatement3<T1, T2, T3>, override val sql: String, override val params: ParameterHolder): SelectTemplate
data class SelectTemplate4<T1, T2, T3, T4>(override val statement: SelectStatement4<T1, T2, T3, T4>, override val sql: String, override val params: ParameterHolder): SelectTemplate
data class SelectTemplate5<T1, T2, T3, T4, T5>(override val statement: SelectStatement5<T1, T2, T3, T4, T5>, override val sql: String, override val params: ParameterHolder): SelectTemplate
data class SelectTemplate6<T1, T2, T3, T4, T5, T6>(override val statement: SelectStatement6<T1, T2, T3, T4, T5, T6>, override val sql: String, override val params: ParameterHolder): SelectTemplate
data class SelectTemplate7<T1, T2, T3, T4, T5, T6, T7>(override val statement: SelectStatement7<T1, T2, T3, T4, T5, T6, T7>, override val sql: String, override val params: ParameterHolder): SelectTemplate
data class SelectTemplate8<T1, T2, T3, T4, T5, T6, T7, T8>(override val statement: SelectStatement8<T1, T2, T3, T4, T5, T6, T7, T8>, override val sql: String, override val params: ParameterHolder): SelectTemplate
data class SelectTemplate9<T1, T2, T3, T4, T5, T6, T7, T8, T9>(override val statement: SelectStatement9<T1, T2, T3, T4, T5, T6, T7, T8, T9>, override val sql: String, override val params: ParameterHolder): SelectTemplate
data class SelectTemplate10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>(override val statement: SelectStatement10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>, override val sql: String, override val params: ParameterHolder): SelectTemplate
data class SelectTemplate11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>(override val statement: SelectStatement11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>, override val sql: String, override val params: ParameterHolder): SelectTemplate
data class SelectTemplate12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>(override val statement: SelectStatement12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>, override val sql: String, override val params: ParameterHolder): SelectTemplate
data class SelectTemplate13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>(override val statement: SelectStatement13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>, override val sql: String, override val params: ParameterHolder): SelectTemplate
data class SelectTemplate14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>(override val statement: SelectStatement14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>, override val sql: String, override val params: ParameterHolder): SelectTemplate
data class SelectTemplate15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>(override val statement: SelectStatement15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>, override val sql: String, override val params: ParameterHolder): SelectTemplate
data class SelectTemplate16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>(override val statement: SelectStatement16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>, override val sql: String, override val params: ParameterHolder): SelectTemplate
data class SelectTemplate17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>(override val statement: SelectStatement17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>, override val sql: String, override val params: ParameterHolder): SelectTemplate
data class SelectTemplate18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>(override val statement: SelectStatement18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>, override val sql: String, override val params: ParameterHolder): SelectTemplate
data class SelectTemplate19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>(override val statement: SelectStatement19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>, override val sql: String, override val params: ParameterHolder): SelectTemplate
data class SelectTemplate20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>(override val statement: SelectStatement20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>, override val sql: String, override val params: ParameterHolder): SelectTemplate
data class SelectTemplate21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>(override val statement: SelectStatement21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>, override val sql: String, override val params: ParameterHolder): SelectTemplate
data class SelectTemplate22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>(override val statement: SelectStatement22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>, override val sql: String, override val params: ParameterHolder): SelectTemplate

interface SelectTemplateSupports: SelectTemplateSupport {
    fun <T1> SelectStatement1<T1>.template() = builder.build(this).let { SelectTemplate1(this, it.sql, it.params) }
    fun <T1> SelectTemplate1<T1>.fetch(vararg values: TemplateValue) = SelectResult1(statement.c, fetch(SelectResultMapper1(statement.c), *values))

    fun <T1, T2> SelectStatement2<T1, T2>.template() = builder.build(this).let { SelectTemplate2(this, it.sql, it.params) }
    fun <T1, T2> SelectTemplate2<T1, T2>.fetch(vararg values: TemplateValue) = SelectResult2(statement.c, fetch(SelectResultMapper2(statement.c), *values))

    fun <T1, T2, T3> SelectStatement3<T1, T2, T3>.template() = builder.build(this).let { SelectTemplate3(this, it.sql, it.params) }
    fun <T1, T2, T3> SelectTemplate3<T1, T2, T3>.fetch(vararg values: TemplateValue) = SelectResult3(statement.c, fetch(SelectResultMapper3(statement.c), *values))

    fun <T1, T2, T3, T4> SelectStatement4<T1, T2, T3, T4>.template() = builder.build(this).let { SelectTemplate4(this, it.sql, it.params) }
    fun <T1, T2, T3, T4> SelectTemplate4<T1, T2, T3, T4>.fetch(vararg values: TemplateValue) = SelectResult4(statement.c, fetch(SelectResultMapper4(statement.c), *values))

    fun <T1, T2, T3, T4, T5> SelectStatement5<T1, T2, T3, T4, T5>.template() = builder.build(this).let { SelectTemplate5(this, it.sql, it.params) }
    fun <T1, T2, T3, T4, T5> SelectTemplate5<T1, T2, T3, T4, T5>.fetch(vararg values: TemplateValue) = SelectResult5(statement.c, fetch(SelectResultMapper5(statement.c), *values))

    fun <T1, T2, T3, T4, T5, T6> SelectStatement6<T1, T2, T3, T4, T5, T6>.template() = builder.build(this).let { SelectTemplate6(this, it.sql, it.params) }
    fun <T1, T2, T3, T4, T5, T6> SelectTemplate6<T1, T2, T3, T4, T5, T6>.fetch(vararg values: TemplateValue) = SelectResult6(statement.c, fetch(SelectResultMapper6(statement.c), *values))

    fun <T1, T2, T3, T4, T5, T6, T7> SelectStatement7<T1, T2, T3, T4, T5, T6, T7>.template() = builder.build(this).let { SelectTemplate7(this, it.sql, it.params) }
    fun <T1, T2, T3, T4, T5, T6, T7> SelectTemplate7<T1, T2, T3, T4, T5, T6, T7>.fetch(vararg values: TemplateValue) = SelectResult7(statement.c, fetch(SelectResultMapper7(statement.c), *values))

    fun <T1, T2, T3, T4, T5, T6, T7, T8> SelectStatement8<T1, T2, T3, T4, T5, T6, T7, T8>.template() = builder.build(this).let { SelectTemplate8(this, it.sql, it.params) }
    fun <T1, T2, T3, T4, T5, T6, T7, T8> SelectTemplate8<T1, T2, T3, T4, T5, T6, T7, T8>.fetch(vararg values: TemplateValue) = SelectResult8(statement.c, fetch(SelectResultMapper8(statement.c), *values))

    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9> SelectStatement9<T1, T2, T3, T4, T5, T6, T7, T8, T9>.template() = builder.build(this).let { SelectTemplate9(this, it.sql, it.params) }
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9> SelectTemplate9<T1, T2, T3, T4, T5, T6, T7, T8, T9>.fetch(vararg values: TemplateValue) = SelectResult9(statement.c, fetch(SelectResultMapper9(statement.c), *values))

    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> SelectStatement10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>.template() = builder.build(this).let { SelectTemplate10(this, it.sql, it.params) }
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> SelectTemplate10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>.fetch(vararg values: TemplateValue) = SelectResult10(statement.c, fetch(SelectResultMapper10(statement.c), *values))

    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> SelectStatement11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>.template() = builder.build(this).let { SelectTemplate11(this, it.sql, it.params) }
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> SelectTemplate11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>.fetch(vararg values: TemplateValue) = SelectResult11(statement.c, fetch(SelectResultMapper11(statement.c), *values))

    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> SelectStatement12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>.template() = builder.build(this).let { SelectTemplate12(this, it.sql, it.params) }
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> SelectTemplate12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>.fetch(vararg values: TemplateValue) = SelectResult12(statement.c, fetch(SelectResultMapper12(statement.c), *values))

    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> SelectStatement13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>.template() = builder.build(this).let { SelectTemplate13(this, it.sql, it.params) }
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> SelectTemplate13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>.fetch(vararg values: TemplateValue) = SelectResult13(statement.c, fetch(SelectResultMapper13(statement.c), *values))

    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> SelectStatement14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>.template() = builder.build(this).let { SelectTemplate14(this, it.sql, it.params) }
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> SelectTemplate14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>.fetch(vararg values: TemplateValue) = SelectResult14(statement.c, fetch(SelectResultMapper14(statement.c), *values))

    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> SelectStatement15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>.template() = builder.build(this).let { SelectTemplate15(this, it.sql, it.params) }
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> SelectTemplate15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>.fetch(vararg values: TemplateValue) = SelectResult15(statement.c, fetch(SelectResultMapper15(statement.c), *values))

    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> SelectStatement16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>.template() = builder.build(this).let { SelectTemplate16(this, it.sql, it.params) }
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> SelectTemplate16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>.fetch(vararg values: TemplateValue) = SelectResult16(statement.c, fetch(SelectResultMapper16(statement.c), *values))

    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> SelectStatement17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>.template() = builder.build(this).let { SelectTemplate17(this, it.sql, it.params) }
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> SelectTemplate17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>.fetch(vararg values: TemplateValue) = SelectResult17(statement.c, fetch(SelectResultMapper17(statement.c), *values))

    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> SelectStatement18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>.template() = builder.build(this).let { SelectTemplate18(this, it.sql, it.params) }
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> SelectTemplate18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>.fetch(vararg values: TemplateValue) = SelectResult18(statement.c, fetch(SelectResultMapper18(statement.c), *values))

    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> SelectStatement19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>.template() = builder.build(this).let { SelectTemplate19(this, it.sql, it.params) }
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> SelectTemplate19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>.fetch(vararg values: TemplateValue) = SelectResult19(statement.c, fetch(SelectResultMapper19(statement.c), *values))

    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> SelectStatement20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>.template() = builder.build(this).let { SelectTemplate20(this, it.sql, it.params) }
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> SelectTemplate20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>.fetch(vararg values: TemplateValue) = SelectResult20(statement.c, fetch(SelectResultMapper20(statement.c), *values))

    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> SelectStatement21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>.template() = builder.build(this).let { SelectTemplate21(this, it.sql, it.params) }
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> SelectTemplate21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>.fetch(vararg values: TemplateValue) = SelectResult21(statement.c, fetch(SelectResultMapper21(statement.c), *values))

    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> SelectStatement22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>.template() = builder.build(this).let { SelectTemplate22(this, it.sql, it.params) }
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> SelectTemplate22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>.fetch(vararg values: TemplateValue) = SelectResult22(statement.c, fetch(SelectResultMapper22(statement.c), *values))

}
