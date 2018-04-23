package com.github.jacokoo.kosql.generator

import com.github.jacokoo.kosql.DataType
import java.sql.ResultSet
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
) {
    override fun toString(): String {
        return "$name $typeName($columnSize) $nullable :$remark"
    }

    companion object {
        fun fromResultSet(rs: ResultSet): ColumnDefinition = ColumnDefinition(
            rs.getString("COLUMN_NAME"),
            rs.getInt("DATA_TYPE"),
            rs.getString("TYPE_NAME"),
            rs.getInt("COLUMN_SIZE"),
            rs.getInt("DECIMAL_DIGITS"),
            rs.getInt("NUM_PREC_RADIX"),
            rs.getString("IS_NULLABLE").let { it != "NO" },
            rs.getString("COLUMN_DEF"),
            rs.getString("REMARKS"),
            rs.getInt("ORDINAL_POSITION"),
            rs.getString("IS_AUTOINCREMENT").let { it != "NO" },
            rs.getString("IS_GENERATEDCOLUMN").let { it != "NO" }
        )
    }
}

data class ColumnInfo(val type: KClass<out DataType<*>>, val typeName: String, val define: String)

interface ColumnGenerator {

    /**
     * check if this generator support che column specification
     */
    fun support(tableName: String, def: ColumnDefinition): Boolean

    /**
     * generate column value
     */
    fun generete(tableName: String, def: ColumnDefinition): ColumnInfo

}

abstract class AbstractColumnGenerator<T>: ColumnGenerator {
    abstract val type: DataType<T>
    override fun generete(tableName: String, def: ColumnDefinition): ColumnInfo = ColumnInfo(
            type::class, type::class.typeParameters[0].name, createColumn(def)
    )

    protected fun createColumn(def: ColumnDefinition): String {
        val typeName = type::class.simpleName
        val defaultValue = if (def.defaultValue == null) type.nullValue.toString() else def.defaultValue
        return "createColumn(${def.name}, $typeName(), ${def.nullable}, ${parseDefaultValue(defaultValue)})"
    }

    protected fun parseDefaultValue(v: String): String = v
}