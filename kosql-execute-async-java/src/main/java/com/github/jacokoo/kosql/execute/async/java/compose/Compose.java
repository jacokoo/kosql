package com.github.jacokoo.kosql.execute.async.java.compose;

import com.github.jacokoo.kosql.compose.expression.Exp;
import com.github.jacokoo.kosql.compose.expression.Functions;
import com.github.jacokoo.kosql.compose.expression.Operator;
import com.github.jacokoo.kosql.compose.typesafe.Selects;

public interface Compose extends Operator, Selects, Insert, Update, Delete, Functions {
    Exp<?> TRUE = Exp.Companion.getTRUE();
}
