package com.github.jacokoo.kosql.generator

import java.io.Writer

interface ClassWriter {
    fun doWrite()
}

interface ClassWriterFactory {
    fun create(writer: Writer, config: KoSQLGeneratorConfig, table: TableInfo): ClassWriter
}

abstract class AbstractClassWriter(val writer: Writer): ClassWriter {
    override fun doWrite() {
        writePackage()
        writer.write("\n")
        writeImports()
        writer.write("\n")
        writeSignature()
        writer.write(" {\n")
        writeFields()
        writer.write("\n")
        writeMethods()
        writer.write("}\n")
        writeTail()
    }
    abstract fun writePackage()
    abstract fun writeImports()
    abstract fun writeSignature()
    abstract fun writeFields()
    abstract fun writeMethods()

    open fun writeTail() {}
}
