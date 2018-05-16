package com.github.jacokoo.kosql.generator.columns

import com.github.jacokoo.kosql.compose.*
import com.github.jacokoo.kosql.generator.AbstractColumnGenerator
import com.github.jacokoo.kosql.generator.ColumnDefinition
import java.sql.Types
import java.time.LocalDate
import java.time.LocalDateTime
import kotlin.reflect.KClass

class DateColumnGenerator: AbstractColumnGenerator<LocalDate>() {
    override val type: DataType<LocalDate> = DateType()
    override fun kotlinType(): KClass<*> = LocalDate::class
    override fun parseDefaultValue(v: Any?): String = v?.let {
        if (v == type.nullValue) "LocalDate.MIN"
        else "LocalDate.parse(\"${v.toString()}\")"
    } ?: "null"
    override fun support(tableName: String, def: ColumnDefinition) =
            Types.DATE == def.dataType
}

class DateTimeColumnGenerator: AbstractColumnGenerator<LocalDateTime>() {
    override val type: DataType<LocalDateTime> = DateTimeType()
    override fun kotlinType(): KClass<*> = LocalDateTime::class
    override fun parseDefaultValue(v: Any?): String = v?.let {
        if (v == type.nullValue) "LocalDateTime.MIN"
        else "LocalDateTime.parse(\"${v.toString()}\")"
    } ?: "null"
    override fun support(tableName: String, def: ColumnDefinition) =
            Types.TIMESTAMP == def.dataType
}

class DateTimeLongColumnGenerator: AbstractColumnGenerator<LocalDateTime>() {
    override val type: DataType<LocalDateTime> = DateTimeLongType()
    override fun kotlinType(): KClass<*> = LocalDateTime::class
    override fun parseDefaultValue(v: Any?): String = v?.let {
        if (v == type.nullValue) "LocalDateTime.MIN"
        else "LocalDateTime.parse(\"${v.toString()}\")"
    } ?: "null"
    override fun support(tableName: String, def: ColumnDefinition) =
            Types.BIGINT == def.dataType && def.name.indexOf("time") != -1
}
