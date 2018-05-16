package com.github.jacokoo.kosql.compose.typesafe

import com.github.jacokoo.kosql.compose.Column
import com.github.jacokoo.kosql.compose.statements.*

data class SelectStatement1<T1>(val c: Column1<T1>, override val data: SelectData): SelectStatement
data class SelectStatement2<T1, T2>(val c: Column2<T1, T2>, override val data: SelectData): SelectStatement
data class SelectStatement3<T1, T2, T3>(val c: Column3<T1, T2, T3>, override val data: SelectData): SelectStatement
data class SelectStatement4<T1, T2, T3, T4>(val c: Column4<T1, T2, T3, T4>, override val data: SelectData): SelectStatement
data class SelectStatement5<T1, T2, T3, T4, T5>(val c: Column5<T1, T2, T3, T4, T5>, override val data: SelectData): SelectStatement
data class SelectStatement6<T1, T2, T3, T4, T5, T6>(val c: Column6<T1, T2, T3, T4, T5, T6>, override val data: SelectData): SelectStatement
data class SelectStatement7<T1, T2, T3, T4, T5, T6, T7>(val c: Column7<T1, T2, T3, T4, T5, T6, T7>, override val data: SelectData): SelectStatement
data class SelectStatement8<T1, T2, T3, T4, T5, T6, T7, T8>(val c: Column8<T1, T2, T3, T4, T5, T6, T7, T8>, override val data: SelectData): SelectStatement
data class SelectStatement9<T1, T2, T3, T4, T5, T6, T7, T8, T9>(val c: Column9<T1, T2, T3, T4, T5, T6, T7, T8, T9>, override val data: SelectData): SelectStatement
data class SelectStatement10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>(val c: Column10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>, override val data: SelectData): SelectStatement
data class SelectStatement11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>(val c: Column11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>, override val data: SelectData): SelectStatement
data class SelectStatement12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>(val c: Column12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>, override val data: SelectData): SelectStatement
data class SelectStatement13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>(val c: Column13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>, override val data: SelectData): SelectStatement
data class SelectStatement14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>(val c: Column14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>, override val data: SelectData): SelectStatement
data class SelectStatement15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>(val c: Column15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>, override val data: SelectData): SelectStatement
data class SelectStatement16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>(val c: Column16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>, override val data: SelectData): SelectStatement
data class SelectStatement17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>(val c: Column17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>, override val data: SelectData): SelectStatement
data class SelectStatement18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>(val c: Column18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>, override val data: SelectData): SelectStatement
data class SelectStatement19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>(val c: Column19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>, override val data: SelectData): SelectStatement
data class SelectStatement20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>(val c: Column20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>, override val data: SelectData): SelectStatement
data class SelectStatement21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>(val c: Column21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>, override val data: SelectData): SelectStatement
data class SelectStatement22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>(val c: Column22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>, override val data: SelectData): SelectStatement

interface Selects: Select {
    fun <T1> SELECT(c1: Column<T1>, block: SelectCreator) =  SelectStatement1(Column1(c1), SelectFromPart(c1).block().data)
    fun <T1> SELECT(c: Column1<T1>, block: SelectCreator) =  SelectStatement1(c, SelectFromPart(c).block().data)

    fun <T1, T2> SELECT(c1: Column<T1>, c2: Column<T2>, block: SelectCreator) =  SelectStatement2(Column2(c1, c2), SelectFromPart(c1, c2).block().data)
    fun <T1, T2> SELECT(c: Column2<T1, T2>, block: SelectCreator) =  SelectStatement2(c, SelectFromPart(c).block().data)

    fun <T1, T2, T3> SELECT(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, block: SelectCreator) =  SelectStatement3(Column3(c1, c2, c3), SelectFromPart(c1, c2, c3).block().data)
    fun <T1, T2, T3> SELECT(c: Column3<T1, T2, T3>, block: SelectCreator) =  SelectStatement3(c, SelectFromPart(c).block().data)

    fun <T1, T2, T3, T4> SELECT(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, block: SelectCreator) =  SelectStatement4(Column4(c1, c2, c3, c4), SelectFromPart(c1, c2, c3, c4).block().data)
    fun <T1, T2, T3, T4> SELECT(c: Column4<T1, T2, T3, T4>, block: SelectCreator) =  SelectStatement4(c, SelectFromPart(c).block().data)

    fun <T1, T2, T3, T4, T5> SELECT(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, block: SelectCreator) =  SelectStatement5(Column5(c1, c2, c3, c4, c5), SelectFromPart(c1, c2, c3, c4, c5).block().data)
    fun <T1, T2, T3, T4, T5> SELECT(c: Column5<T1, T2, T3, T4, T5>, block: SelectCreator) =  SelectStatement5(c, SelectFromPart(c).block().data)

    fun <T1, T2, T3, T4, T5, T6> SELECT(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, block: SelectCreator) =  SelectStatement6(Column6(c1, c2, c3, c4, c5, c6), SelectFromPart(c1, c2, c3, c4, c5, c6).block().data)
    fun <T1, T2, T3, T4, T5, T6> SELECT(c: Column6<T1, T2, T3, T4, T5, T6>, block: SelectCreator) =  SelectStatement6(c, SelectFromPart(c).block().data)

    fun <T1, T2, T3, T4, T5, T6, T7> SELECT(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, block: SelectCreator) =  SelectStatement7(Column7(c1, c2, c3, c4, c5, c6, c7), SelectFromPart(c1, c2, c3, c4, c5, c6, c7).block().data)
    fun <T1, T2, T3, T4, T5, T6, T7> SELECT(c: Column7<T1, T2, T3, T4, T5, T6, T7>, block: SelectCreator) =  SelectStatement7(c, SelectFromPart(c).block().data)

    fun <T1, T2, T3, T4, T5, T6, T7, T8> SELECT(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, block: SelectCreator) =  SelectStatement8(Column8(c1, c2, c3, c4, c5, c6, c7, c8), SelectFromPart(c1, c2, c3, c4, c5, c6, c7, c8).block().data)
    fun <T1, T2, T3, T4, T5, T6, T7, T8> SELECT(c: Column8<T1, T2, T3, T4, T5, T6, T7, T8>, block: SelectCreator) =  SelectStatement8(c, SelectFromPart(c).block().data)

    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9> SELECT(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, block: SelectCreator) =  SelectStatement9(Column9(c1, c2, c3, c4, c5, c6, c7, c8, c9), SelectFromPart(c1, c2, c3, c4, c5, c6, c7, c8, c9).block().data)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9> SELECT(c: Column9<T1, T2, T3, T4, T5, T6, T7, T8, T9>, block: SelectCreator) =  SelectStatement9(c, SelectFromPart(c).block().data)

    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> SELECT(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, block: SelectCreator) =  SelectStatement10(Column10(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10), SelectFromPart(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10).block().data)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> SELECT(c: Column10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>, block: SelectCreator) =  SelectStatement10(c, SelectFromPart(c).block().data)

    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> SELECT(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, block: SelectCreator) =  SelectStatement11(Column11(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11), SelectFromPart(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11).block().data)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> SELECT(c: Column11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>, block: SelectCreator) =  SelectStatement11(c, SelectFromPart(c).block().data)

    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> SELECT(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, block: SelectCreator) =  SelectStatement12(Column12(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12), SelectFromPart(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12).block().data)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> SELECT(c: Column12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>, block: SelectCreator) =  SelectStatement12(c, SelectFromPart(c).block().data)

    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> SELECT(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, block: SelectCreator) =  SelectStatement13(Column13(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13), SelectFromPart(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13).block().data)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> SELECT(c: Column13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>, block: SelectCreator) =  SelectStatement13(c, SelectFromPart(c).block().data)

    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> SELECT(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>, block: SelectCreator) =  SelectStatement14(Column14(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14), SelectFromPart(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14).block().data)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> SELECT(c: Column14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>, block: SelectCreator) =  SelectStatement14(c, SelectFromPart(c).block().data)

    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> SELECT(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>, c15: Column<T15>, block: SelectCreator) =  SelectStatement15(Column15(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15), SelectFromPart(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15).block().data)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> SELECT(c: Column15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>, block: SelectCreator) =  SelectStatement15(c, SelectFromPart(c).block().data)

    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> SELECT(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>, c15: Column<T15>, c16: Column<T16>, block: SelectCreator) =  SelectStatement16(Column16(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16), SelectFromPart(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16).block().data)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> SELECT(c: Column16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>, block: SelectCreator) =  SelectStatement16(c, SelectFromPart(c).block().data)

    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> SELECT(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>, c15: Column<T15>, c16: Column<T16>, c17: Column<T17>, block: SelectCreator) =  SelectStatement17(Column17(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17), SelectFromPart(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17).block().data)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> SELECT(c: Column17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>, block: SelectCreator) =  SelectStatement17(c, SelectFromPart(c).block().data)

    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> SELECT(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>, c15: Column<T15>, c16: Column<T16>, c17: Column<T17>, c18: Column<T18>, block: SelectCreator) =  SelectStatement18(Column18(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18), SelectFromPart(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18).block().data)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> SELECT(c: Column18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>, block: SelectCreator) =  SelectStatement18(c, SelectFromPart(c).block().data)

    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> SELECT(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>, c15: Column<T15>, c16: Column<T16>, c17: Column<T17>, c18: Column<T18>, c19: Column<T19>, block: SelectCreator) =  SelectStatement19(Column19(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19), SelectFromPart(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19).block().data)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> SELECT(c: Column19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>, block: SelectCreator) =  SelectStatement19(c, SelectFromPart(c).block().data)

    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> SELECT(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>, c15: Column<T15>, c16: Column<T16>, c17: Column<T17>, c18: Column<T18>, c19: Column<T19>, c20: Column<T20>, block: SelectCreator) =  SelectStatement20(Column20(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20), SelectFromPart(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20).block().data)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> SELECT(c: Column20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>, block: SelectCreator) =  SelectStatement20(c, SelectFromPart(c).block().data)

    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> SELECT(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>, c15: Column<T15>, c16: Column<T16>, c17: Column<T17>, c18: Column<T18>, c19: Column<T19>, c20: Column<T20>, c21: Column<T21>, block: SelectCreator) =  SelectStatement21(Column21(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21), SelectFromPart(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21).block().data)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> SELECT(c: Column21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>, block: SelectCreator) =  SelectStatement21(c, SelectFromPart(c).block().data)

    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> SELECT(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>, c15: Column<T15>, c16: Column<T16>, c17: Column<T17>, c18: Column<T18>, c19: Column<T19>, c20: Column<T20>, c21: Column<T21>, c22: Column<T22>, block: SelectCreator) =  SelectStatement22(Column22(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21, c22), SelectFromPart(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21, c22).block().data)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> SELECT(c: Column22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>, block: SelectCreator) =  SelectStatement22(c, SelectFromPart(c).block().data)
}
