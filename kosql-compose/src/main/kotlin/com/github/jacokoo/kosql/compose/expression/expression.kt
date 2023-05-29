package com.github.jacokoo.kosql.compose.expression

import com.github.jacokoo.kosql.compose.Column

interface Exp<T> {
    companion object {
        val TRUE = object: Exp<Any> {}
    }
}

data class SingleColumnExp<T>(val op: String, val col: Column<T>): Exp<T>
data class ColumnToColumnExp<T>(val op: String, val left: Column<T>, val right: Column<T>): Exp<T>
data class ColumnToValueExp<T>(val op: String, val left: Column<T>, val value: T): Exp<T>
data class ColumnToExpExp<T>(val op: String, val left: Column<T>, val right: Exp<T>): Exp<T>
data class ExpToColumnExp<T>(val op: String, val left: Exp<T>, val right: Column<T>): Exp<T>
data class ComputeExp<T>(val exp: Exp<T>): Exp<T>
data class BetweenExp<T>(val col: Column<T>, val small: T, val big: T): Exp<T>
data class MultiValueExp<T>(val op: String, val col: Column<T>, val values: List<T>): Exp<T>
