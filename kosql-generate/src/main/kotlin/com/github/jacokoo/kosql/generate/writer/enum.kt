package com.github.jacokoo.kosql.generate.writer

import com.github.jacokoo.kosql.compose.EnumType
import com.github.jacokoo.kosql.generate.KoSQLGeneratorConfig
import java.io.Writer

open class EnumWriter {
    open fun write(writer: Writer, config: KoSQLGeneratorConfig) {
        writer.write("""
            |
            |abstract class IntEnumType<T: Enum<*>>: DataType<T> {
            |    abstract val clazz: Class<T>
            |    override fun fromDb(o: Any?): T = o?.let { clazz.enumConstants[when(it) {
            |        is Byte -> it.toInt()
            |        is Short -> it.toInt()
            |        else -> it as Int
            |    }] } ?: nullValue
            |    override fun toDb(t: Any?): Any? = t?.let { clazz.enumConstants.indexOf(it) }
            |}
            |
            |abstract class StringEnumType<T: Enum<*>>: DataType<T> {
            |    abstract val clazz: Class<T>
            |    override fun fromDb(o: Any?): T = o?.let { oo -> clazz.enumConstants.find { it.name == oo } } ?: nullValue
            |    override fun toDb(t: Any?): Any? = t?.let { it.toString() }
            |}
            |
        """.trimMargin())

        writer.write("\n")
        config.enums.values.forEach { e ->
            writer.write("enum class ${e.name} { ${e.values.joinToString()} }\n")
        }

        config.useEnums.values.forEach { e ->
                writer.write("""
                    |
                    |class ${config.typeName(e, config.namingStrategy.entitySubClassName(e.tableName))}: ${if (e.type == EnumType.INT) "IntEnumType" else "StringEnumType"}<${e.ref}>() {
                    |    override val clazz: Class<${e.ref}> = ${e.ref}::class.java
                    |    override val nullValue: ${e.ref} = ${e.ref}.${e.default}
                    |}
                    |
                """.trimMargin())
        }
    }
}
