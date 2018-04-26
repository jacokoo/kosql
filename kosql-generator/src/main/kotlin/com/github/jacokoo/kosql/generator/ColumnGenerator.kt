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

data class ColumnInfo(
        val name: String,
        val type: String, // the Datatype class for import
        val typeClass: KClass<*>,  // the kotlin class for field declaration
        val defaultValue: String,
        val define: String,
        val def: ColumnDefinition
)

interface ColumnGenerator {

    /**
     * check if this generator support che column specification
     */
    fun support(tableName: String, def: ColumnDefinition): Boolean

    /**
     * generate column value
     */
    fun generete(tableName: String, def: ColumnDefinition, config: KoSQLGeneratorConfig): ColumnInfo

}

abstract class AbstractColumnGenerator<T>: ColumnGenerator {
    abstract val type: DataType<T>
    abstract fun kotlinType(): KClass<*>
    override fun generete(tableName: String, def: ColumnDefinition, config: KoSQLGeneratorConfig): ColumnInfo {
        val (define, dv) = createColumn(def)
        return ColumnInfo(config.namingStrategy.tableFieldName(def.name), type::class.qualifiedName!!, kotlinType(), dv, define, def)
    }

    protected fun createColumn(def: ColumnDefinition): Pair<String, String> {
        val typeName = type::class.simpleName
        val defaultValue: Any? = if (def.defaultValue == null) {
            if (def.nullable) null else type.nullValue
        } else def.defaultValue
        val dv = parseDefaultValue(defaultValue)
        var str = "createColumn(\"${def.name}\", $typeName(), ${def.nullable}, $dv)"
        if (def.isAutoIncrement) str += ".autoIncrement()"
        return  str to dv
    }

    protected open fun parseDefaultValue(v: Any?): String = v?.toString() ?: "null"
}