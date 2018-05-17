package com.github.jacokoo.kosql.compose

data class UnitBooleanHolder(val value: Boolean, val handled: Boolean) {
    fun or(bool: Boolean, block: () -> Unit) =
        if (handled) this
        else if (bool) block().let { UnitBooleanHolder(bool, true) }
        else UnitBooleanHolder(bool, false)

    fun or(block: () -> Unit) {
        if (!handled) block()
    }
}

data class BooleanHolder<T>(val value: Boolean, val result: T?, val handled: Boolean = false) {

    fun or(bool: Boolean, block: () -> T) =
        if (handled) this
        else if (bool) BooleanHolder<T>(bool, block(), true)
        else BooleanHolder<T>(bool, null, false)

    fun or(block: () -> T) =
        if (handled) this.result!!
        else block()

}

fun <T> Boolean.then(block: () -> T) =
    if (this) BooleanHolder<T>(this, block(), true)
    else BooleanHolder<T>(this, null, false)

fun Boolean.thenDo(block: () -> Unit) =
    if (this) block().let { UnitBooleanHolder(this, true) }
    else UnitBooleanHolder(this, false)

fun Boolean.orDo(block: () -> Unit) {
    if (!this) block()
}
