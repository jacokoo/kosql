package com.github.jacokoo.kosql.test
/*
import com.github.jacokoo.kosql.compose.statements.BatchInsertStatement
import com.github.jacokoo.kosql.compose.statements.Insert
import com.github.jacokoo.kosql.compose.statements.InsertStatement
import com.github.jacokoo.kosql.compose.typesafe.Field1
import com.github.jacokoo.kosql.compose.typesafe.Inserts
import com.github.jacokoo.kosql.compose.typesafe.Selects
import com.github.jacokoo.kosql.test.kosql.ORDER
import io.kotlintest.matchers.beInstanceOf
import io.kotlintest.should
import io.kotlintest.specs.FreeSpec

class InsertSyntaxTest: Inserts, Selects, FreeSpec() {
    val INSERT = Insert.INSERT
    init {

    "Insert Syntax" - {
        "insert and batch insert" {
            val part = INSERT INTO ORDER(ORDER.ID)
            part should beInstanceOf(Field1::class)

            val p2 = part VALUES V(1)
            p2 should beInstanceOf(InsertStatement::class)

            val p3 = p2 AND V(2)
            p3 should beInstanceOf(BatchInsertStatement::class)
        }

        "insert from query" {
            val part = INSERT INTO ORDER(ORDER.ID) FROM (SELECT(ORDER.ID) FROM ORDER)
        }
    }
}}
*/
