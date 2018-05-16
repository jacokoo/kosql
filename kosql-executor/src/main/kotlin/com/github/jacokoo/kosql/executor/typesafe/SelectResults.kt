package com.github.jacokoo.kosql.executor.typesafe

import com.github.jacokoo.kosql.compose.statements.SelectStatement
import com.github.jacokoo.kosql.compose.typesafe.*
import com.github.jacokoo.kosql.executor.Query
import com.github.jacokoo.kosql.executor.ResultSetMapper
import com.github.jacokoo.kosql.executor.ResultSetRow
import com.github.jacokoo.kosql.executor.SelectResult

class SelectResultMapper1<T1>(private val c: Column1<T1>): ResultSetMapper<Value1<T1>> {
    override fun map(rs: ResultSetRow) = Value1(rs[0, c.c1])
}
data class SelectResult1<T1>(private val c: Column1<T1>, override val values: List<Value1<T1>>): SelectResult<Value1<T1>> {
    override val columns = c
    constructor(c: Column1<T1>, qp: SelectStatement, ko: Query): this(c, ko.execute(qp, SelectResultMapper1(c)))
}

class SelectResultMapper2<T1, T2>(private val c: Column2<T1, T2>): ResultSetMapper<Value2<T1, T2>> {
    override fun map(rs: ResultSetRow) = Value2(rs[0, c.c1], rs[1, c.c2])
}
data class SelectResult2<T1, T2>(private val c: Column2<T1, T2>, override val values: List<Value2<T1, T2>>): SelectResult<Value2<T1, T2>> {
    override val columns = c
    constructor(c: Column2<T1, T2>, qp: SelectStatement, ko: Query): this(c, ko.execute(qp, SelectResultMapper2(c)))
}

interface Queries: Query {
    fun <T1> SelectStatement1<T1>.fetch(): SelectResult1<T1> = SelectResult1(c, this, this@Queries)
    fun <T1, T2> SelectStatement2<T1, T2>.fetch(): SelectResult2<T1, T2> = SelectResult2(c, this, this@Queries)
}
