package com.github.jacokoo.kosql.compose.typesafe

import com.github.jacokoo.kosql.compose.Column
import com.github.jacokoo.kosql.compose.statements.Select
import com.github.jacokoo.kosql.compose.statements.SelectData
import com.github.jacokoo.kosql.compose.statements.SelectFromOperate

data class SelectStatement1<T1>(override val data: SelectData<Column1<T1>>): SelectFromOperate<Column1<T1>>
data class SelectStatement2<T1, T2>(override val data: SelectData<Column2<T1, T2>>): SelectFromOperate<Column2<T1, T2>>
data class SelectStatement3<T1, T2, T3>(override val data: SelectData<Column3<T1, T2, T3>>): SelectFromOperate<Column3<T1, T2, T3>>
data class SelectStatement4<T1, T2, T3, T4>(override val data: SelectData<Column4<T1, T2, T3, T4>>): SelectFromOperate<Column4<T1, T2, T3, T4>>
data class SelectStatement5<T1, T2, T3, T4, T5>(override val data: SelectData<Column5<T1, T2, T3, T4, T5>>): SelectFromOperate<Column5<T1, T2, T3, T4, T5>>
data class SelectStatement6<T1, T2, T3, T4, T5, T6>(override val data: SelectData<Column6<T1, T2, T3, T4, T5, T6>>): SelectFromOperate<Column6<T1, T2, T3, T4, T5, T6>>
data class SelectStatement7<T1, T2, T3, T4, T5, T6, T7>(override val data: SelectData<Column7<T1, T2, T3, T4, T5, T6, T7>>): SelectFromOperate<Column7<T1, T2, T3, T4, T5, T6, T7>>
data class SelectStatement8<T1, T2, T3, T4, T5, T6, T7, T8>(override val data: SelectData<Column8<T1, T2, T3, T4, T5, T6, T7, T8>>): SelectFromOperate<Column8<T1, T2, T3, T4, T5, T6, T7, T8>>
data class SelectStatement9<T1, T2, T3, T4, T5, T6, T7, T8, T9>(override val data: SelectData<Column9<T1, T2, T3, T4, T5, T6, T7, T8, T9>>): SelectFromOperate<Column9<T1, T2, T3, T4, T5, T6, T7, T8, T9>>
data class SelectStatement10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>(override val data: SelectData<Column10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>>): SelectFromOperate<Column10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>>
data class SelectStatement11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>(override val data: SelectData<Column11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>>): SelectFromOperate<Column11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>>
data class SelectStatement12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>(override val data: SelectData<Column12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>>): SelectFromOperate<Column12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>>
data class SelectStatement13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>(override val data: SelectData<Column13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>>): SelectFromOperate<Column13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>>
data class SelectStatement14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>(override val data: SelectData<Column14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>>): SelectFromOperate<Column14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>>
data class SelectStatement15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>(override val data: SelectData<Column15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>>): SelectFromOperate<Column15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>>
data class SelectStatement16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>(override val data: SelectData<Column16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>>): SelectFromOperate<Column16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>>
data class SelectStatement17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>(override val data: SelectData<Column17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>>): SelectFromOperate<Column17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>>
data class SelectStatement18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>(override val data: SelectData<Column18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>>): SelectFromOperate<Column18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>>
data class SelectStatement19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>(override val data: SelectData<Column19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>>): SelectFromOperate<Column19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>>
data class SelectStatement20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>(override val data: SelectData<Column20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>>): SelectFromOperate<Column20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>>
data class SelectStatement21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>(override val data: SelectData<Column21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>>): SelectFromOperate<Column21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>>
data class SelectStatement22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>(override val data: SelectData<Column22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>>): SelectFromOperate<Column22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>>

interface Selects: Select {
    fun <T1> SELECT(c1: Column<T1>) =  SELECT(Column1(c1))
    fun <T1> SELECT(c: Column1<T1>) =  SelectStatement1(SelectData(c))

    fun <T1, T2> SELECT(c1: Column<T1>, c2: Column<T2>) =  SELECT(Column2(c1, c2))
    fun <T1, T2> SELECT(c: Column2<T1, T2>) =  SelectStatement2(SelectData(c))

    fun <T1, T2, T3> SELECT(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>) =  SELECT(Column3(c1, c2, c3))
    fun <T1, T2, T3> SELECT(c: Column3<T1, T2, T3>) =  SelectStatement3(SelectData(c))

    fun <T1, T2, T3, T4> SELECT(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>) =  SELECT(Column4(c1, c2, c3, c4))
    fun <T1, T2, T3, T4> SELECT(c: Column4<T1, T2, T3, T4>) =  SelectStatement4(SelectData(c))

    fun <T1, T2, T3, T4, T5> SELECT(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>) =  SELECT(Column5(c1, c2, c3, c4, c5))
    fun <T1, T2, T3, T4, T5> SELECT(c: Column5<T1, T2, T3, T4, T5>) =  SelectStatement5(SelectData(c))

    fun <T1, T2, T3, T4, T5, T6> SELECT(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>) =  SELECT(Column6(c1, c2, c3, c4, c5, c6))
    fun <T1, T2, T3, T4, T5, T6> SELECT(c: Column6<T1, T2, T3, T4, T5, T6>) =  SelectStatement6(SelectData(c))

    fun <T1, T2, T3, T4, T5, T6, T7> SELECT(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>) =  SELECT(Column7(c1, c2, c3, c4, c5, c6, c7))
    fun <T1, T2, T3, T4, T5, T6, T7> SELECT(c: Column7<T1, T2, T3, T4, T5, T6, T7>) =  SelectStatement7(SelectData(c))

    fun <T1, T2, T3, T4, T5, T6, T7, T8> SELECT(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>) =  SELECT(Column8(c1, c2, c3, c4, c5, c6, c7, c8))
    fun <T1, T2, T3, T4, T5, T6, T7, T8> SELECT(c: Column8<T1, T2, T3, T4, T5, T6, T7, T8>) =  SelectStatement8(SelectData(c))

    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9> SELECT(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>) =  SELECT(Column9(c1, c2, c3, c4, c5, c6, c7, c8, c9))
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9> SELECT(c: Column9<T1, T2, T3, T4, T5, T6, T7, T8, T9>) =  SelectStatement9(SelectData(c))

    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> SELECT(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>) =  SELECT(Column10(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10))
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> SELECT(c: Column10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>) =  SelectStatement10(SelectData(c))

    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> SELECT(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>) =  SELECT(Column11(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11))
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> SELECT(c: Column11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>) =  SelectStatement11(SelectData(c))

    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> SELECT(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>) =  SELECT(Column12(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12))
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> SELECT(c: Column12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>) =  SelectStatement12(SelectData(c))

    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> SELECT(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>) =  SELECT(Column13(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13))
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> SELECT(c: Column13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>) =  SelectStatement13(SelectData(c))

    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> SELECT(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>) =  SELECT(Column14(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14))
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> SELECT(c: Column14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>) =  SelectStatement14(SelectData(c))

    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> SELECT(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>, c15: Column<T15>) =  SELECT(Column15(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15))
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> SELECT(c: Column15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>) =  SelectStatement15(SelectData(c))

    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> SELECT(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>, c15: Column<T15>, c16: Column<T16>) =  SELECT(Column16(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16))
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> SELECT(c: Column16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>) =  SelectStatement16(SelectData(c))

    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> SELECT(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>, c15: Column<T15>, c16: Column<T16>, c17: Column<T17>) =  SELECT(Column17(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17))
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> SELECT(c: Column17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>) =  SelectStatement17(SelectData(c))

    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> SELECT(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>, c15: Column<T15>, c16: Column<T16>, c17: Column<T17>, c18: Column<T18>) =  SELECT(Column18(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18))
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> SELECT(c: Column18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>) =  SelectStatement18(SelectData(c))

    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> SELECT(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>, c15: Column<T15>, c16: Column<T16>, c17: Column<T17>, c18: Column<T18>, c19: Column<T19>) =  SELECT(Column19(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19))
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> SELECT(c: Column19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>) =  SelectStatement19(SelectData(c))

    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> SELECT(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>, c15: Column<T15>, c16: Column<T16>, c17: Column<T17>, c18: Column<T18>, c19: Column<T19>, c20: Column<T20>) =  SELECT(Column20(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20))
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> SELECT(c: Column20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>) =  SelectStatement20(SelectData(c))

    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> SELECT(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>, c15: Column<T15>, c16: Column<T16>, c17: Column<T17>, c18: Column<T18>, c19: Column<T19>, c20: Column<T20>, c21: Column<T21>) =  SELECT(Column21(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21))
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> SELECT(c: Column21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>) =  SelectStatement21(SelectData(c))

    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> SELECT(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>, c15: Column<T15>, c16: Column<T16>, c17: Column<T17>, c18: Column<T18>, c19: Column<T19>, c20: Column<T20>, c21: Column<T21>, c22: Column<T22>) =  SELECT(Column22(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21, c22))
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> SELECT(c: Column22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>) =  SelectStatement22(SelectData(c))
}
