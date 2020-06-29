package com.github.jacokoo.kosql.generator.columns

import com.github.jacokoo.kosql.compose.*
import com.github.jacokoo.kosql.generator.AbstractColumnGenerator
import com.github.jacokoo.kosql.generator.ColumnDefinition
import com.github.jacokoo.kosql.generator.ColumnGenerator
import java.sql.Types

class BooleanColumnGenerator: AbstractColumnGenerator<Boolean>() {
    override val type: DataType<Boolean> = BooleanType()
    override val nullType: DataType<Boolean> = BooleanNullType()
    override fun kotlinType() = Boolean::class
    override fun support(tableName: String, def: ColumnDefinition) =
        Types.BOOLEAN == def.dataType ||
                (Types.BIT == def.dataType && def.columnSize < 2) ||  // mysql tinyint(1) got BIT(null) here
                (Types.TINYINT == def.dataType && def.columnSize == 1)

    override fun parseDefaultValue(v: Any?) = v?.let { if (v == "b'1'") "true" else "false" } ?: "null"
}

class ByteArrayColumnGenerator: AbstractColumnGenerator<ByteArray>() {
    override val type: DataType<ByteArray> = ByteArrayType()
    override val nullType: DataType<ByteArray> = ByteArrayNullType()

    override fun kotlinType() = ByteArray::class
    override fun support(tableName: String, def: ColumnDefinition): Boolean =
        (ColumnGenerator.bits.contains(def.dataType) && def.columnSize >= 64) ||
                Types.BLOB == def.dataType

    override fun parseDefaultValue(v: Any?): String = "ByteArray(0)" // can not have default value
}
