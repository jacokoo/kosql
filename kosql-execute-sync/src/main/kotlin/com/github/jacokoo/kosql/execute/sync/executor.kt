package com.github.jacokoo.kosql.execute.sync

import com.github.jacokoo.kosql.compose.Entity
import com.github.jacokoo.kosql.compose.Table
import com.github.jacokoo.kosql.compose.result.Mapper
import com.github.jacokoo.kosql.compose.result.Results
import com.github.jacokoo.kosql.compose.result.Row
import com.github.jacokoo.kosql.compose.result.ValuesMapper
import com.github.jacokoo.kosql.compose.statement.*
import com.github.jacokoo.kosql.compose.typesafe.*

interface Executor {
    fun <K, T: Table<K, Entity<K>>>execute(update: UpdateStatement<K, T>): Int
    fun execute(delete: DeleteStatement): Int
    fun <T> execute(insert: InsertStatement<T>): Pair<T, Int>
    fun <T> execute(insert: BatchInsertStatement<T>): Int
    fun <T, R: ColumnList> execute(select: SelectStatement<R>, mapper: Mapper<T>): List<T>

    fun <T: Any, R: ColumnList> execute(select: SelectStatement<R>, mapper: (Row) -> T): List<T> = execute(select, object: Mapper<T> {
        override fun map(rs: Row): T = mapper(rs)
    })
    fun <T, R: Entity<T>, L: ColumnList> execute(select: SelectStatement<L>, table: Table<T, R>): List<R> = execute(select) {
        it.into(table) ?: throw RuntimeException("""
            | Can not fetch into the table, because:
            | 1. no column of the table is mentioned in select list
            | 2. there is a row in which all selected columns of the table are with a null value
        """.trimMargin())
    }

    fun <T: Any, R: ColumnList> SelectStatement<R>.fetch(mapper: Mapper<T>): List<T> = execute(this, mapper)
    fun <T: Any, R: Entity<T>, L: ColumnList> SelectStatement<L>.fetch(table: Table<T, R>): List<R> = execute(this, table)
    fun <T: Any, R: ColumnList> SelectStatement<R>.fetch(mapper: (Row) -> T): List<T> = execute(this, mapper)

    fun <T: ColumnList> SelectStatement<T>.fetch(): Results = Results(data.columns, execute(this, ValuesMapper(data.columns)))
    fun <T, R: Entity<T>, L: ColumnList> SelectStatement<L>.fetch(table: Table<T, R>, setter: (R, Row) -> Unit): List<R> {
        val map = mutableMapOf<T, R>()
        execute(this) {
            val key = table.primaryKey()
            val idx = data.columns.columns.indexOf(key)
            if (idx == -1) {
                throw RuntimeException("To use this method, the primary key of the table must in select list")
            }
            val id = it[idx, key]
            if (!map.containsKey(id)) {
                map[id] = it.into(table)!!
            }
            setter(map[id]!!, it)
        }
        return map.values.toList()
    }

    fun <T1> SelectStatement<Column1<T1>>.fetchValue(): T1
            = fetch().firstOrNull()?.v1 ?: throw RuntimeException("Can not call fetchValue on a null value")

    fun <T1> SelectStatement<Column1<T1>>.fetch()
            = Result1(data.columns, execute(this, Value1Mapper(data.columns)))
    fun <T1, T2> SelectStatement<Column2<T1, T2>>.fetch()
            = Result2(data.columns, execute(this, Value2Mapper(data.columns)))
    fun <T1, T2, T3> SelectStatement<Column3<T1, T2, T3>>.fetch()
            = Result3(data.columns, execute(this, Value3Mapper(data.columns)))
    fun <T1, T2, T3, T4> SelectStatement<Column4<T1, T2, T3, T4>>.fetch()
            = Result4(data.columns, execute(this, Value4Mapper(data.columns)))
    fun <T1, T2, T3, T4, T5> SelectStatement<Column5<T1, T2, T3, T4, T5>>.fetch()
            = Result5(data.columns, execute(this, Value5Mapper(data.columns)))
    fun <T1, T2, T3, T4, T5, T6> SelectStatement<Column6<T1, T2, T3, T4, T5, T6>>.fetch()
            = Result6(data.columns, execute(this, Value6Mapper(data.columns)))
    fun <T1, T2, T3, T4, T5, T6, T7> SelectStatement<Column7<T1, T2, T3, T4, T5, T6, T7>>.fetch()
            = Result7(data.columns, execute(this, Value7Mapper(data.columns)))
    fun <T1, T2, T3, T4, T5, T6, T7, T8> SelectStatement<Column8<T1, T2, T3, T4, T5, T6, T7, T8>>.fetch()
            = Result8(data.columns, execute(this, Value8Mapper(data.columns)))
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9> SelectStatement<Column9<T1, T2, T3, T4, T5, T6, T7, T8, T9>>.fetch()
            = Result9(data.columns, execute(this, Value9Mapper(data.columns)))
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> SelectStatement<Column10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>>.fetch()
            = Result10(data.columns, execute(this, Value10Mapper(data.columns)))
}
