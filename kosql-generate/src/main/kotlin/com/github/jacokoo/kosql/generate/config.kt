package com.github.jacokoo.kosql.generate

import com.github.jacokoo.kosql.compose.Item
import com.github.jacokoo.kosql.compose.UseEnum
import com.github.jacokoo.kosql.generate.writer.*
import org.springframework.core.io.support.PathMatchingResourcePatternResolver
import org.springframework.core.io.support.ResourcePatternResolver
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory
import org.springframework.util.ClassUtils
import java.io.File

private fun loadUseEnum(pkg: String, basePkg: String): Map<String, UseEnum>
    = SimpleMetadataReaderFactory().let { mrf ->
        PathMatchingResourcePatternResolver().getResources(ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX +
                ClassUtils.convertClassNameToResourcePath(pkg) + "/*.class")
            .map {mrf.getMetadataReader(it) }
            .filter { it.classMetadata.superClassName?.startsWith(basePkg) == true }
            .filter { it.annotationMetadata.hasAnnotation(UseEnum::class.java.name) }
            .map { KoSQLGenerator::class.java.classLoader.loadClass(it.classMetadata.className) }
            .map { it.simpleName to it.getAnnotation(UseEnum::class.java) }.toMap()
    }

data class KoSQLGeneratorConfig(
    val outputDirectory: String,
    val outputPackage: String,
    val namingStrategy: NamingStrategy = DefaultNamingStrategy(),
    val tableGenerator: TableGenerator = DefaultTableGenerator(),
    val entityWriterFactory: ClassWriterFactory = EntityWriterFactory(),
    val entitySubWriterFactory: EntitySubWriterFactory = EntitySubWriterFactory(),
    val tableWriterFactory: TableWriterFactory = TableWriterFactory(),
    val innerTableWriterFactory: InnerTableWriterFactory = InnerTableWriterFactory()
) {
    val useEnums = loadUseEnum(entityPackage(), basePackage())

    fun basePackage() = "$outputPackage.kosql"
    fun entityPackage() = "$outputPackage.entity"

    fun baseDir() = File(outputDirectory, ClassUtils.convertClassNameToResourcePath(basePackage()))
    fun entityDir() = File(outputDirectory, ClassUtils.convertClassNameToResourcePath(entityPackage()))

    fun typeName(it: Item<*>, entityName: String) =
        "$entityName${namingStrategy.entityFieldName(it.column).capitalize()}EnumType"

    fun defaultValueString(it: Item<*>) =
        "${it.enum.simpleName}.${it.enum.java.enumConstants[it.defaultIndex]}"
}