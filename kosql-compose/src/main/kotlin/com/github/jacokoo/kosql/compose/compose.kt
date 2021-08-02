package com.github.jacokoo.kosql.compose

import com.github.jacokoo.kosql.compose.expression.*
import com.github.jacokoo.kosql.compose.statement.Delete
import com.github.jacokoo.kosql.compose.statement.Insert
import com.github.jacokoo.kosql.compose.statement.Update
import com.github.jacokoo.kosql.compose.typesafe.Inserts
import com.github.jacokoo.kosql.compose.typesafe.Selects
import java.math.BigDecimal

abstract class Compose: Operator, Selects, Inserts, Update, Delete, Functions {
    val TRUE = Exp.TRUE
    val INSERT = Insert.INSERT
    val DELETE = Delete.DELETE
}
