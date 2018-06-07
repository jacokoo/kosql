package com.github.jacokoo.kosql.compose

import com.github.jacokoo.kosql.compose.statements.SelectData
import com.github.jacokoo.kosql.compose.typesafe.Column1
import com.github.jacokoo.kosql.compose.typesafe.ColumnList
import kotlin.reflect.KClass

enum class Order { ASC, DESC }

enum class JoinType {
    INNER, LEFT, RIGHT, FULL
}

interface SQLPart {
    fun toSQL(ctx: SQLBuilderContext): String
}

interface Statement

interface Nameable<out T>: SQLPart {
    val name: String
    val alias: String
    val aliasRequired: Boolean
    fun AS(alias: String): T

    fun sqlName(ctx: SQLBuilderContext): String = name
    override fun toSQL(ctx: SQLBuilderContext): String =
        ctx.alias(this)?.let { "${sqlName(ctx)} AS $it" } ?: sqlName(ctx)

}

interface Column<T>: Nameable<Column<T>> {
    val table: Table<*, Entity<*>>
    val type: DataType<T>
    val allowNull: Boolean
    val defaultValue: T
    val autoIncrement: Boolean

    fun ASC(): Pair<Column<T>, Order> = this to Order.ASC
    fun DESC(): Pair<Column<T>, Order> = this to Order.DESC

    operator fun unaryPlus(): Column1<T> = Column1(this)
}

data class DefaultColumn<T>(
    override val table: Table<*, Entity<*>>,
    override val name: String,
    override val type: DataType<T>,
    override val alias: String = "",
    override val aliasRequired: Boolean = false,
    override val allowNull: Boolean = false,
    override val defaultValue: T = type.nullValue,
    override val autoIncrement: Boolean = false
): Column<T> {
    override fun AS(alias: String): Column<T> = this.copy(alias = alias)
    override fun sqlName(ctx: SQLBuilderContext): String = "${ctx.alias(table)}.$name"

    fun nullable(): DefaultColumn<T> = this.copy(allowNull = true)
    fun default(t: T): DefaultColumn<T> = this.copy(defaultValue = t)
    fun autoIncrement(auto: Boolean = true): DefaultColumn<T> = this.copy(autoIncrement = auto)
}

abstract class Table<T, out R: Entity<T>>(override val name: String, override val alias: String = "", comment: String = ""): Nameable<Table<T, R>> {
    override val aliasRequired = true
    var columns: List<Column<*>> = listOf()
        protected set

    protected fun register(col: Column<*>) { columns += col }
    protected fun <T> createColumn(name: String, type: DataType<T>, allowNull: Boolean = false, defaultValue: T? = null) =
        DefaultColumn(this, name, type,
            allowNull = allowNull,
            defaultValue = if (defaultValue == null) type.nullValue else defaultValue
        ).also { register(it) }

    fun int(name: String) = createColumn(name, IntType())
    fun float(name: String) = createColumn(name, FloatType())
    fun decimal(name: String) = createColumn(name, DecimalType())
    fun string(name: String) = createColumn(name, StringType())

    abstract fun primaryKey(): Column<T>
}

open class EmptyTable(alias: String = ""): Table<Any, Entity<Any>>(alias) {
    override fun AS(alias: String): EmptyTable {
        throw RuntimeException("never call this method")
    }
    override fun primaryKey(): Column<Any> {
        throw RuntimeException("never call this method")
    }
}

class TableLike<T: ColumnList>(private val data: SelectData<T>, alias: String, private val original: List<Column<*>>): EmptyTable(alias) {
    private val map = original.associate { it to DefaultColumn(this, if (it.alias == "") it.name else it.alias, it.type) }
    init {
        this.columns = map.values.toList()
    }

    override fun sqlName(ctx: SQLBuilderContext): String = "(${ctx.builder.build(data, ctx).sql})"

    @Suppress("UNCHECKED_CAST")
    operator fun <T> get(col: Column<T>): Column<T> {
        val c = original.find { it.table == col.table && it.name == col.name }
            ?: throw RuntimeException("Can not find column $col.name in table-like $alias")
        return map[c] as Column<T>
    }

    @Suppress("UNCHECKED_CAST")
    inline operator fun <reified T> get(name: String): Column<T> {
        return columns.find { it.name == name }!! as Column<T>
    }
}

interface Entity<T> {
    operator fun set(name: String, value: Any?)
    operator fun get(name: String): Any?
}

class EmptyEntity: Entity<Any> {
    override fun get(name: String): Any? = null
    override fun set(name: String, value: Any?) {}
}

interface Database {

    @Suppress("UNCHECKED_CAST")
    companion object {
        private var entityToTable: MutableMap<in KClass<out Entity<*>>, Table<out Any, Entity<out Any>>> = mutableMapOf()
        private var tableToEntity: MutableMap<in Table<out Any, Entity<out Any>>, KClass<out Entity<out Any>>> = mutableMapOf()

        fun <T: Any> register(table: Table<out T, Entity<T>>, entity: KClass<out Entity<T>>) {
            tableToEntity[table] = entity
            entityToTable[entity] = table
        }

        operator fun <T> get(table: Table<out T, Entity<T>>): KClass<out Entity<T>>? = tableToEntity[table]?.let { it as KClass<out Entity<T>> }
        operator fun <T> get(entity: KClass<out Entity<T>>): Table<T, Entity<T>>? = entityToTable[entity] as Table<T, Entity<T>>
    }
}
