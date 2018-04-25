package com.github.jacokoo.kosql.generator

import com.github.jacokoo.kosql.IntEnumType
import java.io.Writer

class ColorEnumType: IntEnumType<Color>() {
    override val clazz: Class<Color> = Color::class.java
    override val nullValue: Color = Color.RED
}

open class EnumWriter {
    open fun write(writer: Writer, enum: UseEnum<*>, naming: NamingStrategy) {
        val name = enum.enumType.simpleName!!
        writer.write("""
            |
            |class ${naming.tableClassName(enum.tableName)}${naming.entityFieldName(enum.columnName).capitalize()}EnumType
            |    : ${if (enum.dbType == Int::class) "IntEnumType" else "StringEnumType"}<${name}> {
            |    override val clazz: Class<$name> = $name::class.java
            |    override val nullValue: $name = $name.${enum.defaultValue.toString()}
            |}
            |
        """.trimMargin())
    }
}