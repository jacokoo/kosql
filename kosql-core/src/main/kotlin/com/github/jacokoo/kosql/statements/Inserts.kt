package com.github.jacokoo.kosql.statements

import com.github.jacokoo.kosql.Column
import com.github.jacokoo.kosql.Table
data class Field1<T1>(val table: Table<*>, val c1: Column<T1>): ExtraValues {
    override val data: InsertData = InsertData(table, listOf(c1), listOf())
    infix fun VALUES(v: Value1<T1>): Repeat1<T1> = Repeat1(append(data, v))
}
data class Value1<out T1>(val v1: T1)
data class Repeat1<in T1>(override val data: InsertData): InsertPart {
    infix fun AND(v: Value1<T1>): Repeat1<T1> = Repeat1(append(data, v.v1))
}
data class Field2<T1, T2>(val table: Table<*>, val c1: Column<T1>, val c2: Column<T2>): ExtraValues {
    override val data: InsertData = InsertData(table, listOf(c1, c2), listOf())
    infix fun VALUES(v: Value2<T1, T2>): Repeat2<T1, T2> = Repeat2(append(data, v))
}
data class Value2<out T1, out T2>(val v1: T1, val v2: T2)
data class Repeat2<in T1, in T2>(override val data: InsertData): InsertPart {
    infix fun AND(v: Value2<T1, T2>): Repeat2<T1, T2> = Repeat2(append(data, v.v1, v.v2))
}
data class Field3<T1, T2, T3>(val table: Table<*>, val c1: Column<T1>, val c2: Column<T2>, val c3: Column<T3>): ExtraValues {
    override val data: InsertData = InsertData(table, listOf(c1, c2, c3), listOf())
    infix fun VALUES(v: Value3<T1, T2, T3>): Repeat3<T1, T2, T3> = Repeat3(append(data, v))
}
data class Value3<out T1, out T2, out T3>(val v1: T1, val v2: T2, val v3: T3)
data class Repeat3<in T1, in T2, in T3>(override val data: InsertData): InsertPart {
    infix fun AND(v: Value3<T1, T2, T3>): Repeat3<T1, T2, T3> = Repeat3(append(data, v.v1, v.v2, v.v3))
}
data class Field4<T1, T2, T3, T4>(val table: Table<*>, val c1: Column<T1>, val c2: Column<T2>, val c3: Column<T3>, val c4: Column<T4>): ExtraValues {
    override val data: InsertData = InsertData(table, listOf(c1, c2, c3, c4), listOf())
    infix fun VALUES(v: Value4<T1, T2, T3, T4>): Repeat4<T1, T2, T3, T4> = Repeat4(append(data, v))
}
data class Value4<out T1, out T2, out T3, out T4>(val v1: T1, val v2: T2, val v3: T3, val v4: T4)
data class Repeat4<in T1, in T2, in T3, in T4>(override val data: InsertData): InsertPart {
    infix fun AND(v: Value4<T1, T2, T3, T4>): Repeat4<T1, T2, T3, T4> = Repeat4(append(data, v.v1, v.v2, v.v3, v.v4))
}
data class Field5<T1, T2, T3, T4, T5>(val table: Table<*>, val c1: Column<T1>, val c2: Column<T2>, val c3: Column<T3>, val c4: Column<T4>, val c5: Column<T5>): ExtraValues {
    override val data: InsertData = InsertData(table, listOf(c1, c2, c3, c4, c5), listOf())
    infix fun VALUES(v: Value5<T1, T2, T3, T4, T5>): Repeat5<T1, T2, T3, T4, T5> = Repeat5(append(data, v))
}
data class Value5<out T1, out T2, out T3, out T4, out T5>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, val v5: T5)
data class Repeat5<in T1, in T2, in T3, in T4, in T5>(override val data: InsertData): InsertPart {
    infix fun AND(v: Value5<T1, T2, T3, T4, T5>): Repeat5<T1, T2, T3, T4, T5> = Repeat5(append(data, v.v1, v.v2, v.v3, v.v4, v.v5))
}
data class Field6<T1, T2, T3, T4, T5, T6>(val table: Table<*>, val c1: Column<T1>, val c2: Column<T2>, val c3: Column<T3>, val c4: Column<T4>, val c5: Column<T5>, val c6: Column<T6>): ExtraValues {
    override val data: InsertData = InsertData(table, listOf(c1, c2, c3, c4, c5, c6), listOf())
    infix fun VALUES(v: Value6<T1, T2, T3, T4, T5, T6>): Repeat6<T1, T2, T3, T4, T5, T6> = Repeat6(append(data, v))
}
data class Value6<out T1, out T2, out T3, out T4, out T5, out T6>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, val v5: T5, val v6: T6)
data class Repeat6<in T1, in T2, in T3, in T4, in T5, in T6>(override val data: InsertData): InsertPart {
    infix fun AND(v: Value6<T1, T2, T3, T4, T5, T6>): Repeat6<T1, T2, T3, T4, T5, T6> = Repeat6(append(data, v.v1, v.v2, v.v3, v.v4, v.v5, v.v6))
}
data class Field7<T1, T2, T3, T4, T5, T6, T7>(val table: Table<*>, val c1: Column<T1>, val c2: Column<T2>, val c3: Column<T3>, val c4: Column<T4>, val c5: Column<T5>, val c6: Column<T6>, val c7: Column<T7>): ExtraValues {
    override val data: InsertData = InsertData(table, listOf(c1, c2, c3, c4, c5, c6, c7), listOf())
    infix fun VALUES(v: Value7<T1, T2, T3, T4, T5, T6, T7>): Repeat7<T1, T2, T3, T4, T5, T6, T7> = Repeat7(append(data, v))
}
data class Value7<out T1, out T2, out T3, out T4, out T5, out T6, out T7>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, val v5: T5, val v6: T6, val v7: T7)
data class Repeat7<in T1, in T2, in T3, in T4, in T5, in T6, in T7>(override val data: InsertData): InsertPart {
    infix fun AND(v: Value7<T1, T2, T3, T4, T5, T6, T7>): Repeat7<T1, T2, T3, T4, T5, T6, T7> = Repeat7(append(data, v.v1, v.v2, v.v3, v.v4, v.v5, v.v6, v.v7))
}
data class Field8<T1, T2, T3, T4, T5, T6, T7, T8>(val table: Table<*>, val c1: Column<T1>, val c2: Column<T2>, val c3: Column<T3>, val c4: Column<T4>, val c5: Column<T5>, val c6: Column<T6>, val c7: Column<T7>, val c8: Column<T8>): ExtraValues {
    override val data: InsertData = InsertData(table, listOf(c1, c2, c3, c4, c5, c6, c7, c8), listOf())
    infix fun VALUES(v: Value8<T1, T2, T3, T4, T5, T6, T7, T8>): Repeat8<T1, T2, T3, T4, T5, T6, T7, T8> = Repeat8(append(data, v))
}
data class Value8<out T1, out T2, out T3, out T4, out T5, out T6, out T7, out T8>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, val v5: T5, val v6: T6, val v7: T7, val v8: T8)
data class Repeat8<in T1, in T2, in T3, in T4, in T5, in T6, in T7, in T8>(override val data: InsertData): InsertPart {
    infix fun AND(v: Value8<T1, T2, T3, T4, T5, T6, T7, T8>): Repeat8<T1, T2, T3, T4, T5, T6, T7, T8> = Repeat8(append(data, v.v1, v.v2, v.v3, v.v4, v.v5, v.v6, v.v7, v.v8))
}
data class Field9<T1, T2, T3, T4, T5, T6, T7, T8, T9>(val table: Table<*>, val c1: Column<T1>, val c2: Column<T2>, val c3: Column<T3>, val c4: Column<T4>, val c5: Column<T5>, val c6: Column<T6>, val c7: Column<T7>, val c8: Column<T8>, val c9: Column<T9>): ExtraValues {
    override val data: InsertData = InsertData(table, listOf(c1, c2, c3, c4, c5, c6, c7, c8, c9), listOf())
    infix fun VALUES(v: Value9<T1, T2, T3, T4, T5, T6, T7, T8, T9>): Repeat9<T1, T2, T3, T4, T5, T6, T7, T8, T9> = Repeat9(append(data, v))
}
data class Value9<out T1, out T2, out T3, out T4, out T5, out T6, out T7, out T8, out T9>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, val v5: T5, val v6: T6, val v7: T7, val v8: T8, val v9: T9)
data class Repeat9<in T1, in T2, in T3, in T4, in T5, in T6, in T7, in T8, in T9>(override val data: InsertData): InsertPart {
    infix fun AND(v: Value9<T1, T2, T3, T4, T5, T6, T7, T8, T9>): Repeat9<T1, T2, T3, T4, T5, T6, T7, T8, T9> = Repeat9(append(data, v.v1, v.v2, v.v3, v.v4, v.v5, v.v6, v.v7, v.v8, v.v9))
}
data class Field10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>(val table: Table<*>, val c1: Column<T1>, val c2: Column<T2>, val c3: Column<T3>, val c4: Column<T4>, val c5: Column<T5>, val c6: Column<T6>, val c7: Column<T7>, val c8: Column<T8>, val c9: Column<T9>, val c10: Column<T10>): ExtraValues {
    override val data: InsertData = InsertData(table, listOf(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10), listOf())
    infix fun VALUES(v: Value10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>): Repeat10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> = Repeat10(append(data, v))
}
data class Value10<out T1, out T2, out T3, out T4, out T5, out T6, out T7, out T8, out T9, out T10>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, val v5: T5, val v6: T6, val v7: T7, val v8: T8, val v9: T9, val v10: T10)
data class Repeat10<in T1, in T2, in T3, in T4, in T5, in T6, in T7, in T8, in T9, in T10>(override val data: InsertData): InsertPart {
    infix fun AND(v: Value10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>): Repeat10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> = Repeat10(append(data, v.v1, v.v2, v.v3, v.v4, v.v5, v.v6, v.v7, v.v8, v.v9, v.v10))
}
data class Field11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>(val table: Table<*>, val c1: Column<T1>, val c2: Column<T2>, val c3: Column<T3>, val c4: Column<T4>, val c5: Column<T5>, val c6: Column<T6>, val c7: Column<T7>, val c8: Column<T8>, val c9: Column<T9>, val c10: Column<T10>, val c11: Column<T11>): ExtraValues {
    override val data: InsertData = InsertData(table, listOf(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11), listOf())
    infix fun VALUES(v: Value11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>): Repeat11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> = Repeat11(append(data, v))
}
data class Value11<out T1, out T2, out T3, out T4, out T5, out T6, out T7, out T8, out T9, out T10, out T11>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, val v5: T5, val v6: T6, val v7: T7, val v8: T8, val v9: T9, val v10: T10, val v11: T11)
data class Repeat11<in T1, in T2, in T3, in T4, in T5, in T6, in T7, in T8, in T9, in T10, in T11>(override val data: InsertData): InsertPart {
    infix fun AND(v: Value11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>): Repeat11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> = Repeat11(append(data, v.v1, v.v2, v.v3, v.v4, v.v5, v.v6, v.v7, v.v8, v.v9, v.v10, v.v11))
}
data class Field12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>(val table: Table<*>, val c1: Column<T1>, val c2: Column<T2>, val c3: Column<T3>, val c4: Column<T4>, val c5: Column<T5>, val c6: Column<T6>, val c7: Column<T7>, val c8: Column<T8>, val c9: Column<T9>, val c10: Column<T10>, val c11: Column<T11>, val c12: Column<T12>): ExtraValues {
    override val data: InsertData = InsertData(table, listOf(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12), listOf())
    infix fun VALUES(v: Value12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>): Repeat12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> = Repeat12(append(data, v))
}
data class Value12<out T1, out T2, out T3, out T4, out T5, out T6, out T7, out T8, out T9, out T10, out T11, out T12>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, val v5: T5, val v6: T6, val v7: T7, val v8: T8, val v9: T9, val v10: T10, val v11: T11, val v12: T12)
data class Repeat12<in T1, in T2, in T3, in T4, in T5, in T6, in T7, in T8, in T9, in T10, in T11, in T12>(override val data: InsertData): InsertPart {
    infix fun AND(v: Value12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>): Repeat12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> = Repeat12(append(data, v.v1, v.v2, v.v3, v.v4, v.v5, v.v6, v.v7, v.v8, v.v9, v.v10, v.v11, v.v12))
}
data class Field13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>(val table: Table<*>, val c1: Column<T1>, val c2: Column<T2>, val c3: Column<T3>, val c4: Column<T4>, val c5: Column<T5>, val c6: Column<T6>, val c7: Column<T7>, val c8: Column<T8>, val c9: Column<T9>, val c10: Column<T10>, val c11: Column<T11>, val c12: Column<T12>, val c13: Column<T13>): ExtraValues {
    override val data: InsertData = InsertData(table, listOf(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13), listOf())
    infix fun VALUES(v: Value13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>): Repeat13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> = Repeat13(append(data, v))
}
data class Value13<out T1, out T2, out T3, out T4, out T5, out T6, out T7, out T8, out T9, out T10, out T11, out T12, out T13>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, val v5: T5, val v6: T6, val v7: T7, val v8: T8, val v9: T9, val v10: T10, val v11: T11, val v12: T12, val v13: T13)
data class Repeat13<in T1, in T2, in T3, in T4, in T5, in T6, in T7, in T8, in T9, in T10, in T11, in T12, in T13>(override val data: InsertData): InsertPart {
    infix fun AND(v: Value13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>): Repeat13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> = Repeat13(append(data, v.v1, v.v2, v.v3, v.v4, v.v5, v.v6, v.v7, v.v8, v.v9, v.v10, v.v11, v.v12, v.v13))
}
data class Field14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>(val table: Table<*>, val c1: Column<T1>, val c2: Column<T2>, val c3: Column<T3>, val c4: Column<T4>, val c5: Column<T5>, val c6: Column<T6>, val c7: Column<T7>, val c8: Column<T8>, val c9: Column<T9>, val c10: Column<T10>, val c11: Column<T11>, val c12: Column<T12>, val c13: Column<T13>, val c14: Column<T14>): ExtraValues {
    override val data: InsertData = InsertData(table, listOf(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14), listOf())
    infix fun VALUES(v: Value14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>): Repeat14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> = Repeat14(append(data, v))
}
data class Value14<out T1, out T2, out T3, out T4, out T5, out T6, out T7, out T8, out T9, out T10, out T11, out T12, out T13, out T14>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, val v5: T5, val v6: T6, val v7: T7, val v8: T8, val v9: T9, val v10: T10, val v11: T11, val v12: T12, val v13: T13, val v14: T14)
data class Repeat14<in T1, in T2, in T3, in T4, in T5, in T6, in T7, in T8, in T9, in T10, in T11, in T12, in T13, in T14>(override val data: InsertData): InsertPart {
    infix fun AND(v: Value14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>): Repeat14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> = Repeat14(append(data, v.v1, v.v2, v.v3, v.v4, v.v5, v.v6, v.v7, v.v8, v.v9, v.v10, v.v11, v.v12, v.v13, v.v14))
}
data class Field15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>(val table: Table<*>, val c1: Column<T1>, val c2: Column<T2>, val c3: Column<T3>, val c4: Column<T4>, val c5: Column<T5>, val c6: Column<T6>, val c7: Column<T7>, val c8: Column<T8>, val c9: Column<T9>, val c10: Column<T10>, val c11: Column<T11>, val c12: Column<T12>, val c13: Column<T13>, val c14: Column<T14>, val c15: Column<T15>): ExtraValues {
    override val data: InsertData = InsertData(table, listOf(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15), listOf())
    infix fun VALUES(v: Value15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>): Repeat15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> = Repeat15(append(data, v))
}
data class Value15<out T1, out T2, out T3, out T4, out T5, out T6, out T7, out T8, out T9, out T10, out T11, out T12, out T13, out T14, out T15>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, val v5: T5, val v6: T6, val v7: T7, val v8: T8, val v9: T9, val v10: T10, val v11: T11, val v12: T12, val v13: T13, val v14: T14, val v15: T15)
data class Repeat15<in T1, in T2, in T3, in T4, in T5, in T6, in T7, in T8, in T9, in T10, in T11, in T12, in T13, in T14, in T15>(override val data: InsertData): InsertPart {
    infix fun AND(v: Value15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>): Repeat15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> = Repeat15(append(data, v.v1, v.v2, v.v3, v.v4, v.v5, v.v6, v.v7, v.v8, v.v9, v.v10, v.v11, v.v12, v.v13, v.v14, v.v15))
}
data class Field16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>(val table: Table<*>, val c1: Column<T1>, val c2: Column<T2>, val c3: Column<T3>, val c4: Column<T4>, val c5: Column<T5>, val c6: Column<T6>, val c7: Column<T7>, val c8: Column<T8>, val c9: Column<T9>, val c10: Column<T10>, val c11: Column<T11>, val c12: Column<T12>, val c13: Column<T13>, val c14: Column<T14>, val c15: Column<T15>, val c16: Column<T16>): ExtraValues {
    override val data: InsertData = InsertData(table, listOf(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16), listOf())
    infix fun VALUES(v: Value16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>): Repeat16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> = Repeat16(append(data, v))
}
data class Value16<out T1, out T2, out T3, out T4, out T5, out T6, out T7, out T8, out T9, out T10, out T11, out T12, out T13, out T14, out T15, out T16>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, val v5: T5, val v6: T6, val v7: T7, val v8: T8, val v9: T9, val v10: T10, val v11: T11, val v12: T12, val v13: T13, val v14: T14, val v15: T15, val v16: T16)
data class Repeat16<in T1, in T2, in T3, in T4, in T5, in T6, in T7, in T8, in T9, in T10, in T11, in T12, in T13, in T14, in T15, in T16>(override val data: InsertData): InsertPart {
    infix fun AND(v: Value16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>): Repeat16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> = Repeat16(append(data, v.v1, v.v2, v.v3, v.v4, v.v5, v.v6, v.v7, v.v8, v.v9, v.v10, v.v11, v.v12, v.v13, v.v14, v.v15, v.v16))
}
data class Field17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>(val table: Table<*>, val c1: Column<T1>, val c2: Column<T2>, val c3: Column<T3>, val c4: Column<T4>, val c5: Column<T5>, val c6: Column<T6>, val c7: Column<T7>, val c8: Column<T8>, val c9: Column<T9>, val c10: Column<T10>, val c11: Column<T11>, val c12: Column<T12>, val c13: Column<T13>, val c14: Column<T14>, val c15: Column<T15>, val c16: Column<T16>, val c17: Column<T17>): ExtraValues {
    override val data: InsertData = InsertData(table, listOf(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17), listOf())
    infix fun VALUES(v: Value17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>): Repeat17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> = Repeat17(append(data, v))
}
data class Value17<out T1, out T2, out T3, out T4, out T5, out T6, out T7, out T8, out T9, out T10, out T11, out T12, out T13, out T14, out T15, out T16, out T17>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, val v5: T5, val v6: T6, val v7: T7, val v8: T8, val v9: T9, val v10: T10, val v11: T11, val v12: T12, val v13: T13, val v14: T14, val v15: T15, val v16: T16, val v17: T17)
data class Repeat17<in T1, in T2, in T3, in T4, in T5, in T6, in T7, in T8, in T9, in T10, in T11, in T12, in T13, in T14, in T15, in T16, in T17>(override val data: InsertData): InsertPart {
    infix fun AND(v: Value17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>): Repeat17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> = Repeat17(append(data, v.v1, v.v2, v.v3, v.v4, v.v5, v.v6, v.v7, v.v8, v.v9, v.v10, v.v11, v.v12, v.v13, v.v14, v.v15, v.v16, v.v17))
}
data class Field18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>(val table: Table<*>, val c1: Column<T1>, val c2: Column<T2>, val c3: Column<T3>, val c4: Column<T4>, val c5: Column<T5>, val c6: Column<T6>, val c7: Column<T7>, val c8: Column<T8>, val c9: Column<T9>, val c10: Column<T10>, val c11: Column<T11>, val c12: Column<T12>, val c13: Column<T13>, val c14: Column<T14>, val c15: Column<T15>, val c16: Column<T16>, val c17: Column<T17>, val c18: Column<T18>): ExtraValues {
    override val data: InsertData = InsertData(table, listOf(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18), listOf())
    infix fun VALUES(v: Value18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>): Repeat18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> = Repeat18(append(data, v))
}
data class Value18<out T1, out T2, out T3, out T4, out T5, out T6, out T7, out T8, out T9, out T10, out T11, out T12, out T13, out T14, out T15, out T16, out T17, out T18>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, val v5: T5, val v6: T6, val v7: T7, val v8: T8, val v9: T9, val v10: T10, val v11: T11, val v12: T12, val v13: T13, val v14: T14, val v15: T15, val v16: T16, val v17: T17, val v18: T18)
data class Repeat18<in T1, in T2, in T3, in T4, in T5, in T6, in T7, in T8, in T9, in T10, in T11, in T12, in T13, in T14, in T15, in T16, in T17, in T18>(override val data: InsertData): InsertPart {
    infix fun AND(v: Value18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>): Repeat18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> = Repeat18(append(data, v.v1, v.v2, v.v3, v.v4, v.v5, v.v6, v.v7, v.v8, v.v9, v.v10, v.v11, v.v12, v.v13, v.v14, v.v15, v.v16, v.v17, v.v18))
}
data class Field19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>(val table: Table<*>, val c1: Column<T1>, val c2: Column<T2>, val c3: Column<T3>, val c4: Column<T4>, val c5: Column<T5>, val c6: Column<T6>, val c7: Column<T7>, val c8: Column<T8>, val c9: Column<T9>, val c10: Column<T10>, val c11: Column<T11>, val c12: Column<T12>, val c13: Column<T13>, val c14: Column<T14>, val c15: Column<T15>, val c16: Column<T16>, val c17: Column<T17>, val c18: Column<T18>, val c19: Column<T19>): ExtraValues {
    override val data: InsertData = InsertData(table, listOf(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19), listOf())
    infix fun VALUES(v: Value19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>): Repeat19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> = Repeat19(append(data, v))
}
data class Value19<out T1, out T2, out T3, out T4, out T5, out T6, out T7, out T8, out T9, out T10, out T11, out T12, out T13, out T14, out T15, out T16, out T17, out T18, out T19>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, val v5: T5, val v6: T6, val v7: T7, val v8: T8, val v9: T9, val v10: T10, val v11: T11, val v12: T12, val v13: T13, val v14: T14, val v15: T15, val v16: T16, val v17: T17, val v18: T18, val v19: T19)
data class Repeat19<in T1, in T2, in T3, in T4, in T5, in T6, in T7, in T8, in T9, in T10, in T11, in T12, in T13, in T14, in T15, in T16, in T17, in T18, in T19>(override val data: InsertData): InsertPart {
    infix fun AND(v: Value19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>): Repeat19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> = Repeat19(append(data, v.v1, v.v2, v.v3, v.v4, v.v5, v.v6, v.v7, v.v8, v.v9, v.v10, v.v11, v.v12, v.v13, v.v14, v.v15, v.v16, v.v17, v.v18, v.v19))
}
data class Field20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>(val table: Table<*>, val c1: Column<T1>, val c2: Column<T2>, val c3: Column<T3>, val c4: Column<T4>, val c5: Column<T5>, val c6: Column<T6>, val c7: Column<T7>, val c8: Column<T8>, val c9: Column<T9>, val c10: Column<T10>, val c11: Column<T11>, val c12: Column<T12>, val c13: Column<T13>, val c14: Column<T14>, val c15: Column<T15>, val c16: Column<T16>, val c17: Column<T17>, val c18: Column<T18>, val c19: Column<T19>, val c20: Column<T20>): ExtraValues {
    override val data: InsertData = InsertData(table, listOf(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20), listOf())
    infix fun VALUES(v: Value20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>): Repeat20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> = Repeat20(append(data, v))
}
data class Value20<out T1, out T2, out T3, out T4, out T5, out T6, out T7, out T8, out T9, out T10, out T11, out T12, out T13, out T14, out T15, out T16, out T17, out T18, out T19, out T20>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, val v5: T5, val v6: T6, val v7: T7, val v8: T8, val v9: T9, val v10: T10, val v11: T11, val v12: T12, val v13: T13, val v14: T14, val v15: T15, val v16: T16, val v17: T17, val v18: T18, val v19: T19, val v20: T20)
data class Repeat20<in T1, in T2, in T3, in T4, in T5, in T6, in T7, in T8, in T9, in T10, in T11, in T12, in T13, in T14, in T15, in T16, in T17, in T18, in T19, in T20>(override val data: InsertData): InsertPart {
    infix fun AND(v: Value20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>): Repeat20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> = Repeat20(append(data, v.v1, v.v2, v.v3, v.v4, v.v5, v.v6, v.v7, v.v8, v.v9, v.v10, v.v11, v.v12, v.v13, v.v14, v.v15, v.v16, v.v17, v.v18, v.v19, v.v20))
}
data class Field21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>(val table: Table<*>, val c1: Column<T1>, val c2: Column<T2>, val c3: Column<T3>, val c4: Column<T4>, val c5: Column<T5>, val c6: Column<T6>, val c7: Column<T7>, val c8: Column<T8>, val c9: Column<T9>, val c10: Column<T10>, val c11: Column<T11>, val c12: Column<T12>, val c13: Column<T13>, val c14: Column<T14>, val c15: Column<T15>, val c16: Column<T16>, val c17: Column<T17>, val c18: Column<T18>, val c19: Column<T19>, val c20: Column<T20>, val c21: Column<T21>): ExtraValues {
    override val data: InsertData = InsertData(table, listOf(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21), listOf())
    infix fun VALUES(v: Value21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>): Repeat21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> = Repeat21(append(data, v))
}
data class Value21<out T1, out T2, out T3, out T4, out T5, out T6, out T7, out T8, out T9, out T10, out T11, out T12, out T13, out T14, out T15, out T16, out T17, out T18, out T19, out T20, out T21>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, val v5: T5, val v6: T6, val v7: T7, val v8: T8, val v9: T9, val v10: T10, val v11: T11, val v12: T12, val v13: T13, val v14: T14, val v15: T15, val v16: T16, val v17: T17, val v18: T18, val v19: T19, val v20: T20, val v21: T21)
data class Repeat21<in T1, in T2, in T3, in T4, in T5, in T6, in T7, in T8, in T9, in T10, in T11, in T12, in T13, in T14, in T15, in T16, in T17, in T18, in T19, in T20, in T21>(override val data: InsertData): InsertPart {
    infix fun AND(v: Value21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>): Repeat21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> = Repeat21(append(data, v.v1, v.v2, v.v3, v.v4, v.v5, v.v6, v.v7, v.v8, v.v9, v.v10, v.v11, v.v12, v.v13, v.v14, v.v15, v.v16, v.v17, v.v18, v.v19, v.v20, v.v21))
}
data class Field22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>(val table: Table<*>, val c1: Column<T1>, val c2: Column<T2>, val c3: Column<T3>, val c4: Column<T4>, val c5: Column<T5>, val c6: Column<T6>, val c7: Column<T7>, val c8: Column<T8>, val c9: Column<T9>, val c10: Column<T10>, val c11: Column<T11>, val c12: Column<T12>, val c13: Column<T13>, val c14: Column<T14>, val c15: Column<T15>, val c16: Column<T16>, val c17: Column<T17>, val c18: Column<T18>, val c19: Column<T19>, val c20: Column<T20>, val c21: Column<T21>, val c22: Column<T22>): ExtraValues {
    override val data: InsertData = InsertData(table, listOf(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21, c22), listOf())
    infix fun VALUES(v: Value22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>): Repeat22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> = Repeat22(append(data, v))
}
data class Value22<out T1, out T2, out T3, out T4, out T5, out T6, out T7, out T8, out T9, out T10, out T11, out T12, out T13, out T14, out T15, out T16, out T17, out T18, out T19, out T20, out T21, out T22>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, val v5: T5, val v6: T6, val v7: T7, val v8: T8, val v9: T9, val v10: T10, val v11: T11, val v12: T12, val v13: T13, val v14: T14, val v15: T15, val v16: T16, val v17: T17, val v18: T18, val v19: T19, val v20: T20, val v21: T21, val v22: T22)
data class Repeat22<in T1, in T2, in T3, in T4, in T5, in T6, in T7, in T8, in T9, in T10, in T11, in T12, in T13, in T14, in T15, in T16, in T17, in T18, in T19, in T20, in T21, in T22>(override val data: InsertData): InsertPart {
    infix fun AND(v: Value22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>): Repeat22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> = Repeat22(append(data, v.v1, v.v2, v.v3, v.v4, v.v5, v.v6, v.v7, v.v8, v.v9, v.v10, v.v11, v.v12, v.v13, v.v14, v.v15, v.v16, v.v17, v.v18, v.v19, v.v20, v.v21, v.v22))
}
interface Inserts {
    fun <T1> V(v1: T1): Value1<T1> = Value1(v1)
    operator fun <T1> Table<*>.invoke(c1: Column<T1>): Field1<T1> = Field1(this, c1)
    fun <T1, T2> V(v1: T1, v2: T2): Value2<T1, T2> = Value2(v1, v2)
    operator fun <T1, T2> Table<*>.invoke(c1: Column<T1>, c2: Column<T2>): Field2<T1, T2> = Field2(this, c1, c2)
    fun <T1, T2, T3> V(v1: T1, v2: T2, v3: T3): Value3<T1, T2, T3> = Value3(v1, v2, v3)
    operator fun <T1, T2, T3> Table<*>.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>): Field3<T1, T2, T3> = Field3(this, c1, c2, c3)
    fun <T1, T2, T3, T4> V(v1: T1, v2: T2, v3: T3, v4: T4): Value4<T1, T2, T3, T4> = Value4(v1, v2, v3, v4)
    operator fun <T1, T2, T3, T4> Table<*>.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>): Field4<T1, T2, T3, T4> = Field4(this, c1, c2, c3, c4)
    fun <T1, T2, T3, T4, T5> V(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5): Value5<T1, T2, T3, T4, T5> = Value5(v1, v2, v3, v4, v5)
    operator fun <T1, T2, T3, T4, T5> Table<*>.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>): Field5<T1, T2, T3, T4, T5> = Field5(this, c1, c2, c3, c4, c5)
    fun <T1, T2, T3, T4, T5, T6> V(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6): Value6<T1, T2, T3, T4, T5, T6> = Value6(v1, v2, v3, v4, v5, v6)
    operator fun <T1, T2, T3, T4, T5, T6> Table<*>.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>): Field6<T1, T2, T3, T4, T5, T6> = Field6(this, c1, c2, c3, c4, c5, c6)
    fun <T1, T2, T3, T4, T5, T6, T7> V(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7): Value7<T1, T2, T3, T4, T5, T6, T7> = Value7(v1, v2, v3, v4, v5, v6, v7)
    operator fun <T1, T2, T3, T4, T5, T6, T7> Table<*>.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>): Field7<T1, T2, T3, T4, T5, T6, T7> = Field7(this, c1, c2, c3, c4, c5, c6, c7)
    fun <T1, T2, T3, T4, T5, T6, T7, T8> V(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8): Value8<T1, T2, T3, T4, T5, T6, T7, T8> = Value8(v1, v2, v3, v4, v5, v6, v7, v8)
    operator fun <T1, T2, T3, T4, T5, T6, T7, T8> Table<*>.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>): Field8<T1, T2, T3, T4, T5, T6, T7, T8> = Field8(this, c1, c2, c3, c4, c5, c6, c7, c8)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9> V(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8, v9: T9): Value9<T1, T2, T3, T4, T5, T6, T7, T8, T9> = Value9(v1, v2, v3, v4, v5, v6, v7, v8, v9)
    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9> Table<*>.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>): Field9<T1, T2, T3, T4, T5, T6, T7, T8, T9> = Field9(this, c1, c2, c3, c4, c5, c6, c7, c8, c9)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> V(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8, v9: T9, v10: T10): Value10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> = Value10(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10)
    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> Table<*>.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>): Field10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> = Field10(this, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> V(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8, v9: T9, v10: T10, v11: T11): Value11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> = Value11(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11)
    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> Table<*>.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>): Field11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> = Field11(this, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> V(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8, v9: T9, v10: T10, v11: T11, v12: T12): Value12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> = Value12(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12)
    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> Table<*>.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>): Field12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> = Field12(this, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> V(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8, v9: T9, v10: T10, v11: T11, v12: T12, v13: T13): Value13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> = Value13(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13)
    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> Table<*>.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>): Field13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> = Field13(this, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> V(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8, v9: T9, v10: T10, v11: T11, v12: T12, v13: T13, v14: T14): Value14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> = Value14(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14)
    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> Table<*>.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>): Field14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> = Field14(this, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> V(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8, v9: T9, v10: T10, v11: T11, v12: T12, v13: T13, v14: T14, v15: T15): Value15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> = Value15(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15)
    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> Table<*>.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>, c15: Column<T15>): Field15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> = Field15(this, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> V(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8, v9: T9, v10: T10, v11: T11, v12: T12, v13: T13, v14: T14, v15: T15, v16: T16): Value16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> = Value16(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16)
    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> Table<*>.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>, c15: Column<T15>, c16: Column<T16>): Field16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> = Field16(this, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> V(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8, v9: T9, v10: T10, v11: T11, v12: T12, v13: T13, v14: T14, v15: T15, v16: T16, v17: T17): Value17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> = Value17(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17)
    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> Table<*>.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>, c15: Column<T15>, c16: Column<T16>, c17: Column<T17>): Field17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> = Field17(this, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> V(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8, v9: T9, v10: T10, v11: T11, v12: T12, v13: T13, v14: T14, v15: T15, v16: T16, v17: T17, v18: T18): Value18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> = Value18(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18)
    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> Table<*>.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>, c15: Column<T15>, c16: Column<T16>, c17: Column<T17>, c18: Column<T18>): Field18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> = Field18(this, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> V(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8, v9: T9, v10: T10, v11: T11, v12: T12, v13: T13, v14: T14, v15: T15, v16: T16, v17: T17, v18: T18, v19: T19): Value19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> = Value19(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18, v19)
    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> Table<*>.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>, c15: Column<T15>, c16: Column<T16>, c17: Column<T17>, c18: Column<T18>, c19: Column<T19>): Field19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> = Field19(this, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> V(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8, v9: T9, v10: T10, v11: T11, v12: T12, v13: T13, v14: T14, v15: T15, v16: T16, v17: T17, v18: T18, v19: T19, v20: T20): Value20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> = Value20(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18, v19, v20)
    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> Table<*>.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>, c15: Column<T15>, c16: Column<T16>, c17: Column<T17>, c18: Column<T18>, c19: Column<T19>, c20: Column<T20>): Field20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> = Field20(this, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> V(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8, v9: T9, v10: T10, v11: T11, v12: T12, v13: T13, v14: T14, v15: T15, v16: T16, v17: T17, v18: T18, v19: T19, v20: T20, v21: T21): Value21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> = Value21(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18, v19, v20, v21)
    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> Table<*>.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>, c15: Column<T15>, c16: Column<T16>, c17: Column<T17>, c18: Column<T18>, c19: Column<T19>, c20: Column<T20>, c21: Column<T21>): Field21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> = Field21(this, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> V(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8, v9: T9, v10: T10, v11: T11, v12: T12, v13: T13, v14: T14, v15: T15, v16: T16, v17: T17, v18: T18, v19: T19, v20: T20, v21: T21, v22: T22): Value22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> = Value22(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18, v19, v20, v21, v22)
    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> Table<*>.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>, c15: Column<T15>, c16: Column<T16>, c17: Column<T17>, c18: Column<T18>, c19: Column<T19>, c20: Column<T20>, c21: Column<T21>, c22: Column<T22>): Field22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> = Field22(this, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21, c22)
}