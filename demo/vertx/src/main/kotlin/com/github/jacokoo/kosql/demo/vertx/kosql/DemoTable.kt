package com.github.jacokoo.kosql.demo.vertx.kosql

import com.github.jacokoo.kosql.compose.Entity
import com.github.jacokoo.kosql.compose.InnerTable
import com.github.jacokoo.kosql.compose.Table
import com.github.jacokoo.kosql.compose.statement.Columns
import com.github.jacokoo.kosql.compose.type.BooleanNullType
import com.github.jacokoo.kosql.compose.type.BooleanType
import com.github.jacokoo.kosql.compose.type.BufferNullType
import com.github.jacokoo.kosql.compose.type.DateNullType
import com.github.jacokoo.kosql.compose.type.DateTimeNullType
import com.github.jacokoo.kosql.compose.type.DecimalNullType
import com.github.jacokoo.kosql.compose.type.DoubleNullType
import com.github.jacokoo.kosql.compose.type.DurationNullType
import com.github.jacokoo.kosql.compose.type.EPOCH_DATE
import com.github.jacokoo.kosql.compose.type.EPOCH_TIME
import com.github.jacokoo.kosql.compose.type.FloatNullType
import com.github.jacokoo.kosql.compose.type.IntNullType
import com.github.jacokoo.kosql.compose.type.LongNullType
import com.github.jacokoo.kosql.compose.type.LongType
import com.github.jacokoo.kosql.compose.type.StringNullType
import com.github.jacokoo.kosql.demo.vertx.entity.Demo
import com.github.jacokoo.kosql.demo.vertx.entity.DemoType
import io.vertx.core.buffer.Buffer
import java.math.BigDecimal
import java.time.Duration
import java.time.LocalDate
import java.time.LocalDateTime


open class DemoBase(): Entity<Long> {
    override val INNER_TABLE: InnerTable<Long, Entity<Long>> = INNER_DEMO
    var id: Long = 0L
    var int: Int = 0
    var uint: Long = 0L
    var tiny: DemoType = DemoType.TYPE1
    var utiny: Int = 0
    var tiny1: Boolean = false
    var utiny1: Boolean = false
    var small: Int = 0
    var usmall: Int = 0
    var mint: Int = 0
    var umint: Int = 0
    var ubig: BigDecimal = BigDecimal.ZERO
    var float: Float = 0.0f
    var ufloat: Float = 0.0f
    var double: Double = 0.0
    var udouble: Double = 0.0
    var numeric: BigDecimal = BigDecimal.ZERO
    var unumeric: BigDecimal = BigDecimal.ZERO
    var bit1: Boolean = false
    var bit32: Long = 0L
    var bit16: Long = 0L
    var bit8: Long = 0L
    var bit64: Long = 0L
    var bool: Boolean = false
    var char: String = ""
    var varchar: String = ""
    var tinyText: String = ""
    var text: String = ""
    var longText: String = ""
    var tinyBlob: Buffer = Buffer.buffer()
    var blob: Buffer = Buffer.buffer()
    var mblob: Buffer = Buffer.buffer()
    var lblob: Buffer = Buffer.buffer()
    var bin: Buffer = Buffer.buffer()
    var createTime: Long = 0L
    var varbin: Buffer = Buffer.buffer()
    var date: LocalDate = EPOCH_DATE
    var datetime: LocalDateTime = EPOCH_TIME
    var timestamp: LocalDateTime = EPOCH_TIME
    var year: Int = 0
    var time: Duration = Duration.ofSeconds(0)

    constructor(other: DemoBase): this() {
        this.id = other.id
        this.int = other.int
        this.uint = other.uint
        this.tiny = other.tiny
        this.utiny = other.utiny
        this.tiny1 = other.tiny1
        this.utiny1 = other.utiny1
        this.small = other.small
        this.usmall = other.usmall
        this.mint = other.mint
        this.umint = other.umint
        this.ubig = other.ubig
        this.float = other.float
        this.ufloat = other.ufloat
        this.double = other.double
        this.udouble = other.udouble
        this.numeric = other.numeric
        this.unumeric = other.unumeric
        this.bit1 = other.bit1
        this.bit32 = other.bit32
        this.bit16 = other.bit16
        this.bit8 = other.bit8
        this.bit64 = other.bit64
        this.bool = other.bool
        this.char = other.char
        this.varchar = other.varchar
        this.tinyText = other.tinyText
        this.text = other.text
        this.longText = other.longText
        this.tinyBlob = other.tinyBlob
        this.blob = other.blob
        this.mblob = other.mblob
        this.lblob = other.lblob
        this.bin = other.bin
        this.createTime = other.createTime
        this.varbin = other.varbin
        this.date = other.date
        this.datetime = other.datetime
        this.timestamp = other.timestamp
        this.year = other.year
        this.time = other.time
    }

    override fun get(name: String): Any? = when(name) {
        DEMO.ID.name -> this.id
        DEMO.INT.name -> this.int
        DEMO.UINT.name -> this.uint
        DEMO.TINY.name -> this.tiny
        DEMO.UTINY.name -> this.utiny
        DEMO.TINY1.name -> this.tiny1
        DEMO.UTINY1.name -> this.utiny1
        DEMO.SMALL.name -> this.small
        DEMO.USMALL.name -> this.usmall
        DEMO.MINT.name -> this.mint
        DEMO.UMINT.name -> this.umint
        DEMO.UBIG.name -> this.ubig
        DEMO.FLOAT.name -> this.float
        DEMO.UFLOAT.name -> this.ufloat
        DEMO.DOUBLE.name -> this.double
        DEMO.UDOUBLE.name -> this.udouble
        DEMO.NUMERIC.name -> this.numeric
        DEMO.UNUMERIC.name -> this.unumeric
        DEMO.BIT1.name -> this.bit1
        DEMO.BIT32.name -> this.bit32
        DEMO.BIT16.name -> this.bit16
        DEMO.BIT8.name -> this.bit8
        DEMO.BIT64.name -> this.bit64
        DEMO.BOOL.name -> this.bool
        DEMO.CHAR.name -> this.char
        DEMO.VARCHAR.name -> this.varchar
        DEMO.TINY_TEXT.name -> this.tinyText
        DEMO.TEXT.name -> this.text
        DEMO.LONG_TEXT.name -> this.longText
        DEMO.TINY_BLOB.name -> this.tinyBlob
        DEMO.BLOB.name -> this.blob
        DEMO.MBLOB.name -> this.mblob
        DEMO.LBLOB.name -> this.lblob
        DEMO.BIN.name -> this.bin
        DEMO.CREATE_TIME.name -> this.createTime
        DEMO.VARBIN.name -> this.varbin
        DEMO.DATE.name -> this.date
        DEMO.DATETIME.name -> this.datetime
        DEMO.TIMESTAMP.name -> this.timestamp
        DEMO.YEAR.name -> this.year
        DEMO.TIME.name -> this.time
        else -> null
    }

    override fun set(name: String, value: Any?) {
        when (name) {
            DEMO.ID.name -> this.id = value as Long
            DEMO.INT.name -> this.int = value as Int
            DEMO.UINT.name -> this.uint = value as Long
            DEMO.TINY.name -> this.tiny = value as DemoType
            DEMO.UTINY.name -> this.utiny = value as Int
            DEMO.TINY1.name -> this.tiny1 = value as Boolean
            DEMO.UTINY1.name -> this.utiny1 = value as Boolean
            DEMO.SMALL.name -> this.small = value as Int
            DEMO.USMALL.name -> this.usmall = value as Int
            DEMO.MINT.name -> this.mint = value as Int
            DEMO.UMINT.name -> this.umint = value as Int
            DEMO.UBIG.name -> this.ubig = value as BigDecimal
            DEMO.FLOAT.name -> this.float = value as Float
            DEMO.UFLOAT.name -> this.ufloat = value as Float
            DEMO.DOUBLE.name -> this.double = value as Double
            DEMO.UDOUBLE.name -> this.udouble = value as Double
            DEMO.NUMERIC.name -> this.numeric = value as BigDecimal
            DEMO.UNUMERIC.name -> this.unumeric = value as BigDecimal
            DEMO.BIT1.name -> this.bit1 = value as Boolean
            DEMO.BIT32.name -> this.bit32 = value as Long
            DEMO.BIT16.name -> this.bit16 = value as Long
            DEMO.BIT8.name -> this.bit8 = value as Long
            DEMO.BIT64.name -> this.bit64 = value as Long
            DEMO.BOOL.name -> this.bool = value as Boolean
            DEMO.CHAR.name -> this.char = value as String
            DEMO.VARCHAR.name -> this.varchar = value as String
            DEMO.TINY_TEXT.name -> this.tinyText = value as String
            DEMO.TEXT.name -> this.text = value as String
            DEMO.LONG_TEXT.name -> this.longText = value as String
            DEMO.TINY_BLOB.name -> this.tinyBlob = value as Buffer
            DEMO.BLOB.name -> this.blob = value as Buffer
            DEMO.MBLOB.name -> this.mblob = value as Buffer
            DEMO.LBLOB.name -> this.lblob = value as Buffer
            DEMO.BIN.name -> this.bin = value as Buffer
            DEMO.CREATE_TIME.name -> this.createTime = value as Long
            DEMO.VARBIN.name -> this.varbin = value as Buffer
            DEMO.DATE.name -> this.date = value as LocalDate
            DEMO.DATETIME.name -> this.datetime = value as LocalDateTime
            DEMO.TIMESTAMP.name -> this.timestamp = value as LocalDateTime
            DEMO.YEAR.name -> this.year = value as Int
            DEMO.TIME.name -> this.time = value as Duration
        }
    }

    override fun toString(): String = buildString {
        append("DemoBase (")
        append("id = $id, int = $int, uint = $uint, tiny = $tiny, utiny = $utiny, tiny1 = $tiny1, utiny1 = $utiny1, small = $small, usmall = $usmall, mint = $mint, umint = $umint, ubig = $ubig, float = $float, ufloat = $ufloat, double = $double, udouble = $udouble, numeric = $numeric, unumeric = $unumeric, bit1 = $bit1, bit32 = $bit32, bit16 = $bit16, bit8 = $bit8, bit64 = $bit64, bool = $bool, char = $char, varchar = $varchar, tinyText = $tinyText, text = $text, longText = $longText, tinyBlob = $tinyBlob, blob = $blob, mblob = $mblob, lblob = $lblob, bin = $bin, createTime = $createTime, varbin = $varbin, date = $date, datetime = $datetime, timestamp = $timestamp, year = $year, time = $time")
        append(")")
    }

}


open class DemoInnerTable(alias: String = ""): InnerTable<Long, Demo>("t_demo", alias) {

    override fun AS(alias: String) = DemoInnerTable(alias)
}
private object INNER_DEMO: DemoInnerTable()

open class DemoTable protected constructor(override val inner: InnerTable<Long, Demo>): Table<Long, Demo> {
    val ID = inner.createPrimaryKey("f_id", LongType(), true)
    val INT = inner.createColumn("f_int", IntNullType(), true, 0, false)
    val UINT = inner.createColumn("f_uint", LongType(), false, 0L, false)
    val TINY = inner.createColumn("f_tiny", DemoTinyEnumType(), false, DemoType.TYPE1)
    val UTINY = inner.createColumn("f_utiny", IntNullType(), true, 0, false)
    val TINY1 = inner.createColumn("f_tiny1", BooleanNullType(), true, false, false)
    val UTINY1 = inner.createColumn("f_utiny1", BooleanType(), false, false, false)
    val SMALL = inner.createColumn("f_small", IntNullType(), true, 0, false)
    val USMALL = inner.createColumn("f_usmall", IntNullType(), true, 0, false)
    val MINT = inner.createColumn("f_mint", IntNullType(), true, 0, false)
    val UMINT = inner.createColumn("f_umint", IntNullType(), true, 0, false)
    val UBIG = inner.createColumn("f_ubig", DecimalNullType(), true, BigDecimal.ZERO, false)
    val FLOAT = inner.createColumn("f_float", FloatNullType(), true, 0.0f, false)
    val UFLOAT = inner.createColumn("f_ufloat", FloatNullType(), true, 0.0f, false)
    val DOUBLE = inner.createColumn("f_double", DoubleNullType(), true, 0.0, false)
    val UDOUBLE = inner.createColumn("f_udouble", DoubleNullType(), true, 0.0, false)
    val NUMERIC = inner.createColumn("f_numeric", DecimalNullType(), true, BigDecimal.ZERO, false)
    val UNUMERIC = inner.createColumn("f_unumeric", DecimalNullType(), true, BigDecimal.ZERO, false)
    val BIT1 = inner.createColumn("f_bit1", BooleanNullType(), true, false, false)
    val BIT32 = inner.createColumn("f_bit32", LongNullType(), true, 0L, false)
    val BIT16 = inner.createColumn("f_bit16", LongNullType(), true, 0L, false)
    val BIT8 = inner.createColumn("f_bit8", LongNullType(), true, 0L, false)
    val BIT64 = inner.createColumn("f_bit64", LongNullType(), true, 0L, false)
    val BOOL = inner.createColumn("f_bool", BooleanNullType(), true, false, false)
    val CHAR = inner.createColumn("f_char", StringNullType(), true, "", false)
    val VARCHAR = inner.createColumn("f_varchar", StringNullType(), true, "", false)
    val TINY_TEXT = inner.createColumn("f_tiny_text", StringNullType(), true, "", false)
    val TEXT = inner.createColumn("f_text", StringNullType(), true, "", false)
    val LONG_TEXT = inner.createColumn("f_long_text", StringNullType(), true, "", false)
    val TINY_BLOB = inner.createColumn("f_tiny_blob", BufferNullType(), true, Buffer.buffer(), false)
    val BLOB = inner.createColumn("f_blob", BufferNullType(), true, Buffer.buffer(), false)
    val MBLOB = inner.createColumn("f_mblob", BufferNullType(), true, Buffer.buffer(), false)
    val LBLOB = inner.createColumn("f_lblob", BufferNullType(), true, Buffer.buffer(), false)
    val BIN = inner.createColumn("f_bin", BufferNullType(), true, Buffer.buffer(), false)
    val CREATE_TIME = inner.createColumn("f_create_time", LongNullType(), true, 0L, false)
    val VARBIN = inner.createColumn("f_varbin", BufferNullType(), true, Buffer.buffer(), false)
    val DATE = inner.createColumn("f_date", DateNullType(), true, EPOCH_DATE, false)
    val DATETIME = inner.createColumn("f_datetime", DateTimeNullType(), true, EPOCH_TIME, false)
    val TIMESTAMP = inner.createColumn("f_timestamp", DateTimeNullType(), true, EPOCH_TIME, false)
    val YEAR = inner.createColumn("f_year", IntNullType(), true, 0, false)
    val TIME = inner.createColumn("f_time", DurationNullType(), true, Duration.ofSeconds(0), false)

    val columns get() = Columns(ID, INT, UINT, TINY, UTINY, TINY1, UTINY1, SMALL, USMALL, MINT, UMINT, UBIG, FLOAT, UFLOAT, DOUBLE, UDOUBLE, NUMERIC, UNUMERIC, BIT1, BIT32, BIT16, BIT8, BIT64, BOOL, CHAR, VARCHAR, TINY_TEXT, TEXT, LONG_TEXT, TINY_BLOB, BLOB, MBLOB, LBLOB, BIN, CREATE_TIME, VARBIN, DATE, DATETIME, TIMESTAMP, YEAR, TIME)

    override fun AS(alias: String) = DemoTable(inner.AS(alias))
    override fun primaryKey() = ID
    override fun createEntity(): Demo = Demo()}

object DEMO: DemoTable(INNER_DEMO)
