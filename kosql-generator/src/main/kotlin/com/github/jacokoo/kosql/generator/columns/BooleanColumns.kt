package com.github.jacokoo.kosql.generator.columns

import com.github.jacokoo.kosql.BooleanType
import com.github.jacokoo.kosql.DataType
import com.github.jacokoo.kosql.generator.AbstractColumnGenerator
import com.github.jacokoo.kosql.generator.ColumnDefinition
import java.sql.Types
import kotlin.reflect.KClass

class BooleanColumnGenerator: AbstractColumnGenerator<Boolean>() {
    override val type: DataType<Boolean> = BooleanType()
    override fun kotlinType(): KClass<*> = Boolean::class
    override fun support(tableName: String, def: ColumnDefinition) =
        Types.BOOLEAN == def.dataType || (Types.BIT == def.dataType && def.columnSize == 1)

    override fun parseDefaultValue(v: Any?) = v?.let { if (v == "b'1'") "true" else "false" } ?: "null"
}