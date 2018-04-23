package com.github.jacokoo.kosql.statements

import com.github.jacokoo.kosql.Column
import com.github.jacokoo.kosql.mapping.*

data class SelectStatement1<T1>(val c: Column1<T1>, override val data: QueryData): QueryPart
data class ResultRow1<T1>(val v1: T1, override val values: List<Any?> = listOf(v1)): ResultRow
data class QueryResult1<T1>(private val c: Column1<T1>, override val values: List<ResultRow1<T1>>): QueryResult<ResultRow1<T1>> {
    override val columns = c
    constructor(c: Column1<T1>, qp: QueryPart, ko: QueryResultExtension): this(c, ko.execute(qp, Mapper(c)))
    private class Mapper<T1>(private val c: Column1<T1>): ResultSetMapper<ResultRow1<T1>> {
        override fun map(rs: ResultSetRow) = ResultRow1(rs[0, c.c1])
    }
}

data class SelectStatement2<T1, T2>(val c: Column2<T1, T2>, override val data: QueryData): QueryPart
data class ResultRow2<T1, T2>(val v1: T1, val v2: T2, override val values: List<Any?> = listOf(v1, v2)): ResultRow
data class QueryResult2<T1, T2>(private val c: Column2<T1, T2>, override val values: List<ResultRow2<T1, T2>>): QueryResult<ResultRow2<T1, T2>> {
    override val columns = c
    constructor(c: Column2<T1, T2>, qp: QueryPart, ko: QueryResultExtension): this(c, ko.execute(qp, Mapper(c)))
    private class Mapper<T1, T2>(private val c: Column2<T1, T2>): ResultSetMapper<ResultRow2<T1, T2>> {
        override fun map(rs: ResultSetRow) = ResultRow2(rs[0, c.c1], rs[1, c.c2])
    }
}

data class SelectStatement3<T1, T2, T3>(val c: Column3<T1, T2, T3>, override val data: QueryData): QueryPart
data class ResultRow3<T1, T2, T3>(val v1: T1, val v2: T2, val v3: T3, override val values: List<Any?> = listOf(v1, v2, v3)): ResultRow
data class QueryResult3<T1, T2, T3>(private val c: Column3<T1, T2, T3>, override val values: List<ResultRow3<T1, T2, T3>>): QueryResult<ResultRow3<T1, T2, T3>> {
    override val columns = c
    constructor(c: Column3<T1, T2, T3>, qp: QueryPart, ko: QueryResultExtension): this(c, ko.execute(qp, Mapper(c)))
    private class Mapper<T1, T2, T3>(private val c: Column3<T1, T2, T3>): ResultSetMapper<ResultRow3<T1, T2, T3>> {
        override fun map(rs: ResultSetRow) = ResultRow3(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3])
    }
}

data class SelectStatement4<T1, T2, T3, T4>(val c: Column4<T1, T2, T3, T4>, override val data: QueryData): QueryPart
data class ResultRow4<T1, T2, T3, T4>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, override val values: List<Any?> = listOf(v1, v2, v3, v4)): ResultRow
data class QueryResult4<T1, T2, T3, T4>(private val c: Column4<T1, T2, T3, T4>, override val values: List<ResultRow4<T1, T2, T3, T4>>): QueryResult<ResultRow4<T1, T2, T3, T4>> {
    override val columns = c
    constructor(c: Column4<T1, T2, T3, T4>, qp: QueryPart, ko: QueryResultExtension): this(c, ko.execute(qp, Mapper(c)))
    private class Mapper<T1, T2, T3, T4>(private val c: Column4<T1, T2, T3, T4>): ResultSetMapper<ResultRow4<T1, T2, T3, T4>> {
        override fun map(rs: ResultSetRow) = ResultRow4(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4])
    }
}

data class SelectStatement5<T1, T2, T3, T4, T5>(val c: Column5<T1, T2, T3, T4, T5>, override val data: QueryData): QueryPart
data class ResultRow5<T1, T2, T3, T4, T5>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, val v5: T5, override val values: List<Any?> = listOf(v1, v2, v3, v4, v5)): ResultRow
data class QueryResult5<T1, T2, T3, T4, T5>(private val c: Column5<T1, T2, T3, T4, T5>, override val values: List<ResultRow5<T1, T2, T3, T4, T5>>): QueryResult<ResultRow5<T1, T2, T3, T4, T5>> {
    override val columns = c
    constructor(c: Column5<T1, T2, T3, T4, T5>, qp: QueryPart, ko: QueryResultExtension): this(c, ko.execute(qp, Mapper(c)))
    private class Mapper<T1, T2, T3, T4, T5>(private val c: Column5<T1, T2, T3, T4, T5>): ResultSetMapper<ResultRow5<T1, T2, T3, T4, T5>> {
        override fun map(rs: ResultSetRow) = ResultRow5(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5])
    }
}

data class SelectStatement6<T1, T2, T3, T4, T5, T6>(val c: Column6<T1, T2, T3, T4, T5, T6>, override val data: QueryData): QueryPart
data class ResultRow6<T1, T2, T3, T4, T5, T6>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, val v5: T5, val v6: T6, override val values: List<Any?> = listOf(v1, v2, v3, v4, v5, v6)): ResultRow
data class QueryResult6<T1, T2, T3, T4, T5, T6>(private val c: Column6<T1, T2, T3, T4, T5, T6>, override val values: List<ResultRow6<T1, T2, T3, T4, T5, T6>>): QueryResult<ResultRow6<T1, T2, T3, T4, T5, T6>> {
    override val columns = c
    constructor(c: Column6<T1, T2, T3, T4, T5, T6>, qp: QueryPart, ko: QueryResultExtension): this(c, ko.execute(qp, Mapper(c)))
    private class Mapper<T1, T2, T3, T4, T5, T6>(private val c: Column6<T1, T2, T3, T4, T5, T6>): ResultSetMapper<ResultRow6<T1, T2, T3, T4, T5, T6>> {
        override fun map(rs: ResultSetRow) = ResultRow6(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6])
    }
}

data class SelectStatement7<T1, T2, T3, T4, T5, T6, T7>(val c: Column7<T1, T2, T3, T4, T5, T6, T7>, override val data: QueryData): QueryPart
data class ResultRow7<T1, T2, T3, T4, T5, T6, T7>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, val v5: T5, val v6: T6, val v7: T7, override val values: List<Any?> = listOf(v1, v2, v3, v4, v5, v6, v7)): ResultRow
data class QueryResult7<T1, T2, T3, T4, T5, T6, T7>(private val c: Column7<T1, T2, T3, T4, T5, T6, T7>, override val values: List<ResultRow7<T1, T2, T3, T4, T5, T6, T7>>): QueryResult<ResultRow7<T1, T2, T3, T4, T5, T6, T7>> {
    override val columns = c
    constructor(c: Column7<T1, T2, T3, T4, T5, T6, T7>, qp: QueryPart, ko: QueryResultExtension): this(c, ko.execute(qp, Mapper(c)))
    private class Mapper<T1, T2, T3, T4, T5, T6, T7>(private val c: Column7<T1, T2, T3, T4, T5, T6, T7>): ResultSetMapper<ResultRow7<T1, T2, T3, T4, T5, T6, T7>> {
        override fun map(rs: ResultSetRow) = ResultRow7(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6], rs[6, c.c7])
    }
}

data class SelectStatement8<T1, T2, T3, T4, T5, T6, T7, T8>(val c: Column8<T1, T2, T3, T4, T5, T6, T7, T8>, override val data: QueryData): QueryPart
data class ResultRow8<T1, T2, T3, T4, T5, T6, T7, T8>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, val v5: T5, val v6: T6, val v7: T7, val v8: T8, override val values: List<Any?> = listOf(v1, v2, v3, v4, v5, v6, v7, v8)): ResultRow
data class QueryResult8<T1, T2, T3, T4, T5, T6, T7, T8>(private val c: Column8<T1, T2, T3, T4, T5, T6, T7, T8>, override val values: List<ResultRow8<T1, T2, T3, T4, T5, T6, T7, T8>>): QueryResult<ResultRow8<T1, T2, T3, T4, T5, T6, T7, T8>> {
    override val columns = c
    constructor(c: Column8<T1, T2, T3, T4, T5, T6, T7, T8>, qp: QueryPart, ko: QueryResultExtension): this(c, ko.execute(qp, Mapper(c)))
    private class Mapper<T1, T2, T3, T4, T5, T6, T7, T8>(private val c: Column8<T1, T2, T3, T4, T5, T6, T7, T8>): ResultSetMapper<ResultRow8<T1, T2, T3, T4, T5, T6, T7, T8>> {
        override fun map(rs: ResultSetRow) = ResultRow8(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6], rs[6, c.c7], rs[7, c.c8])
    }
}

data class SelectStatement9<T1, T2, T3, T4, T5, T6, T7, T8, T9>(val c: Column9<T1, T2, T3, T4, T5, T6, T7, T8, T9>, override val data: QueryData): QueryPart
data class ResultRow9<T1, T2, T3, T4, T5, T6, T7, T8, T9>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, val v5: T5, val v6: T6, val v7: T7, val v8: T8, val v9: T9, override val values: List<Any?> = listOf(v1, v2, v3, v4, v5, v6, v7, v8, v9)): ResultRow
data class QueryResult9<T1, T2, T3, T4, T5, T6, T7, T8, T9>(private val c: Column9<T1, T2, T3, T4, T5, T6, T7, T8, T9>, override val values: List<ResultRow9<T1, T2, T3, T4, T5, T6, T7, T8, T9>>): QueryResult<ResultRow9<T1, T2, T3, T4, T5, T6, T7, T8, T9>> {
    override val columns = c
    constructor(c: Column9<T1, T2, T3, T4, T5, T6, T7, T8, T9>, qp: QueryPart, ko: QueryResultExtension): this(c, ko.execute(qp, Mapper(c)))
    private class Mapper<T1, T2, T3, T4, T5, T6, T7, T8, T9>(private val c: Column9<T1, T2, T3, T4, T5, T6, T7, T8, T9>): ResultSetMapper<ResultRow9<T1, T2, T3, T4, T5, T6, T7, T8, T9>> {
        override fun map(rs: ResultSetRow) = ResultRow9(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6], rs[6, c.c7], rs[7, c.c8], rs[8, c.c9])
    }
}

data class SelectStatement10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>(val c: Column10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>, override val data: QueryData): QueryPart
data class ResultRow10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, val v5: T5, val v6: T6, val v7: T7, val v8: T8, val v9: T9, val v10: T10, override val values: List<Any?> = listOf(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10)): ResultRow
data class QueryResult10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>(private val c: Column10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>, override val values: List<ResultRow10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>>): QueryResult<ResultRow10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>> {
    override val columns = c
    constructor(c: Column10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>, qp: QueryPart, ko: QueryResultExtension): this(c, ko.execute(qp, Mapper(c)))
    private class Mapper<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>(private val c: Column10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>): ResultSetMapper<ResultRow10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>> {
        override fun map(rs: ResultSetRow) = ResultRow10(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6], rs[6, c.c7], rs[7, c.c8], rs[8, c.c9], rs[9, c.c10])
    }
}

data class SelectStatement11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>(val c: Column11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>, override val data: QueryData): QueryPart
data class ResultRow11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, val v5: T5, val v6: T6, val v7: T7, val v8: T8, val v9: T9, val v10: T10, val v11: T11, override val values: List<Any?> = listOf(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11)): ResultRow
data class QueryResult11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>(private val c: Column11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>, override val values: List<ResultRow11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>>): QueryResult<ResultRow11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>> {
    override val columns = c
    constructor(c: Column11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>, qp: QueryPart, ko: QueryResultExtension): this(c, ko.execute(qp, Mapper(c)))
    private class Mapper<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>(private val c: Column11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>): ResultSetMapper<ResultRow11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>> {
        override fun map(rs: ResultSetRow) = ResultRow11(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6], rs[6, c.c7], rs[7, c.c8], rs[8, c.c9], rs[9, c.c10], rs[10, c.c11])
    }
}

data class SelectStatement12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>(val c: Column12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>, override val data: QueryData): QueryPart
data class ResultRow12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, val v5: T5, val v6: T6, val v7: T7, val v8: T8, val v9: T9, val v10: T10, val v11: T11, val v12: T12, override val values: List<Any?> = listOf(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12)): ResultRow
data class QueryResult12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>(private val c: Column12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>, override val values: List<ResultRow12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>>): QueryResult<ResultRow12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>> {
    override val columns = c
    constructor(c: Column12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>, qp: QueryPart, ko: QueryResultExtension): this(c, ko.execute(qp, Mapper(c)))
    private class Mapper<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>(private val c: Column12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>): ResultSetMapper<ResultRow12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>> {
        override fun map(rs: ResultSetRow) = ResultRow12(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6], rs[6, c.c7], rs[7, c.c8], rs[8, c.c9], rs[9, c.c10], rs[10, c.c11], rs[11, c.c12])
    }
}

data class SelectStatement13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>(val c: Column13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>, override val data: QueryData): QueryPart
data class ResultRow13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, val v5: T5, val v6: T6, val v7: T7, val v8: T8, val v9: T9, val v10: T10, val v11: T11, val v12: T12, val v13: T13, override val values: List<Any?> = listOf(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13)): ResultRow
data class QueryResult13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>(private val c: Column13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>, override val values: List<ResultRow13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>>): QueryResult<ResultRow13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>> {
    override val columns = c
    constructor(c: Column13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>, qp: QueryPart, ko: QueryResultExtension): this(c, ko.execute(qp, Mapper(c)))
    private class Mapper<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>(private val c: Column13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>): ResultSetMapper<ResultRow13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>> {
        override fun map(rs: ResultSetRow) = ResultRow13(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6], rs[6, c.c7], rs[7, c.c8], rs[8, c.c9], rs[9, c.c10], rs[10, c.c11], rs[11, c.c12], rs[12, c.c13])
    }
}

data class SelectStatement14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>(val c: Column14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>, override val data: QueryData): QueryPart
data class ResultRow14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, val v5: T5, val v6: T6, val v7: T7, val v8: T8, val v9: T9, val v10: T10, val v11: T11, val v12: T12, val v13: T13, val v14: T14, override val values: List<Any?> = listOf(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14)): ResultRow
data class QueryResult14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>(private val c: Column14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>, override val values: List<ResultRow14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>>): QueryResult<ResultRow14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>> {
    override val columns = c
    constructor(c: Column14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>, qp: QueryPart, ko: QueryResultExtension): this(c, ko.execute(qp, Mapper(c)))
    private class Mapper<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>(private val c: Column14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>): ResultSetMapper<ResultRow14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>> {
        override fun map(rs: ResultSetRow) = ResultRow14(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6], rs[6, c.c7], rs[7, c.c8], rs[8, c.c9], rs[9, c.c10], rs[10, c.c11], rs[11, c.c12], rs[12, c.c13], rs[13, c.c14])
    }
}

data class SelectStatement15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>(val c: Column15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>, override val data: QueryData): QueryPart
data class ResultRow15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, val v5: T5, val v6: T6, val v7: T7, val v8: T8, val v9: T9, val v10: T10, val v11: T11, val v12: T12, val v13: T13, val v14: T14, val v15: T15, override val values: List<Any?> = listOf(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15)): ResultRow
data class QueryResult15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>(private val c: Column15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>, override val values: List<ResultRow15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>>): QueryResult<ResultRow15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>> {
    override val columns = c
    constructor(c: Column15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>, qp: QueryPart, ko: QueryResultExtension): this(c, ko.execute(qp, Mapper(c)))
    private class Mapper<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>(private val c: Column15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>): ResultSetMapper<ResultRow15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>> {
        override fun map(rs: ResultSetRow) = ResultRow15(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6], rs[6, c.c7], rs[7, c.c8], rs[8, c.c9], rs[9, c.c10], rs[10, c.c11], rs[11, c.c12], rs[12, c.c13], rs[13, c.c14], rs[14, c.c15])
    }
}

data class SelectStatement16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>(val c: Column16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>, override val data: QueryData): QueryPart
data class ResultRow16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, val v5: T5, val v6: T6, val v7: T7, val v8: T8, val v9: T9, val v10: T10, val v11: T11, val v12: T12, val v13: T13, val v14: T14, val v15: T15, val v16: T16, override val values: List<Any?> = listOf(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16)): ResultRow
data class QueryResult16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>(private val c: Column16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>, override val values: List<ResultRow16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>>): QueryResult<ResultRow16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>> {
    override val columns = c
    constructor(c: Column16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>, qp: QueryPart, ko: QueryResultExtension): this(c, ko.execute(qp, Mapper(c)))
    private class Mapper<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>(private val c: Column16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>): ResultSetMapper<ResultRow16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>> {
        override fun map(rs: ResultSetRow) = ResultRow16(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6], rs[6, c.c7], rs[7, c.c8], rs[8, c.c9], rs[9, c.c10], rs[10, c.c11], rs[11, c.c12], rs[12, c.c13], rs[13, c.c14], rs[14, c.c15], rs[15, c.c16])
    }
}

data class SelectStatement17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>(val c: Column17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>, override val data: QueryData): QueryPart
data class ResultRow17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, val v5: T5, val v6: T6, val v7: T7, val v8: T8, val v9: T9, val v10: T10, val v11: T11, val v12: T12, val v13: T13, val v14: T14, val v15: T15, val v16: T16, val v17: T17, override val values: List<Any?> = listOf(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17)): ResultRow
data class QueryResult17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>(private val c: Column17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>, override val values: List<ResultRow17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>>): QueryResult<ResultRow17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>> {
    override val columns = c
    constructor(c: Column17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>, qp: QueryPart, ko: QueryResultExtension): this(c, ko.execute(qp, Mapper(c)))
    private class Mapper<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>(private val c: Column17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>): ResultSetMapper<ResultRow17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>> {
        override fun map(rs: ResultSetRow) = ResultRow17(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6], rs[6, c.c7], rs[7, c.c8], rs[8, c.c9], rs[9, c.c10], rs[10, c.c11], rs[11, c.c12], rs[12, c.c13], rs[13, c.c14], rs[14, c.c15], rs[15, c.c16], rs[16, c.c17])
    }
}

data class SelectStatement18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>(val c: Column18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>, override val data: QueryData): QueryPart
data class ResultRow18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, val v5: T5, val v6: T6, val v7: T7, val v8: T8, val v9: T9, val v10: T10, val v11: T11, val v12: T12, val v13: T13, val v14: T14, val v15: T15, val v16: T16, val v17: T17, val v18: T18, override val values: List<Any?> = listOf(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18)): ResultRow
data class QueryResult18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>(private val c: Column18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>, override val values: List<ResultRow18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>>): QueryResult<ResultRow18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>> {
    override val columns = c
    constructor(c: Column18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>, qp: QueryPart, ko: QueryResultExtension): this(c, ko.execute(qp, Mapper(c)))
    private class Mapper<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>(private val c: Column18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>): ResultSetMapper<ResultRow18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>> {
        override fun map(rs: ResultSetRow) = ResultRow18(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6], rs[6, c.c7], rs[7, c.c8], rs[8, c.c9], rs[9, c.c10], rs[10, c.c11], rs[11, c.c12], rs[12, c.c13], rs[13, c.c14], rs[14, c.c15], rs[15, c.c16], rs[16, c.c17], rs[17, c.c18])
    }
}

data class SelectStatement19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>(val c: Column19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>, override val data: QueryData): QueryPart
data class ResultRow19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, val v5: T5, val v6: T6, val v7: T7, val v8: T8, val v9: T9, val v10: T10, val v11: T11, val v12: T12, val v13: T13, val v14: T14, val v15: T15, val v16: T16, val v17: T17, val v18: T18, val v19: T19, override val values: List<Any?> = listOf(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18, v19)): ResultRow
data class QueryResult19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>(private val c: Column19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>, override val values: List<ResultRow19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>>): QueryResult<ResultRow19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>> {
    override val columns = c
    constructor(c: Column19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>, qp: QueryPart, ko: QueryResultExtension): this(c, ko.execute(qp, Mapper(c)))
    private class Mapper<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>(private val c: Column19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>): ResultSetMapper<ResultRow19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>> {
        override fun map(rs: ResultSetRow) = ResultRow19(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6], rs[6, c.c7], rs[7, c.c8], rs[8, c.c9], rs[9, c.c10], rs[10, c.c11], rs[11, c.c12], rs[12, c.c13], rs[13, c.c14], rs[14, c.c15], rs[15, c.c16], rs[16, c.c17], rs[17, c.c18], rs[18, c.c19])
    }
}

data class SelectStatement20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>(val c: Column20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>, override val data: QueryData): QueryPart
data class ResultRow20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, val v5: T5, val v6: T6, val v7: T7, val v8: T8, val v9: T9, val v10: T10, val v11: T11, val v12: T12, val v13: T13, val v14: T14, val v15: T15, val v16: T16, val v17: T17, val v18: T18, val v19: T19, val v20: T20, override val values: List<Any?> = listOf(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18, v19, v20)): ResultRow
data class QueryResult20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>(private val c: Column20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>, override val values: List<ResultRow20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>>): QueryResult<ResultRow20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>> {
    override val columns = c
    constructor(c: Column20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>, qp: QueryPart, ko: QueryResultExtension): this(c, ko.execute(qp, Mapper(c)))
    private class Mapper<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>(private val c: Column20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>): ResultSetMapper<ResultRow20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>> {
        override fun map(rs: ResultSetRow) = ResultRow20(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6], rs[6, c.c7], rs[7, c.c8], rs[8, c.c9], rs[9, c.c10], rs[10, c.c11], rs[11, c.c12], rs[12, c.c13], rs[13, c.c14], rs[14, c.c15], rs[15, c.c16], rs[16, c.c17], rs[17, c.c18], rs[18, c.c19], rs[19, c.c20])
    }
}

data class SelectStatement21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>(val c: Column21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>, override val data: QueryData): QueryPart
data class ResultRow21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, val v5: T5, val v6: T6, val v7: T7, val v8: T8, val v9: T9, val v10: T10, val v11: T11, val v12: T12, val v13: T13, val v14: T14, val v15: T15, val v16: T16, val v17: T17, val v18: T18, val v19: T19, val v20: T20, val v21: T21, override val values: List<Any?> = listOf(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18, v19, v20, v21)): ResultRow
data class QueryResult21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>(private val c: Column21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>, override val values: List<ResultRow21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>>): QueryResult<ResultRow21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>> {
    override val columns = c
    constructor(c: Column21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>, qp: QueryPart, ko: QueryResultExtension): this(c, ko.execute(qp, Mapper(c)))
    private class Mapper<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>(private val c: Column21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>): ResultSetMapper<ResultRow21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>> {
        override fun map(rs: ResultSetRow) = ResultRow21(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6], rs[6, c.c7], rs[7, c.c8], rs[8, c.c9], rs[9, c.c10], rs[10, c.c11], rs[11, c.c12], rs[12, c.c13], rs[13, c.c14], rs[14, c.c15], rs[15, c.c16], rs[16, c.c17], rs[17, c.c18], rs[18, c.c19], rs[19, c.c20], rs[20, c.c21])
    }
}

data class SelectStatement22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>(val c: Column22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>, override val data: QueryData): QueryPart
data class ResultRow22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>(val v1: T1, val v2: T2, val v3: T3, val v4: T4, val v5: T5, val v6: T6, val v7: T7, val v8: T8, val v9: T9, val v10: T10, val v11: T11, val v12: T12, val v13: T13, val v14: T14, val v15: T15, val v16: T16, val v17: T17, val v18: T18, val v19: T19, val v20: T20, val v21: T21, val v22: T22, override val values: List<Any?> = listOf(v1, v2, v3, v4, v5, v6, v7, v8, v9, v10, v11, v12, v13, v14, v15, v16, v17, v18, v19, v20, v21, v22)): ResultRow
data class QueryResult22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>(private val c: Column22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>, override val values: List<ResultRow22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>>): QueryResult<ResultRow22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>> {
    override val columns = c
    constructor(c: Column22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>, qp: QueryPart, ko: QueryResultExtension): this(c, ko.execute(qp, Mapper(c)))
    private class Mapper<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>(private val c: Column22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>): ResultSetMapper<ResultRow22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>> {
        override fun map(rs: ResultSetRow) = ResultRow22(rs[0, c.c1], rs[1, c.c2], rs[2, c.c3], rs[3, c.c4], rs[4, c.c5], rs[5, c.c6], rs[6, c.c7], rs[7, c.c8], rs[8, c.c9], rs[9, c.c10], rs[10, c.c11], rs[11, c.c12], rs[12, c.c13], rs[13, c.c14], rs[14, c.c15], rs[15, c.c16], rs[16, c.c17], rs[17, c.c18], rs[18, c.c19], rs[19, c.c20], rs[20, c.c21], rs[21, c.c22])
    }
}
interface Selects: QueryResultExtension {
    operator fun <T1> Select.SELECT.invoke(c1: Column<T1>, block: SelectCreator) =  SelectStatement1(Column1(c1), SelectFromPart(c1).block().data)
    operator fun <T1> Select.SELECT.invoke(c: Column1<T1>, block: SelectCreator) =  SelectStatement1(c, SelectFromPart(c).block().data)
    fun <T1> SelectStatement1<T1>.fetch(): QueryResult1<T1> = QueryResult1(c, this, this@Selects)

    operator fun <T1, T2> Select.SELECT.invoke(c1: Column<T1>, c2: Column<T2>, block: SelectCreator) =  SelectStatement2(Column2(c1, c2), SelectFromPart(c1, c2).block().data)
    operator fun <T1, T2> Select.SELECT.invoke(c: Column2<T1, T2>, block: SelectCreator) =  SelectStatement2(c, SelectFromPart(c).block().data)
    fun <T1, T2> SelectStatement2<T1, T2>.fetch(): QueryResult2<T1, T2> = QueryResult2(c, this, this@Selects)

    operator fun <T1, T2, T3> Select.SELECT.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, block: SelectCreator) =  SelectStatement3(Column3(c1, c2, c3), SelectFromPart(c1, c2, c3).block().data)
    operator fun <T1, T2, T3> Select.SELECT.invoke(c: Column3<T1, T2, T3>, block: SelectCreator) =  SelectStatement3(c, SelectFromPart(c).block().data)
    fun <T1, T2, T3> SelectStatement3<T1, T2, T3>.fetch(): QueryResult3<T1, T2, T3> = QueryResult3(c, this, this@Selects)

    operator fun <T1, T2, T3, T4> Select.SELECT.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, block: SelectCreator) =  SelectStatement4(Column4(c1, c2, c3, c4), SelectFromPart(c1, c2, c3, c4).block().data)
    operator fun <T1, T2, T3, T4> Select.SELECT.invoke(c: Column4<T1, T2, T3, T4>, block: SelectCreator) =  SelectStatement4(c, SelectFromPart(c).block().data)
    fun <T1, T2, T3, T4> SelectStatement4<T1, T2, T3, T4>.fetch(): QueryResult4<T1, T2, T3, T4> = QueryResult4(c, this, this@Selects)

    operator fun <T1, T2, T3, T4, T5> Select.SELECT.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, block: SelectCreator) =  SelectStatement5(Column5(c1, c2, c3, c4, c5), SelectFromPart(c1, c2, c3, c4, c5).block().data)
    operator fun <T1, T2, T3, T4, T5> Select.SELECT.invoke(c: Column5<T1, T2, T3, T4, T5>, block: SelectCreator) =  SelectStatement5(c, SelectFromPart(c).block().data)
    fun <T1, T2, T3, T4, T5> SelectStatement5<T1, T2, T3, T4, T5>.fetch(): QueryResult5<T1, T2, T3, T4, T5> = QueryResult5(c, this, this@Selects)

    operator fun <T1, T2, T3, T4, T5, T6> Select.SELECT.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, block: SelectCreator) =  SelectStatement6(Column6(c1, c2, c3, c4, c5, c6), SelectFromPart(c1, c2, c3, c4, c5, c6).block().data)
    operator fun <T1, T2, T3, T4, T5, T6> Select.SELECT.invoke(c: Column6<T1, T2, T3, T4, T5, T6>, block: SelectCreator) =  SelectStatement6(c, SelectFromPart(c).block().data)
    fun <T1, T2, T3, T4, T5, T6> SelectStatement6<T1, T2, T3, T4, T5, T6>.fetch(): QueryResult6<T1, T2, T3, T4, T5, T6> = QueryResult6(c, this, this@Selects)

    operator fun <T1, T2, T3, T4, T5, T6, T7> Select.SELECT.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, block: SelectCreator) =  SelectStatement7(Column7(c1, c2, c3, c4, c5, c6, c7), SelectFromPart(c1, c2, c3, c4, c5, c6, c7).block().data)
    operator fun <T1, T2, T3, T4, T5, T6, T7> Select.SELECT.invoke(c: Column7<T1, T2, T3, T4, T5, T6, T7>, block: SelectCreator) =  SelectStatement7(c, SelectFromPart(c).block().data)
    fun <T1, T2, T3, T4, T5, T6, T7> SelectStatement7<T1, T2, T3, T4, T5, T6, T7>.fetch(): QueryResult7<T1, T2, T3, T4, T5, T6, T7> = QueryResult7(c, this, this@Selects)

    operator fun <T1, T2, T3, T4, T5, T6, T7, T8> Select.SELECT.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, block: SelectCreator) =  SelectStatement8(Column8(c1, c2, c3, c4, c5, c6, c7, c8), SelectFromPart(c1, c2, c3, c4, c5, c6, c7, c8).block().data)
    operator fun <T1, T2, T3, T4, T5, T6, T7, T8> Select.SELECT.invoke(c: Column8<T1, T2, T3, T4, T5, T6, T7, T8>, block: SelectCreator) =  SelectStatement8(c, SelectFromPart(c).block().data)
    fun <T1, T2, T3, T4, T5, T6, T7, T8> SelectStatement8<T1, T2, T3, T4, T5, T6, T7, T8>.fetch(): QueryResult8<T1, T2, T3, T4, T5, T6, T7, T8> = QueryResult8(c, this, this@Selects)

    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9> Select.SELECT.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, block: SelectCreator) =  SelectStatement9(Column9(c1, c2, c3, c4, c5, c6, c7, c8, c9), SelectFromPart(c1, c2, c3, c4, c5, c6, c7, c8, c9).block().data)
    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9> Select.SELECT.invoke(c: Column9<T1, T2, T3, T4, T5, T6, T7, T8, T9>, block: SelectCreator) =  SelectStatement9(c, SelectFromPart(c).block().data)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9> SelectStatement9<T1, T2, T3, T4, T5, T6, T7, T8, T9>.fetch(): QueryResult9<T1, T2, T3, T4, T5, T6, T7, T8, T9> = QueryResult9(c, this, this@Selects)

    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> Select.SELECT.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, block: SelectCreator) =  SelectStatement10(Column10(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10), SelectFromPart(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10).block().data)
    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> Select.SELECT.invoke(c: Column10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>, block: SelectCreator) =  SelectStatement10(c, SelectFromPart(c).block().data)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> SelectStatement10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>.fetch(): QueryResult10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> = QueryResult10(c, this, this@Selects)

    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> Select.SELECT.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, block: SelectCreator) =  SelectStatement11(Column11(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11), SelectFromPart(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11).block().data)
    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> Select.SELECT.invoke(c: Column11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>, block: SelectCreator) =  SelectStatement11(c, SelectFromPart(c).block().data)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> SelectStatement11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>.fetch(): QueryResult11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> = QueryResult11(c, this, this@Selects)

    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> Select.SELECT.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, block: SelectCreator) =  SelectStatement12(Column12(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12), SelectFromPart(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12).block().data)
    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> Select.SELECT.invoke(c: Column12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>, block: SelectCreator) =  SelectStatement12(c, SelectFromPart(c).block().data)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> SelectStatement12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>.fetch(): QueryResult12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> = QueryResult12(c, this, this@Selects)

    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> Select.SELECT.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, block: SelectCreator) =  SelectStatement13(Column13(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13), SelectFromPart(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13).block().data)
    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> Select.SELECT.invoke(c: Column13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>, block: SelectCreator) =  SelectStatement13(c, SelectFromPart(c).block().data)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> SelectStatement13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>.fetch(): QueryResult13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> = QueryResult13(c, this, this@Selects)

    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> Select.SELECT.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>, block: SelectCreator) =  SelectStatement14(Column14(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14), SelectFromPart(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14).block().data)
    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> Select.SELECT.invoke(c: Column14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>, block: SelectCreator) =  SelectStatement14(c, SelectFromPart(c).block().data)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> SelectStatement14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>.fetch(): QueryResult14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> = QueryResult14(c, this, this@Selects)

    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> Select.SELECT.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>, c15: Column<T15>, block: SelectCreator) =  SelectStatement15(Column15(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15), SelectFromPart(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15).block().data)
    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> Select.SELECT.invoke(c: Column15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>, block: SelectCreator) =  SelectStatement15(c, SelectFromPart(c).block().data)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> SelectStatement15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>.fetch(): QueryResult15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> = QueryResult15(c, this, this@Selects)

    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> Select.SELECT.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>, c15: Column<T15>, c16: Column<T16>, block: SelectCreator) =  SelectStatement16(Column16(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16), SelectFromPart(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16).block().data)
    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> Select.SELECT.invoke(c: Column16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>, block: SelectCreator) =  SelectStatement16(c, SelectFromPart(c).block().data)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> SelectStatement16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>.fetch(): QueryResult16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> = QueryResult16(c, this, this@Selects)

    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> Select.SELECT.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>, c15: Column<T15>, c16: Column<T16>, c17: Column<T17>, block: SelectCreator) =  SelectStatement17(Column17(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17), SelectFromPart(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17).block().data)
    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> Select.SELECT.invoke(c: Column17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>, block: SelectCreator) =  SelectStatement17(c, SelectFromPart(c).block().data)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> SelectStatement17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>.fetch(): QueryResult17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> = QueryResult17(c, this, this@Selects)

    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> Select.SELECT.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>, c15: Column<T15>, c16: Column<T16>, c17: Column<T17>, c18: Column<T18>, block: SelectCreator) =  SelectStatement18(Column18(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18), SelectFromPart(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18).block().data)
    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> Select.SELECT.invoke(c: Column18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>, block: SelectCreator) =  SelectStatement18(c, SelectFromPart(c).block().data)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> SelectStatement18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>.fetch(): QueryResult18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> = QueryResult18(c, this, this@Selects)

    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> Select.SELECT.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>, c15: Column<T15>, c16: Column<T16>, c17: Column<T17>, c18: Column<T18>, c19: Column<T19>, block: SelectCreator) =  SelectStatement19(Column19(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19), SelectFromPart(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19).block().data)
    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> Select.SELECT.invoke(c: Column19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>, block: SelectCreator) =  SelectStatement19(c, SelectFromPart(c).block().data)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> SelectStatement19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>.fetch(): QueryResult19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> = QueryResult19(c, this, this@Selects)

    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> Select.SELECT.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>, c15: Column<T15>, c16: Column<T16>, c17: Column<T17>, c18: Column<T18>, c19: Column<T19>, c20: Column<T20>, block: SelectCreator) =  SelectStatement20(Column20(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20), SelectFromPart(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20).block().data)
    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> Select.SELECT.invoke(c: Column20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>, block: SelectCreator) =  SelectStatement20(c, SelectFromPart(c).block().data)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> SelectStatement20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>.fetch(): QueryResult20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> = QueryResult20(c, this, this@Selects)

    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> Select.SELECT.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>, c15: Column<T15>, c16: Column<T16>, c17: Column<T17>, c18: Column<T18>, c19: Column<T19>, c20: Column<T20>, c21: Column<T21>, block: SelectCreator) =  SelectStatement21(Column21(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21), SelectFromPart(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21).block().data)
    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> Select.SELECT.invoke(c: Column21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>, block: SelectCreator) =  SelectStatement21(c, SelectFromPart(c).block().data)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> SelectStatement21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>.fetch(): QueryResult21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> = QueryResult21(c, this, this@Selects)

    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> Select.SELECT.invoke(c1: Column<T1>, c2: Column<T2>, c3: Column<T3>, c4: Column<T4>, c5: Column<T5>, c6: Column<T6>, c7: Column<T7>, c8: Column<T8>, c9: Column<T9>, c10: Column<T10>, c11: Column<T11>, c12: Column<T12>, c13: Column<T13>, c14: Column<T14>, c15: Column<T15>, c16: Column<T16>, c17: Column<T17>, c18: Column<T18>, c19: Column<T19>, c20: Column<T20>, c21: Column<T21>, c22: Column<T22>, block: SelectCreator) =  SelectStatement22(Column22(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21, c22), SelectFromPart(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21, c22).block().data)
    operator fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> Select.SELECT.invoke(c: Column22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>, block: SelectCreator) =  SelectStatement22(c, SelectFromPart(c).block().data)
    fun <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> SelectStatement22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>.fetch(): QueryResult22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> = QueryResult22(c, this, this@Selects)
}
