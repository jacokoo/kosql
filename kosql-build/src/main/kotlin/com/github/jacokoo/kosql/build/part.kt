package com.github.jacokoo.kosql.build

import com.github.jacokoo.kosql.compose.*
import com.github.jacokoo.kosql.compose.expression.*
import com.github.jacokoo.kosql.compose.expression.Function
import com.github.jacokoo.kosql.compose.statement.TableLike
import com.github.jacokoo.kosql.compose.type.DataType

interface Part {
    fun build(part: Any, ctx: Context) {
        when(part) {
            is Table<*, *> -> build(part, ctx)
            is Named<*> -> build(part, ctx)
            is Exp<*> -> build(part, ctx)
            else -> unhandled(part, ctx)
        }
    }

    fun build(part: Named<*>, ctx: Context) {
        when(part) {
            is InnerTable<*, *> -> build(part, ctx)
            is Count<*> -> build(part, ctx)
            is Function<*> -> build(part, ctx)
            is DecimalFunction<*> -> build(part, ctx)
            is Column<*> -> build(part, ctx)
            else -> unhandled(part, ctx)
        }
    }

    fun build(part: Exp<*>, ctx: Context) {
        when(part) {
            is LogicalPartial<*> -> build(part, ctx)
            is SingleColumnExp<*> -> build(part, ctx)
            is ColumnToColumnExp<*> -> build(part, ctx)
            is ColumnToValueExp<*> -> build(part, ctx)
            is ColumnToExpExp<*> -> build(part, ctx)
            is ExpToColumnExp<*> -> build(part, ctx)
            is ComputeExp<*> -> build(part, ctx)
            is BetweenExp<*> -> build(part, ctx)
            is MultiValueExp<*> -> build(part, ctx)
            Exp.TRUE -> ctx.append("1 = 1")
            else -> unhandled(part, ctx)
        }
    }

    fun build(part: Table<*, *>, ctx: Context) {
        when(part) {
            is TableLike<*> -> build(part, ctx)
            else -> build(part.inner, ctx)
        }
    }

    fun build(part: InnerTable<*, *>, ctx: Context) {
        ctx.append(part.name)
        ctx.aliasIt(part)
    }

    fun build(part: TableLike<*>, ctx: Context) {
        ctx.append("(")
        ctx.builder.build(part.data, ctx)
        ctx.append(")")
        ctx.alias(part.inner)
    }

    fun build(part: Column<*>, ctx: Context) {
        ctx.append("${ctx.alias(part.table)}.${part.name}")
        ctx.aliasIt(part)
    }

    fun build(part: Function<*>, ctx: Context) {
        if (part.fn == "DISTINCT") {
            ctx.append("DISTINCT ")
            build(part.column, ctx)
        } else {
            ctx.quote("${part.fn}(") { build(part.column, ctx) }
        }
        ctx.aliasIt(part)
    }

    fun build(part: DecimalFunction<*>, ctx: Context) {
        ctx.quote("${part.fn}(") { build(part.column, ctx) }
        ctx.aliasIt(part)
    }

    fun build(part: Count<*>, ctx: Context) {
        if (part.hasColumn()) {
            ctx.quote("COUNT(") { build(part.column, ctx)}
        } else {
            ctx.append("COUNT(*)")
        }
        ctx.aliasIt(part)
    }

    fun build(part: SingleColumnExp<*>, ctx: Context) {
        build(part.col, ctx)
        ctx.append(" ${part.op}")
    }

    fun build(part: ColumnToColumnExp<*>, ctx: Context) {
        build(part.left, ctx)
        ctx.pad(part.op)
        build(part.right, ctx)
    }

    fun build(part: ColumnToValueExp<*>, ctx: Context) {
        build(part.left, ctx)
        ctx.append(" ${part.op} ?")
        ctx.paramIt(part.value, part.left.type)
    }

    fun build(part: ColumnToExpExp<*>, ctx: Context) {
        build(part.left, ctx)
        ctx.pad(part.op)
        build(part.right, ctx)
    }

    fun build(part: ExpToColumnExp<*>, ctx: Context) {
        build(part.left, ctx)
        ctx.pad(part.op)
        build(part.right, ctx)
    }

    fun build(part: ComputeExp<*>, ctx: Context) {
        build(part.exp, ctx)
    }

    fun build(part: BetweenExp<*>, ctx: Context) {
        build(part.col, ctx)
        ctx.append(" BETWEEN ? AND ?")
        ctx.paramIt(part.small, part.col.type)
        ctx.paramIt(part.big, part.col.type)
    }

    fun build(part: MultiValueExp<*>, ctx: Context) {
        build(part.col, ctx)
        ctx.pad(part.op)
        ctx.append(part.values.joinToString(prefix = "(", postfix = ")") { "?" })
        part.values.forEach { ctx.paramIt(it, part.col.type) }
    }

    fun build(part: LogicalPartial<*>, ctx: Context) {
        part.right?.let {
            if (part.isAnd) {
                build(part.left, ctx)
                ctx.pad("AND")
                build(it, ctx)
            } else {
                ctx.append("(")
                ctx.quote { build(part.left, ctx) }
                ctx.pad("OR")
                ctx.quote { build(it, ctx)}
                ctx.append(")")
            }
        } ?: build(part.left, ctx)
    }

    fun unhandled(part: Any, ctx: Context): Nothing {
        throw RuntimeException("unhandled sql part: $part")
    }

    fun Context.quote(open: String = "(", close: String = ")", fn: () -> Unit) {
        append(open)
        fn()
        append(close)
    }

    fun Context.aliasIt(named: Named<*>) {
        alias(named)?.let { append(" AS $it") }
    }

    fun Context.paramIt(value: Any?, type: DataType<*>) {
        param(type.toDb(value))
    }
}

open class DefaultPart: Part
