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
    constructor(s: SelectStatement<Column1<T1>>, ko: Query): this(s.data.columns, ko.execute(s, SelectResultMapper1(s.data.columns)))
}
class SelectResultMapper2<T1, T2>(private val c: Column2<T1, T2>): ResultSetMapper<Value2<T1, T2>> {
    override fun map(rs: ResultSetRow) = Value2(rs[0, c.c1], rs[1, c.c2])
}
data class SelectResult2<T1, T2>(private val c: Column2<T1, T2>, override val values: List<Value2<T1, T2>>): SelectResult<Value2<T1, T2>> {
    override val columns = c
    constructor(s: SelectStatement<Column2<T1, T2>>, ko: Query): this(s.data.columns, ko.execute(s, SelectResultMapper2(s.data.columns)))
}
class SelectResultMapper3<T1, T2, T3>(private val c: Column3<T1, T2, T3>): ResultSetMapper<Value3<T1, T2, T3>> {
    override fun map(rs: ResultSetRow) = Value3(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3])
}
data class SelectResult3<T1, T2, T3>(private val c: Column3<T1, T2, T3>, override val values: List<Value3<T1, T2, T3>>): SelectResult<Value3<T1, T2, T3>> {
    override val columns = c
    constructor(s: SelectStatement<Column3<T1, T2, T3>>, ko: Query): this(s.data.columns, ko.execute(s, SelectResultMapper3(s.data.columns)))
}
class SelectResultMapper4<T1, T2, T3, T4>(private val c: Column4<T1, T2, T3, T4>): ResultSetMapper<Value4<T1, T2, T3, T4>> {
    override fun map(rs: ResultSetRow) = Value4(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4])
}
data class SelectResult4<T1, T2, T3, T4>(private val c: Column4<T1, T2, T3, T4>, override val values: List<Value4<T1, T2, T3, T4>>): SelectResult<Value4<T1, T2, T3, T4>> {
    override val columns = c
    constructor(s: SelectStatement<Column4<T1, T2, T3, T4>>, ko: Query): this(s.data.columns, ko.execute(s, SelectResultMapper4(s.data.columns)))
}
class SelectResultMapper5<T1, T2, T3, T4, T5>(private val c: Column5<T1, T2, T3, T4, T5>): ResultSetMapper<Value5<T1, T2, T3, T4, T5>> {
    override fun map(rs: ResultSetRow) = Value5(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5])
}
data class SelectResult5<T1, T2, T3, T4, T5>(private val c: Column5<T1, T2, T3, T4, T5>, override val values: List<Value5<T1, T2, T3, T4, T5>>): SelectResult<Value5<T1, T2, T3, T4, T5>> {
    override val columns = c
    constructor(s: SelectStatement<Column5<T1, T2, T3, T4, T5>>, ko: Query): this(s.data.columns, ko.execute(s, SelectResultMapper5(s.data.columns)))
}
class SelectResultMapper6<T1, T2, T3, T4, T5, T6>(private val c: Column6<T1, T2, T3, T4, T5, T6>): ResultSetMapper<Value6<T1, T2, T3, T4, T5, T6>> {
    override fun map(rs: ResultSetRow) = Value6(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6])
}
data class SelectResult6<T1, T2, T3, T4, T5, T6>(private val c: Column6<T1, T2, T3, T4, T5, T6>, override val values: List<Value6<T1, T2, T3, T4, T5, T6>>): SelectResult<Value6<T1, T2, T3, T4, T5, T6>> {
    override val columns = c
    constructor(s: SelectStatement<Column6<T1, T2, T3, T4, T5, T6>>, ko: Query): this(s.data.columns, ko.execute(s, SelectResultMapper6(s.data.columns)))
}
class SelectResultMapper7<T1, T2, T3, T4, T5, T6, T7>(private val c: Column7<T1, T2, T3, T4, T5, T6, T7>): ResultSetMapper<Value7<T1, T2, T3, T4, T5, T6, T7>> {
    override fun map(rs: ResultSetRow) = Value7(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6], rs[6, c.c7])
}
data class SelectResult7<T1, T2, T3, T4, T5, T6, T7>(private val c: Column7<T1, T2, T3, T4, T5, T6, T7>, override val values: List<Value7<T1, T2, T3, T4, T5, T6, T7>>): SelectResult<Value7<T1, T2, T3, T4, T5, T6, T7>> {
    override val columns = c
    constructor(s: SelectStatement<Column7<T1, T2, T3, T4, T5, T6, T7>>, ko: Query): this(s.data.columns, ko.execute(s, SelectResultMapper7(s.data.columns)))
}
class SelectResultMapper8<T1, T2, T3, T4, T5, T6, T7, T8>(private val c: Column8<T1, T2, T3, T4, T5, T6, T7, T8>): ResultSetMapper<Value8<T1, T2, T3, T4, T5, T6, T7, T8>> {
    override fun map(rs: ResultSetRow) = Value8(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6], rs[6, c.c7], rs[7, c.c8])
}
data class SelectResult8<T1, T2, T3, T4, T5, T6, T7, T8>(private val c: Column8<T1, T2, T3, T4, T5, T6, T7, T8>, override val values: List<Value8<T1, T2, T3, T4, T5, T6, T7, T8>>): SelectResult<Value8<T1, T2, T3, T4, T5, T6, T7, T8>> {
    override val columns = c
    constructor(s: SelectStatement<Column8<T1, T2, T3, T4, T5, T6, T7, T8>>, ko: Query): this(s.data.columns, ko.execute(s, SelectResultMapper8(s.data.columns)))
}
class SelectResultMapper9<T1, T2, T3, T4, T5, T6, T7, T8, T9>(private val c: Column9<T1, T2, T3, T4, T5, T6, T7, T8, T9>): ResultSetMapper<Value9<T1, T2, T3, T4, T5, T6, T7, T8, T9>> {
    override fun map(rs: ResultSetRow) = Value9(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6], rs[6, c.c7], rs[7, c.c8], rs[8, c.c9])
}
data class SelectResult9<T1, T2, T3, T4, T5, T6, T7, T8, T9>(private val c: Column9<T1, T2, T3, T4, T5, T6, T7, T8, T9>, override val values: List<Value9<T1, T2, T3, T4, T5, T6, T7, T8, T9>>): SelectResult<Value9<T1, T2, T3, T4, T5, T6, T7, T8, T9>> {
    override val columns = c
    constructor(s: SelectStatement<Column9<T1, T2, T3, T4, T5, T6, T7, T8, T9>>, ko: Query): this(s.data.columns, ko.execute(s, SelectResultMapper9(s.data.columns)))
}
class SelectResultMapper10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>(private val c: Column10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>): ResultSetMapper<Value10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>> {
    override fun map(rs: ResultSetRow) = Value10(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6], rs[6, c.c7], rs[7, c.c8], rs[8, c.c9], rs[9, c.c10])
}
data class SelectResult10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>(private val c: Column10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>, override val values: List<Value10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>>): SelectResult<Value10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>> {
    override val columns = c
    constructor(s: SelectStatement<Column10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>>, ko: Query): this(s.data.columns, ko.execute(s, SelectResultMapper10(s.data.columns)))
}

interface Queries: Query {
    fun <T1> SelectStatement<Column1<T1>>.fetchValue(): T1 = fetch()[0].v1

    fun <T1> SelectStatement<Column1<T1>>.fetch() = SelectResult1(this, this@Queries)
    fun <T1, T2> SelectStatement<Column2<T1, T2>>.fetch() = SelectResult2(this, this@Queries)
    fun <T1, T2, T3> SelectStatement<Column3<T1, T2, T3>>.fetch() = SelectResult3(this, this@Queries)
    fun <T1, T2, T3, T4> SelectStatement<Column4<T1, T2, T3, T4>>.fetch() = SelectResult4(this, this@Queries)
    fun <T1, T2, T3, T4, T5> SelectStatement<Column5<T1, T2, T3, T4, T5>>.fetch() = SelectResult5(this, this@Queries)
    fun <T1, T2, T3, T4, T5, T6> SelectStatement<Column6<T1, T2, T3, T4, T5, T6>>.fetch() = SelectResult6(this, this@Queries)
    fun <T1, T2, T3, T4, T5, T6, T7> SelectStatement<Column7<T1, T2, T3, T4, T5, T6, T7>>.fetch() = SelectResult7(this, this@Queries)
    fun <T1, T2, T3, T4, T5, T6, T7, T8> SelectStatement<Column8<T1, T2, T3, T4, T5, T6, T7, T8>>.fetch() = SelectResult8(this, this@Queries)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9> SelectStatement<Column9<T1, T2, T3, T4, T5, T6, T7, T8, T9>>.fetch() = SelectResult9(this, this@Queries)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> SelectStatement<Column10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>>.fetch() = SelectResult10(this, this@Queries)
}
