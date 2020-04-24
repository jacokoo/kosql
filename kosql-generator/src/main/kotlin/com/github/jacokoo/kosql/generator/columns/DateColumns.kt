package com.github.jacokoo.kosql.generator.columns

import com.github.jacokoo.kosql.compose.*
import com.github.jacokoo.kosql.generator.AbstractColumnGenerator
import com.github.jacokoo.kosql.generator.ColumnDefinition
import java.sql.Types
import java.time.LocalDate
import java.time.LocalDateTime

class DateColumnGenerator: AbstractColumnGenerator<LocalDate>() {
    override val type: DataType<LocalDate> = DateType()
    override val nullType: DataType<LocalDate?> = DateNullType()
    override fun kotlinType() = LocalDate::class
    override fun parseDefaultValue(v: Any?): String = v?.let {
        if (v == type.nullValue) "LocalDate.of(1970, 1, 1)"
        else "LocalDate.parse(\"${v}\")"
    } ?: "null"
    override fun support(tableName: String, def: ColumnDefinition) =
            Types.DATE == def.dataType
}

class DateTimeColumnGenerator: AbstractColumnGenerator<LocalDateTime>() {
    override val type: DataType<LocalDateTime> = DateTimeType()
    override val nullType: DataType<LocalDateTime?> = DateTimeNullType()
    override fun kotlinType() = LocalDateTime::class
    override fun parseDefaultValue(v: Any?): String = when(v) {
        null -> "null"
        type.nullValue -> "LocalDateTime.of(1970, 1, 1, 0, 0, 0)"
        "CURRENT_TIMESTAMP" -> "LocalDateTime.now()"
        else -> "LocalDateTime.parse(\"${v}\")"
    }
    override fun support(tableName: String, def: ColumnDefinition) =
            Types.TIMESTAMP == def.dataType
}

class DateTimeLongColumnGenerator: AbstractColumnGenerator<LocalDateTime>() {
    override val type: DataType<LocalDateTime> = DateTimeLongType()
    override val nullType: DataType<LocalDateTime?> = DateTimeLongNullType()
    override fun kotlinType() = LocalDateTime::class
    override fun parseDefaultValue(v: Any?): String = when(v) {
        null -> "null"
        type.nullValue -> "LocalDateTime.of(1970, 1, 1, 0, 0, 0)"
        "CURRENT_TIMESTAMP" -> "System.currentTimeMillis()"
        else -> "LocalDateTime.parse(\"${v}\")"
    }
    override fun support(tableName: String, def: ColumnDefinition) =
            Types.BIGINT == def.dataType && def.name.endsWith("time")
}
