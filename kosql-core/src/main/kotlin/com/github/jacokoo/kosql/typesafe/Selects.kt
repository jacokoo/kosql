package com.github.jacokoo.kosql.typesafe

import com.github.jacokoo.kosql.Column
import com.github.jacokoo.kosql.mapping.QueryResult
import com.github.jacokoo.kosql.mapping.QueryResultExtension
import com.github.jacokoo.kosql.mapping.ResultSetMapper
import com.github.jacokoo.kosql.mapping.ResultSetRow
import com.github.jacokoo.kosql.statements.*

data class SelectStatement1<T1>(val c: Column1<T1>, override val data: SelectData): SelectStatement
class QueryResultMapper1<T1>(private val c: Column1<T1>): ResultSetMapper<Value1<T1>> {
    override fun map(rs: ResultSetRow) = Value1(rs[0, c.c1])
}
data class QueryResult1<T1>(private val c: Column1<T1>, override val values: List<Value1<T1>>): QueryResult<Value1<T1>> {
    override val columns = c
    constructor(c: Column1<T1>, qp: SelectStatement, ko: QueryResultExtension): this(c, ko.execute(qp, QueryResultMapper1(c)))
}

data class SelectStatement2<T1, T2>(val c: Column2<T1, T2>, override val data: SelectData): SelectStatement
class QueryResultMapper2<T1, T2>(private val c: Column2<T1, T2>): ResultSetMapper<Value2<T1, T2>> {
    override fun map(rs: ResultSetRow) = Value2(rs[0, c.c1], rs[1, c.c2])
}
data class QueryResult2<T1, T2>(private val c: Column2<T1, T2>, override val values: List<Value2<T1, T2>>): QueryResult<Value2<T1, T2>> {
    override val columns = c
    constructor(c: Column2<T1, T2>, qp: SelectStatement, ko: QueryResultExtension): this(c, ko.execute(qp, QueryResultMapper2(c)))
}

data class SelectStatement3<T1, T2, T3>(val c: Column3<T1, T2, T3>, override val data: SelectData): SelectStatement
class QueryResultMapper3<T1, T2, T3>(private val c: Column3<T1, T2, T3>): ResultSetMapper<Value3<T1, T2, T3>> {
    override fun map(rs: ResultSetRow) = Value3(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3])
}
data class QueryResult3<T1, T2, T3>(private val c: Column3<T1, T2, T3>, override val values: List<Value3<T1, T2, T3>>): QueryResult<Value3<T1, T2, T3>> {
    override val columns = c
    constructor(c: Column3<T1, T2, T3>, qp: SelectStatement, ko: QueryResultExtension): this(c, ko.execute(qp, QueryResultMapper3(c)))
}

data class SelectStatement4<T1, T2, T3, T4>(val c: Column4<T1, T2, T3, T4>, override val data: SelectData): SelectStatement
class QueryResultMapper4<T1, T2, T3, T4>(private val c: Column4<T1, T2, T3, T4>): ResultSetMapper<Value4<T1, T2, T3, T4>> {
    override fun map(rs: ResultSetRow) = Value4(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4])
}
data class QueryResult4<T1, T2, T3, T4>(private val c: Column4<T1, T2, T3, T4>, override val values: List<Value4<T1, T2, T3, T4>>): QueryResult<Value4<T1, T2, T3, T4>> {
    override val columns = c
    constructor(c: Column4<T1, T2, T3, T4>, qp: SelectStatement, ko: QueryResultExtension): this(c, ko.execute(qp, QueryResultMapper4(c)))
}

data class SelectStatement5<T1, T2, T3, T4, T5>(val c: Column5<T1, T2, T3, T4, T5>, override val data: SelectData): SelectStatement
class QueryResultMapper5<T1, T2, T3, T4, T5>(private val c: Column5<T1, T2, T3, T4, T5>): ResultSetMapper<Value5<T1, T2, T3, T4, T5>> {
    override fun map(rs: ResultSetRow) = Value5(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5])
}
data class QueryResult5<T1, T2, T3, T4, T5>(private val c: Column5<T1, T2, T3, T4, T5>, override val values: List<Value5<T1, T2, T3, T4, T5>>): QueryResult<Value5<T1, T2, T3, T4, T5>> {
    override val columns = c
    constructor(c: Column5<T1, T2, T3, T4, T5>, qp: SelectStatement, ko: QueryResultExtension): this(c, ko.execute(qp, QueryResultMapper5(c)))
}

data class SelectStatement6<T1, T2, T3, T4, T5, T6>(val c: Column6<T1, T2, T3, T4, T5, T6>, override val data: SelectData): SelectStatement
class QueryResultMapper6<T1, T2, T3, T4, T5, T6>(private val c: Column6<T1, T2, T3, T4, T5, T6>): ResultSetMapper<Value6<T1, T2, T3, T4, T5, T6>> {
    override fun map(rs: ResultSetRow) = Value6(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6])
}
data class QueryResult6<T1, T2, T3, T4, T5, T6>(private val c: Column6<T1, T2, T3, T4, T5, T6>, override val values: List<Value6<T1, T2, T3, T4, T5, T6>>): QueryResult<Value6<T1, T2, T3, T4, T5, T6>> {
    override val columns = c
    constructor(c: Column6<T1, T2, T3, T4, T5, T6>, qp: SelectStatement, ko: QueryResultExtension): this(c, ko.execute(qp, QueryResultMapper6(c)))
}

data class SelectStatement7<T1, T2, T3, T4, T5, T6, T7>(val c: Column7<T1, T2, T3, T4, T5, T6, T7>, override val data: SelectData): SelectStatement
class QueryResultMapper7<T1, T2, T3, T4, T5, T6, T7>(private val c: Column7<T1, T2, T3, T4, T5, T6, T7>): ResultSetMapper<Value7<T1, T2, T3, T4, T5, T6, T7>> {
    override fun map(rs: ResultSetRow) = Value7(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6], rs[6, c.c7])
}
data class QueryResult7<T1, T2, T3, T4, T5, T6, T7>(private val c: Column7<T1, T2, T3, T4, T5, T6, T7>, override val values: List<Value7<T1, T2, T3, T4, T5, T6, T7>>): QueryResult<Value7<T1, T2, T3, T4, T5, T6, T7>> {
    override val columns = c
    constructor(c: Column7<T1, T2, T3, T4, T5, T6, T7>, qp: SelectStatement, ko: QueryResultExtension): this(c, ko.execute(qp, QueryResultMapper7(c)))
}

data class SelectStatement8<T1, T2, T3, T4, T5, T6, T7, T8>(val c: Column8<T1, T2, T3, T4, T5, T6, T7, T8>, override val data: SelectData): SelectStatement
class QueryResultMapper8<T1, T2, T3, T4, T5, T6, T7, T8>(private val c: Column8<T1, T2, T3, T4, T5, T6, T7, T8>): ResultSetMapper<Value8<T1, T2, T3, T4, T5, T6, T7, T8>> {
    override fun map(rs: ResultSetRow) = Value8(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6], rs[6, c.c7], rs[7, c.c8])
}
data class QueryResult8<T1, T2, T3, T4, T5, T6, T7, T8>(private val c: Column8<T1, T2, T3, T4, T5, T6, T7, T8>, override val values: List<Value8<T1, T2, T3, T4, T5, T6, T7, T8>>): QueryResult<Value8<T1, T2, T3, T4, T5, T6, T7, T8>> {
    override val columns = c
    constructor(c: Column8<T1, T2, T3, T4, T5, T6, T7, T8>, qp: SelectStatement, ko: QueryResultExtension): this(c, ko.execute(qp, QueryResultMapper8(c)))
}

data class SelectStatement9<T1, T2, T3, T4, T5, T6, T7, T8, T9>(val c: Column9<T1, T2, T3, T4, T5, T6, T7, T8, T9>, override val data: SelectData): SelectStatement
class QueryResultMapper9<T1, T2, T3, T4, T5, T6, T7, T8, T9>(private val c: Column9<T1, T2, T3, T4, T5, T6, T7, T8, T9>): ResultSetMapper<Value9<T1, T2, T3, T4, T5, T6, T7, T8, T9>> {
    override fun map(rs: ResultSetRow) = Value9(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6], rs[6, c.c7], rs[7, c.c8], rs[8, c.c9])
}
data class QueryResult9<T1, T2, T3, T4, T5, T6, T7, T8, T9>(private val c: Column9<T1, T2, T3, T4, T5, T6, T7, T8, T9>, override val values: List<Value9<T1, T2, T3, T4, T5, T6, T7, T8, T9>>): QueryResult<Value9<T1, T2, T3, T4, T5, T6, T7, T8, T9>> {
    override val columns = c
    constructor(c: Column9<T1, T2, T3, T4, T5, T6, T7, T8, T9>, qp: SelectStatement, ko: QueryResultExtension): this(c, ko.execute(qp, QueryResultMapper9(c)))
}

data class SelectStatement10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>(val c: Column10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>, override val data: SelectData): SelectStatement
class QueryResultMapper10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>(private val c: Column10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>): ResultSetMapper<Value10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>> {
    override fun map(rs: ResultSetRow) = Value10(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6], rs[6, c.c7], rs[7, c.c8], rs[8, c.c9], rs[9, c.c10])
}
data class QueryResult10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>(private val c: Column10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>, override val values: List<Value10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>>): QueryResult<Value10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>> {
    override val columns = c
    constructor(c: Column10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>, qp: SelectStatement, ko: QueryResultExtension): this(c, ko.execute(qp, QueryResultMapper10(c)))
}

data class SelectStatement11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>(val c: Column11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>, override val data: SelectData): SelectStatement
class QueryResultMapper11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>(private val c: Column11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>): ResultSetMapper<Value11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>> {
    override fun map(rs: ResultSetRow) = Value11(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6], rs[6, c.c7], rs[7, c.c8], rs[8, c.c9], rs[9, c.c10], rs[10, c.c11])
}
data class QueryResult11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>(private val c: Column11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>, override val values: List<Value11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>>): QueryResult<Value11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>> {
    override val columns = c
    constructor(c: Column11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>, qp: SelectStatement, ko: QueryResultExtension): this(c, ko.execute(qp, QueryResultMapper11(c)))
}

data class SelectStatement12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>(val c: Column12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>, override val data: SelectData): SelectStatement
class QueryResultMapper12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>(private val c: Column12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>): ResultSetMapper<Value12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>> {
    override fun map(rs: ResultSetRow) = Value12(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6], rs[6, c.c7], rs[7, c.c8], rs[8, c.c9], rs[9, c.c10], rs[10, c.c11], rs[11, c.c12])
}
data class QueryResult12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>(private val c: Column12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>, override val values: List<Value12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>>): QueryResult<Value12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>> {
    override val columns = c
    constructor(c: Column12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>, qp: SelectStatement, ko: QueryResultExtension): this(c, ko.execute(qp, QueryResultMapper12(c)))
}

data class SelectStatement13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>(val c: Column13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>, override val data: SelectData): SelectStatement
class QueryResultMapper13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>(private val c: Column13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>): ResultSetMapper<Value13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>> {
    override fun map(rs: ResultSetRow) = Value13(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6], rs[6, c.c7], rs[7, c.c8], rs[8, c.c9], rs[9, c.c10], rs[10, c.c11], rs[11, c.c12], rs[12, c.c13])
}
data class QueryResult13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>(private val c: Column13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>, override val values: List<Value13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>>): QueryResult<Value13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>> {
    override val columns = c
    constructor(c: Column13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>, qp: SelectStatement, ko: QueryResultExtension): this(c, ko.execute(qp, QueryResultMapper13(c)))
}

data class SelectStatement14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>(val c: Column14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>, override val data: SelectData): SelectStatement
class QueryResultMapper14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>(private val c: Column14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>): ResultSetMapper<Value14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>> {
    override fun map(rs: ResultSetRow) = Value14(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6], rs[6, c.c7], rs[7, c.c8], rs[8, c.c9], rs[9, c.c10], rs[10, c.c11], rs[11, c.c12], rs[12, c.c13], rs[13, c.c14])
}
data class QueryResult14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>(private val c: Column14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>, override val values: List<Value14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>>): QueryResult<Value14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>> {
    override val columns = c
    constructor(c: Column14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>, qp: SelectStatement, ko: QueryResultExtension): this(c, ko.execute(qp, QueryResultMapper14(c)))
}

data class SelectStatement15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>(val c: Column15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>, override val data: SelectData): SelectStatement
class QueryResultMapper15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>(private val c: Column15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>): ResultSetMapper<Value15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>> {
    override fun map(rs: ResultSetRow) = Value15(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6], rs[6, c.c7], rs[7, c.c8], rs[8, c.c9], rs[9, c.c10], rs[10, c.c11], rs[11, c.c12], rs[12, c.c13], rs[13, c.c14], rs[14, c.c15])
}
data class QueryResult15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>(private val c: Column15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>, override val values: List<Value15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>>): QueryResult<Value15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>> {
    override val columns = c
    constructor(c: Column15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>, qp: SelectStatement, ko: QueryResultExtension): this(c, ko.execute(qp, QueryResultMapper15(c)))
}

data class SelectStatement16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>(val c: Column16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>, override val data: SelectData): SelectStatement
class QueryResultMapper16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>(private val c: Column16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>): ResultSetMapper<Value16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>> {
    override fun map(rs: ResultSetRow) = Value16(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6], rs[6, c.c7], rs[7, c.c8], rs[8, c.c9], rs[9, c.c10], rs[10, c.c11], rs[11, c.c12], rs[12, c.c13], rs[13, c.c14], rs[14, c.c15], rs[15, c.c16])
}
data class QueryResult16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>(private val c: Column16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>, override val values: List<Value16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>>): QueryResult<Value16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>> {
    override val columns = c
    constructor(c: Column16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>, qp: SelectStatement, ko: QueryResultExtension): this(c, ko.execute(qp, QueryResultMapper16(c)))
}

data class SelectStatement17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>(val c: Column17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>, override val data: SelectData): SelectStatement
class QueryResultMapper17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>(private val c: Column17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>): ResultSetMapper<Value17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>> {
    override fun map(rs: ResultSetRow) = Value17(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6], rs[6, c.c7], rs[7, c.c8], rs[8, c.c9], rs[9, c.c10], rs[10, c.c11], rs[11, c.c12], rs[12, c.c13], rs[13, c.c14], rs[14, c.c15], rs[15, c.c16], rs[16, c.c17])
}
data class QueryResult17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>(private val c: Column17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>, override val values: List<Value17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>>): QueryResult<Value17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>> {
    override val columns = c
    constructor(c: Column17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>, qp: SelectStatement, ko: QueryResultExtension): this(c, ko.execute(qp, QueryResultMapper17(c)))
}

data class SelectStatement18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>(val c: Column18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>, override val data: SelectData): SelectStatement
class QueryResultMapper18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>(private val c: Column18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>): ResultSetMapper<Value18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>> {
    override fun map(rs: ResultSetRow) = Value18(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6], rs[6, c.c7], rs[7, c.c8], rs[8, c.c9], rs[9, c.c10], rs[10, c.c11], rs[11, c.c12], rs[12, c.c13], rs[13, c.c14], rs[14, c.c15], rs[15, c.c16], rs[16, c.c17], rs[17, c.c18])
}
data class QueryResult18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>(private val c: Column18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>, override val values: List<Value18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>>): QueryResult<Value18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>> {
    override val columns = c
    constructor(c: Column18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>, qp: SelectStatement, ko: QueryResultExtension): this(c, ko.execute(qp, QueryResultMapper18(c)))
}

data class SelectStatement19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>(val c: Column19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>, override val data: SelectData): SelectStatement
class QueryResultMapper19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>(private val c: Column19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>): ResultSetMapper<Value19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>> {
    override fun map(rs: ResultSetRow) = Value19(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6], rs[6, c.c7], rs[7, c.c8], rs[8, c.c9], rs[9, c.c10], rs[10, c.c11], rs[11, c.c12], rs[12, c.c13], rs[13, c.c14], rs[14, c.c15], rs[15, c.c16], rs[16, c.c17], rs[17, c.c18], rs[18, c.c19])
}
data class QueryResult19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>(private val c: Column19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>, override val values: List<Value19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>>): QueryResult<Value19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>> {
    override val columns = c
    constructor(c: Column19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>, qp: SelectStatement, ko: QueryResultExtension): this(c, ko.execute(qp, QueryResultMapper19(c)))
}

data class SelectStatement20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>(val c: Column20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>, override val data: SelectData): SelectStatement
class QueryResultMapper20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>(private val c: Column20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>): ResultSetMapper<Value20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>> {
    override fun map(rs: ResultSetRow) = Value20(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6], rs[6, c.c7], rs[7, c.c8], rs[8, c.c9], rs[9, c.c10], rs[10, c.c11], rs[11, c.c12], rs[12, c.c13], rs[13, c.c14], rs[14, c.c15], rs[15, c.c16], rs[16, c.c17], rs[17, c.c18], rs[18, c.c19], rs[19, c.c20])
}
data class QueryResult20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>(private val c: Column20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>, override val values: List<Value20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>>): QueryResult<Value20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>> {
    override val columns = c
    constructor(c: Column20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>, qp: SelectStatement, ko: QueryResultExtension): this(c, ko.execute(qp, QueryResultMapper20(c)))
}

data class SelectStatement21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>(val c: Column21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>, override val data: SelectData): SelectStatement
class QueryResultMapper21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>(private val c: Column21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>): ResultSetMapper<Value21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>> {
    override fun map(rs: ResultSetRow) = Value21(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6], rs[6, c.c7], rs[7, c.c8], rs[8, c.c9], rs[9, c.c10], rs[10, c.c11], rs[11, c.c12], rs[12, c.c13], rs[13, c.c14], rs[14, c.c15], rs[15, c.c16], rs[16, c.c17], rs[17, c.c18], rs[18, c.c19], rs[19, c.c20], rs[20, c.c21])
}
data class QueryResult21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>(private val c: Column21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>, override val values: List<Value21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>>): QueryResult<Value21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>> {
    override val columns = c
    constructor(c: Column21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>, qp: SelectStatement, ko: QueryResultExtension): this(c, ko.execute(qp, QueryResultMapper21(c)))
}

data class SelectStatement22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>(val c: Column22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>, override val data: SelectData): SelectStatement
class QueryResultMapper22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>(private val c: Column22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>): ResultSetMapper<Value22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>> {
    override fun map(rs: ResultSetRow) = Value22(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6], rs[6, c.c7], rs[7, c.c8], rs[8, c.c9], rs[9, c.c10], rs[10, c.c11], rs[11, c.c12], rs[12, c.c13], rs[13, c.c14], rs[14, c.c15], rs[15, c.c16], rs[16, c.c17], rs[17, c.c18], rs[18, c.c19], rs[19, c.c20], rs[20, c.c21], rs[21, c.c22])
}
data class QueryResult22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>(private val c: Column22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>, override val values: List<Value22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>>): QueryResult<Value22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>> {
    override val columns = c
    constructor(c: Column22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>, qp: SelectStatement, ko: QueryResultExtension): this(c, ko.execute(qp, QueryResultMapper22(c)))
}
interface Selects: QueryResultExtension {
    operator fun <T1> Select.SELECT.invoke(c1: Column<T1>, block: SelectCreator) = SelectStatement1(Column1(c1), SelectFromPart(c1).block().data)
    operator fun <T1> Select.SELECT.invoke(c: Column1<T1>, block: SelectCreator) = SelectStatement1(c, SelectFromPart(c).block().data)
    fun <T1> SelectStatement1<T1>.fetch(): QueryResult1<T1> = QueryResult1(c, this, this@Selects)
    fun <T1> SelectStatement1<T1>.fetchOne() = fetch().values.firstOrNull()

    operator fun <T1, T2> Select.SELECT.invoke(c1: Column<T1>, c2: Column<T2>, block: SelectCreator) = SelectStatement2(Column2(c1, c2), SelectFromPart(c1, c2).block().data)
    operator fun <T1, T2> Select.SELECT.invoke(c: Column2<T1, T2>, block: SelectCreator) = SelectStatement2(c, SelectFromPart(c).block().data)
    fun <T1, T2> SelectStatement2<T1, T2>.fetch(): QueryResult2<T1, T2> = QueryResult2(c, this, this@Selects)
    fun <T1, T2> SelectStatement2<T1, T2>.fetchOne() = fetch().values.firstOrNull()

    operator fun <T1, T2, T3> Select.SELECT.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, block: SelectCreator) = SelectStatement3(Column3(c1, c2, c3), SelectFromPart(c1, c2, c3).block().data)
    operator fun <T1, T2, T3> Select.SELECT.invoke(c: Column3<T1, T2, T3>, block: SelectCreator) = SelectStatement3(c, SelectFromPart(c).block().data)
    fun <T1, T2, T3> SelectStatement3<T1, T2, T3>.fetch(): QueryResult3<T1, T2, T3> = QueryResult3(c, this, this@Selects)
    fun <T1, T2, T3> SelectStatement3<T1, T2, T3>.fetchOne() = fetch().values.firstOrNull()

    operator fun <T1, T2, T3, T4> Select.SELECT.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, block: SelectCreator) = SelectStatement4(Column4(c1, c2, c3, c4), SelectFromPart(c1, c2, c3, c4).block().data)
    operator fun <T1, T2, T3, T4> Select.SELECT.invoke(c: Column4<T1, T2, T3, T4>, block: SelectCreator) = SelectStatement4(c, SelectFromPart(c).block().data)
    fun <T1, T2, T3, T4> SelectStatement4<T1, T2, T3, T4>.fetch(): QueryResult4<T1, T2, T3, T4> = QueryResult4(c, this, this@Selects)
    fun <T1, T2, T3, T4> SelectStatement4<T1, T2, T3, T4>.fetchOne() = fetch().values.firstOrNull()

    operator fun <T1, T2, T3, T4, T5> Select.SELECT.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, block: SelectCreator) = SelectStatement5(Column5(c1, c2, c3, c4, c5), SelectFromPart(c1, c2, c3, c4, c5).block().data)
    operator fun <T1, T2, T3, T4, T5> Select.SELECT.invoke(c: Column5<T1, T2, T3, T4, T5>, block: SelectCreator) = SelectStatement5(c, SelectFromPart(c).block().data)
    fun <T1, T2, T3, T4, T5> SelectStatement5<T1, T2, T3, T4, T5>.fetch(): QueryResult5<T1, T2, T3, T4, T5> = QueryResult5(c, this, this@Selects)
    fun <T1, T2, T3, T4, T5> SelectStatement5<T1, T2, T3, T4, T5>.fetchOne() = fetch().values.firstOrNull()

    operator fun <T1, T2, T3, T4, T5, T6> Select.SELECT.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, block: SelectCreator) = SelectStatement6(Column6(c1, c2, c3, c4, c5, c6), SelectFromPart(c1, c2, c3, c4, c5, c6).block().data)
    operator fun <T1, T2, T3, T4, T5, T6> Select.SELECT.invoke(c: Column6<T1, T2, T3, T4, T5, T6>, block: SelectCreator) = SelectStatement6(c, SelectFromPart(c).block().data)
    fun <T1, T2, T3, T4, T5, T6> SelectStatement6<T1, T2, T3, T4, T5, T6>.fetch(): QueryResult6<T1, T2, T3, T4, T5, T6> = QueryResult6(c, this, this@Selects)
    fun <T1, T2, T3, T4, T5, T6> SelectStatement6<T1, T2, T3, T4, T5, T6>.fetchOne() = fetch().values.firstOrNull()

    operator fun <T1, T2, T3, T4, T5, T6, T7> Select.SELECT.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, block: SelectCreator) = SelectStatement7(Column7(c1, c2, c3, c4, c5, c6, c7), SelectFromPart(c1, c2, c3, c4, c5, c6, c7).block().data)
    operator fun <T1, T2, T3, T4, T5, T6, T7> Select.SELECT.invoke(c: Column7<T1, T2, T3, T4, T5, T6, T7>, block: SelectCreator) = SelectStatement7(c, SelectFromPart(c).block().data)
    fun <T1, T2, T3, T4, T5, T6, T7> SelectStatement7<T1, T2, T3, T4, T5, T6, T7>.fetch(): QueryResult7<T1, T2, T3, T4, T5, T6, T7> = QueryResult7(c, this, this@Selects)
    fun <T1, T2, T3, T4, T5, T6, T7> SelectStatement7<T1, T2, T3, T4, T5, T6, T7>.fetchOne() = fetch().values.firstOrNull()

    operator fun <T1, T2, T3, T4, T5, T6, T7, T8> Select.SELECT.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, block: SelectCreator) = SelectStatement8(Column8(c1, c2, c3, c4, c5, c6, c7, c8), SelectFromPart(c1, c2, c3, c4, c5, c6, c7, c8).block().data)
    operator fun <T1, T2, T3, T4, T5, T6, T7, T8> Select.SELECT.invoke(c: Column8<T1, T2, T3, T4, T5, T6, T7, T8>, block: SelectCreator) = SelectStatement8(c, SelectFromPart(c).block().data)
    fun <T1, T2, T3, T4, T5, T6, T7, T8> SelectStatement8<T1, T2, T3, T4, T5, T6, T7, T8>.fetch(): QueryResult8<T1, T2, T3, T4, T5, T6, T7, T8> = QueryResult8(c, this, this@Selects)
    fun <T1, T2, T3, T4, T5, T6, T7, T8> SelectStatement8<T1, T2, T3, T4, T5, T6, T7, T8>.fetchOne() = fetch().values.firstOrNull()

    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9> Select.SELECT.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, block: SelectCreator) = SelectStatement9(Column9(c1, c2, c3, c4, c5, c6, c7, c8, c9), SelectFromPart(c1, c2, c3, c4, c5, c6, c7, c8, c9).block().data)
    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9> Select.SELECT.invoke(c: Column9<T1, T2, T3, T4, T5, T6, T7, T8, T9>, block: SelectCreator) = SelectStatement9(c, SelectFromPart(c).block().data)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9> SelectStatement9<T1, T2, T3, T4, T5, T6, T7, T8, T9>.fetch(): QueryResult9<T1, T2, T3, T4, T5, T6, T7, T8, T9> = QueryResult9(c, this, this@Selects)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9> SelectStatement9<T1, T2, T3, T4, T5, T6, T7, T8, T9>.fetchOne() = fetch().values.firstOrNull()

    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> Select.SELECT.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, block: SelectCreator) = SelectStatement10(Column10(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10), SelectFromPart(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10).block().data)
    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> Select.SELECT.invoke(c: Column10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>, block: SelectCreator) = SelectStatement10(c, SelectFromPart(c).block().data)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> SelectStatement10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>.fetch(): QueryResult10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> = QueryResult10(c, this, this@Selects)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> SelectStatement10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>.fetchOne() = fetch().values.firstOrNull()

    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> Select.SELECT.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, block: SelectCreator) = SelectStatement11(Column11(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11), SelectFromPart(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11).block().data)
    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> Select.SELECT.invoke(c: Column11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>, block: SelectCreator) = SelectStatement11(c, SelectFromPart(c).block().data)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> SelectStatement11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>.fetch(): QueryResult11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> = QueryResult11(c, this, this@Selects)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> SelectStatement11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>.fetchOne() = fetch().values.firstOrNull()

    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> Select.SELECT.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, block: SelectCreator) = SelectStatement12(Column12(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12), SelectFromPart(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12).block().data)
    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> Select.SELECT.invoke(c: Column12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>, block: SelectCreator) = SelectStatement12(c, SelectFromPart(c).block().data)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> SelectStatement12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>.fetch(): QueryResult12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> = QueryResult12(c, this, this@Selects)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> SelectStatement12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>.fetchOne() = fetch().values.firstOrNull()

    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> Select.SELECT.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, block: SelectCreator) = SelectStatement13(Column13(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13), SelectFromPart(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13).block().data)
    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> Select.SELECT.invoke(c: Column13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>, block: SelectCreator) = SelectStatement13(c, SelectFromPart(c).block().data)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> SelectStatement13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>.fetch(): QueryResult13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> = QueryResult13(c, this, this@Selects)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> SelectStatement13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>.fetchOne() = fetch().values.firstOrNull()

    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> Select.SELECT.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>, block: SelectCreator) = SelectStatement14(Column14(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14), SelectFromPart(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14).block().data)
    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> Select.SELECT.invoke(c: Column14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>, block: SelectCreator) = SelectStatement14(c, SelectFromPart(c).block().data)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> SelectStatement14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>.fetch(): QueryResult14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> = QueryResult14(c, this, this@Selects)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> SelectStatement14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>.fetchOne() = fetch().values.firstOrNull()

    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> Select.SELECT.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>, c15: Column<T15>, block: SelectCreator) = SelectStatement15(Column15(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15), SelectFromPart(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15).block().data)
    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> Select.SELECT.invoke(c: Column15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>, block: SelectCreator) = SelectStatement15(c, SelectFromPart(c).block().data)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> SelectStatement15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>.fetch(): QueryResult15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> = QueryResult15(c, this, this@Selects)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> SelectStatement15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>.fetchOne() = fetch().values.firstOrNull()

    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> Select.SELECT.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>, c15: Column<T15>, c16: Column<T16>, block: SelectCreator) = SelectStatement16(Column16(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16), SelectFromPart(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16).block().data)
    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> Select.SELECT.invoke(c: Column16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>, block: SelectCreator) = SelectStatement16(c, SelectFromPart(c).block().data)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> SelectStatement16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>.fetch(): QueryResult16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> = QueryResult16(c, this, this@Selects)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> SelectStatement16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>.fetchOne() = fetch().values.firstOrNull()

    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> Select.SELECT.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>, c15: Column<T15>, c16: Column<T16>, c17: Column<T17>, block: SelectCreator) = SelectStatement17(Column17(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17), SelectFromPart(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17).block().data)
    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> Select.SELECT.invoke(c: Column17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>, block: SelectCreator) = SelectStatement17(c, SelectFromPart(c).block().data)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> SelectStatement17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>.fetch(): QueryResult17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> = QueryResult17(c, this, this@Selects)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> SelectStatement17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>.fetchOne() = fetch().values.firstOrNull()

    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> Select.SELECT.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>, c15: Column<T15>, c16: Column<T16>, c17: Column<T17>, c18: Column<T18>, block: SelectCreator) = SelectStatement18(Column18(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18), SelectFromPart(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18).block().data)
    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> Select.SELECT.invoke(c: Column18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>, block: SelectCreator) = SelectStatement18(c, SelectFromPart(c).block().data)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> SelectStatement18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>.fetch(): QueryResult18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> = QueryResult18(c, this, this@Selects)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> SelectStatement18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>.fetchOne() = fetch().values.firstOrNull()

    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> Select.SELECT.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>, c15: Column<T15>, c16: Column<T16>, c17: Column<T17>, c18: Column<T18>, c19: Column<T19>, block: SelectCreator) = SelectStatement19(Column19(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19), SelectFromPart(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19).block().data)
    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> Select.SELECT.invoke(c: Column19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>, block: SelectCreator) = SelectStatement19(c, SelectFromPart(c).block().data)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> SelectStatement19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>.fetch(): QueryResult19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> = QueryResult19(c, this, this@Selects)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> SelectStatement19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>.fetchOne() = fetch().values.firstOrNull()

    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> Select.SELECT.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>, c15: Column<T15>, c16: Column<T16>, c17: Column<T17>, c18: Column<T18>, c19: Column<T19>, c20: Column<T20>, block: SelectCreator) = SelectStatement20(Column20(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20), SelectFromPart(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20).block().data)
    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> Select.SELECT.invoke(c: Column20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>, block: SelectCreator) = SelectStatement20(c, SelectFromPart(c).block().data)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> SelectStatement20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>.fetch(): QueryResult20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> = QueryResult20(c, this, this@Selects)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> SelectStatement20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>.fetchOne() = fetch().values.firstOrNull()

    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> Select.SELECT.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>, c15: Column<T15>, c16: Column<T16>, c17: Column<T17>, c18: Column<T18>, c19: Column<T19>, c20: Column<T20>, c21: Column<T21>, block: SelectCreator) = SelectStatement21(Column21(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21), SelectFromPart(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21).block().data)
    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> Select.SELECT.invoke(c: Column21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>, block: SelectCreator) = SelectStatement21(c, SelectFromPart(c).block().data)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> SelectStatement21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>.fetch(): QueryResult21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> = QueryResult21(c, this, this@Selects)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> SelectStatement21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>.fetchOne() = fetch().values.firstOrNull()

    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> Select.SELECT.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>, c15: Column<T15>, c16: Column<T16>, c17: Column<T17>, c18: Column<T18>, c19: Column<T19>, c20: Column<T20>, c21: Column<T21>, c22: Column<T22>, block: SelectCreator) = SelectStatement22(Column22(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21, c22), SelectFromPart(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21, c22).block().data)
    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> Select.SELECT.invoke(c: Column22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>, block: SelectCreator) = SelectStatement22(c, SelectFromPart(c).block().data)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> SelectStatement22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>.fetch(): QueryResult22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> = QueryResult22(c, this, this@Selects)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> SelectStatement22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>.fetchOne() = fetch().values.firstOrNull()
}