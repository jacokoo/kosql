package com.github.jacokoo.kosql.gradle

import com.github.jacokoo.kosql.compose.EnumType
import com.github.jacokoo.kosql.generate.*
import org.gradle.api.Plugin
import org.gradle.api.Project

enum class KoSQLFileNameStrategy { Uppercase, Lowercase }

class EnumOperator internal constructor() {
    internal val enumDefinitions = mutableMapOf<String, EnumDef>()
    internal val useEnums = mutableMapOf<String, UseEnum>()

    inline fun <reified T: Enum<T>> set(table: String, column: String, default: Int = 0, type: EnumType = EnumType.INT) {
        addEnumDefine(table, column, T::class.java, default, type)
    }

    fun <T: Enum<T>> addEnumDefine(table: String, column: String, use: Class<T>, default: Int, type: EnumType) {
        val values = use.enumConstants.map { it.name }
        val name = use.simpleName
        enumDefinitions[name] = EnumDef(name, values)
        useEnums["$table-$column"] = UseEnum(table, column, name, values[default], type)
    }
}

abstract class KoSQLOptions {
    abstract var outputPackage: String
    abstract var outputDirectory: String
    abstract var driverClassName: String
    abstract var connectionUri: String
    var strategy = KoSQLFileNameStrategy.Lowercase
    internal val enum = EnumOperator()

    fun enum(fn: EnumOperator.() -> Unit) = enum.fn()
}

class KoSQLPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        val options = target.extensions.create("kosql", KoSQLOptions::class.java)
        target.task("kosql-generate") {
            doLast {
                doGenerate(options)
            }
        }
    }

    private fun doGenerate(options: KoSQLOptions) {
        val s = when(options.strategy) {
            KoSQLFileNameStrategy.Uppercase -> DefaultNamingStrategy()
            else -> LowercaseFileNameStrategy()
        }

        println(options.enum.enumDefinitions)
        println(options.enum.useEnums)

        KoSQLGenerator(KoSQLGeneratorConfig(
            driverClass = options.driverClassName,
            connectionUri = options.connectionUri,
            outputPackage = options.outputPackage,
            outputDirectory = options.outputDirectory,
            namingStrategy = s,
            enums = options.enum.enumDefinitions,
            useEnums = options.enum.useEnums
        )).doGenerate()
    }
}
