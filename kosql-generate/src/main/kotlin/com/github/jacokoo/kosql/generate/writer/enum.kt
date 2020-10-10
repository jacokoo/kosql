package com.github.jacokoo.kosql.generate.writer

import com.github.jacokoo.kosql.compose.EnumType
import com.github.jacokoo.kosql.generate.KoSQLGeneratorConfig
import java.io.Writer

open class EnumWriter {
    open fun write(writer: Writer, config: KoSQLGeneratorConfig) {
        config.useEnums.forEach { name, use ->
            use.value.forEach {
                writer.write("\nimport ${it.enum.java.name}")
            }
        }
        writer.write("""
            |
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
        config.useEnums.forEach { name, use ->
            use.value.forEach {
                writer.write("""
                    |
                    |class ${config.typeName(it, name)}: ${if (it.type == EnumType.INT) "IntEnumType" else "StringEnumType"}<${it.enum.simpleName}>() {
                    |    override val clazz: Class<${it.enum.simpleName}> = ${it.enum.simpleName}::class.java
                    |    override val nullValue: ${it.enum.simpleName} = ${config.defaultValueString(it)}
                    |}
                    |
                """.trimMargin())
            }
        }
    }
}