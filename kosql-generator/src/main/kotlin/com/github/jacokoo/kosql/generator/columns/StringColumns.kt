package com.github.jacokoo.kosql.generator.columns

import com.github.jacokoo.kosql.DataType
import com.github.jacokoo.kosql.StringType
import com.github.jacokoo.kosql.generator.AbstractColumnGenerator
import com.github.jacokoo.kosql.generator.ColumnDefinition
import java.sql.Types
import kotlin.reflect.KClass

class StringColumnGenerator: AbstractColumnGenerator<String>() {
    override val type: DataType<String> = StringType()
    override fun kotlinType(): KClass<*> = String::class
    override fun parseDefaultValue(v: Any?): String = v?.let { "\"${it.toString()}\"" } ?: "null"
    override fun support(tableName: String, def: ColumnDefinition) =
            Types.CHAR == def.dataType || Types.VARCHAR == def.dataType || Types.LONGVARCHAR == def.dataType
}