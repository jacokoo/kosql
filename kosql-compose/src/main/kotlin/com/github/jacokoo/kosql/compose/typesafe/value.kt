package com.github.jacokoo.kosql.compose.typesafe

import com.github.jacokoo.kosql.compose.statement.ValueList
import com.github.jacokoo.kosql.compose.statement.Values

data class Value1<T1>(val v1: T1, override val values: List<Any?> = listOf(v1)): ValueList
data class Value2<T1, T2>(val v1: T1, val v2: T2, override val values: List<Any?> = listOf(v1, v2)): ValueList
data class Value3<T1, T2, T3>(val v1: T1, val v2: T2, val v3: T3, override val values: List<Any?> = listOf(v1, v2, v3)): ValueList
data class Value4<T1, T2, T3, T4>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, override val values: List<Any?> = listOf(v1, v2, v3, v4)): ValueList
data class Value5<T1, T2, T3, T4, T5>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, val v5: T5, override val values: List<Any?> = listOf(v1, v2, v3, v4, v5)): ValueList
data class Value6<T1, T2, T3, T4, T5, T6>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, val v5: T5, val v6: T6, override val values: List<Any?> = listOf(v1, v2, v3, v4, v5, v6)): ValueList
data class Value7<T1, T2, T3, T4, T5, T6, T7>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, val v5: T5, val v6: T6, val v7: T7, override val values: List<Any?> = listOf(v1, v2, v3, v4, v5, v6, v7)): ValueList
data class Value8<T1, T2, T3, T4, T5, T6, T7, T8>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, val v5: T5, val v6: T6, val v7: T7, val v8: T8, override val values: List<Any?> = listOf(v1, v2, v3, v4, v5, v6, v7, v8)): ValueList
data class Value9<T1, T2, T3, T4, T5, T6, T7, T8, T9>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, val v5: T5, val v6: T6, val v7: T7, val v8: T8, val v9: T9, override val values: List<Any?> = listOf(v1, v2, v3, v4, v5, v6, v7, v8, v9)): ValueList
data class Value10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, val v5: T5, val v6: T6, val v7: T7, val v8: T8, val v9: T9, val v10: T10, override val values: List<Any?> = listOf(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10)): ValueList

interface ValueSupport {
    fun V(list: List<Any?>) = Values(list)
    fun <T1> V(v1: T1) = Value1(v1)
    fun <T1, T2> V(v1: T1, v2: T2) = Value2(v1, v2)
    fun <T1, T2, T3> V(v1: T1, v2: T2, v3: T3) = Value3(v1, v2, v3)
    fun <T1, T2, T3, T4> V(v1: T1, v2: T2, v3: T3, v4: T4) = Value4(v1, v2, v3, v4)
    fun <T1, T2, T3, T4, T5> V(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5) = Value5(v1, v2, v3, v4, v5)
    fun <T1, T2, T3, T4, T5, T6> V(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6) = Value6(v1, v2, v3, v4, v5, v6)
    fun <T1, T2, T3, T4, T5, T6, T7> V(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7) = Value7(v1, v2, v3, v4, v5, v6, v7)
    fun <T1, T2, T3, T4, T5, T6, T7, T8> V(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8) = Value8(v1, v2, v3, v4, v5, v6, v7, v8)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9> V(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8, v9: T9) = Value9(v1, v2, v3, v4, v5, v6, v7, v8, v9)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> V(v1: T1, v2: T2, v3: T3, v4: T4, v5: T5, v6: T6, v7: T7, v8: T8, v9: T9, v10: T10) = Value10(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10)
}
