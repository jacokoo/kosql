package com.github.jacokoo.kosql.compose.typesafe

import com.github.jacokoo.kosql.compose.Column
import com.github.jacokoo.kosql.compose.statement.Select
import com.github.jacokoo.kosql.compose.statement.SelectData
import com.github.jacokoo.kosql.compose.statement.SelectFromOperate

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
}
