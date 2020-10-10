package com.github.jacokoo.kosql.execute.sync

interface Use {
    fun <T, U> USE(t: T, fn: (T) -> U): U = fn(t)
    fun <T, T2, U> USE(t: T, t2: T2, fn: (T, T2) -> U): U = fn(t, t2)
    fun <T, T2, T3, U> USE(t: T, t2: T2, t3: T3, fn: (T, T2, T3) -> U): U = fn(t, t2, t3)
    fun <T, T2, T3, T4, U> USE(t: T, t2: T2, t3: T3, t4: T4, fn: (T, T2, T3, T4) -> U): U = fn(t, t2, t3, t4)
    fun <T, T2, T3, T4, T5, U> USE(t: T, t2: T2, t3: T3, t4: T4, t5: T5, fn: (T, T2, T3, T4, T5) -> U): U = fn(t, t2, t3, t4, t5)
    fun <T, T2, T3, T4, T5, T6, U> USE(t: T, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, fn: (T, T2, T3, T4, T5, T6) -> U): U = fn(t, t2, t3, t4, t5, t6)
    fun <T, T2, T3, T4, T5, T6, T7, U> USE(t: T, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, fn: (T, T2, T3, T4, T5, T6, T7) -> U): U = fn(t, t2, t3, t4, t5, t6, t7)
    fun <T, T2, T3, T4, T5, T6, T7, T8, U> USE(t: T, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, fn: (T, T2, T3, T4, T5, T6, T7, T8) -> U): U = fn(t, t2, t3, t4, t5, t6, t7, t8)
    fun <T, T2, T3, T4, T5, T6, T7, T8, T9, U> USE(t: T, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, fn: (T, T2, T3, T4, T5, T6, T7, T8, T9) -> U): U = fn(t, t2, t3, t4, t5, t6, t7, t8, t9)
    fun <T, T2, T3, T4, T5, T6, T7, T8, T9, T0, U> USE(t: T, t2: T2, t3: T3, t4: T4, t5: T5, t6: T6, t7: T7, t8: T8, t9: T9, t0: T0, fn: (T, T2, T3, T4, T5, T6, T7, T8, T9, T0) -> U): U = fn(t, t2, t3, t4, t5, t6, t7, t8, t9, t0)
}
