package com.github.jacokoo.kosql.example.kosql.table

import com.github.jacokoo.kosql.IntType
import com.github.jacokoo.kosql.Table
import com.github.jacokoo.kosql.mapping.Database
import com.github.jacokoo.kosql.statements.Column2

open class AbcTable protected constructor(alias: String = ""): Table<Int>("t_abc", alias, "") {
    val ID = createColumn("f_id", IntType(), false, 0)
    val A = createColumn("f_a", IntType(), true, null)

    override fun AS(alias: String) = AbcTable(alias)
    override fun primaryKey() = ID
    operator fun invoke() = Column2(ID, A)
}

object ABC: AbcTable()
