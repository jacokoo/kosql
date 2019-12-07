package com.github.jacokoo.kosql.test.kosql

import com.github.jacokoo.kosql.compose.BooleanType
import com.github.jacokoo.kosql.compose.ByteArrayType
import com.github.jacokoo.kosql.compose.DateTimeLongType
import com.github.jacokoo.kosql.compose.DateTimeType
import com.github.jacokoo.kosql.compose.DateType
import com.github.jacokoo.kosql.compose.DecimalType
import com.github.jacokoo.kosql.compose.DoubleType
import com.github.jacokoo.kosql.compose.Entity
import com.github.jacokoo.kosql.compose.FloatType
import com.github.jacokoo.kosql.compose.IntEnumType
import com.github.jacokoo.kosql.compose.IntType
import com.github.jacokoo.kosql.compose.LongType
import com.github.jacokoo.kosql.compose.StringEnumType
import com.github.jacokoo.kosql.compose.StringType
import com.github.jacokoo.kosql.compose.Table
import com.github.jacokoo.kosql.compose.typesafe.Column22
import com.github.jacokoo.kosql.test.Color
import com.github.jacokoo.kosql.test.State
import com.github.jacokoo.kosql.test.entity.SupportType
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime

class SupportTypeTableIntEnumEnumType: IntEnumType<Color>() {
    override val clazz: Class<Color> = Color::class.java
    override val nullValue: Color = Color.RED
}

class SupportTypeTableStringEnumEnumType: StringEnumType<State>() {
    override val clazz: Class<State> = State::class.java
    override val nullValue: State = State.INIT
}


open class SupportTypeBase(): Entity<Long> {
    var id: Long = 0L
    var int: Int? = null
    var tinyInt: Int? = null
    var smallInt: Int? = null
    var bitInt: Int? = null
    var long: Long? = null
    var bitLong: Long = 0L
    var float: Float? = null
    var double: Double? = null
    var decimal: BigDecimal? = null
    var intEnum: Color = Color.RED
    var stringEnum: State = State.INIT
    var intBool: Boolean = false
    var bitBool: Boolean = false
    var blob: ByteArray? = ByteArray(0)
    var date: LocalDate = LocalDate.MIN
    var datetime: LocalDateTime = LocalDateTime.MIN
    var timestamp: LocalDateTime? = null
    var longDatetime: LocalDateTime = LocalDateTime.MIN
    var charString: String? = null
    var varcharString: String? = null
    var textString: String? = null

    constructor(other: SupportTypeBase): this() {
        this.id = other.id
        this.int = other.int
        this.tinyInt = other.tinyInt
        this.smallInt = other.smallInt
        this.bitInt = other.bitInt
        this.long = other.long
        this.bitLong = other.bitLong
        this.float = other.float
        this.double = other.double
        this.decimal = other.decimal
        this.intEnum = other.intEnum
        this.stringEnum = other.stringEnum
        this.intBool = other.intBool
        this.bitBool = other.bitBool
        this.blob = other.blob
        this.date = other.date
        this.datetime = other.datetime
        this.timestamp = other.timestamp
        this.longDatetime = other.longDatetime
        this.charString = other.charString
        this.varcharString = other.varcharString
        this.textString = other.textString
    }

    override fun get(name: String): Any? = when(name) {
        SUPPORT_TYPE.ID.name -> this.id
        SUPPORT_TYPE.INT.name -> this.int
        SUPPORT_TYPE.TINY_INT.name -> this.tinyInt
        SUPPORT_TYPE.SMALL_INT.name -> this.smallInt
        SUPPORT_TYPE.BIT_INT.name -> this.bitInt
        SUPPORT_TYPE.LONG.name -> this.long
        SUPPORT_TYPE.BIT_LONG.name -> this.bitLong
        SUPPORT_TYPE.FLOAT.name -> this.float
        SUPPORT_TYPE.DOUBLE.name -> this.double
        SUPPORT_TYPE.DECIMAL.name -> this.decimal
        SUPPORT_TYPE.INT_ENUM.name -> this.intEnum
        SUPPORT_TYPE.STRING_ENUM.name -> this.stringEnum
        SUPPORT_TYPE.INT_BOOL.name -> this.intBool
        SUPPORT_TYPE.BIT_BOOL.name -> this.bitBool
        SUPPORT_TYPE.BLOB.name -> this.blob
        SUPPORT_TYPE.DATE.name -> this.date
        SUPPORT_TYPE.DATETIME.name -> this.datetime
        SUPPORT_TYPE.TIMESTAMP.name -> this.timestamp
        SUPPORT_TYPE.LONG_DATETIME.name -> this.longDatetime
        SUPPORT_TYPE.CHAR_STRING.name -> this.charString
        SUPPORT_TYPE.VARCHAR_STRING.name -> this.varcharString
        SUPPORT_TYPE.TEXT_STRING.name -> this.textString
        else -> null
    }

    override fun set(name: String, value: Any?) {
        when (name) {
            SUPPORT_TYPE.ID.name -> this.id = value as Long
            SUPPORT_TYPE.INT.name -> this.int = value as Int
            SUPPORT_TYPE.TINY_INT.name -> this.tinyInt = value as Int
            SUPPORT_TYPE.SMALL_INT.name -> this.smallInt = value as Int
            SUPPORT_TYPE.BIT_INT.name -> this.bitInt = value as Int
            SUPPORT_TYPE.LONG.name -> this.long = value as Long
            SUPPORT_TYPE.BIT_LONG.name -> this.bitLong = value as Long
            SUPPORT_TYPE.FLOAT.name -> this.float = value as Float
            SUPPORT_TYPE.DOUBLE.name -> this.double = value as Double
            SUPPORT_TYPE.DECIMAL.name -> this.decimal = value as BigDecimal
            SUPPORT_TYPE.INT_ENUM.name -> this.intEnum = value as Color
            SUPPORT_TYPE.STRING_ENUM.name -> this.stringEnum = value as State
            SUPPORT_TYPE.INT_BOOL.name -> this.intBool = value as Boolean
            SUPPORT_TYPE.BIT_BOOL.name -> this.bitBool = value as Boolean
            SUPPORT_TYPE.BLOB.name -> this.blob = value as ByteArray
            SUPPORT_TYPE.DATE.name -> this.date = value as LocalDate
            SUPPORT_TYPE.DATETIME.name -> this.datetime = value as LocalDateTime
            SUPPORT_TYPE.TIMESTAMP.name -> this.timestamp = value as LocalDateTime
            SUPPORT_TYPE.LONG_DATETIME.name -> this.longDatetime = value as LocalDateTime
            SUPPORT_TYPE.CHAR_STRING.name -> this.charString = value as String
            SUPPORT_TYPE.VARCHAR_STRING.name -> this.varcharString = value as String
            SUPPORT_TYPE.TEXT_STRING.name -> this.textString = value as String
        }
    }

    override fun toString(): String = buildString {
        append("SupportTypeBase (")
        append("id = $id, int = $int, tinyInt = $tinyInt, smallInt = $smallInt, bitInt = $bitInt, long = $long, bitLong = $bitLong, float = $float, double = $double, decimal = $decimal, intEnum = $intEnum, stringEnum = $stringEnum, intBool = $intBool, bitBool = $bitBool, blob = $blob, date = $date, datetime = $datetime, timestamp = $timestamp, longDatetime = $longDatetime, charString = $charString, varcharString = $varcharString, textString = $textString")
        append(")")
    }

}


open class SupportTypeTable protected constructor(alias: String = ""): Table<Long, SupportType>("t_support_type", alias, "") {
    val ID = createColumn("f_id", LongType(), false, 0L, autoIncrement = true)
    val INT = createColumn("f_int", IntType(), true, null)
    val TINY_INT = createColumn("f_tiny_int", IntType(), true, null)
    val SMALL_INT = createColumn("f_small_int", IntType(), true, null)
    val BIT_INT = createColumn("f_bit_int", IntType(), true, null)
    val LONG = createColumn("f_long", LongType(), true, null)
    val BIT_LONG = createColumn("f_bit_long", LongType(), false, 0L)
    val FLOAT = createColumn("f_float", FloatType(), true, null)
    val DOUBLE = createColumn("f_double", DoubleType(), true, null)
    val DECIMAL = createColumn("f_decimal", DecimalType(), true, null)
    val INT_ENUM = createColumn("f_int_enum", SupportTypeTableIntEnumEnumType(), false, Color.RED)
    val STRING_ENUM = createColumn("f_string_enum", SupportTypeTableStringEnumEnumType(), false, State.INIT)
    val INT_BOOL = createColumn("f_int_bool", BooleanType(), false, false)
    val BIT_BOOL = createColumn("f_bit_bool", BooleanType(), false, false)
    val BLOB = createColumn("f_blob", ByteArrayType(), true, ByteArray(0))
    val DATE = createColumn("f_date", DateType(), false, LocalDate.MIN)
    val DATETIME = createColumn("f_datetime", DateTimeType(), false, LocalDateTime.MIN)
    val TIMESTAMP = createColumn("f_timestamp", DateTimeType(), true, null)
    val LONG_DATETIME = createColumn("f_long_datetime", DateTimeLongType(), false, LocalDateTime.MIN)
    val CHAR_STRING = createColumn("f_char_string", StringType(), true, null)
    val VARCHAR_STRING = createColumn("f_varchar_string", StringType(), true, null)
    val TEXT_STRING = createColumn("f_text_string", StringType(), true, null)

    override fun AS(alias: String) = SupportTypeTable(alias)
    override fun primaryKey() = ID
    operator fun unaryMinus() = Column22(ID, INT, TINY_INT, SMALL_INT, BIT_INT, LONG, BIT_LONG, FLOAT, DOUBLE, DECIMAL, INT_ENUM, STRING_ENUM, INT_BOOL, BIT_BOOL, BLOB, DATE, DATETIME, TIMESTAMP, LONG_DATETIME, CHAR_STRING, VARCHAR_STRING, TEXT_STRING)
}

object SUPPORT_TYPE: SupportTypeTable()
