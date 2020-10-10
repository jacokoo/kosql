package com.github.jacokoo.kosql.compose.typesafe

import com.github.jacokoo.kosql.compose.result.Mapper
import com.github.jacokoo.kosql.compose.result.Row
import com.github.jacokoo.kosql.compose.result.SelectResult

class Value1Mapper<T1>(private val c: Column1<T1>): Mapper<Value1<T1>> {
    override fun map(rs: Row) = Value1(rs[0, c.c1])
}
data class Result1<T1>(private val c: Column1<T1>, override val values: List<Value1<T1>>): SelectResult<Value1<T1>> {
    override val columns = c
}

class Value2Mapper<T1, T2>(private val c: Column2<T1, T2>): Mapper<Value2<T1, T2>> {
    override fun map(rs: Row) = Value2(rs[0, c.c1], rs[1, c.c2])
}
data class Result2<T1, T2>(private val c: Column2<T1, T2>, override val values: List<Value2<T1, T2>>): SelectResult<Value2<T1, T2>> {
    override val columns = c
}

class Value3Mapper<T1, T2, T3>(private val c: Column3<T1, T2, T3>): Mapper<Value3<T1, T2, T3>> {
    override fun map(rs: Row) = Value3(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3])
}
data class Result3<T1, T2, T3>(private val c: Column3<T1, T2, T3>, override val values: List<Value3<T1, T2, T3>>): SelectResult<Value3<T1, T2, T3>> {
    override val columns = c
}

class Value4Mapper<T1, T2, T3, T4>(private val c: Column4<T1, T2, T3, T4>): Mapper<Value4<T1, T2, T3, T4>> {
    override fun map(rs: Row) = Value4(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4])
}
data class Result4<T1, T2, T3, T4>(private val c: Column4<T1, T2, T3, T4>, override val values: List<Value4<T1, T2, T3, T4>>): SelectResult<Value4<T1, T2, T3, T4>> {
    override val columns = c
}

class Value5Mapper<T1, T2, T3, T4, T5>(private val c: Column5<T1, T2, T3, T4, T5>): Mapper<Value5<T1, T2, T3, T4, T5>> {
    override fun map(rs: Row) = Value5(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5])
}
data class Result5<T1, T2, T3, T4, T5>(private val c: Column5<T1, T2, T3, T4, T5>, override val values: List<Value5<T1, T2, T3, T4, T5>>): SelectResult<Value5<T1, T2, T3, T4, T5>> {
    override val columns = c
}

class Value6Mapper<T1, T2, T3, T4, T5, T6>(private val c: Column6<T1, T2, T3, T4, T5, T6>): Mapper<Value6<T1, T2, T3, T4, T5, T6>> {
    override fun map(rs: Row) = Value6(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6])
}
data class Result6<T1, T2, T3, T4, T5, T6>(private val c: Column6<T1, T2, T3, T4, T5, T6>, override val values: List<Value6<T1, T2, T3, T4, T5, T6>>): SelectResult<Value6<T1, T2, T3, T4, T5, T6>> {
    override val columns = c
}

class Value7Mapper<T1, T2, T3, T4, T5, T6, T7>(private val c: Column7<T1, T2, T3, T4, T5, T6, T7>): Mapper<Value7<T1, T2, T3, T4, T5, T6, T7>> {
    override fun map(rs: Row) = Value7(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6], rs[6, c.c7])
}
data class Result7<T1, T2, T3, T4, T5, T6, T7>(private val c: Column7<T1, T2, T3, T4, T5, T6, T7>, override val values: List<Value7<T1, T2, T3, T4, T5, T6, T7>>): SelectResult<Value7<T1, T2, T3, T4, T5, T6, T7>> {
    override val columns = c
}

class Value8Mapper<T1, T2, T3, T4, T5, T6, T7, T8>(private val c: Column8<T1, T2, T3, T4, T5, T6, T7, T8>): Mapper<Value8<T1, T2, T3, T4, T5, T6, T7, T8>> {
    override fun map(rs: Row) = Value8(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6], rs[6, c.c7], rs[7, c.c8])
}
data class Result8<T1, T2, T3, T4, T5, T6, T7, T8>(private val c: Column8<T1, T2, T3, T4, T5, T6, T7, T8>, override val values: List<Value8<T1, T2, T3, T4, T5, T6, T7, T8>>): SelectResult<Value8<T1, T2, T3, T4, T5, T6, T7, T8>> {
    override val columns = c
}

class Value9Mapper<T1, T2, T3, T4, T5, T6, T7, T8, T9>(private val c: Column9<T1, T2, T3, T4, T5, T6, T7, T8, T9>): Mapper<Value9<T1, T2, T3, T4, T5, T6, T7, T8, T9>> {
    override fun map(rs: Row) = Value9(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6], rs[6, c.c7], rs[7, c.c8], rs[8, c.c9])
}
data class Result9<T1, T2, T3, T4, T5, T6, T7, T8, T9>(private val c: Column9<T1, T2, T3, T4, T5, T6, T7, T8, T9>, override val values: List<Value9<T1, T2, T3, T4, T5, T6, T7, T8, T9>>): SelectResult<Value9<T1, T2, T3, T4, T5, T6, T7, T8, T9>> {
    override val columns = c
}

class Value10Mapper<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>(private val c: Column10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>): Mapper<Value10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>> {
    override fun map(rs: Row) = Value10(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6], rs[6, c.c7], rs[7, c.c8], rs[8, c.c9], rs[9, c.c10])
}
data class Result10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>(private val c: Column10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>, override val values: List<Value10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>>): SelectResult<Value10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>> {
    override val columns = c
}
