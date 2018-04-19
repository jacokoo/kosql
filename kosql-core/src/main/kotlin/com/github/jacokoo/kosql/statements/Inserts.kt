package com.github.jacokoo.kosql.statements

import com.github.jacokoo.kosql.Column
import com.github.jacokoo.kosql.Table


/*
 * auto generated contents for insert
 */


/* create by template:

fun times(n: Int, b: (Int) -> String): String = (1..n).map { b(it) }.joinToString()

fun template(v: Int) = (1..v).forEach { println("""

    |data class Field$it<${times(it) { "T$it: Any" }}>(val table: Table<*>, ${times(it) { "val c$it: Column<T$it>" }})
    |data class Value$it<${times(it) { "out T$it: Any" }}>(${times(it) { "val v$it: T$it" }})
    |data class Repeat$it<${times(it) { "in T$it: Any" }}>(override val data: InsertData): InsertPart {
    |    infix fun AND(v: Value$it<${times(it) { "T$it" }}>): Repeat$it<${times(it) { "T$it" }}> = Repeat$it(append(data, ${times(it) {"v.v$it"}}))
    |}
    |data class ValuePart$it<${times(it) {"in T$it: Any"}}>(private val f: Field$it<${times(it) {"T$it"}}>, override val data: InsertData): InsertPart, ExtraValues {
    |    infix fun VALUES(v: Value$it<${times(it) {"T$it"}}>): Repeat$it<${times(it) {"T$it"}}> = Repeat$it(append(data, ${times(it) {"v.v$it"}}))
    |}
""".trimMargin())}
 */
data class Field1<T1: Any>(val table: Table<*>, val c1: Column<T1>)
data class Value1<out T1: Any>(val v1: T1)
data class Repeat1<in T1: Any>(override val data: InsertData): InsertPart {
    infix fun AND(v: Value1<T1>): Repeat1<T1> = Repeat1(append(data, v.v1))
}
data class ValuePart1<in T1: Any>(private val f: Field1<T1>, override val data: InsertData): InsertPart, ExtraValues {
    infix fun VALUES(v: Value1<T1>): Repeat1<T1> = Repeat1(append(data, v.v1))
}

data class Field2<T1: Any, T2: Any>(val table: Table<*>, val c1: Column<T1>, val c2: Column<T2>)
data class Value2<out T1: Any, out T2: Any>(val v1: T1, val v2: T2)
data class Repeat2<in T1: Any, in T2: Any>(override val data: InsertData): InsertPart {
    infix fun AND(v: Value2<T1, T2>): Repeat2<T1, T2> = Repeat2(append(data, v.v1, v.v2))
}
data class ValuePart2<in T1: Any, in T2: Any>(private val f: Field2<T1, T2>, override val data: InsertData): InsertPart, ExtraValues {
    infix fun VALUES(v: Value2<T1, T2>): Repeat2<T1, T2> = Repeat2(append(data, v.v1, v.v2))
}

data class Field3<T1: Any, T2: Any, T3: Any>(val table: Table<*>, val c1: Column<T1>, val c2: Column<T2>, val c3: Column<T3>)
data class Value3<out T1: Any, out T2: Any, out T3: Any>(val v1: T1, val v2: T2, val v3: T3)
data class Repeat3<in T1: Any, in T2: Any, in T3: Any>(override val data: InsertData): InsertPart {
    infix fun AND(v: Value3<T1, T2, T3>): Repeat3<T1, T2, T3> = Repeat3(append(data, v.v1, v.v2, v.v3))
}
data class ValuePart3<in T1: Any, in T2: Any, in T3: Any>(private val f: Field3<T1, T2, T3>, override val data: InsertData): InsertPart, ExtraValues {
    infix fun VALUES(v: Value3<T1, T2, T3>): Repeat3<T1, T2, T3> = Repeat3(append(data, v.v1, v.v2, v.v3))
}

data class Field4<T1: Any, T2: Any, T3: Any, T4: Any>(val table: Table<*>, val c1: Column<T1>, val c2: Column<T2>, val c3: Column<T3>, val c4: Column<T4>)
data class Value4<out T1: Any, out T2: Any, out T3: Any, out T4: Any>(val v1: T1, val v2: T2, val v3: T3, val v4: T4)
data class Repeat4<in T1: Any, in T2: Any, in T3: Any, in T4: Any>(override val data: InsertData): InsertPart {
    infix fun AND(v: Value4<T1, T2, T3, T4>): Repeat4<T1, T2, T3, T4> = Repeat4(append(data, v.v1, v.v2, v.v3, v.v4))
}
data class ValuePart4<in T1: Any, in T2: Any, in T3: Any, in T4: Any>(private val f: Field4<T1, T2, T3, T4>, override val data: InsertData): InsertPart, ExtraValues {
    infix fun VALUES(v: Value4<T1, T2, T3, T4>): Repeat4<T1, T2, T3, T4> = Repeat4(append(data, v.v1, v.v2, v.v3, v.v4))
}

data class Field5<T1: Any, T2: Any, T3: Any, T4: Any, T5: Any>(val table: Table<*>, val c1: Column<T1>, val c2: Column<T2>, val c3: Column<T3>, val c4: Column<T4>, val c5: Column<T5>)
data class Value5<out T1: Any, out T2: Any, out T3: Any, out T4: Any, out T5: Any>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, val v5: T5)
data class Repeat5<in T1: Any, in T2: Any, in T3: Any, in T4: Any, in T5: Any>(override val data: InsertData): InsertPart {
    infix fun AND(v: Value5<T1, T2, T3, T4, T5>): Repeat5<T1, T2, T3, T4, T5> = Repeat5(append(data, v.v1, v.v2, v.v3, v.v4, v.v5))
}
data class ValuePart5<in T1: Any, in T2: Any, in T3: Any, in T4: Any, in T5: Any>(private val f: Field5<T1, T2, T3, T4, T5>, override val data: InsertData): InsertPart, ExtraValues {
    infix fun VALUES(v: Value5<T1, T2, T3, T4, T5>): Repeat5<T1, T2, T3, T4, T5> = Repeat5(append(data, v.v1, v.v2, v.v3, v.v4, v.v5))
}

data class Field6<T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any>(val table: Table<*>, val c1: Column<T1>, val c2: Column<T2>, val c3: Column<T3>, val c4: Column<T4>, val c5: Column<T5>, val c6: Column<T6>)
data class Value6<out T1: Any, out T2: Any, out T3: Any, out T4: Any, out T5: Any, out T6: Any>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, val v5: T5, val v6: T6)
data class Repeat6<in T1: Any, in T2: Any, in T3: Any, in T4: Any, in T5: Any, in T6: Any>(override val data: InsertData): InsertPart {
    infix fun AND(v: Value6<T1, T2, T3, T4, T5, T6>): Repeat6<T1, T2, T3, T4, T5, T6> = Repeat6(append(data, v.v1, v.v2, v.v3, v.v4, v.v5, v.v6))
}
data class ValuePart6<in T1: Any, in T2: Any, in T3: Any, in T4: Any, in T5: Any, in T6: Any>(private val f: Field6<T1, T2, T3, T4, T5, T6>, override val data: InsertData): InsertPart, ExtraValues {
    infix fun VALUES(v: Value6<T1, T2, T3, T4, T5, T6>): Repeat6<T1, T2, T3, T4, T5, T6> = Repeat6(append(data, v.v1, v.v2, v.v3, v.v4, v.v5, v.v6))
}

data class Field7<T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any>(val table: Table<*>, val c1: Column<T1>, val c2: Column<T2>, val c3: Column<T3>, val c4: Column<T4>, val c5: Column<T5>, val c6: Column<T6>, val c7: Column<T7>)
data class Value7<out T1: Any, out T2: Any, out T3: Any, out T4: Any, out T5: Any, out T6: Any, out T7: Any>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, val v5: T5, val v6: T6, val v7: T7)
data class Repeat7<in T1: Any, in T2: Any, in T3: Any, in T4: Any, in T5: Any, in T6: Any, in T7: Any>(override val data: InsertData): InsertPart {
    infix fun AND(v: Value7<T1, T2, T3, T4, T5, T6, T7>): Repeat7<T1, T2, T3, T4, T5, T6, T7> = Repeat7(append(data, v.v1, v.v2, v.v3, v.v4, v.v5, v.v6, v.v7))
}
data class ValuePart7<in T1: Any, in T2: Any, in T3: Any, in T4: Any, in T5: Any, in T6: Any, in T7: Any>(private val f: Field7<T1, T2, T3, T4, T5, T6, T7>, override val data: InsertData): InsertPart, ExtraValues {
    infix fun VALUES(v: Value7<T1, T2, T3, T4, T5, T6, T7>): Repeat7<T1, T2, T3, T4, T5, T6, T7> = Repeat7(append(data, v.v1, v.v2, v.v3, v.v4, v.v5, v.v6, v.v7))
}

data class Field8<T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any, T8: Any>(val table: Table<*>, val c1: Column<T1>, val c2: Column<T2>, val c3: Column<T3>, val c4: Column<T4>, val c5: Column<T5>, val c6: Column<T6>, val c7: Column<T7>, val c8: Column<T8>)
data class Value8<out T1: Any, out T2: Any, out T3: Any, out T4: Any, out T5: Any, out T6: Any, out T7: Any, out T8: Any>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, val v5: T5, val v6: T6, val v7: T7, val v8: T8)
data class Repeat8<in T1: Any, in T2: Any, in T3: Any, in T4: Any, in T5: Any, in T6: Any, in T7: Any, in T8: Any>(override val data: InsertData): InsertPart {
    infix fun AND(v: Value8<T1, T2, T3, T4, T5, T6, T7, T8>): Repeat8<T1, T2, T3, T4, T5, T6, T7, T8> = Repeat8(append(data, v.v1, v.v2, v.v3, v.v4, v.v5, v.v6, v.v7, v.v8))
}
data class ValuePart8<in T1: Any, in T2: Any, in T3: Any, in T4: Any, in T5: Any, in T6: Any, in T7: Any, in T8: Any>(private val f: Field8<T1, T2, T3, T4, T5, T6, T7, T8>, override val data: InsertData): InsertPart, ExtraValues {
    infix fun VALUES(v: Value8<T1, T2, T3, T4, T5, T6, T7, T8>): Repeat8<T1, T2, T3, T4, T5, T6, T7, T8> = Repeat8(append(data, v.v1, v.v2, v.v3, v.v4, v.v5, v.v6, v.v7, v.v8))
}

data class Field9<T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any, T8: Any, T9: Any>(val table: Table<*>, val c1: Column<T1>, val c2: Column<T2>, val c3: Column<T3>, val c4: Column<T4>, val c5: Column<T5>, val c6: Column<T6>, val c7: Column<T7>, val c8: Column<T8>, val c9: Column<T9>)
data class Value9<out T1: Any, out T2: Any, out T3: Any, out T4: Any, out T5: Any, out T6: Any, out T7: Any, out T8: Any, out T9: Any>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, val v5: T5, val v6: T6, val v7: T7, val v8: T8, val v9: T9)
data class Repeat9<in T1: Any, in T2: Any, in T3: Any, in T4: Any, in T5: Any, in T6: Any, in T7: Any, in T8: Any, in T9: Any>(override val data: InsertData): InsertPart {
    infix fun AND(v: Value9<T1, T2, T3, T4, T5, T6, T7, T8, T9>): Repeat9<T1, T2, T3, T4, T5, T6, T7, T8, T9> = Repeat9(append(data, v.v1, v.v2, v.v3, v.v4, v.v5, v.v6, v.v7, v.v8, v.v9))
}
data class ValuePart9<in T1: Any, in T2: Any, in T3: Any, in T4: Any, in T5: Any, in T6: Any, in T7: Any, in T8: Any, in T9: Any>(private val f: Field9<T1, T2, T3, T4, T5, T6, T7, T8, T9>, override val data: InsertData): InsertPart, ExtraValues {
    infix fun VALUES(v: Value9<T1, T2, T3, T4, T5, T6, T7, T8, T9>): Repeat9<T1, T2, T3, T4, T5, T6, T7, T8, T9> = Repeat9(append(data, v.v1, v.v2, v.v3, v.v4, v.v5, v.v6, v.v7, v.v8, v.v9))
}

data class Field10<T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any, T8: Any, T9: Any, T10: Any>(val table: Table<*>, val c1: Column<T1>, val c2: Column<T2>, val c3: Column<T3>, val c4: Column<T4>, val c5: Column<T5>, val c6: Column<T6>, val c7: Column<T7>, val c8: Column<T8>, val c9: Column<T9>, val c10: Column<T10>)
data class Value10<out T1: Any, out T2: Any, out T3: Any, out T4: Any, out T5: Any, out T6: Any, out T7: Any, out T8: Any, out T9: Any, out T10: Any>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, val v5: T5, val v6: T6, val v7: T7, val v8: T8, val v9: T9, val v10: T10)
data class Repeat10<in T1: Any, in T2: Any, in T3: Any, in T4: Any, in T5: Any, in T6: Any, in T7: Any, in T8: Any, in T9: Any, in T10: Any>(override val data: InsertData): InsertPart {
    infix fun AND(v: Value10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>): Repeat10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> = Repeat10(append(data, v.v1, v.v2, v.v3, v.v4, v.v5, v.v6, v.v7, v.v8, v.v9, v.v10))
}
data class ValuePart10<in T1: Any, in T2: Any, in T3: Any, in T4: Any, in T5: Any, in T6: Any, in T7: Any, in T8: Any, in T9: Any, in T10: Any>(private val f: Field10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>, override val data: InsertData): InsertPart, ExtraValues {
    infix fun VALUES(v: Value10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>): Repeat10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> = Repeat10(append(data, v.v1, v.v2, v.v3, v.v4, v.v5, v.v6, v.v7, v.v8, v.v9, v.v10))
}

data class Field11<T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any, T8: Any, T9: Any, T10: Any, T11: Any>(val table: Table<*>, val c1: Column<T1>, val c2: Column<T2>, val c3: Column<T3>, val c4: Column<T4>, val c5: Column<T5>, val c6: Column<T6>, val c7: Column<T7>, val c8: Column<T8>, val c9: Column<T9>, val c10: Column<T10>, val c11: Column<T11>)
data class Value11<out T1: Any, out T2: Any, out T3: Any, out T4: Any, out T5: Any, out T6: Any, out T7: Any, out T8: Any, out T9: Any, out T10: Any, out T11: Any>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, val v5: T5, val v6: T6, val v7: T7, val v8: T8, val v9: T9, val v10: T10, val v11: T11)
data class Repeat11<in T1: Any, in T2: Any, in T3: Any, in T4: Any, in T5: Any, in T6: Any, in T7: Any, in T8: Any, in T9: Any, in T10: Any, in T11: Any>(override val data: InsertData): InsertPart {
    infix fun AND(v: Value11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>): Repeat11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> = Repeat11(append(data, v.v1, v.v2, v.v3, v.v4, v.v5, v.v6, v.v7, v.v8, v.v9, v.v10, v.v11))
}
data class ValuePart11<in T1: Any, in T2: Any, in T3: Any, in T4: Any, in T5: Any, in T6: Any, in T7: Any, in T8: Any, in T9: Any, in T10: Any, in T11: Any>(private val f: Field11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>, override val data: InsertData): InsertPart, ExtraValues {
    infix fun VALUES(v: Value11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>): Repeat11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> = Repeat11(append(data, v.v1, v.v2, v.v3, v.v4, v.v5, v.v6, v.v7, v.v8, v.v9, v.v10, v.v11))
}

data class Field12<T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any, T8: Any, T9: Any, T10: Any, T11: Any, T12: Any>(val table: Table<*>, val c1: Column<T1>, val c2: Column<T2>, val c3: Column<T3>, val c4: Column<T4>, val c5: Column<T5>, val c6: Column<T6>, val c7: Column<T7>, val c8: Column<T8>, val c9: Column<T9>, val c10: Column<T10>, val c11: Column<T11>, val c12: Column<T12>)
data class Value12<out T1: Any, out T2: Any, out T3: Any, out T4: Any, out T5: Any, out T6: Any, out T7: Any, out T8: Any, out T9: Any, out T10: Any, out T11: Any, out T12: Any>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, val v5: T5, val v6: T6, val v7: T7, val v8: T8, val v9: T9, val v10: T10, val v11: T11, val v12: T12)
data class Repeat12<in T1: Any, in T2: Any, in T3: Any, in T4: Any, in T5: Any, in T6: Any, in T7: Any, in T8: Any, in T9: Any, in T10: Any, in T11: Any, in T12: Any>(override val data: InsertData): InsertPart {
    infix fun AND(v: Value12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>): Repeat12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> = Repeat12(append(data, v.v1, v.v2, v.v3, v.v4, v.v5, v.v6, v.v7, v.v8, v.v9, v.v10, v.v11, v.v12))
}
data class ValuePart12<in T1: Any, in T2: Any, in T3: Any, in T4: Any, in T5: Any, in T6: Any, in T7: Any, in T8: Any, in T9: Any, in T10: Any, in T11: Any, in T12: Any>(private val f: Field12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>, override val data: InsertData): InsertPart, ExtraValues {
    infix fun VALUES(v: Value12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>): Repeat12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> = Repeat12(append(data, v.v1, v.v2, v.v3, v.v4, v.v5, v.v6, v.v7, v.v8, v.v9, v.v10, v.v11, v.v12))
}

data class Field13<T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any, T8: Any, T9: Any, T10: Any, T11: Any, T12: Any, T13: Any>(val table: Table<*>, val c1: Column<T1>, val c2: Column<T2>, val c3: Column<T3>, val c4: Column<T4>, val c5: Column<T5>, val c6: Column<T6>, val c7: Column<T7>, val c8: Column<T8>, val c9: Column<T9>, val c10: Column<T10>, val c11: Column<T11>, val c12: Column<T12>, val c13: Column<T13>)
data class Value13<out T1: Any, out T2: Any, out T3: Any, out T4: Any, out T5: Any, out T6: Any, out T7: Any, out T8: Any, out T9: Any, out T10: Any, out T11: Any, out T12: Any, out T13: Any>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, val v5: T5, val v6: T6, val v7: T7, val v8: T8, val v9: T9, val v10: T10, val v11: T11, val v12: T12, val v13: T13)
data class Repeat13<in T1: Any, in T2: Any, in T3: Any, in T4: Any, in T5: Any, in T6: Any, in T7: Any, in T8: Any, in T9: Any, in T10: Any, in T11: Any, in T12: Any, in T13: Any>(override val data: InsertData): InsertPart {
    infix fun AND(v: Value13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>): Repeat13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> = Repeat13(append(data, v.v1, v.v2, v.v3, v.v4, v.v5, v.v6, v.v7, v.v8, v.v9, v.v10, v.v11, v.v12, v.v13))
}
data class ValuePart13<in T1: Any, in T2: Any, in T3: Any, in T4: Any, in T5: Any, in T6: Any, in T7: Any, in T8: Any, in T9: Any, in T10: Any, in T11: Any, in T12: Any, in T13: Any>(private val f: Field13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>, override val data: InsertData): InsertPart, ExtraValues {
    infix fun VALUES(v: Value13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>): Repeat13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> = Repeat13(append(data, v.v1, v.v2, v.v3, v.v4, v.v5, v.v6, v.v7, v.v8, v.v9, v.v10, v.v11, v.v12, v.v13))
}

data class Field14<T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any, T8: Any, T9: Any, T10: Any, T11: Any, T12: Any, T13: Any, T14: Any>(val table: Table<*>, val c1: Column<T1>, val c2: Column<T2>, val c3: Column<T3>, val c4: Column<T4>, val c5: Column<T5>, val c6: Column<T6>, val c7: Column<T7>, val c8: Column<T8>, val c9: Column<T9>, val c10: Column<T10>, val c11: Column<T11>, val c12: Column<T12>, val c13: Column<T13>, val c14: Column<T14>)
data class Value14<out T1: Any, out T2: Any, out T3: Any, out T4: Any, out T5: Any, out T6: Any, out T7: Any, out T8: Any, out T9: Any, out T10: Any, out T11: Any, out T12: Any, out T13: Any, out T14: Any>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, val v5: T5, val v6: T6, val v7: T7, val v8: T8, val v9: T9, val v10: T10, val v11: T11, val v12: T12, val v13: T13, val v14: T14)
data class Repeat14<in T1: Any, in T2: Any, in T3: Any, in T4: Any, in T5: Any, in T6: Any, in T7: Any, in T8: Any, in T9: Any, in T10: Any, in T11: Any, in T12: Any, in T13: Any, in T14: Any>(override val data: InsertData): InsertPart {
    infix fun AND(v: Value14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>): Repeat14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> = Repeat14(append(data, v.v1, v.v2, v.v3, v.v4, v.v5, v.v6, v.v7, v.v8, v.v9, v.v10, v.v11, v.v12, v.v13, v.v14))
}
data class ValuePart14<in T1: Any, in T2: Any, in T3: Any, in T4: Any, in T5: Any, in T6: Any, in T7: Any, in T8: Any, in T9: Any, in T10: Any, in T11: Any, in T12: Any, in T13: Any, in T14: Any>(private val f: Field14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>, override val data: InsertData): InsertPart, ExtraValues {
    infix fun VALUES(v: Value14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>): Repeat14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> = Repeat14(append(data, v.v1, v.v2, v.v3, v.v4, v.v5, v.v6, v.v7, v.v8, v.v9, v.v10, v.v11, v.v12, v.v13, v.v14))
}

data class Field15<T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any, T8: Any, T9: Any, T10: Any, T11: Any, T12: Any, T13: Any, T14: Any, T15: Any>(val table: Table<*>, val c1: Column<T1>, val c2: Column<T2>, val c3: Column<T3>, val c4: Column<T4>, val c5: Column<T5>, val c6: Column<T6>, val c7: Column<T7>, val c8: Column<T8>, val c9: Column<T9>, val c10: Column<T10>, val c11: Column<T11>, val c12: Column<T12>, val c13: Column<T13>, val c14: Column<T14>, val c15: Column<T15>)
data class Value15<out T1: Any, out T2: Any, out T3: Any, out T4: Any, out T5: Any, out T6: Any, out T7: Any, out T8: Any, out T9: Any, out T10: Any, out T11: Any, out T12: Any, out T13: Any, out T14: Any, out T15: Any>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, val v5: T5, val v6: T6, val v7: T7, val v8: T8, val v9: T9, val v10: T10, val v11: T11, val v12: T12, val v13: T13, val v14: T14, val v15: T15)
data class Repeat15<in T1: Any, in T2: Any, in T3: Any, in T4: Any, in T5: Any, in T6: Any, in T7: Any, in T8: Any, in T9: Any, in T10: Any, in T11: Any, in T12: Any, in T13: Any, in T14: Any, in T15: Any>(override val data: InsertData): InsertPart {
    infix fun AND(v: Value15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>): Repeat15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> = Repeat15(append(data, v.v1, v.v2, v.v3, v.v4, v.v5, v.v6, v.v7, v.v8, v.v9, v.v10, v.v11, v.v12, v.v13, v.v14, v.v15))
}
data class ValuePart15<in T1: Any, in T2: Any, in T3: Any, in T4: Any, in T5: Any, in T6: Any, in T7: Any, in T8: Any, in T9: Any, in T10: Any, in T11: Any, in T12: Any, in T13: Any, in T14: Any, in T15: Any>(private val f: Field15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>, override val data: InsertData): InsertPart, ExtraValues {
    infix fun VALUES(v: Value15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>): Repeat15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> = Repeat15(append(data, v.v1, v.v2, v.v3, v.v4, v.v5, v.v6, v.v7, v.v8, v.v9, v.v10, v.v11, v.v12, v.v13, v.v14, v.v15))
}

data class Field16<T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any, T8: Any, T9: Any, T10: Any, T11: Any, T12: Any, T13: Any, T14: Any, T15: Any, T16: Any>(val table: Table<*>, val c1: Column<T1>, val c2: Column<T2>, val c3: Column<T3>, val c4: Column<T4>, val c5: Column<T5>, val c6: Column<T6>, val c7: Column<T7>, val c8: Column<T8>, val c9: Column<T9>, val c10: Column<T10>, val c11: Column<T11>, val c12: Column<T12>, val c13: Column<T13>, val c14: Column<T14>, val c15: Column<T15>, val c16: Column<T16>)
data class Value16<out T1: Any, out T2: Any, out T3: Any, out T4: Any, out T5: Any, out T6: Any, out T7: Any, out T8: Any, out T9: Any, out T10: Any, out T11: Any, out T12: Any, out T13: Any, out T14: Any, out T15: Any, out T16: Any>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, val v5: T5, val v6: T6, val v7: T7, val v8: T8, val v9: T9, val v10: T10, val v11: T11, val v12: T12, val v13: T13, val v14: T14, val v15: T15, val v16: T16)
data class Repeat16<in T1: Any, in T2: Any, in T3: Any, in T4: Any, in T5: Any, in T6: Any, in T7: Any, in T8: Any, in T9: Any, in T10: Any, in T11: Any, in T12: Any, in T13: Any, in T14: Any, in T15: Any, in T16: Any>(override val data: InsertData): InsertPart {
    infix fun AND(v: Value16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>): Repeat16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> = Repeat16(append(data, v.v1, v.v2, v.v3, v.v4, v.v5, v.v6, v.v7, v.v8, v.v9, v.v10, v.v11, v.v12, v.v13, v.v14, v.v15, v.v16))
}
data class ValuePart16<in T1: Any, in T2: Any, in T3: Any, in T4: Any, in T5: Any, in T6: Any, in T7: Any, in T8: Any, in T9: Any, in T10: Any, in T11: Any, in T12: Any, in T13: Any, in T14: Any, in T15: Any, in T16: Any>(private val f: Field16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>, override val data: InsertData): InsertPart, ExtraValues {
    infix fun VALUES(v: Value16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>): Repeat16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> = Repeat16(append(data, v.v1, v.v2, v.v3, v.v4, v.v5, v.v6, v.v7, v.v8, v.v9, v.v10, v.v11, v.v12, v.v13, v.v14, v.v15, v.v16))
}

data class Field17<T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any, T8: Any, T9: Any, T10: Any, T11: Any, T12: Any, T13: Any, T14: Any, T15: Any, T16: Any, T17: Any>(val table: Table<*>, val c1: Column<T1>, val c2: Column<T2>, val c3: Column<T3>, val c4: Column<T4>, val c5: Column<T5>, val c6: Column<T6>, val c7: Column<T7>, val c8: Column<T8>, val c9: Column<T9>, val c10: Column<T10>, val c11: Column<T11>, val c12: Column<T12>, val c13: Column<T13>, val c14: Column<T14>, val c15: Column<T15>, val c16: Column<T16>, val c17: Column<T17>)
data class Value17<out T1: Any, out T2: Any, out T3: Any, out T4: Any, out T5: Any, out T6: Any, out T7: Any, out T8: Any, out T9: Any, out T10: Any, out T11: Any, out T12: Any, out T13: Any, out T14: Any, out T15: Any, out T16: Any, out T17: Any>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, val v5: T5, val v6: T6, val v7: T7, val v8: T8, val v9: T9, val v10: T10, val v11: T11, val v12: T12, val v13: T13, val v14: T14, val v15: T15, val v16: T16, val v17: T17)
data class Repeat17<in T1: Any, in T2: Any, in T3: Any, in T4: Any, in T5: Any, in T6: Any, in T7: Any, in T8: Any, in T9: Any, in T10: Any, in T11: Any, in T12: Any, in T13: Any, in T14: Any, in T15: Any, in T16: Any, in T17: Any>(override val data: InsertData): InsertPart {
    infix fun AND(v: Value17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>): Repeat17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> = Repeat17(append(data, v.v1, v.v2, v.v3, v.v4, v.v5, v.v6, v.v7, v.v8, v.v9, v.v10, v.v11, v.v12, v.v13, v.v14, v.v15, v.v16, v.v17))
}
data class ValuePart17<in T1: Any, in T2: Any, in T3: Any, in T4: Any, in T5: Any, in T6: Any, in T7: Any, in T8: Any, in T9: Any, in T10: Any, in T11: Any, in T12: Any, in T13: Any, in T14: Any, in T15: Any, in T16: Any, in T17: Any>(private val f: Field17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>, override val data: InsertData): InsertPart, ExtraValues {
    infix fun VALUES(v: Value17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>): Repeat17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> = Repeat17(append(data, v.v1, v.v2, v.v3, v.v4, v.v5, v.v6, v.v7, v.v8, v.v9, v.v10, v.v11, v.v12, v.v13, v.v14, v.v15, v.v16, v.v17))
}

data class Field18<T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any, T8: Any, T9: Any, T10: Any, T11: Any, T12: Any, T13: Any, T14: Any, T15: Any, T16: Any, T17: Any, T18: Any>(val table: Table<*>, val c1: Column<T1>, val c2: Column<T2>, val c3: Column<T3>, val c4: Column<T4>, val c5: Column<T5>, val c6: Column<T6>, val c7: Column<T7>, val c8: Column<T8>, val c9: Column<T9>, val c10: Column<T10>, val c11: Column<T11>, val c12: Column<T12>, val c13: Column<T13>, val c14: Column<T14>, val c15: Column<T15>, val c16: Column<T16>, val c17: Column<T17>, val c18: Column<T18>)
data class Value18<out T1: Any, out T2: Any, out T3: Any, out T4: Any, out T5: Any, out T6: Any, out T7: Any, out T8: Any, out T9: Any, out T10: Any, out T11: Any, out T12: Any, out T13: Any, out T14: Any, out T15: Any, out T16: Any, out T17: Any, out T18: Any>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, val v5: T5, val v6: T6, val v7: T7, val v8: T8, val v9: T9, val v10: T10, val v11: T11, val v12: T12, val v13: T13, val v14: T14, val v15: T15, val v16: T16, val v17: T17, val v18: T18)
data class Repeat18<in T1: Any, in T2: Any, in T3: Any, in T4: Any, in T5: Any, in T6: Any, in T7: Any, in T8: Any, in T9: Any, in T10: Any, in T11: Any, in T12: Any, in T13: Any, in T14: Any, in T15: Any, in T16: Any, in T17: Any, in T18: Any>(override val data: InsertData): InsertPart {
    infix fun AND(v: Value18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>): Repeat18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> = Repeat18(append(data, v.v1, v.v2, v.v3, v.v4, v.v5, v.v6, v.v7, v.v8, v.v9, v.v10, v.v11, v.v12, v.v13, v.v14, v.v15, v.v16, v.v17, v.v18))
}
data class ValuePart18<in T1: Any, in T2: Any, in T3: Any, in T4: Any, in T5: Any, in T6: Any, in T7: Any, in T8: Any, in T9: Any, in T10: Any, in T11: Any, in T12: Any, in T13: Any, in T14: Any, in T15: Any, in T16: Any, in T17: Any, in T18: Any>(private val f: Field18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>, override val data: InsertData): InsertPart, ExtraValues {
    infix fun VALUES(v: Value18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>): Repeat18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> = Repeat18(append(data, v.v1, v.v2, v.v3, v.v4, v.v5, v.v6, v.v7, v.v8, v.v9, v.v10, v.v11, v.v12, v.v13, v.v14, v.v15, v.v16, v.v17, v.v18))
}

data class Field19<T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any, T8: Any, T9: Any, T10: Any, T11: Any, T12: Any, T13: Any, T14: Any, T15: Any, T16: Any, T17: Any, T18: Any, T19: Any>(val table: Table<*>, val c1: Column<T1>, val c2: Column<T2>, val c3: Column<T3>, val c4: Column<T4>, val c5: Column<T5>, val c6: Column<T6>, val c7: Column<T7>, val c8: Column<T8>, val c9: Column<T9>, val c10: Column<T10>, val c11: Column<T11>, val c12: Column<T12>, val c13: Column<T13>, val c14: Column<T14>, val c15: Column<T15>, val c16: Column<T16>, val c17: Column<T17>, val c18: Column<T18>, val c19: Column<T19>)
data class Value19<out T1: Any, out T2: Any, out T3: Any, out T4: Any, out T5: Any, out T6: Any, out T7: Any, out T8: Any, out T9: Any, out T10: Any, out T11: Any, out T12: Any, out T13: Any, out T14: Any, out T15: Any, out T16: Any, out T17: Any, out T18: Any, out T19: Any>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, val v5: T5, val v6: T6, val v7: T7, val v8: T8, val v9: T9, val v10: T10, val v11: T11, val v12: T12, val v13: T13, val v14: T14, val v15: T15, val v16: T16, val v17: T17, val v18: T18, val v19: T19)
data class Repeat19<in T1: Any, in T2: Any, in T3: Any, in T4: Any, in T5: Any, in T6: Any, in T7: Any, in T8: Any, in T9: Any, in T10: Any, in T11: Any, in T12: Any, in T13: Any, in T14: Any, in T15: Any, in T16: Any, in T17: Any, in T18: Any, in T19: Any>(override val data: InsertData): InsertPart {
    infix fun AND(v: Value19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>): Repeat19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> = Repeat19(append(data, v.v1, v.v2, v.v3, v.v4, v.v5, v.v6, v.v7, v.v8, v.v9, v.v10, v.v11, v.v12, v.v13, v.v14, v.v15, v.v16, v.v17, v.v18, v.v19))
}
data class ValuePart19<in T1: Any, in T2: Any, in T3: Any, in T4: Any, in T5: Any, in T6: Any, in T7: Any, in T8: Any, in T9: Any, in T10: Any, in T11: Any, in T12: Any, in T13: Any, in T14: Any, in T15: Any, in T16: Any, in T17: Any, in T18: Any, in T19: Any>(private val f: Field19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>, override val data: InsertData): InsertPart, ExtraValues {
    infix fun VALUES(v: Value19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>): Repeat19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> = Repeat19(append(data, v.v1, v.v2, v.v3, v.v4, v.v5, v.v6, v.v7, v.v8, v.v9, v.v10, v.v11, v.v12, v.v13, v.v14, v.v15, v.v16, v.v17, v.v18, v.v19))
}

data class Field20<T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any, T8: Any, T9: Any, T10: Any, T11: Any, T12: Any, T13: Any, T14: Any, T15: Any, T16: Any, T17: Any, T18: Any, T19: Any, T20: Any>(val table: Table<*>, val c1: Column<T1>, val c2: Column<T2>, val c3: Column<T3>, val c4: Column<T4>, val c5: Column<T5>, val c6: Column<T6>, val c7: Column<T7>, val c8: Column<T8>, val c9: Column<T9>, val c10: Column<T10>, val c11: Column<T11>, val c12: Column<T12>, val c13: Column<T13>, val c14: Column<T14>, val c15: Column<T15>, val c16: Column<T16>, val c17: Column<T17>, val c18: Column<T18>, val c19: Column<T19>, val c20: Column<T20>)
data class Value20<out T1: Any, out T2: Any, out T3: Any, out T4: Any, out T5: Any, out T6: Any, out T7: Any, out T8: Any, out T9: Any, out T10: Any, out T11: Any, out T12: Any, out T13: Any, out T14: Any, out T15: Any, out T16: Any, out T17: Any, out T18: Any, out T19: Any, out T20: Any>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, val v5: T5, val v6: T6, val v7: T7, val v8: T8, val v9: T9, val v10: T10, val v11: T11, val v12: T12, val v13: T13, val v14: T14, val v15: T15, val v16: T16, val v17: T17, val v18: T18, val v19: T19, val v20: T20)
data class Repeat20<in T1: Any, in T2: Any, in T3: Any, in T4: Any, in T5: Any, in T6: Any, in T7: Any, in T8: Any, in T9: Any, in T10: Any, in T11: Any, in T12: Any, in T13: Any, in T14: Any, in T15: Any, in T16: Any, in T17: Any, in T18: Any, in T19: Any, in T20: Any>(override val data: InsertData): InsertPart {
    infix fun AND(v: Value20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>): Repeat20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> = Repeat20(append(data, v.v1, v.v2, v.v3, v.v4, v.v5, v.v6, v.v7, v.v8, v.v9, v.v10, v.v11, v.v12, v.v13, v.v14, v.v15, v.v16, v.v17, v.v18, v.v19, v.v20))
}
data class ValuePart20<in T1: Any, in T2: Any, in T3: Any, in T4: Any, in T5: Any, in T6: Any, in T7: Any, in T8: Any, in T9: Any, in T10: Any, in T11: Any, in T12: Any, in T13: Any, in T14: Any, in T15: Any, in T16: Any, in T17: Any, in T18: Any, in T19: Any, in T20: Any>(private val f: Field20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>, override val data: InsertData): InsertPart, ExtraValues {
    infix fun VALUES(v: Value20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>): Repeat20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> = Repeat20(append(data, v.v1, v.v2, v.v3, v.v4, v.v5, v.v6, v.v7, v.v8, v.v9, v.v10, v.v11, v.v12, v.v13, v.v14, v.v15, v.v16, v.v17, v.v18, v.v19, v.v20))
}

data class Field21<T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any, T8: Any, T9: Any, T10: Any, T11: Any, T12: Any, T13: Any, T14: Any, T15: Any, T16: Any, T17: Any, T18: Any, T19: Any, T20: Any, T21: Any>(val table: Table<*>, val c1: Column<T1>, val c2: Column<T2>, val c3: Column<T3>, val c4: Column<T4>, val c5: Column<T5>, val c6: Column<T6>, val c7: Column<T7>, val c8: Column<T8>, val c9: Column<T9>, val c10: Column<T10>, val c11: Column<T11>, val c12: Column<T12>, val c13: Column<T13>, val c14: Column<T14>, val c15: Column<T15>, val c16: Column<T16>, val c17: Column<T17>, val c18: Column<T18>, val c19: Column<T19>, val c20: Column<T20>, val c21: Column<T21>)
data class Value21<out T1: Any, out T2: Any, out T3: Any, out T4: Any, out T5: Any, out T6: Any, out T7: Any, out T8: Any, out T9: Any, out T10: Any, out T11: Any, out T12: Any, out T13: Any, out T14: Any, out T15: Any, out T16: Any, out T17: Any, out T18: Any, out T19: Any, out T20: Any, out T21: Any>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, val v5: T5, val v6: T6, val v7: T7, val v8: T8, val v9: T9, val v10: T10, val v11: T11, val v12: T12, val v13: T13, val v14: T14, val v15: T15, val v16: T16, val v17: T17, val v18: T18, val v19: T19, val v20: T20, val v21: T21)
data class Repeat21<in T1: Any, in T2: Any, in T3: Any, in T4: Any, in T5: Any, in T6: Any, in T7: Any, in T8: Any, in T9: Any, in T10: Any, in T11: Any, in T12: Any, in T13: Any, in T14: Any, in T15: Any, in T16: Any, in T17: Any, in T18: Any, in T19: Any, in T20: Any, in T21: Any>(override val data: InsertData): InsertPart {
    infix fun AND(v: Value21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>): Repeat21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> = Repeat21(append(data, v.v1, v.v2, v.v3, v.v4, v.v5, v.v6, v.v7, v.v8, v.v9, v.v10, v.v11, v.v12, v.v13, v.v14, v.v15, v.v16, v.v17, v.v18, v.v19, v.v20, v.v21))
}
data class ValuePart21<in T1: Any, in T2: Any, in T3: Any, in T4: Any, in T5: Any, in T6: Any, in T7: Any, in T8: Any, in T9: Any, in T10: Any, in T11: Any, in T12: Any, in T13: Any, in T14: Any, in T15: Any, in T16: Any, in T17: Any, in T18: Any, in T19: Any, in T20: Any, in T21: Any>(private val f: Field21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>, override val data: InsertData): InsertPart, ExtraValues {
    infix fun VALUES(v: Value21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>): Repeat21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> = Repeat21(append(data, v.v1, v.v2, v.v3, v.v4, v.v5, v.v6, v.v7, v.v8, v.v9, v.v10, v.v11, v.v12, v.v13, v.v14, v.v15, v.v16, v.v17, v.v18, v.v19, v.v20, v.v21))
}

data class Field22<T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any, T8: Any, T9: Any, T10: Any, T11: Any, T12: Any, T13: Any, T14: Any, T15: Any, T16: Any, T17: Any, T18: Any, T19: Any, T20: Any, T21: Any, T22: Any>(val table: Table<*>, val c1: Column<T1>, val c2: Column<T2>, val c3: Column<T3>, val c4: Column<T4>, val c5: Column<T5>, val c6: Column<T6>, val c7: Column<T7>, val c8: Column<T8>, val c9: Column<T9>, val c10: Column<T10>, val c11: Column<T11>, val c12: Column<T12>, val c13: Column<T13>, val c14: Column<T14>, val c15: Column<T15>, val c16: Column<T16>, val c17: Column<T17>, val c18: Column<T18>, val c19: Column<T19>, val c20: Column<T20>, val c21: Column<T21>, val c22: Column<T22>)
data class Value22<out T1: Any, out T2: Any, out T3: Any, out T4: Any, out T5: Any, out T6: Any, out T7: Any, out T8: Any, out T9: Any, out T10: Any, out T11: Any, out T12: Any, out T13: Any, out T14: Any, out T15: Any, out T16: Any, out T17: Any, out T18: Any, out T19: Any, out T20: Any, out T21: Any, out T22: Any>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, val v5: T5, val v6: T6, val v7: T7, val v8: T8, val v9: T9, val v10: T10, val v11: T11, val v12: T12, val v13: T13, val v14: T14, val v15: T15, val v16: T16, val v17: T17, val v18: T18, val v19: T19, val v20: T20, val v21: T21, val v22: T22)
data class Repeat22<in T1: Any, in T2: Any, in T3: Any, in T4: Any, in T5: Any, in T6: Any, in T7: Any, in T8: Any, in T9: Any, in T10: Any, in T11: Any, in T12: Any, in T13: Any, in T14: Any, in T15: Any, in T16: Any, in T17: Any, in T18: Any, in T19: Any, in T20: Any, in T21: Any, in T22: Any>(override val data: InsertData): InsertPart {
    infix fun AND(v: Value22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>): Repeat22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> = Repeat22(append(data, v.v1, v.v2, v.v3, v.v4, v.v5, v.v6, v.v7, v.v8, v.v9, v.v10, v.v11, v.v12, v.v13, v.v14, v.v15, v.v16, v.v17, v.v18, v.v19, v.v20, v.v21, v.v22))
}
data class ValuePart22<in T1: Any, in T2: Any, in T3: Any, in T4: Any, in T5: Any, in T6: Any, in T7: Any, in T8: Any, in T9: Any, in T10: Any, in T11: Any, in T12: Any, in T13: Any, in T14: Any, in T15: Any, in T16: Any, in T17: Any, in T18: Any, in T19: Any, in T20: Any, in T21: Any, in T22: Any>(private val f: Field22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>, override val data: InsertData): InsertPart, ExtraValues {
    infix fun VALUES(v: Value22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>): Repeat22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> = Repeat22(append(data, v.v1, v.v2, v.v3, v.v4, v.v5, v.v6, v.v7, v.v8, v.v9, v.v10, v.v11, v.v12, v.v13, v.v14, v.v15, v.v16, v.v17, v.v18, v.v19, v.v20, v.v21, v.v22))
}

interface Inserts {

    /* create by template:
    fun template2(v: Int) = (1..v).forEach { println("""
        |infix fun<${times(it) {"T$it: Any"}}> Insert.INSERT.INTO(f: Field$it<${times(it) {"T$it"}}>): ValuePart$it<${times(it) {"T$it"}}> = ValuePart$it(f, InsertData(f.table, listOf(${times(it) {"f.c$it"}})))
    """.trimMargin())}
     */
    infix fun<T1: Any> Insert.INSERT.INTO(f: Field1<T1>): ValuePart1<T1> = ValuePart1(f, InsertData(f.table, listOf(f.c1)))
    infix fun<T1: Any, T2: Any> Insert.INSERT.INTO(f: Field2<T1, T2>): ValuePart2<T1, T2> = ValuePart2(f, InsertData(f.table, listOf(f.c1, f.c2)))
    infix fun<T1: Any, T2: Any, T3: Any> Insert.INSERT.INTO(f: Field3<T1, T2, T3>): ValuePart3<T1, T2, T3> = ValuePart3(f, InsertData(f.table, listOf(f.c1, f.c2, f.c3)))
    infix fun<T1: Any, T2: Any, T3: Any, T4: Any> Insert.INSERT.INTO(f: Field4<T1, T2, T3, T4>): ValuePart4<T1, T2, T3, T4> = ValuePart4(f, InsertData(f.table, listOf(f.c1, f.c2, f.c3, f.c4)))
    infix fun<T1: Any, T2: Any, T3: Any, T4: Any, T5: Any> Insert.INSERT.INTO(f: Field5<T1, T2, T3, T4, T5>): ValuePart5<T1, T2, T3, T4, T5> = ValuePart5(f, InsertData(f.table, listOf(f.c1, f.c2, f.c3, f.c4, f.c5)))
    infix fun<T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any> Insert.INSERT.INTO(f: Field6<T1, T2, T3, T4, T5, T6>): ValuePart6<T1, T2, T3, T4, T5, T6> = ValuePart6(f, InsertData(f.table, listOf(f.c1, f.c2, f.c3, f.c4, f.c5, f.c6)))
    infix fun<T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any> Insert.INSERT.INTO(f: Field7<T1, T2, T3, T4, T5, T6, T7>): ValuePart7<T1, T2, T3, T4, T5, T6, T7> = ValuePart7(f, InsertData(f.table, listOf(f.c1, f.c2, f.c3, f.c4, f.c5, f.c6, f.c7)))
    infix fun<T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any, T8: Any> Insert.INSERT.INTO(f: Field8<T1, T2, T3, T4, T5, T6, T7, T8>): ValuePart8<T1, T2, T3, T4, T5, T6, T7, T8> = ValuePart8(f, InsertData(f.table, listOf(f.c1, f.c2, f.c3, f.c4, f.c5, f.c6, f.c7, f.c8)))
    infix fun<T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any, T8: Any, T9: Any> Insert.INSERT.INTO(f: Field9<T1, T2, T3, T4, T5, T6, T7, T8, T9>): ValuePart9<T1, T2, T3, T4, T5, T6, T7, T8, T9> = ValuePart9(f, InsertData(f.table, listOf(f.c1, f.c2, f.c3, f.c4, f.c5, f.c6, f.c7, f.c8, f.c9)))
    infix fun<T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any, T8: Any, T9: Any, T10: Any> Insert.INSERT.INTO(f: Field10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>): ValuePart10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> = ValuePart10(f, InsertData(f.table, listOf(f.c1, f.c2, f.c3, f.c4, f.c5, f.c6, f.c7, f.c8, f.c9, f.c10)))
    infix fun<T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any, T8: Any, T9: Any, T10: Any, T11: Any> Insert.INSERT.INTO(f: Field11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>): ValuePart11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> = ValuePart11(f, InsertData(f.table, listOf(f.c1, f.c2, f.c3, f.c4, f.c5, f.c6, f.c7, f.c8, f.c9, f.c10, f.c11)))
    infix fun<T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any, T8: Any, T9: Any, T10: Any, T11: Any, T12: Any> Insert.INSERT.INTO(f: Field12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>): ValuePart12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> = ValuePart12(f, InsertData(f.table, listOf(f.c1, f.c2, f.c3, f.c4, f.c5, f.c6, f.c7, f.c8, f.c9, f.c10, f.c11, f.c12)))
    infix fun<T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any, T8: Any, T9: Any, T10: Any, T11: Any, T12: Any, T13: Any> Insert.INSERT.INTO(f: Field13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>): ValuePart13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> = ValuePart13(f, InsertData(f.table, listOf(f.c1, f.c2, f.c3, f.c4, f.c5, f.c6, f.c7, f.c8, f.c9, f.c10, f.c11, f.c12, f.c13)))
    infix fun<T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any, T8: Any, T9: Any, T10: Any, T11: Any, T12: Any, T13: Any, T14: Any> Insert.INSERT.INTO(f: Field14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>): ValuePart14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> = ValuePart14(f, InsertData(f.table, listOf(f.c1, f.c2, f.c3, f.c4, f.c5, f.c6, f.c7, f.c8, f.c9, f.c10, f.c11, f.c12, f.c13, f.c14)))
    infix fun<T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any, T8: Any, T9: Any, T10: Any, T11: Any, T12: Any, T13: Any, T14: Any, T15: Any> Insert.INSERT.INTO(f: Field15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>): ValuePart15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> = ValuePart15(f, InsertData(f.table, listOf(f.c1, f.c2, f.c3, f.c4, f.c5, f.c6, f.c7, f.c8, f.c9, f.c10, f.c11, f.c12, f.c13, f.c14, f.c15)))
    infix fun<T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any, T8: Any, T9: Any, T10: Any, T11: Any, T12: Any, T13: Any, T14: Any, T15: Any, T16: Any> Insert.INSERT.INTO(f: Field16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>): ValuePart16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> = ValuePart16(f, InsertData(f.table, listOf(f.c1, f.c2, f.c3, f.c4, f.c5, f.c6, f.c7, f.c8, f.c9, f.c10, f.c11, f.c12, f.c13, f.c14, f.c15, f.c16)))
    infix fun<T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any, T8: Any, T9: Any, T10: Any, T11: Any, T12: Any, T13: Any, T14: Any, T15: Any, T16: Any, T17: Any> Insert.INSERT.INTO(f: Field17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>): ValuePart17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> = ValuePart17(f, InsertData(f.table, listOf(f.c1, f.c2, f.c3, f.c4, f.c5, f.c6, f.c7, f.c8, f.c9, f.c10, f.c11, f.c12, f.c13, f.c14, f.c15, f.c16, f.c17)))
    infix fun<T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any, T8: Any, T9: Any, T10: Any, T11: Any, T12: Any, T13: Any, T14: Any, T15: Any, T16: Any, T17: Any, T18: Any> Insert.INSERT.INTO(f: Field18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>): ValuePart18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> = ValuePart18(f, InsertData(f.table, listOf(f.c1, f.c2, f.c3, f.c4, f.c5, f.c6, f.c7, f.c8, f.c9, f.c10, f.c11, f.c12, f.c13, f.c14, f.c15, f.c16, f.c17, f.c18)))
    infix fun<T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any, T8: Any, T9: Any, T10: Any, T11: Any, T12: Any, T13: Any, T14: Any, T15: Any, T16: Any, T17: Any, T18: Any, T19: Any> Insert.INSERT.INTO(f: Field19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>): ValuePart19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> = ValuePart19(f, InsertData(f.table, listOf(f.c1, f.c2, f.c3, f.c4, f.c5, f.c6, f.c7, f.c8, f.c9, f.c10, f.c11, f.c12, f.c13, f.c14, f.c15, f.c16, f.c17, f.c18, f.c19)))
    infix fun<T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any, T8: Any, T9: Any, T10: Any, T11: Any, T12: Any, T13: Any, T14: Any, T15: Any, T16: Any, T17: Any, T18: Any, T19: Any, T20: Any> Insert.INSERT.INTO(f: Field20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>): ValuePart20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> = ValuePart20(f, InsertData(f.table, listOf(f.c1, f.c2, f.c3, f.c4, f.c5, f.c6, f.c7, f.c8, f.c9, f.c10, f.c11, f.c12, f.c13, f.c14, f.c15, f.c16, f.c17, f.c18, f.c19, f.c20)))
    infix fun<T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any, T8: Any, T9: Any, T10: Any, T11: Any, T12: Any, T13: Any, T14: Any, T15: Any, T16: Any, T17: Any, T18: Any, T19: Any, T20: Any, T21: Any> Insert.INSERT.INTO(f: Field21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>): ValuePart21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> = ValuePart21(f, InsertData(f.table, listOf(f.c1, f.c2, f.c3, f.c4, f.c5, f.c6, f.c7, f.c8, f.c9, f.c10, f.c11, f.c12, f.c13, f.c14, f.c15, f.c16, f.c17, f.c18, f.c19, f.c20, f.c21)))
    infix fun<T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any, T8: Any, T9: Any, T10: Any, T11: Any, T12: Any, T13: Any, T14: Any, T15: Any, T16: Any, T17: Any, T18: Any, T19: Any, T20: Any, T21: Any, T22: Any> Insert.INSERT.INTO(f: Field22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>): ValuePart22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> = ValuePart22(f, InsertData(f.table, listOf(f.c1, f.c2, f.c3, f.c4, f.c5, f.c6, f.c7, f.c8, f.c9, f.c10, f.c11, f.c12, f.c13, f.c14, f.c15, f.c16, f.c17, f.c18, f.c19, f.c20, f.c21, f.c22)))

    /* create by template:
    fun template3(v: Int) = (1..v).forEach { println("""
        |
        |fun <${times(it) {"T$it: Any"}}> V(${times(it) {"v$it: T$it"}}): Value$it<${times(it) {"T$it"}}> = Value$it(${times(it) {"v$it"}})
        |operator fun <${times(it) {"T$it: Any"}}> Table<*>.invoke(${times(it) {"c$it: Column<T$it>"}}): Field$it<${times(it) {"T$it"}}> = Field$it(this, ${times(it) {"c$it"}})
    """.trimMargin()) }
     */
    fun <T1: Any> V(v1: T1): Value1<T1> = Value1(v1)
    operator fun <T1: Any> Table<*>.invoke(c1: Column<T1>): Field1<T1> = Field1(this, c1)

    fun <T1: Any, T2: Any> V(v1: T1, v2: T2): Value2<T1, T2> = Value2(v1, v2)
    operator fun <T1: Any, T2: Any> Table<*>.invoke(c1: Column<T1>, c2: Column<T2>): Field2<T1, T2> = Field2(this, c1, c2)

    fun <T1: Any, T2: Any, T3: Any> V(v1: T1, v2: T2, v3: T3): Value3<T1, T2, T3> = Value3(v1, v2, v3)
    operator fun <T1: Any, T2: Any, T3: Any> Table<*>.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>): Field3<T1, T2, T3> = Field3(this, c1, c2, c3)

    fun <T1: Any, T2: Any, T3: Any, T4: Any> V(v1: T1, v2: T2, v3: T3, v4: T4): Value4<T1, T2, T3, T4> = Value4(v1, v2, v3, v4)
    operator fun <T1: Any, T2: Any, T3: Any, T4: Any> Table<*>.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>): Field4<T1, T2, T3, T4> = Field4(this, c1, c2, c3, c4)

    fun <T1: Any, T2: Any, T3: Any, T4: Any, T5: Any> V(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5): Value5<T1, T2, T3, T4, T5> = Value5(v1, v2, v3, v4, v5)
    operator fun <T1: Any, T2: Any, T3: Any, T4: Any, T5: Any> Table<*>.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>): Field5<T1, T2, T3, T4, T5> = Field5(this, c1, c2, c3, c4, c5)

    fun <T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any> V(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6): Value6<T1, T2, T3, T4, T5, T6> = Value6(v1, v2, v3, v4, v5, v6)
    operator fun <T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any> Table<*>.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>): Field6<T1, T2, T3, T4, T5, T6> = Field6(this, c1, c2, c3, c4, c5, c6)

    fun <T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any> V(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7): Value7<T1, T2, T3, T4, T5, T6, T7> = Value7(v1, v2, v3, v4, v5, v6, v7)
    operator fun <T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any> Table<*>.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>): Field7<T1, T2, T3, T4, T5, T6, T7> = Field7(this, c1, c2, c3, c4, c5, c6, c7)

    fun <T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any, T8: Any> V(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8): Value8<T1, T2, T3, T4, T5, T6, T7, T8> = Value8(v1, v2, v3, v4, v5, v6, v7, v8)
    operator fun <T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any, T8: Any> Table<*>.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>): Field8<T1, T2, T3, T4, T5, T6, T7, T8> = Field8(this, c1, c2, c3, c4, c5, c6, c7, c8)

    fun <T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any, T8: Any, T9: Any> V(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8, v9: T9): Value9<T1, T2, T3, T4, T5, T6, T7, T8, T9> = Value9(v1, v2, v3, v4, v5, v6, v7, v8, v9)
    operator fun <T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any, T8: Any, T9: Any> Table<*>.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>): Field9<T1, T2, T3, T4, T5, T6, T7, T8, T9> = Field9(this, c1, c2, c3, c4, c5, c6, c7, c8, c9)

    fun <T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any, T8: Any, T9: Any, T10: Any> V(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8, v9: T9, v10: T10): Value10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> = Value10(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10)
    operator fun <T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any, T8: Any, T9: Any, T10: Any> Table<*>.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>): Field10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> = Field10(this, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10)

    fun <T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any, T8: Any, T9: Any, T10: Any, T11: Any> V(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8, v9: T9, v10: T10, v11: T11): Value11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> = Value11(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11)
    operator fun <T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any, T8: Any, T9: Any, T10: Any, T11: Any> Table<*>.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>): Field11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> = Field11(this, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11)

    fun <T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any, T8: Any, T9: Any, T10: Any, T11: Any, T12: Any> V(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8, v9: T9, v10: T10, v11: T11, v12: T12): Value12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> = Value12(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12)
    operator fun <T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any, T8: Any, T9: Any, T10: Any, T11: Any, T12: Any> Table<*>.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>): Field12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> = Field12(this, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12)

    fun <T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any, T8: Any, T9: Any, T10: Any, T11: Any, T12: Any, T13: Any> V(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8, v9: T9, v10: T10, v11: T11, v12: T12, v13: T13): Value13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> = Value13(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13)
    operator fun <T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any, T8: Any, T9: Any, T10: Any, T11: Any, T12: Any, T13: Any> Table<*>.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>): Field13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> = Field13(this, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13)

    fun <T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any, T8: Any, T9: Any, T10: Any, T11: Any, T12: Any, T13: Any, T14: Any> V(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8, v9: T9, v10: T10, v11: T11, v12: T12, v13: T13, v14: T14): Value14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> = Value14(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14)
    operator fun <T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any, T8: Any, T9: Any, T10: Any, T11: Any, T12: Any, T13: Any, T14: Any> Table<*>.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>): Field14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> = Field14(this, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14)

    fun <T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any, T8: Any, T9: Any, T10: Any, T11: Any, T12: Any, T13: Any, T14: Any, T15: Any> V(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8, v9: T9, v10: T10, v11: T11, v12: T12, v13: T13, v14: T14, v15: T15): Value15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> = Value15(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15)
    operator fun <T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any, T8: Any, T9: Any, T10: Any, T11: Any, T12: Any, T13: Any, T14: Any, T15: Any> Table<*>.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>, c15: Column<T15>): Field15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> = Field15(this, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15)

    fun <T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any, T8: Any, T9: Any, T10: Any, T11: Any, T12: Any, T13: Any, T14: Any, T15: Any, T16: Any> V(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8, v9: T9, v10: T10, v11: T11, v12: T12, v13: T13, v14: T14, v15: T15, v16: T16): Value16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> = Value16(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16)
    operator fun <T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any, T8: Any, T9: Any, T10: Any, T11: Any, T12: Any, T13: Any, T14: Any, T15: Any, T16: Any> Table<*>.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>, c15: Column<T15>, c16: Column<T16>): Field16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> = Field16(this, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16)

    fun <T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any, T8: Any, T9: Any, T10: Any, T11: Any, T12: Any, T13: Any, T14: Any, T15: Any, T16: Any, T17: Any> V(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8, v9: T9, v10: T10, v11: T11, v12: T12, v13: T13, v14: T14, v15: T15, v16: T16, v17: T17): Value17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> = Value17(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17)
    operator fun <T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any, T8: Any, T9: Any, T10: Any, T11: Any, T12: Any, T13: Any, T14: Any, T15: Any, T16: Any, T17: Any> Table<*>.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>, c15: Column<T15>, c16: Column<T16>, c17: Column<T17>): Field17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> = Field17(this, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17)

    fun <T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any, T8: Any, T9: Any, T10: Any, T11: Any, T12: Any, T13: Any, T14: Any, T15: Any, T16: Any, T17: Any, T18: Any> V(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8, v9: T9, v10: T10, v11: T11, v12: T12, v13: T13, v14: T14, v15: T15, v16: T16, v17: T17, v18: T18): Value18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> = Value18(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18)
    operator fun <T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any, T8: Any, T9: Any, T10: Any, T11: Any, T12: Any, T13: Any, T14: Any, T15: Any, T16: Any, T17: Any, T18: Any> Table<*>.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>, c15: Column<T15>, c16: Column<T16>, c17: Column<T17>, c18: Column<T18>): Field18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> = Field18(this, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18)

    fun <T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any, T8: Any, T9: Any, T10: Any, T11: Any, T12: Any, T13: Any, T14: Any, T15: Any, T16: Any, T17: Any, T18: Any, T19: Any> V(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8, v9: T9, v10: T10, v11: T11, v12: T12, v13: T13, v14: T14, v15: T15, v16: T16, v17: T17, v18: T18, v19: T19): Value19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> = Value19(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18, v19)
    operator fun <T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any, T8: Any, T9: Any, T10: Any, T11: Any, T12: Any, T13: Any, T14: Any, T15: Any, T16: Any, T17: Any, T18: Any, T19: Any> Table<*>.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>, c15: Column<T15>, c16: Column<T16>, c17: Column<T17>, c18: Column<T18>, c19: Column<T19>): Field19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> = Field19(this, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19)

    fun <T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any, T8: Any, T9: Any, T10: Any, T11: Any, T12: Any, T13: Any, T14: Any, T15: Any, T16: Any, T17: Any, T18: Any, T19: Any, T20: Any> V(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8, v9: T9, v10: T10, v11: T11, v12: T12, v13: T13, v14: T14, v15: T15, v16: T16, v17: T17, v18: T18, v19: T19, v20: T20): Value20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> = Value20(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18, v19, v20)
    operator fun <T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any, T8: Any, T9: Any, T10: Any, T11: Any, T12: Any, T13: Any, T14: Any, T15: Any, T16: Any, T17: Any, T18: Any, T19: Any, T20: Any> Table<*>.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>, c15: Column<T15>, c16: Column<T16>, c17: Column<T17>, c18: Column<T18>, c19: Column<T19>, c20: Column<T20>): Field20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> = Field20(this, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20)

    fun <T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any, T8: Any, T9: Any, T10: Any, T11: Any, T12: Any, T13: Any, T14: Any, T15: Any, T16: Any, T17: Any, T18: Any, T19: Any, T20: Any, T21: Any> V(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8, v9: T9, v10: T10, v11: T11, v12: T12, v13: T13, v14: T14, v15: T15, v16: T16, v17: T17, v18: T18, v19: T19, v20: T20, v21: T21): Value21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> = Value21(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18, v19, v20, v21)
    operator fun <T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any, T8: Any, T9: Any, T10: Any, T11: Any, T12: Any, T13: Any, T14: Any, T15: Any, T16: Any, T17: Any, T18: Any, T19: Any, T20: Any, T21: Any> Table<*>.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>, c15: Column<T15>, c16: Column<T16>, c17: Column<T17>, c18: Column<T18>, c19: Column<T19>, c20: Column<T20>, c21: Column<T21>): Field21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> = Field21(this, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21)

    fun <T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any, T8: Any, T9: Any, T10: Any, T11: Any, T12: Any, T13: Any, T14: Any, T15: Any, T16: Any, T17: Any, T18: Any, T19: Any, T20: Any, T21: Any, T22: Any> V(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8, v9: T9, v10: T10, v11: T11, v12: T12, v13: T13, v14: T14, v15: T15, v16: T16, v17: T17, v18: T18, v19: T19, v20: T20, v21: T21, v22: T22): Value22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> = Value22(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18, v19, v20, v21, v22)
    operator fun <T1: Any, T2: Any, T3: Any, T4: Any, T5: Any, T6: Any, T7: Any, T8: Any, T9: Any, T10: Any, T11: Any, T12: Any, T13: Any, T14: Any, T15: Any, T16: Any, T17: Any, T18: Any, T19: Any, T20: Any, T21: Any, T22: Any> Table<*>.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>, c15: Column<T15>, c16: Column<T16>, c17: Column<T17>, c18: Column<T18>, c19: Column<T19>, c20: Column<T20>, c21: Column<T21>, c22: Column<T22>): Field22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> = Field22(this, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21, c22)

}