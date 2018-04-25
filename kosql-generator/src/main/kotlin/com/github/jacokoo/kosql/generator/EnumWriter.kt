package com.github.jacokoo.kosql.generator

import java.io.Writer

open class EnumWriter {
    open fun write(writer: Writer, enum: UseEnum<*>, naming: NamingStrategy) {
        val name = enum.enumType.simpleName!!
        writer.write("""
            |
            |class ${naming.tableClassName(enum.tableName)}${naming.entityFieldName(enum.columnName).capitalize()}EnumType: ${if (enum.dbType == Int::class) "IntEnumType" else "StringEnumType"}<${name}>() {
            |    override val clazz: Class<$name> = $name::class.java
            |    override val nullValue: $name = $name.${enum.defaultValue.toString()}
            |}
            |
        """.trimMargin())
    }
}