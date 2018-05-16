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
class SelectResultMapper3<T1, T2, T3>(private val c: Column3<T1, T2, T3>): ResultSetMapper<Value3<T1, T2, T3>> {
    override fun map(rs: ResultSetRow) = Value3(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3])
}
data class SelectResult3<T1, T2, T3>(private val c: Column3<T1, T2, T3>, override val values: List<Value3<T1, T2, T3>>): SelectResult<Value3<T1, T2, T3>> {
    override val columns = c
    constructor(c: Column3<T1, T2, T3>, qp: SelectStatement, ko: Query): this(c, ko.execute(qp, SelectResultMapper3(c)))
}
class SelectResultMapper4<T1, T2, T3, T4>(private val c: Column4<T1, T2, T3, T4>): ResultSetMapper<Value4<T1, T2, T3, T4>> {
    override fun map(rs: ResultSetRow) = Value4(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4])
}
data class SelectResult4<T1, T2, T3, T4>(private val c: Column4<T1, T2, T3, T4>, override val values: List<Value4<T1, T2, T3, T4>>): SelectResult<Value4<T1, T2, T3, T4>> {
    override val columns = c
    constructor(c: Column4<T1, T2, T3, T4>, qp: SelectStatement, ko: Query): this(c, ko.execute(qp, SelectResultMapper4(c)))
}
class SelectResultMapper5<T1, T2, T3, T4, T5>(private val c: Column5<T1, T2, T3, T4, T5>): ResultSetMapper<Value5<T1, T2, T3, T4, T5>> {
    override fun map(rs: ResultSetRow) = Value5(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5])
}
data class SelectResult5<T1, T2, T3, T4, T5>(private val c: Column5<T1, T2, T3, T4, T5>, override val values: List<Value5<T1, T2, T3, T4, T5>>): SelectResult<Value5<T1, T2, T3, T4, T5>> {
    override val columns = c
    constructor(c: Column5<T1, T2, T3, T4, T5>, qp: SelectStatement, ko: Query): this(c, ko.execute(qp, SelectResultMapper5(c)))
}
class SelectResultMapper6<T1, T2, T3, T4, T5, T6>(private val c: Column6<T1, T2, T3, T4, T5, T6>): ResultSetMapper<Value6<T1, T2, T3, T4, T5, T6>> {
    override fun map(rs: ResultSetRow) = Value6(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6])
}
data class SelectResult6<T1, T2, T3, T4, T5, T6>(private val c: Column6<T1, T2, T3, T4, T5, T6>, override val values: List<Value6<T1, T2, T3, T4, T5, T6>>): SelectResult<Value6<T1, T2, T3, T4, T5, T6>> {
    override val columns = c
    constructor(c: Column6<T1, T2, T3, T4, T5, T6>, qp: SelectStatement, ko: Query): this(c, ko.execute(qp, SelectResultMapper6(c)))
}
class SelectResultMapper7<T1, T2, T3, T4, T5, T6, T7>(private val c: Column7<T1, T2, T3, T4, T5, T6, T7>): ResultSetMapper<Value7<T1, T2, T3, T4, T5, T6, T7>> {
    override fun map(rs: ResultSetRow) = Value7(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6], rs[6, c.c7])
}
data class SelectResult7<T1, T2, T3, T4, T5, T6, T7>(private val c: Column7<T1, T2, T3, T4, T5, T6, T7>, override val values: List<Value7<T1, T2, T3, T4, T5, T6, T7>>): SelectResult<Value7<T1, T2, T3, T4, T5, T6, T7>> {
    override val columns = c
    constructor(c: Column7<T1, T2, T3, T4, T5, T6, T7>, qp: SelectStatement, ko: Query): this(c, ko.execute(qp, SelectResultMapper7(c)))
}
class SelectResultMapper8<T1, T2, T3, T4, T5, T6, T7, T8>(private val c: Column8<T1, T2, T3, T4, T5, T6, T7, T8>): ResultSetMapper<Value8<T1, T2, T3, T4, T5, T6, T7, T8>> {
    override fun map(rs: ResultSetRow) = Value8(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6], rs[6, c.c7], rs[7, c.c8])
}
data class SelectResult8<T1, T2, T3, T4, T5, T6, T7, T8>(private val c: Column8<T1, T2, T3, T4, T5, T6, T7, T8>, override val values: List<Value8<T1, T2, T3, T4, T5, T6, T7, T8>>): SelectResult<Value8<T1, T2, T3, T4, T5, T6, T7, T8>> {
    override val columns = c
    constructor(c: Column8<T1, T2, T3, T4, T5, T6, T7, T8>, qp: SelectStatement, ko: Query): this(c, ko.execute(qp, SelectResultMapper8(c)))
}
class SelectResultMapper9<T1, T2, T3, T4, T5, T6, T7, T8, T9>(private val c: Column9<T1, T2, T3, T4, T5, T6, T7, T8, T9>): ResultSetMapper<Value9<T1, T2, T3, T4, T5, T6, T7, T8, T9>> {
    override fun map(rs: ResultSetRow) = Value9(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6], rs[6, c.c7], rs[7, c.c8], rs[8, c.c9])
}
data class SelectResult9<T1, T2, T3, T4, T5, T6, T7, T8, T9>(private val c: Column9<T1, T2, T3, T4, T5, T6, T7, T8, T9>, override val values: List<Value9<T1, T2, T3, T4, T5, T6, T7, T8, T9>>): SelectResult<Value9<T1, T2, T3, T4, T5, T6, T7, T8, T9>> {
    override val columns = c
    constructor(c: Column9<T1, T2, T3, T4, T5, T6, T7, T8, T9>, qp: SelectStatement, ko: Query): this(c, ko.execute(qp, SelectResultMapper9(c)))
}
class SelectResultMapper10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>(private val c: Column10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>): ResultSetMapper<Value10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>> {
    override fun map(rs: ResultSetRow) = Value10(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6], rs[6, c.c7], rs[7, c.c8], rs[8, c.c9], rs[9, c.c10])
}
data class SelectResult10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>(private val c: Column10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>, override val values: List<Value10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>>): SelectResult<Value10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>> {
    override val columns = c
    constructor(c: Column10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>, qp: SelectStatement, ko: Query): this(c, ko.execute(qp, SelectResultMapper10(c)))
}
class SelectResultMapper11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>(private val c: Column11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>): ResultSetMapper<Value11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>> {
    override fun map(rs: ResultSetRow) = Value11(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6], rs[6, c.c7], rs[7, c.c8], rs[8, c.c9], rs[9, c.c10], rs[10, c.c11])
}
data class SelectResult11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>(private val c: Column11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>, override val values: List<Value11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>>): SelectResult<Value11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>> {
    override val columns = c
    constructor(c: Column11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>, qp: SelectStatement, ko: Query): this(c, ko.execute(qp, SelectResultMapper11(c)))
}
class SelectResultMapper12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>(private val c: Column12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>): ResultSetMapper<Value12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>> {
    override fun map(rs: ResultSetRow) = Value12(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6], rs[6, c.c7], rs[7, c.c8], rs[8, c.c9], rs[9, c.c10], rs[10, c.c11], rs[11, c.c12])
}
data class SelectResult12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>(private val c: Column12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>, override val values: List<Value12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>>): SelectResult<Value12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>> {
    override val columns = c
    constructor(c: Column12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>, qp: SelectStatement, ko: Query): this(c, ko.execute(qp, SelectResultMapper12(c)))
}
class SelectResultMapper13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>(private val c: Column13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>): ResultSetMapper<Value13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>> {
    override fun map(rs: ResultSetRow) = Value13(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6], rs[6, c.c7], rs[7, c.c8], rs[8, c.c9], rs[9, c.c10], rs[10, c.c11], rs[11, c.c12], rs[12, c.c13])
}
data class SelectResult13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>(private val c: Column13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>, override val values: List<Value13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>>): SelectResult<Value13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>> {
    override val columns = c
    constructor(c: Column13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>, qp: SelectStatement, ko: Query): this(c, ko.execute(qp, SelectResultMapper13(c)))
}
class SelectResultMapper14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>(private val c: Column14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>): ResultSetMapper<Value14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>> {
    override fun map(rs: ResultSetRow) = Value14(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6], rs[6, c.c7], rs[7, c.c8], rs[8, c.c9], rs[9, c.c10], rs[10, c.c11], rs[11, c.c12], rs[12, c.c13], rs[13, c.c14])
}
data class SelectResult14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>(private val c: Column14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>, override val values: List<Value14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>>): SelectResult<Value14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>> {
    override val columns = c
    constructor(c: Column14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>, qp: SelectStatement, ko: Query): this(c, ko.execute(qp, SelectResultMapper14(c)))
}
class SelectResultMapper15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>(private val c: Column15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>): ResultSetMapper<Value15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>> {
    override fun map(rs: ResultSetRow) = Value15(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6], rs[6, c.c7], rs[7, c.c8], rs[8, c.c9], rs[9, c.c10], rs[10, c.c11], rs[11, c.c12], rs[12, c.c13], rs[13, c.c14], rs[14, c.c15])
}
data class SelectResult15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>(private val c: Column15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>, override val values: List<Value15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>>): SelectResult<Value15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>> {
    override val columns = c
    constructor(c: Column15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>, qp: SelectStatement, ko: Query): this(c, ko.execute(qp, SelectResultMapper15(c)))
}
class SelectResultMapper16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>(private val c: Column16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>): ResultSetMapper<Value16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>> {
    override fun map(rs: ResultSetRow) = Value16(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6], rs[6, c.c7], rs[7, c.c8], rs[8, c.c9], rs[9, c.c10], rs[10, c.c11], rs[11, c.c12], rs[12, c.c13], rs[13, c.c14], rs[14, c.c15], rs[15, c.c16])
}
data class SelectResult16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>(private val c: Column16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>, override val values: List<Value16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>>): SelectResult<Value16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>> {
    override val columns = c
    constructor(c: Column16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>, qp: SelectStatement, ko: Query): this(c, ko.execute(qp, SelectResultMapper16(c)))
}
class SelectResultMapper17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>(private val c: Column17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>): ResultSetMapper<Value17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>> {
    override fun map(rs: ResultSetRow) = Value17(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6], rs[6, c.c7], rs[7, c.c8], rs[8, c.c9], rs[9, c.c10], rs[10, c.c11], rs[11, c.c12], rs[12, c.c13], rs[13, c.c14], rs[14, c.c15], rs[15, c.c16], rs[16, c.c17])
}
data class SelectResult17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>(private val c: Column17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>, override val values: List<Value17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>>): SelectResult<Value17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>> {
    override val columns = c
    constructor(c: Column17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>, qp: SelectStatement, ko: Query): this(c, ko.execute(qp, SelectResultMapper17(c)))
}
class SelectResultMapper18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>(private val c: Column18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>): ResultSetMapper<Value18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>> {
    override fun map(rs: ResultSetRow) = Value18(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6], rs[6, c.c7], rs[7, c.c8], rs[8, c.c9], rs[9, c.c10], rs[10, c.c11], rs[11, c.c12], rs[12, c.c13], rs[13, c.c14], rs[14, c.c15], rs[15, c.c16], rs[16, c.c17], rs[17, c.c18])
}
data class SelectResult18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>(private val c: Column18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>, override val values: List<Value18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>>): SelectResult<Value18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>> {
    override val columns = c
    constructor(c: Column18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>, qp: SelectStatement, ko: Query): this(c, ko.execute(qp, SelectResultMapper18(c)))
}
class SelectResultMapper19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>(private val c: Column19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>): ResultSetMapper<Value19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>> {
    override fun map(rs: ResultSetRow) = Value19(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6], rs[6, c.c7], rs[7, c.c8], rs[8, c.c9], rs[9, c.c10], rs[10, c.c11], rs[11, c.c12], rs[12, c.c13], rs[13, c.c14], rs[14, c.c15], rs[15, c.c16], rs[16, c.c17], rs[17, c.c18], rs[18, c.c19])
}
data class SelectResult19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>(private val c: Column19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>, override val values: List<Value19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>>): SelectResult<Value19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>> {
    override val columns = c
    constructor(c: Column19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>, qp: SelectStatement, ko: Query): this(c, ko.execute(qp, SelectResultMapper19(c)))
}
class SelectResultMapper20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>(private val c: Column20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>): ResultSetMapper<Value20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>> {
    override fun map(rs: ResultSetRow) = Value20(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6], rs[6, c.c7], rs[7, c.c8], rs[8, c.c9], rs[9, c.c10], rs[10, c.c11], rs[11, c.c12], rs[12, c.c13], rs[13, c.c14], rs[14, c.c15], rs[15, c.c16], rs[16, c.c17], rs[17, c.c18], rs[18, c.c19], rs[19, c.c20])
}
data class SelectResult20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>(private val c: Column20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>, override val values: List<Value20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>>): SelectResult<Value20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>> {
    override val columns = c
    constructor(c: Column20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>, qp: SelectStatement, ko: Query): this(c, ko.execute(qp, SelectResultMapper20(c)))
}
class SelectResultMapper21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>(private val c: Column21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>): ResultSetMapper<Value21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>> {
    override fun map(rs: ResultSetRow) = Value21(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6], rs[6, c.c7], rs[7, c.c8], rs[8, c.c9], rs[9, c.c10], rs[10, c.c11], rs[11, c.c12], rs[12, c.c13], rs[13, c.c14], rs[14, c.c15], rs[15, c.c16], rs[16, c.c17], rs[17, c.c18], rs[18, c.c19], rs[19, c.c20], rs[20, c.c21])
}
data class SelectResult21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>(private val c: Column21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>, override val values: List<Value21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>>): SelectResult<Value21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>> {
    override val columns = c
    constructor(c: Column21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>, qp: SelectStatement, ko: Query): this(c, ko.execute(qp, SelectResultMapper21(c)))
}
class SelectResultMapper22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>(private val c: Column22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>): ResultSetMapper<Value22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>> {
    override fun map(rs: ResultSetRow) = Value22(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6], rs[6, c.c7], rs[7, c.c8], rs[8, c.c9], rs[9, c.c10], rs[10, c.c11], rs[11, c.c12], rs[12, c.c13], rs[13, c.c14], rs[14, c.c15], rs[15, c.c16], rs[16, c.c17], rs[17, c.c18], rs[18, c.c19], rs[19, c.c20], rs[20, c.c21], rs[21, c.c22])
}
data class SelectResult22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>(private val c: Column22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>, override val values: List<Value22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>>): SelectResult<Value22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>> {
    override val columns = c
    constructor(c: Column22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>, qp: SelectStatement, ko: Query): this(c, ko.execute(qp, SelectResultMapper22(c)))
}

interface Queries: Query {
    fun <T1> SelectStatement1<T1>.fetch() = SelectResult1(c, this, this@Queries)
    fun <T1, T2> SelectStatement2<T1, T2>.fetch() = SelectResult2(c, this, this@Queries)
    fun <T1, T2, T3> SelectStatement3<T1, T2, T3>.fetch() = SelectResult3(c, this, this@Queries)
    fun <T1, T2, T3, T4> SelectStatement4<T1, T2, T3, T4>.fetch() = SelectResult4(c, this, this@Queries)
    fun <T1, T2, T3, T4, T5> SelectStatement5<T1, T2, T3, T4, T5>.fetch() = SelectResult5(c, this, this@Queries)
    fun <T1, T2, T3, T4, T5, T6> SelectStatement6<T1, T2, T3, T4, T5, T6>.fetch() = SelectResult6(c, this, this@Queries)
    fun <T1, T2, T3, T4, T5, T6, T7> SelectStatement7<T1, T2, T3, T4, T5, T6, T7>.fetch() = SelectResult7(c, this, this@Queries)
    fun <T1, T2, T3, T4, T5, T6, T7, T8> SelectStatement8<T1, T2, T3, T4, T5, T6, T7, T8>.fetch() = SelectResult8(c, this, this@Queries)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9> SelectStatement9<T1, T2, T3, T4, T5, T6, T7, T8, T9>.fetch() = SelectResult9(c, this, this@Queries)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> SelectStatement10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>.fetch() = SelectResult10(c, this, this@Queries)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> SelectStatement11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>.fetch() = SelectResult11(c, this, this@Queries)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> SelectStatement12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>.fetch() = SelectResult12(c, this, this@Queries)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> SelectStatement13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>.fetch() = SelectResult13(c, this, this@Queries)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> SelectStatement14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>.fetch() = SelectResult14(c, this, this@Queries)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> SelectStatement15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>.fetch() = SelectResult15(c, this, this@Queries)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> SelectStatement16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>.fetch() = SelectResult16(c, this, this@Queries)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> SelectStatement17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>.fetch() = SelectResult17(c, this, this@Queries)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> SelectStatement18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>.fetch() = SelectResult18(c, this, this@Queries)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> SelectStatement19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>.fetch() = SelectResult19(c, this, this@Queries)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> SelectStatement20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>.fetch() = SelectResult20(c, this, this@Queries)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> SelectStatement21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>.fetch() = SelectResult21(c, this, this@Queries)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> SelectStatement22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>.fetch() = SelectResult22(c, this, this@Queries)
}
