package com.github.jacokoo.kosql.compose.typesafe

import com.github.jacokoo.kosql.compose.Column
import com.github.jacokoo.kosql.compose.statements.*

data class SelectStatement1<T1>(val c: Column1<T1>, override val data: SelectData): SelectStatement
data class SelectStatement2<T1, T2>(val c: Column2<T1, T2>, override val data: SelectData): SelectStatement

interface Selects: Select {
    fun <T1> SELECT(c1: Column<T1>, block: SelectCreator) = SelectStatement1(Column1(c1), SelectFromPart(c1).block().data)
    fun <T1> SELECT(c: Column1<T1>, block: SelectCreator) = SelectStatement1(c, SelectFromPart(c).block().data)

    fun <T1, T2> SELECT(c1: Column<T1>, c2: Column<T2>, block: SelectCreator) = SelectStatement2(Column2(c1, c2), SelectFromPart(c1, c2).block().data)
    fun <T1, T2> SELECT(c: Column2<T1, T2>, block: SelectCreator) = SelectStatement2(c, SelectFromPart(c).block().data)
}
