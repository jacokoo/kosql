package com.github.jacokoo.kosql.test

import com.github.jacokoo.kosql.compose.statements.*
import com.github.jacokoo.kosql.compose.typesafe.Selects
import com.github.jacokoo.kosql.test.kosql.ORDER
import com.github.jacokoo.kosql.test.kosql.ORDER_ITEM
import com.github.jacokoo.kosql.test.kosql.SUPPORT_TYPE
import io.kotlintest.matchers.beInstanceOf
import io.kotlintest.should
import io.kotlintest.shouldFail
import io.kotlintest.specs.FreeSpec

class SelectTest: Selects, FreeSpec() { init {
    "Select Syntax" - {
        "FROM after SELECT" {
            val query = SELECT(SUPPORT_TYPE.ID)
            query should beInstanceOf<SelectFromOperate<*>>()
            shouldFail { query should beInstanceOf(SelectStatement::class) }
        }

        "JOIN, WHERE, GROUP BY, ORDER BY, LIMIT after FROM" {
            val from = SELECT(-SUPPORT_TYPE) FROM SUPPORT_TYPE
            from should beInstanceOf<SelectStatement<*>>()
            from should beInstanceOf<SelectJoinOperate<*>>()
            from should beInstanceOf<SelectWhereOperate<*>>()
            from should beInstanceOf<GroupByOperate<*>>()
            from should beInstanceOf<LimitOperate<*>>()
            from should beInstanceOf<OrderByOperate<*>>()
        }

        "ON is required after JOIN" {
            val s = SELECT(-ORDER) FROM ORDER LEFT_JOIN ORDER_ITEM
            s should beInstanceOf<JoinOnPart<*, *>>()
            shouldFail { s should beInstanceOf(SelectWhereOperate::class) }
            shouldFail { s should beInstanceOf(SelectStatement::class) }
        }

        "JOIN, WHERE, GROUP BY, ORDER BY, LIMIT after JOIN ON" {
            val query = SELECT(-ORDER) FROM ORDER LEFT_JOIN ORDER_ITEM ON ORDER.ID EQ ORDER_ITEM.ORDER_ID
            query should beInstanceOf<SelectStatement<*>>()
            query should beInstanceOf<SelectJoinOperate<*>>()
            query should beInstanceOf<SelectWhereOperate<*>>()
            query should beInstanceOf<GroupByOperate<*>>()
            query should beInstanceOf<LimitOperate<*>>()
            query should beInstanceOf<OrderByOperate<*>>()
        }

        "GROUP BY, ORDER BY, LIMIT after WHERE" {
            val query = SELECT(-ORDER) FROM ORDER WHERE ORDER.ID EQ 1
            query should beInstanceOf<SelectStatement<*>>()
            query should beInstanceOf<GroupByOperate<*>>()
            query should beInstanceOf<LimitOperate<*>>()
            query should beInstanceOf<OrderByOperate<*>>()
        }

        "HAVING, ORDER BY, LIMIT after GROUP BY" {
            val query = SELECT(-ORDER) FROM ORDER GROUP_BY ORDER.ID AND ORDER.CUSTOMER_ID
            query should beInstanceOf<SelectStatement<*>>()
            query should beInstanceOf<LimitOperate<*>>()
            query should beInstanceOf<OrderByOperate<*>>()
            query should beInstanceOf<GroupByMorePart<*>>()
        }

        "ORDER BY, LIMIT after HAVING" {
            val query = SELECT(-ORDER) FROM ORDER GROUP_BY ORDER.ID HAVING ORDER.ID EQ 1
            query should beInstanceOf<SelectStatement<*>>()
            query should beInstanceOf<LimitOperate<*>>()
            query should beInstanceOf<OrderByOperate<*>>()
        }

        "LIMIT after ORDER BY" {
            val query = SELECT(-ORDER) FROM ORDER ORDER_BY ORDER.ID.ASC() AND ORDER.CUSTOMER_ID.DESC()
            query should beInstanceOf<SelectStatement<*>>()
            query should beInstanceOf<LimitOperate<*>>()
        }

        "terminate after LIMIT" {
            val query = SELECT(-ORDER) FROM ORDER LIMIT 10 OFFSET 200
            query should beInstanceOf<SelectStatement<*>>()
            query should beInstanceOf<SelectEnd<*>>()
        }
    }
}}
