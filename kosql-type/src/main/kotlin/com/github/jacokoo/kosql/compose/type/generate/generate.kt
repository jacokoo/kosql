package com.github.jacokoo.kosql.compose.type.generate

import com.github.jacokoo.kosql.compose.type.DataType
import com.github.jacokoo.kosql.compose.type.IntType
import kotlin.reflect.KClass

data class ColumnDefinition(
    val name: String,
    val dataType: Int,
    val typeName: String,
    val columnSize: Int,
    val decimalDigits: Int,
    val numPrecRadix: Int,
    val nullable: Boolean,
    val defaultValue: String?,
    val remark: String,
    val ordinalPosition: Int,
    val isAutoIncrement: Boolean,
    val isGeneratedColumn: Boolean
)

typealias TypeClass = KClass<out DataType<*>>

open class ColumnType(val type: TypeClass, val dataType: KClass<*>, private val nullValue: String) {
    open fun parseDefaultValue(v: String?): String = v?.let { doParse(it) } ?: nullValue
    open fun doParse(it: String): String = it
    open fun extraImports(): Array<String> = arrayOf()
}

class ColumnFactory {
    fun generate(tableName: String, def: ColumnDefinition): ColumnType
            = ColumnType(IntType::class, Int::class,"0")
}