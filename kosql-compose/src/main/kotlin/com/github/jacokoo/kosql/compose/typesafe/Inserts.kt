package com.github.jacokoo.kosql.compose.typesafe

import com.github.jacokoo.kosql.compose.Column
import com.github.jacokoo.kosql.compose.Table
import com.github.jacokoo.kosql.compose.Entity
import com.github.jacokoo.kosql.compose.statements.*

data class Field1<T, T1>(val table: Table<T, Entity<T>>, val c: Column1<T1>): ExtraValues<T> {
    override val data: InsertData<T> = InsertData(table, c, listOf())
    infix fun VALUES(v: Value1<T1>): Repeat1<T, T1> = Repeat1(data.copy(values = data.values + v))
}
data class Repeat1<T, T1>(override val data: InsertData<T>): InsertStatement<T> {
    infix fun AND(v: Value1<T1>): BatchRepeat1<T, T1> = BatchRepeat1(data.copy(values = data.values + v))
}
data class BatchRepeat1<T, T1>(override val data: InsertData<T>): BatchInsertStatement<T> {
    infix fun AND(v: Value1<T1>): BatchRepeat1<T, T1> = BatchRepeat1(data.copy(values = data.values + v))
}
data class Field2<T, T1, T2>(val table: Table<T, Entity<T>>, val c: Column2<T1, T2>): ExtraValues<T> {
    override val data: InsertData<T> = InsertData(table, c, listOf())
    infix fun VALUES(v: Value2<T1, T2>): Repeat2<T, T1, T2> = Repeat2(data.copy(values = data.values + v))
}
data class Repeat2<T, T1, T2>(override val data: InsertData<T>): InsertStatement<T> {
    infix fun AND(v: Value2<T1, T2>): BatchRepeat2<T, T1, T2> = BatchRepeat2(data.copy(values = data.values + v))
}
data class BatchRepeat2<T, T1, T2>(override val data: InsertData<T>): BatchInsertStatement<T> {
    infix fun AND(v: Value2<T1, T2>): BatchRepeat2<T, T1, T2> = BatchRepeat2(data.copy(values = data.values + v))
}
data class Field3<T, T1, T2, T3>(val table: Table<T, Entity<T>>, val c: Column3<T1, T2, T3>): ExtraValues<T> {
    override val data: InsertData<T> = InsertData(table, c, listOf())
    infix fun VALUES(v: Value3<T1, T2, T3>): Repeat3<T, T1, T2, T3> = Repeat3(data.copy(values = data.values + v))
}
data class Repeat3<T, T1, T2, T3>(override val data: InsertData<T>): InsertStatement<T> {
    infix fun AND(v: Value3<T1, T2, T3>): BatchRepeat3<T, T1, T2, T3> = BatchRepeat3(data.copy(values = data.values + v))
}
data class BatchRepeat3<T, T1, T2, T3>(override val data: InsertData<T>): BatchInsertStatement<T> {
    infix fun AND(v: Value3<T1, T2, T3>): BatchRepeat3<T, T1, T2, T3> = BatchRepeat3(data.copy(values = data.values + v))
}
data class Field4<T, T1, T2, T3, T4>(val table: Table<T, Entity<T>>, val c: Column4<T1, T2, T3, T4>): ExtraValues<T> {
    override val data: InsertData<T> = InsertData(table, c, listOf())
    infix fun VALUES(v: Value4<T1, T2, T3, T4>): Repeat4<T, T1, T2, T3, T4> = Repeat4(data.copy(values = data.values + v))
}
data class Repeat4<T, T1, T2, T3, T4>(override val data: InsertData<T>): InsertStatement<T> {
    infix fun AND(v: Value4<T1, T2, T3, T4>): BatchRepeat4<T, T1, T2, T3, T4> = BatchRepeat4(data.copy(values = data.values + v))
}
data class BatchRepeat4<T, T1, T2, T3, T4>(override val data: InsertData<T>): BatchInsertStatement<T> {
    infix fun AND(v: Value4<T1, T2, T3, T4>): BatchRepeat4<T, T1, T2, T3, T4> = BatchRepeat4(data.copy(values = data.values + v))
}
data class Field5<T, T1, T2, T3, T4, T5>(val table: Table<T, Entity<T>>, val c: Column5<T1, T2, T3, T4, T5>): ExtraValues<T> {
    override val data: InsertData<T> = InsertData(table, c, listOf())
    infix fun VALUES(v: Value5<T1, T2, T3, T4, T5>): Repeat5<T, T1, T2, T3, T4, T5> = Repeat5(data.copy(values = data.values + v))
}
data class Repeat5<T, T1, T2, T3, T4, T5>(override val data: InsertData<T>): InsertStatement<T> {
    infix fun AND(v: Value5<T1, T2, T3, T4, T5>): BatchRepeat5<T, T1, T2, T3, T4, T5> = BatchRepeat5(data.copy(values = data.values + v))
}
data class BatchRepeat5<T, T1, T2, T3, T4, T5>(override val data: InsertData<T>): BatchInsertStatement<T> {
    infix fun AND(v: Value5<T1, T2, T3, T4, T5>): BatchRepeat5<T, T1, T2, T3, T4, T5> = BatchRepeat5(data.copy(values = data.values + v))
}
data class Field6<T, T1, T2, T3, T4, T5, T6>(val table: Table<T, Entity<T>>, val c: Column6<T1, T2, T3, T4, T5, T6>): ExtraValues<T> {
    override val data: InsertData<T> = InsertData(table, c, listOf())
    infix fun VALUES(v: Value6<T1, T2, T3, T4, T5, T6>): Repeat6<T, T1, T2, T3, T4, T5, T6> = Repeat6(data.copy(values = data.values + v))
}
data class Repeat6<T, T1, T2, T3, T4, T5, T6>(override val data: InsertData<T>): InsertStatement<T> {
    infix fun AND(v: Value6<T1, T2, T3, T4, T5, T6>): BatchRepeat6<T, T1, T2, T3, T4, T5, T6> = BatchRepeat6(data.copy(values = data.values + v))
}
data class BatchRepeat6<T, T1, T2, T3, T4, T5, T6>(override val data: InsertData<T>): BatchInsertStatement<T> {
    infix fun AND(v: Value6<T1, T2, T3, T4, T5, T6>): BatchRepeat6<T, T1, T2, T3, T4, T5, T6> = BatchRepeat6(data.copy(values = data.values + v))
}
data class Field7<T, T1, T2, T3, T4, T5, T6, T7>(val table: Table<T, Entity<T>>, val c: Column7<T1, T2, T3, T4, T5, T6, T7>): ExtraValues<T> {
    override val data: InsertData<T> = InsertData(table, c, listOf())
    infix fun VALUES(v: Value7<T1, T2, T3, T4, T5, T6, T7>): Repeat7<T, T1, T2, T3, T4, T5, T6, T7> = Repeat7(data.copy(values = data.values + v))
}
data class Repeat7<T, T1, T2, T3, T4, T5, T6, T7>(override val data: InsertData<T>): InsertStatement<T> {
    infix fun AND(v: Value7<T1, T2, T3, T4, T5, T6, T7>): BatchRepeat7<T, T1, T2, T3, T4, T5, T6, T7> = BatchRepeat7(data.copy(values = data.values + v))
}
data class BatchRepeat7<T, T1, T2, T3, T4, T5, T6, T7>(override val data: InsertData<T>): BatchInsertStatement<T> {
    infix fun AND(v: Value7<T1, T2, T3, T4, T5, T6, T7>): BatchRepeat7<T, T1, T2, T3, T4, T5, T6, T7> = BatchRepeat7(data.copy(values = data.values + v))
}
data class Field8<T, T1, T2, T3, T4, T5, T6, T7, T8>(val table: Table<T, Entity<T>>, val c: Column8<T1, T2, T3, T4, T5, T6, T7, T8>): ExtraValues<T> {
    override val data: InsertData<T> = InsertData(table, c, listOf())
    infix fun VALUES(v: Value8<T1, T2, T3, T4, T5, T6, T7, T8>): Repeat8<T, T1, T2, T3, T4, T5, T6, T7, T8> = Repeat8(data.copy(values = data.values + v))
}
data class Repeat8<T, T1, T2, T3, T4, T5, T6, T7, T8>(override val data: InsertData<T>): InsertStatement<T> {
    infix fun AND(v: Value8<T1, T2, T3, T4, T5, T6, T7, T8>): BatchRepeat8<T, T1, T2, T3, T4, T5, T6, T7, T8> = BatchRepeat8(data.copy(values = data.values + v))
}
data class BatchRepeat8<T, T1, T2, T3, T4, T5, T6, T7, T8>(override val data: InsertData<T>): BatchInsertStatement<T> {
    infix fun AND(v: Value8<T1, T2, T3, T4, T5, T6, T7, T8>): BatchRepeat8<T, T1, T2, T3, T4, T5, T6, T7, T8> = BatchRepeat8(data.copy(values = data.values + v))
}
data class Field9<T, T1, T2, T3, T4, T5, T6, T7, T8, T9>(val table: Table<T, Entity<T>>, val c: Column9<T1, T2, T3, T4, T5, T6, T7, T8, T9>): ExtraValues<T> {
    override val data: InsertData<T> = InsertData(table, c, listOf())
    infix fun VALUES(v: Value9<T1, T2, T3, T4, T5, T6, T7, T8, T9>): Repeat9<T, T1, T2, T3, T4, T5, T6, T7, T8, T9> = Repeat9(data.copy(values = data.values + v))
}
data class Repeat9<T, T1, T2, T3, T4, T5, T6, T7, T8, T9>(override val data: InsertData<T>): InsertStatement<T> {
    infix fun AND(v: Value9<T1, T2, T3, T4, T5, T6, T7, T8, T9>): BatchRepeat9<T, T1, T2, T3, T4, T5, T6, T7, T8, T9> = BatchRepeat9(data.copy(values = data.values + v))
}
data class BatchRepeat9<T, T1, T2, T3, T4, T5, T6, T7, T8, T9>(override val data: InsertData<T>): BatchInsertStatement<T> {
    infix fun AND(v: Value9<T1, T2, T3, T4, T5, T6, T7, T8, T9>): BatchRepeat9<T, T1, T2, T3, T4, T5, T6, T7, T8, T9> = BatchRepeat9(data.copy(values = data.values + v))
}
data class Field10<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>(val table: Table<T, Entity<T>>, val c: Column10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>): ExtraValues<T> {
    override val data: InsertData<T> = InsertData(table, c, listOf())
    infix fun VALUES(v: Value10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>): Repeat10<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> = Repeat10(data.copy(values = data.values + v))
}
data class Repeat10<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>(override val data: InsertData<T>): InsertStatement<T> {
    infix fun AND(v: Value10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>): BatchRepeat10<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> = BatchRepeat10(data.copy(values = data.values + v))
}
data class BatchRepeat10<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>(override val data: InsertData<T>): BatchInsertStatement<T> {
    infix fun AND(v: Value10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>): BatchRepeat10<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> = BatchRepeat10(data.copy(values = data.values + v))
}
data class Field11<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>(val table: Table<T, Entity<T>>, val c: Column11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>): ExtraValues<T> {
    override val data: InsertData<T> = InsertData(table, c, listOf())
    infix fun VALUES(v: Value11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>): Repeat11<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> = Repeat11(data.copy(values = data.values + v))
}
data class Repeat11<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>(override val data: InsertData<T>): InsertStatement<T> {
    infix fun AND(v: Value11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>): BatchRepeat11<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> = BatchRepeat11(data.copy(values = data.values + v))
}
data class BatchRepeat11<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>(override val data: InsertData<T>): BatchInsertStatement<T> {
    infix fun AND(v: Value11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>): BatchRepeat11<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> = BatchRepeat11(data.copy(values = data.values + v))
}
data class Field12<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>(val table: Table<T, Entity<T>>, val c: Column12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>): ExtraValues<T> {
    override val data: InsertData<T> = InsertData(table, c, listOf())
    infix fun VALUES(v: Value12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>): Repeat12<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> = Repeat12(data.copy(values = data.values + v))
}
data class Repeat12<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>(override val data: InsertData<T>): InsertStatement<T> {
    infix fun AND(v: Value12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>): BatchRepeat12<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> = BatchRepeat12(data.copy(values = data.values + v))
}
data class BatchRepeat12<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>(override val data: InsertData<T>): BatchInsertStatement<T> {
    infix fun AND(v: Value12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>): BatchRepeat12<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> = BatchRepeat12(data.copy(values = data.values + v))
}
data class Field13<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>(val table: Table<T, Entity<T>>, val c: Column13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>): ExtraValues<T> {
    override val data: InsertData<T> = InsertData(table, c, listOf())
    infix fun VALUES(v: Value13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>): Repeat13<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> = Repeat13(data.copy(values = data.values + v))
}
data class Repeat13<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>(override val data: InsertData<T>): InsertStatement<T> {
    infix fun AND(v: Value13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>): BatchRepeat13<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> = BatchRepeat13(data.copy(values = data.values + v))
}
data class BatchRepeat13<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>(override val data: InsertData<T>): BatchInsertStatement<T> {
    infix fun AND(v: Value13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>): BatchRepeat13<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> = BatchRepeat13(data.copy(values = data.values + v))
}
data class Field14<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>(val table: Table<T, Entity<T>>, val c: Column14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>): ExtraValues<T> {
    override val data: InsertData<T> = InsertData(table, c, listOf())
    infix fun VALUES(v: Value14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>): Repeat14<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> = Repeat14(data.copy(values = data.values + v))
}
data class Repeat14<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>(override val data: InsertData<T>): InsertStatement<T> {
    infix fun AND(v: Value14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>): BatchRepeat14<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> = BatchRepeat14(data.copy(values = data.values + v))
}
data class BatchRepeat14<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>(override val data: InsertData<T>): BatchInsertStatement<T> {
    infix fun AND(v: Value14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>): BatchRepeat14<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> = BatchRepeat14(data.copy(values = data.values + v))
}
data class Field15<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>(val table: Table<T, Entity<T>>, val c: Column15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>): ExtraValues<T> {
    override val data: InsertData<T> = InsertData(table, c, listOf())
    infix fun VALUES(v: Value15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>): Repeat15<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> = Repeat15(data.copy(values = data.values + v))
}
data class Repeat15<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>(override val data: InsertData<T>): InsertStatement<T> {
    infix fun AND(v: Value15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>): BatchRepeat15<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> = BatchRepeat15(data.copy(values = data.values + v))
}
data class BatchRepeat15<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>(override val data: InsertData<T>): BatchInsertStatement<T> {
    infix fun AND(v: Value15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>): BatchRepeat15<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> = BatchRepeat15(data.copy(values = data.values + v))
}
data class Field16<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>(val table: Table<T, Entity<T>>, val c: Column16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>): ExtraValues<T> {
    override val data: InsertData<T> = InsertData(table, c, listOf())
    infix fun VALUES(v: Value16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>): Repeat16<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> = Repeat16(data.copy(values = data.values + v))
}
data class Repeat16<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>(override val data: InsertData<T>): InsertStatement<T> {
    infix fun AND(v: Value16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>): BatchRepeat16<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> = BatchRepeat16(data.copy(values = data.values + v))
}
data class BatchRepeat16<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>(override val data: InsertData<T>): BatchInsertStatement<T> {
    infix fun AND(v: Value16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>): BatchRepeat16<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> = BatchRepeat16(data.copy(values = data.values + v))
}
data class Field17<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>(val table: Table<T, Entity<T>>, val c: Column17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>): ExtraValues<T> {
    override val data: InsertData<T> = InsertData(table, c, listOf())
    infix fun VALUES(v: Value17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>): Repeat17<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> = Repeat17(data.copy(values = data.values + v))
}
data class Repeat17<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>(override val data: InsertData<T>): InsertStatement<T> {
    infix fun AND(v: Value17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>): BatchRepeat17<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> = BatchRepeat17(data.copy(values = data.values + v))
}
data class BatchRepeat17<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>(override val data: InsertData<T>): BatchInsertStatement<T> {
    infix fun AND(v: Value17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>): BatchRepeat17<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> = BatchRepeat17(data.copy(values = data.values + v))
}
data class Field18<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>(val table: Table<T, Entity<T>>, val c: Column18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>): ExtraValues<T> {
    override val data: InsertData<T> = InsertData(table, c, listOf())
    infix fun VALUES(v: Value18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>): Repeat18<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> = Repeat18(data.copy(values = data.values + v))
}
data class Repeat18<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>(override val data: InsertData<T>): InsertStatement<T> {
    infix fun AND(v: Value18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>): BatchRepeat18<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> = BatchRepeat18(data.copy(values = data.values + v))
}
data class BatchRepeat18<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>(override val data: InsertData<T>): BatchInsertStatement<T> {
    infix fun AND(v: Value18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>): BatchRepeat18<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> = BatchRepeat18(data.copy(values = data.values + v))
}
data class Field19<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>(val table: Table<T, Entity<T>>, val c: Column19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>): ExtraValues<T> {
    override val data: InsertData<T> = InsertData(table, c, listOf())
    infix fun VALUES(v: Value19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>): Repeat19<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> = Repeat19(data.copy(values = data.values + v))
}
data class Repeat19<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>(override val data: InsertData<T>): InsertStatement<T> {
    infix fun AND(v: Value19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>): BatchRepeat19<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> = BatchRepeat19(data.copy(values = data.values + v))
}
data class BatchRepeat19<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>(override val data: InsertData<T>): BatchInsertStatement<T> {
    infix fun AND(v: Value19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>): BatchRepeat19<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> = BatchRepeat19(data.copy(values = data.values + v))
}
data class Field20<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>(val table: Table<T, Entity<T>>, val c: Column20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>): ExtraValues<T> {
    override val data: InsertData<T> = InsertData(table, c, listOf())
    infix fun VALUES(v: Value20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>): Repeat20<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> = Repeat20(data.copy(values = data.values + v))
}
data class Repeat20<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>(override val data: InsertData<T>): InsertStatement<T> {
    infix fun AND(v: Value20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>): BatchRepeat20<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> = BatchRepeat20(data.copy(values = data.values + v))
}
data class BatchRepeat20<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>(override val data: InsertData<T>): BatchInsertStatement<T> {
    infix fun AND(v: Value20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>): BatchRepeat20<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> = BatchRepeat20(data.copy(values = data.values + v))
}
data class Field21<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>(val table: Table<T, Entity<T>>, val c: Column21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>): ExtraValues<T> {
    override val data: InsertData<T> = InsertData(table, c, listOf())
    infix fun VALUES(v: Value21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>): Repeat21<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> = Repeat21(data.copy(values = data.values + v))
}
data class Repeat21<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>(override val data: InsertData<T>): InsertStatement<T> {
    infix fun AND(v: Value21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>): BatchRepeat21<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> = BatchRepeat21(data.copy(values = data.values + v))
}
data class BatchRepeat21<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>(override val data: InsertData<T>): BatchInsertStatement<T> {
    infix fun AND(v: Value21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>): BatchRepeat21<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> = BatchRepeat21(data.copy(values = data.values + v))
}
data class Field22<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>(val table: Table<T, Entity<T>>, val c: Column22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>): ExtraValues<T> {
    override val data: InsertData<T> = InsertData(table, c, listOf())
    infix fun VALUES(v: Value22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>): Repeat22<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> = Repeat22(data.copy(values = data.values + v))
}
data class Repeat22<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>(override val data: InsertData<T>): InsertStatement<T> {
    infix fun AND(v: Value22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>): BatchRepeat22<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> = BatchRepeat22(data.copy(values = data.values + v))
}
data class BatchRepeat22<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>(override val data: InsertData<T>): BatchInsertStatement<T> {
    infix fun AND(v: Value22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>): BatchRepeat22<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> = BatchRepeat22(data.copy(values = data.values + v))
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
    operator fun <T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> Table<T, Entity<T>>.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>): Field11<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> = Field11(this, Column11(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11))
    operator fun <T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> Table<T, Entity<T>>.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>): Field12<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> = Field12(this, Column12(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12))
    operator fun <T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> Table<T, Entity<T>>.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>): Field13<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> = Field13(this, Column13(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13))
    operator fun <T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> Table<T, Entity<T>>.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>): Field14<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> = Field14(this, Column14(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14))
    operator fun <T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> Table<T, Entity<T>>.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>, c15: Column<T15>): Field15<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> = Field15(this, Column15(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15))
    operator fun <T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> Table<T, Entity<T>>.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>, c15: Column<T15>, c16: Column<T16>): Field16<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> = Field16(this, Column16(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16))
    operator fun <T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> Table<T, Entity<T>>.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>, c15: Column<T15>, c16: Column<T16>, c17: Column<T17>): Field17<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> = Field17(this, Column17(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17))
    operator fun <T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> Table<T, Entity<T>>.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>, c15: Column<T15>, c16: Column<T16>, c17: Column<T17>, c18: Column<T18>): Field18<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> = Field18(this, Column18(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18))
    operator fun <T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> Table<T, Entity<T>>.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>, c15: Column<T15>, c16: Column<T16>, c17: Column<T17>, c18: Column<T18>, c19: Column<T19>): Field19<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> = Field19(this, Column19(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19))
    operator fun <T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> Table<T, Entity<T>>.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>, c15: Column<T15>, c16: Column<T16>, c17: Column<T17>, c18: Column<T18>, c19: Column<T19>, c20: Column<T20>): Field20<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> = Field20(this, Column20(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20))
    operator fun <T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> Table<T, Entity<T>>.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>, c15: Column<T15>, c16: Column<T16>, c17: Column<T17>, c18: Column<T18>, c19: Column<T19>, c20: Column<T20>, c21: Column<T21>): Field21<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> = Field21(this, Column21(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21))
    operator fun <T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> Table<T, Entity<T>>.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>, c15: Column<T15>, c16: Column<T16>, c17: Column<T17>, c18: Column<T18>, c19: Column<T19>, c20: Column<T20>, c21: Column<T21>, c22: Column<T22>): Field22<T, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> = Field22(this, Column22(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21, c22))
}
