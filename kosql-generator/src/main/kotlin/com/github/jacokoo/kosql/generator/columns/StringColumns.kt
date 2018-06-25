package com.github.jacokoo.kosql.generator.columns

import com.github.jacokoo.kosql.compose.DataType
import com.github.jacokoo.kosql.compose.StringType
import com.github.jacokoo.kosql.generator.AbstractColumnGenerator
import com.github.jacokoo.kosql.generator.ColumnDefinition
import com.github.jacokoo.kosql.generator.ColumnGenerator

class StringColumnGenerator: AbstractColumnGenerator<String>() {
    override val type: DataType<String> = StringType()
    override fun kotlinType() = String::class
    override fun parseDefaultValue(v: Any?): String = v?.let { "\"${it.toString()}\"" } ?: "null"
    override fun support(tableName: String, def: ColumnDefinition) = ColumnGenerator.strs.contains(def.dataType)
}
