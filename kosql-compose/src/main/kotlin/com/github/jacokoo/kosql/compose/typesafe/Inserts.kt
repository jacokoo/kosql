package com.github.jacokoo.kosql.compose.typesafe

import com.github.jacokoo.kosql.compose.Column
import com.github.jacokoo.kosql.compose.Table
import com.github.jacokoo.kosql.compose.Entity
import com.github.jacokoo.kosql.compose.statements.*

data class Field1<T, T1>(val table: Table<T, Entity<T>>, val c: Column1<T1>): ExtraValues<T> {
    override val data: InsertData<T> = InsertData(table, c, listOf())
    infix fun VALUES(v: Value1<out T1>): Repeat1<T, T1> = Repeat1(data.copy(values = data.values + v))
}
data class Repeat1<T, T1>(override val data: InsertData<T>): InsertStatement<T> {
    infix fun AND(v: Value1<out T1>): BatchRepeat1<T, T1> = BatchRepeat1(data.copy(values = data.values + v))
}
data class BatchRepeat1<T, T1>(override val data: InsertData<T>): BatchInsertStatement<T> {
    infix fun AND(v: Value1<out T1>): BatchRepeat1<T, T1> = BatchRepeat1(data.copy(values = data.values + v))
}
data class Field2<T, T1, T2>(val table: Table<T, Entity<T>>, val c: Column2<T1, T2>): ExtraValues<T> {
    override val data: InsertData<T> = InsertData(table, c, listOf())
    infix fun VALUES(v: Value2<out T1, out T2>): Repeat2<T, T1, T2> = Repeat2(data.copy(values = data.values + v))
}
data class Repeat2<T, T1, T2>(override val data: InsertData<T>): InsertStatement<T> {
    infix fun AND(v: Value2<out T1, out T2>): BatchRepeat2<T, T1, T2> = BatchRepeat2(data.copy(values = data.values + v))
}
data class BatchRepeat2<T, T1, T2>(override val data: InsertData<T>): BatchInsertStatement<T> {
    infix fun AND(v: Value2<out T1, out T2>): BatchRepeat2<T, T1, T2> = BatchRepeat2(data.copy(values = data.values + v))
}
data class Field3<T, T1, T2, T3>(val table: Table<T, Entity<T>>, val c: Column3<T1, T2, T3>): ExtraValues<T> {
    override val data: InsertData<T> = InsertData(table, c, listOf())
    infix fun VALUES(v: Value3<out T1, out T2, out T3>): Repeat3<T, T1, T2, T3> = Repeat3(data.copy(values = data.values + v))
}
data class Repeat3<T, T1, T2, T3>(override val data: InsertData<T>): InsertStatement<T> {
    infix fun AND(v: Value3<out T1, out T2, out T3>): BatchRepeat3<T, T1, T2, T3> = BatchRepeat3(data.copy(values = data.values + v))
}
data class BatchRepeat3<T, T1, T2, T3>(override val data: InsertData<T>): BatchInsertStatement<T> {
    infix fun AND(v: Value3<out T1, out T2, out T3>): BatchRepeat3<T, T1, T2, T3> = BatchRepeat3(data.copy(values = data.values + v))
}
data class Field4<T, T1, T2, T3, T4>(val table: Table<T, Entity<T>>, val c: Column4<T1, T2, T3, T4>): ExtraValues<T> {
    override val data: InsertData<T> = InsertData(table, c, listOf())
    infix fun VALUES(v: Value4<out T1, out T2, out T3, out T4>): Repeat4<T, T1, T2, T3, T4> = Repeat4(data.copy(values = data.values + v))
}
data class Repeat4<T, T1, T2, T3, T4>(override val data: InsertData<T>): InsertStatement<T> {
    infix fun AND(v: Value4<out T1, out T2, out T3, out T4>): BatchRepeat4<T, T1, T2, T3, T4> = BatchRepeat4(data.copy(values = data.values + v))
}
data class BatchRepeat4<T, T1, T2, T3, T4>(override val data: InsertData<T>): BatchInsertStatement<T> {
    infix fun AND(v: Value4<out T1, out T2, out T3, out T4>): BatchRepeat4<T, T1, T2, T3, T4> = BatchRepeat4(data.copy(values = data.values + v))
}
data class Field5<T, T1, T2, T3, T4, T5>(val table: Table<T, Entity<T>>, val c: Column5<T1, T2, T3, T4, T5>): ExtraValues<T> {
    override val data: InsertData<T> = InsertData(table, c, listOf())
    infix fun VALUES(v: Value5<out T1, out T2, out T3, out T4, out T5>): Repeat5<T, T1, T2, T3, T4, T5> = Repeat5(data.copy(values = data.values + v))
}
data class Repeat5<T, T1, T2, T3, T4, T5>(override val data: InsertData<T>): InsertStatement<T> {
    infix fun AND(v: Value5<out T1, out T2, out T3, out T4, out T5>): BatchRepeat5<T, T1, T2, T3, T4, T5> = BatchRepeat5(data.copy(values = data.values + v))
}
data class BatchRepeat5<T, T1, T2, T3, T4, T5>(override val data: InsertData<T>): BatchInsertStatement<T> {
    infix fun AND(v: Value5<out T1, out T2, out T3, out T4, out T5>): BatchRepeat5<T, T1, T2, T3, T4, T5> = BatchRepeat5(data.copy(values = data.values + v))
}
data class Field6<T, T1, T2, T3, T4, T5, T6>(val table: Table<T, Entity<T>>, val c: Column6<T1, T2, T3, T4, T5, T6>): ExtraValues<T> {
    override val data: InsertData<T> = InsertData(table, c, listOf())
    infix fun VALUES(v: Value6<out T1, out T2, out T3, out T4, out T5, out T6>): Repeat6<T, T1, T2, T3, T4, T5, T6> = Repeat6(data.copy(values = data.values + v))
}
data class Repeat6<T, T1, T2, T3, T4, T5, T6>(override val data: InsertData<T>): InsertStatement<T> {
    infix fun AND(v: Value6<out T1, out T2, out T3, out T4, out T5, out T6>): BatchRepeat6<T, T1, T2, T3, T4, T5, T6> = BatchRepeat6(data.copy(values = data.values + v))
}
data class BatchRepeat6<T, T1, T2, T3, T4, T5, T6>(override val data: InsertData<T>): BatchInsertStatement<T> {
    infix fun AND(v: Value6<out T1, out T2, out T3, out T4, out T5, out T6>): BatchRepeat6<T, T1, T2, T3, T4, T5, T6> = BatchRepeat6(data.copy(values = data.values + v))
}
data class Field7<T, T1, T2, T3, T4, T5, T6, T7>(val table: Table<T, Entity<T>>, val c: Column7<T1, T2, T3, T4, T5, T6, T7>): ExtraValues<T> {
    override val data: InsertData<T> = InsertData(table, c, listOf())
    infix fun VALUES(v: Value7<out T1, out T2, out T3, out T4, out T5, out T6, out T7>): Repeat7<T, T1, T2, T3, T4, T5, T6, T7> = Repeat7(data.copy(values = data.values + v))
}
data class Repeat7<T, T1, T2, T3, T4, T5, T6, T7>(override val data: InsertData<T>): InsertStatement<T> {
    infix fun AND(v: Value7<out T1, out T2, out T3, out T4, out T5, out T6, out T7>): BatchRepeat7<T, T1, T2, T3, T4, T5, T6, T7> = BatchRepeat7(data.copy(values = data.values + v))
}
data class BatchRepeat7<T, T1, T2, T3, T4, T5, T6, T7>(override val data: InsertData<T>): BatchInsertStatement<T> {
    infix fun AND(v: Value7<out T1, out T2, out T3, out T4, out T5, out T6, out T7>): BatchRepeat7<T, T1, T2, T3, T4, T5, T6, T7> = BatchRepeat7(data.copy(values = data.values + v))
}
data class Field8<T, T1, T2, T3, T4, T5, T6, T7, T8>(val table: Table<T, Entity<T>>, val c: Column8<T1, T2, T3, T4, T5, T6, T7, T8>): ExtraValues<T> {
    override val data: InsertData<T> = InsertData(table, c, listOf())
    infix fun VALUES(v: Value8<out T1, out T2, out T3, out T4, out T5, out T6, out T7, out T8>): Repeat8<T, T1, T2, T3, T4, T5, T6, T7, T8> = Repeat8(data.copy(values = data.values + v))
}
data class Repeat8<T, T1, T2, T3, T4, T5, T6, T7, T8>(override val data: InsertData<T>): InsertStatement<T> {
    infix fun AND(v: Value8<out T1, out T2, out T3, out T4, out T5, out T6, out T7, out T8>): BatchRepeat8<T, T1, T2, T3, T4, T5, T6, T7, T8> = BatchRepeat8(data.copy(values = data.values + v))
}
data class BatchRepeat8<T, T1, T2, T3, T4, T5, T6, T7, T8>(override val data: InsertData<T>): BatchInsertStatement<T> {
    infix fun AND(v: Value8<out T1, out T2, out T3, out T4, out T5, out T6, out T7, out T8>): BatchRepeat8<T, T1, T2, T3, T4, T5, T6, T7, T8> = BatchRepeat8(data.copy(values = data.values + v))
}
data class Field9<T, T1, T2, T3, T4, T5, T6, T7, T8, T9>(val table: Table<T, Entity<T>>, val c: Column9<T1, T2, T3, T4, T5, T6, T7, T8, T9>): ExtraValues<T> {
    override val data: InsertData<T> = InsertData(table, c, listOf())
    infix fun VALUES(v: Value9<out T1, out T2, out T3, out T4, out T5, out T6, out T7, out T8, out T9>): Repeat9<T, T1, T2, T3, T4, T5, T6, T7, T8, T9> = Repeat9(data.copy(values = data.values + v))
}
data class Repeat9<T, T1, T2, T3, T4, T5, T6, T7, T8, T9>(override val data: InsertData<T>): InsertStatement<T> {
    infix fun AND(v: Value9<out T1, out T2, out T3, out T4, out T5, out T6, out T7, out T8, out T9>): BatchRepeat9<T, T1, T2, T3, T4, T5, T6, T7, T8, T9> = BatchRepeat9(data.copy(values = data.values + v))
}
data class BatchRepeat9<T, T1, T2, T3, T4, T5, T6, T7, T8, T9>(override val data: InsertData<T>): BatchInsertStatement<T> {
    infix fun AND(v: Value9<out T1, out T2, out T3, out T4, out T5, out T6, out T7, out T8, out T9>): BatchRepeat9<T, T1, T2, T3, T4, T5, T6, T7, T8, T9> = BatchRepeat9(data.copy(values = data.values + v))
}
data class Field10<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>(val table: Table<T, Entity<T>>, val c: Column10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>): ExtraValues<T> {
    override val data: InsertData<T> = InsertData(table, c, listOf())
    infix fun VALUES(v: Value10<out T1, out T2, out T3, out T4, out T5, out T6, out T7, out T8, out T9, out T10>): Repeat10<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> = Repeat10(data.copy(values = data.values + v))
}
data class Repeat10<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>(override val data: InsertData<T>): InsertStatement<T> {
    infix fun AND(v: Value10<out T1, out T2, out T3, out T4, out T5, out T6, out T7, out T8, out T9, out T10>): BatchRepeat10<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> = BatchRepeat10(data.copy(values = data.values + v))
}
data class BatchRepeat10<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>(override val data: InsertData<T>): BatchInsertStatement<T> {
    infix fun AND(v: Value10<out T1, out T2, out T3, out T4, out T5, out T6, out T7, out T8, out T9, out T10>): BatchRepeat10<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> = BatchRepeat10(data.copy(values = data.values + v))
}

interface Inserts: ValueSupport {
    operator fun <T, T1> Table<T, Entity<T>>.invoke(c1: Column<T1>): Field1<T, T1> = Field1(this, Column1(c1))
    operator fun <T, T1, T2> Table<T, Entity<T>>.invoke(c1: Column<T1>, c2: Column<T2>): Field2<T, T1, T2> = Field2(this, Column2(c1, c2))
    operator fun <T, T1, T2, T3> Table<T, Entity<T>>.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>): Field3<T, T1, T2, T3> = Field3(this, Column3(c1, c2, c3))
    operator fun <T, T1, T2, T3, T4> Table<T, Entity<T>>.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>): Field4<T, T1, T2, T3, T4> = Field4(this, Column4(c1, c2, c3, c4))
    operator fun <T, T1, T2, T3, T4, T5> Table<T, Entity<T>>.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>): Field5<T, T1, T2, T3, T4, T5> = Field5(this, Column5(c1, c2, c3, c4, c5))
    operator fun <T, T1, T2, T3, T4, T5, T6> Table<T, Entity<T>>.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>): Field6<T, T1, T2, T3, T4, T5, T6> = Field6(this, Column6(c1, c2, c3, c4, c5, c6))
    operator fun <T, T1, T2, T3, T4, T5, T6, T7> Table<T, Entity<T>>.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>): Field7<T, T1, T2, T3, T4, T5, T6, T7> = Field7(this, Column7(c1, c2, c3, c4, c5, c6, c7))
    operator fun <T, T1, T2, T3, T4, T5, T6, T7, T8> Table<T, Entity<T>>.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>): Field8<T, T1, T2, T3, T4, T5, T6, T7, T8> = Field8(this, Column8(c1, c2, c3, c4, c5, c6, c7, c8))
    operator fun <T, T1, T2, T3, T4, T5, T6, T7, T8, T9> Table<T, Entity<T>>.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>): Field9<T, T1, T2, T3, T4, T5, T6, T7, T8, T9> = Field9(this, Column9(c1, c2, c3, c4, c5, c6, c7, c8, c9))
    operator fun <T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> Table<T, Entity<T>>.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>): Field10<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> = Field10(this, Column10(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10))
}
