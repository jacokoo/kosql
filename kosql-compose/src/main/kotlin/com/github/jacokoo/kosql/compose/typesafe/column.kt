package com.github.jacokoo.kosql.compose.typesafe

import com.github.jacokoo.kosql.compose.Column
import com.github.jacokoo.kosql.compose.statement.ColumnList
import com.github.jacokoo.kosql.compose.statement.Columns


data class Column1<T1>(val c1: Column<T1>, override val columns: List<Column<*>> = listOf(c1)): ColumnList {
    operator fun <R1> plus(c: Column<R1>) = Column2(c1, c)
    operator fun <R1> plus(c: Column1<R1>) = Column2(c1, c.c1)
    operator fun <R1, R2> plus(c: Column2<R1, R2>) = Column3(c1, c.c1, c.c2)
    operator fun <R1, R2, R3> plus(c: Column3<R1, R2, R3>) = Column4(c1, c.c1, c.c2, c.c3)
    operator fun <R1, R2, R3, R4> plus(c: Column4<R1, R2, R3, R4>) = Column5(c1, c.c1, c.c2, c.c3, c.c4)
    operator fun <R1, R2, R3, R4, R5> plus(c: Column5<R1, R2, R3, R4, R5>) = Column6(c1, c.c1, c.c2, c.c3, c.c4, c.c5)
    operator fun <R1, R2, R3, R4, R5, R6> plus(c: Column6<R1, R2, R3, R4, R5, R6>) = Column7(c1, c.c1, c.c2, c.c3, c.c4, c.c5, c.c6)
    operator fun <R1, R2, R3, R4, R5, R6, R7> plus(c: Column7<R1, R2, R3, R4, R5, R6, R7>) = Column8(c1, c.c1, c.c2, c.c3, c.c4, c.c5, c.c6, c.c7)
    operator fun <R1, R2, R3, R4, R5, R6, R7, R8> plus(c: Column8<R1, R2, R3, R4, R5, R6, R7, R8>) = Column9(c1, c.c1, c.c2, c.c3, c.c4, c.c5, c.c6, c.c7, c.c8)
    operator fun <R1, R2, R3, R4, R5, R6, R7, R8, R9> plus(c: Column9<R1, R2, R3, R4, R5, R6, R7, R8, R9>) = Column10(c1, c.c1, c.c2, c.c3, c.c4, c.c5, c.c6, c.c7, c.c8, c.c9)
    operator fun <R1, R2, R3, R4, R5, R6, R7, R8, R9, R10> plus(c: Column10<R1, R2, R3, R4, R5, R6, R7, R8, R9, R10>) = Columns(columns + c.columns)
}

data class Column2<T1, T2>(val c1: Column<T1>, val c2: Column<T2>, override val columns: List<Column<*>> = listOf(c1, c2)): ColumnList {
    operator fun <R1> plus(c: Column<R1>) = Column3(c1, c2, c)
    operator fun <R1> plus(c: Column1<R1>) = Column3(c1, c2, c.c1)
    operator fun <R1, R2> plus(c: Column2<R1, R2>) = Column4(c1, c2, c.c1, c.c2)
    operator fun <R1, R2, R3> plus(c: Column3<R1, R2, R3>) = Column5(c1, c2, c.c1, c.c2, c.c3)
    operator fun <R1, R2, R3, R4> plus(c: Column4<R1, R2, R3, R4>) = Column6(c1, c2, c.c1, c.c2, c.c3, c.c4)
    operator fun <R1, R2, R3, R4, R5> plus(c: Column5<R1, R2, R3, R4, R5>) = Column7(c1, c2, c.c1, c.c2, c.c3, c.c4, c.c5)
    operator fun <R1, R2, R3, R4, R5, R6> plus(c: Column6<R1, R2, R3, R4, R5, R6>) = Column8(c1, c2, c.c1, c.c2, c.c3, c.c4, c.c5, c.c6)
    operator fun <R1, R2, R3, R4, R5, R6, R7> plus(c: Column7<R1, R2, R3, R4, R5, R6, R7>) = Column9(c1, c2, c.c1, c.c2, c.c3, c.c4, c.c5, c.c6, c.c7)
    operator fun <R1, R2, R3, R4, R5, R6, R7, R8> plus(c: Column8<R1, R2, R3, R4, R5, R6, R7, R8>) = Column10(c1, c2, c.c1, c.c2, c.c3, c.c4, c.c5, c.c6, c.c7, c.c8)
    operator fun <R1, R2, R3, R4, R5, R6, R7, R8, R9> plus(c: Column9<R1, R2, R3, R4, R5, R6, R7, R8, R9>) = Columns(columns + c.columns)
    operator fun <R1, R2, R3, R4, R5, R6, R7, R8, R9, R10> plus(c: Column10<R1, R2, R3, R4, R5, R6, R7, R8, R9, R10>) = Columns(columns + c.columns)
}

data class Column3<T1, T2, T3>(val c1: Column<T1>, val c2: Column<T2>, val c3: Column<T3>, override val columns: List<Column<*>> = listOf(c1, c2, c3)): ColumnList {
    operator fun <R1> plus(c: Column<R1>) = Column4(c1, c2, c3, c)
    operator fun <R1> plus(c: Column1<R1>) = Column4(c1, c2, c3, c.c1)
    operator fun <R1, R2> plus(c: Column2<R1, R2>) = Column5(c1, c2, c3, c.c1, c.c2)
    operator fun <R1, R2, R3> plus(c: Column3<R1, R2, R3>) = Column6(c1, c2, c3, c.c1, c.c2, c.c3)
    operator fun <R1, R2, R3, R4> plus(c: Column4<R1, R2, R3, R4>) = Column7(c1, c2, c3, c.c1, c.c2, c.c3, c.c4)
    operator fun <R1, R2, R3, R4, R5> plus(c: Column5<R1, R2, R3, R4, R5>) = Column8(c1, c2, c3, c.c1, c.c2, c.c3, c.c4, c.c5)
    operator fun <R1, R2, R3, R4, R5, R6> plus(c: Column6<R1, R2, R3, R4, R5, R6>) = Column9(c1, c2, c3, c.c1, c.c2, c.c3, c.c4, c.c5, c.c6)
    operator fun <R1, R2, R3, R4, R5, R6, R7> plus(c: Column7<R1, R2, R3, R4, R5, R6, R7>) = Column10(c1, c2, c3, c.c1, c.c2, c.c3, c.c4, c.c5, c.c6, c.c7)
    operator fun <R1, R2, R3, R4, R5, R6, R7, R8> plus(c: Column8<R1, R2, R3, R4, R5, R6, R7, R8>) = Columns(columns + c.columns)
    operator fun <R1, R2, R3, R4, R5, R6, R7, R8, R9> plus(c: Column9<R1, R2, R3, R4, R5, R6, R7, R8, R9>) = Columns(columns + c.columns)
    operator fun <R1, R2, R3, R4, R5, R6, R7, R8, R9, R10> plus(c: Column10<R1, R2, R3, R4, R5, R6, R7, R8, R9, R10>) = Columns(columns + c.columns)
}

data class Column4<T1, T2, T3, T4>(val c1: Column<T1>, val c2: Column<T2>, val c3: Column<T3>, val c4: Column<T4>, override val columns: List<Column<*>> = listOf(c1, c2, c3, c4)): ColumnList {
    operator fun <R1> plus(c: Column<R1>) = Column5(c1, c2, c3, c4, c)
    operator fun <R1> plus(c: Column1<R1>) = Column5(c1, c2, c3, c4, c.c1)
    operator fun <R1, R2> plus(c: Column2<R1, R2>) = Column6(c1, c2, c3, c4, c.c1, c.c2)
    operator fun <R1, R2, R3> plus(c: Column3<R1, R2, R3>) = Column7(c1, c2, c3, c4, c.c1, c.c2, c.c3)
    operator fun <R1, R2, R3, R4> plus(c: Column4<R1, R2, R3, R4>) = Column8(c1, c2, c3, c4, c.c1, c.c2, c.c3, c.c4)
    operator fun <R1, R2, R3, R4, R5> plus(c: Column5<R1, R2, R3, R4, R5>) = Column9(c1, c2, c3, c4, c.c1, c.c2, c.c3, c.c4, c.c5)
    operator fun <R1, R2, R3, R4, R5, R6> plus(c: Column6<R1, R2, R3, R4, R5, R6>) = Column10(c1, c2, c3, c4, c.c1, c.c2, c.c3, c.c4, c.c5, c.c6)
    operator fun <R1, R2, R3, R4, R5, R6, R7> plus(c: Column7<R1, R2, R3, R4, R5, R6, R7>) = Columns(columns + c.columns)
    operator fun <R1, R2, R3, R4, R5, R6, R7, R8> plus(c: Column8<R1, R2, R3, R4, R5, R6, R7, R8>) = Columns(columns + c.columns)
    operator fun <R1, R2, R3, R4, R5, R6, R7, R8, R9> plus(c: Column9<R1, R2, R3, R4, R5, R6, R7, R8, R9>) = Columns(columns + c.columns)
    operator fun <R1, R2, R3, R4, R5, R6, R7, R8, R9, R10> plus(c: Column10<R1, R2, R3, R4, R5, R6, R7, R8, R9, R10>) = Columns(columns + c.columns)
}

data class Column5<T1, T2, T3, T4, T5>(val c1: Column<T1>, val c2: Column<T2>, val c3: Column<T3>, val c4: Column<T4>, val c5: Column<T5>, override val columns: List<Column<*>> = listOf(c1, c2, c3, c4, c5)): ColumnList {
    operator fun <R1> plus(c: Column<R1>) = Column6(c1, c2, c3, c4, c5, c)
    operator fun <R1> plus(c: Column1<R1>) = Column6(c1, c2, c3, c4, c5, c.c1)
    operator fun <R1, R2> plus(c: Column2<R1, R2>) = Column7(c1, c2, c3, c4, c5, c.c1, c.c2)
    operator fun <R1, R2, R3> plus(c: Column3<R1, R2, R3>) = Column8(c1, c2, c3, c4, c5, c.c1, c.c2, c.c3)
    operator fun <R1, R2, R3, R4> plus(c: Column4<R1, R2, R3, R4>) = Column9(c1, c2, c3, c4, c5, c.c1, c.c2, c.c3, c.c4)
    operator fun <R1, R2, R3, R4, R5> plus(c: Column5<R1, R2, R3, R4, R5>) = Column10(c1, c2, c3, c4, c5, c.c1, c.c2, c.c3, c.c4, c.c5)
    operator fun <R1, R2, R3, R4, R5, R6> plus(c: Column6<R1, R2, R3, R4, R5, R6>) = Columns(columns + c.columns)
    operator fun <R1, R2, R3, R4, R5, R6, R7> plus(c: Column7<R1, R2, R3, R4, R5, R6, R7>) = Columns(columns + c.columns)
    operator fun <R1, R2, R3, R4, R5, R6, R7, R8> plus(c: Column8<R1, R2, R3, R4, R5, R6, R7, R8>) = Columns(columns + c.columns)
    operator fun <R1, R2, R3, R4, R5, R6, R7, R8, R9> plus(c: Column9<R1, R2, R3, R4, R5, R6, R7, R8, R9>) = Columns(columns + c.columns)
    operator fun <R1, R2, R3, R4, R5, R6, R7, R8, R9, R10> plus(c: Column10<R1, R2, R3, R4, R5, R6, R7, R8, R9, R10>) = Columns(columns + c.columns)
}

data class Column6<T1, T2, T3, T4, T5, T6>(val c1: Column<T1>, val c2: Column<T2>, val c3: Column<T3>, val c4: Column<T4>, val c5: Column<T5>, val c6: Column<T6>, override val columns: List<Column<*>> = listOf(c1, c2, c3, c4, c5, c6)): ColumnList {
    operator fun <R1> plus(c: Column<R1>) = Column7(c1, c2, c3, c4, c5, c6, c)
    operator fun <R1> plus(c: Column1<R1>) = Column7(c1, c2, c3, c4, c5, c6, c.c1)
    operator fun <R1, R2> plus(c: Column2<R1, R2>) = Column8(c1, c2, c3, c4, c5, c6, c.c1, c.c2)
    operator fun <R1, R2, R3> plus(c: Column3<R1, R2, R3>) = Column9(c1, c2, c3, c4, c5, c6, c.c1, c.c2, c.c3)
    operator fun <R1, R2, R3, R4> plus(c: Column4<R1, R2, R3, R4>) = Column10(c1, c2, c3, c4, c5, c6, c.c1, c.c2, c.c3, c.c4)
    operator fun <R1, R2, R3, R4, R5> plus(c: Column5<R1, R2, R3, R4, R5>) = Columns(columns + c.columns)
    operator fun <R1, R2, R3, R4, R5, R6> plus(c: Column6<R1, R2, R3, R4, R5, R6>) = Columns(columns + c.columns)
    operator fun <R1, R2, R3, R4, R5, R6, R7> plus(c: Column7<R1, R2, R3, R4, R5, R6, R7>) = Columns(columns + c.columns)
    operator fun <R1, R2, R3, R4, R5, R6, R7, R8> plus(c: Column8<R1, R2, R3, R4, R5, R6, R7, R8>) = Columns(columns + c.columns)
    operator fun <R1, R2, R3, R4, R5, R6, R7, R8, R9> plus(c: Column9<R1, R2, R3, R4, R5, R6, R7, R8, R9>) = Columns(columns + c.columns)
    operator fun <R1, R2, R3, R4, R5, R6, R7, R8, R9, R10> plus(c: Column10<R1, R2, R3, R4, R5, R6, R7, R8, R9, R10>) = Columns(columns + c.columns)
}

data class Column7<T1, T2, T3, T4, T5, T6, T7>(val c1: Column<T1>, val c2: Column<T2>, val c3: Column<T3>, val c4: Column<T4>, val c5: Column<T5>, val c6: Column<T6>, val c7: Column<T7>, override val columns: List<Column<*>> = listOf(c1, c2, c3, c4, c5, c6, c7)): ColumnList {
    operator fun <R1> plus(c: Column<R1>) = Column8(c1, c2, c3, c4, c5, c6, c7, c)
    operator fun <R1> plus(c: Column1<R1>) = Column8(c1, c2, c3, c4, c5, c6, c7, c.c1)
    operator fun <R1, R2> plus(c: Column2<R1, R2>) = Column9(c1, c2, c3, c4, c5, c6, c7, c.c1, c.c2)
    operator fun <R1, R2, R3> plus(c: Column3<R1, R2, R3>) = Column10(c1, c2, c3, c4, c5, c6, c7, c.c1, c.c2, c.c3)
    operator fun <R1, R2, R3, R4> plus(c: Column4<R1, R2, R3, R4>) = Columns(columns + c.columns)
    operator fun <R1, R2, R3, R4, R5> plus(c: Column5<R1, R2, R3, R4, R5>) = Columns(columns + c.columns)
    operator fun <R1, R2, R3, R4, R5, R6> plus(c: Column6<R1, R2, R3, R4, R5, R6>) = Columns(columns + c.columns)
    operator fun <R1, R2, R3, R4, R5, R6, R7> plus(c: Column7<R1, R2, R3, R4, R5, R6, R7>) = Columns(columns + c.columns)
    operator fun <R1, R2, R3, R4, R5, R6, R7, R8> plus(c: Column8<R1, R2, R3, R4, R5, R6, R7, R8>) = Columns(columns + c.columns)
    operator fun <R1, R2, R3, R4, R5, R6, R7, R8, R9> plus(c: Column9<R1, R2, R3, R4, R5, R6, R7, R8, R9>) = Columns(columns + c.columns)
    operator fun <R1, R2, R3, R4, R5, R6, R7, R8, R9, R10> plus(c: Column10<R1, R2, R3, R4, R5, R6, R7, R8, R9, R10>) = Columns(columns + c.columns)
}

data class Column8<T1, T2, T3, T4, T5, T6, T7, T8>(val c1: Column<T1>, val c2: Column<T2>, val c3: Column<T3>, val c4: Column<T4>, val c5: Column<T5>, val c6: Column<T6>, val c7: Column<T7>, val c8: Column<T8>, override val columns: List<Column<*>> = listOf(c1, c2, c3, c4, c5, c6, c7, c8)): ColumnList {
    operator fun <R1> plus(c: Column<R1>) = Column9(c1, c2, c3, c4, c5, c6, c7, c8, c)
    operator fun <R1> plus(c: Column1<R1>) = Column9(c1, c2, c3, c4, c5, c6, c7, c8, c.c1)
    operator fun <R1, R2> plus(c: Column2<R1, R2>) = Column10(c1, c2, c3, c4, c5, c6, c7, c8, c.c1, c.c2)
    operator fun <R1, R2, R3> plus(c: Column3<R1, R2, R3>) = Columns(columns + c.columns)
    operator fun <R1, R2, R3, R4> plus(c: Column4<R1, R2, R3, R4>) = Columns(columns + c.columns)
    operator fun <R1, R2, R3, R4, R5> plus(c: Column5<R1, R2, R3, R4, R5>) = Columns(columns + c.columns)
    operator fun <R1, R2, R3, R4, R5, R6> plus(c: Column6<R1, R2, R3, R4, R5, R6>) = Columns(columns + c.columns)
    operator fun <R1, R2, R3, R4, R5, R6, R7> plus(c: Column7<R1, R2, R3, R4, R5, R6, R7>) = Columns(columns + c.columns)
    operator fun <R1, R2, R3, R4, R5, R6, R7, R8> plus(c: Column8<R1, R2, R3, R4, R5, R6, R7, R8>) = Columns(columns + c.columns)
    operator fun <R1, R2, R3, R4, R5, R6, R7, R8, R9> plus(c: Column9<R1, R2, R3, R4, R5, R6, R7, R8, R9>) = Columns(columns + c.columns)
    operator fun <R1, R2, R3, R4, R5, R6, R7, R8, R9, R10> plus(c: Column10<R1, R2, R3, R4, R5, R6, R7, R8, R9, R10>) = Columns(columns + c.columns)
}

data class Column9<T1, T2, T3, T4, T5, T6, T7, T8, T9>(val c1: Column<T1>, val c2: Column<T2>, val c3: Column<T3>, val c4: Column<T4>, val c5: Column<T5>, val c6: Column<T6>, val c7: Column<T7>, val c8: Column<T8>, val c9: Column<T9>, override val columns: List<Column<*>> = listOf(c1, c2, c3, c4, c5, c6, c7, c8, c9)): ColumnList {
    operator fun <R1> plus(c: Column<R1>) = Column10(c1, c2, c3, c4, c5, c6, c7, c8, c9, c)
    operator fun <R1> plus(c: Column1<R1>) = Column10(c1, c2, c3, c4, c5, c6, c7, c8, c9, c.c1)
    operator fun <R1, R2> plus(c: Column2<R1, R2>) = Columns(columns + c.columns)
    operator fun <R1, R2, R3> plus(c: Column3<R1, R2, R3>) = Columns(columns + c.columns)
    operator fun <R1, R2, R3, R4> plus(c: Column4<R1, R2, R3, R4>) = Columns(columns + c.columns)
    operator fun <R1, R2, R3, R4, R5> plus(c: Column5<R1, R2, R3, R4, R5>) = Columns(columns + c.columns)
    operator fun <R1, R2, R3, R4, R5, R6> plus(c: Column6<R1, R2, R3, R4, R5, R6>) = Columns(columns + c.columns)
    operator fun <R1, R2, R3, R4, R5, R6, R7> plus(c: Column7<R1, R2, R3, R4, R5, R6, R7>) = Columns(columns + c.columns)
    operator fun <R1, R2, R3, R4, R5, R6, R7, R8> plus(c: Column8<R1, R2, R3, R4, R5, R6, R7, R8>) = Columns(columns + c.columns)
    operator fun <R1, R2, R3, R4, R5, R6, R7, R8, R9> plus(c: Column9<R1, R2, R3, R4, R5, R6, R7, R8, R9>) = Columns(columns + c.columns)
    operator fun <R1, R2, R3, R4, R5, R6, R7, R8, R9, R10> plus(c: Column10<R1, R2, R3, R4, R5, R6, R7, R8, R9, R10>) = Columns(columns + c.columns)
}

data class Column10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>(val c1: Column<T1>, val c2: Column<T2>, val c3: Column<T3>, val c4: Column<T4>, val c5: Column<T5>, val c6: Column<T6>, val c7: Column<T7>, val c8: Column<T8>, val c9: Column<T9>, val c10: Column<T10>, override val columns: List<Column<*>> = listOf(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10)): ColumnList {
    operator fun <R1> plus(c: Column<R1>) = Columns(columns + c)
    operator fun <R1> plus(c: Column1<R1>) = Columns(columns + c.columns)
    operator fun <R1, R2> plus(c: Column2<R1, R2>) = Columns(columns + c.columns)
    operator fun <R1, R2, R3> plus(c: Column3<R1, R2, R3>) = Columns(columns + c.columns)
    operator fun <R1, R2, R3, R4> plus(c: Column4<R1, R2, R3, R4>) = Columns(columns + c.columns)
    operator fun <R1, R2, R3, R4, R5> plus(c: Column5<R1, R2, R3, R4, R5>) = Columns(columns + c.columns)
    operator fun <R1, R2, R3, R4, R5, R6> plus(c: Column6<R1, R2, R3, R4, R5, R6>) = Columns(columns + c.columns)
    operator fun <R1, R2, R3, R4, R5, R6, R7> plus(c: Column7<R1, R2, R3, R4, R5, R6, R7>) = Columns(columns + c.columns)
    operator fun <R1, R2, R3, R4, R5, R6, R7, R8> plus(c: Column8<R1, R2, R3, R4, R5, R6, R7, R8>) = Columns(columns + c.columns)
    operator fun <R1, R2, R3, R4, R5, R6, R7, R8, R9> plus(c: Column9<R1, R2, R3, R4, R5, R6, R7, R8, R9>) = Columns(columns + c.columns)
    operator fun <R1, R2, R3, R4, R5, R6, R7, R8, R9, R10> plus(c: Column10<R1, R2, R3, R4, R5, R6, R7, R8, R9, R10>) = Columns(columns + c.columns)
}