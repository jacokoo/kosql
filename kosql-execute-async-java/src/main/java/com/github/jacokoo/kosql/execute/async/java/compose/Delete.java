package com.github.jacokoo.kosql.execute.async.java.compose;

import com.github.jacokoo.kosql.compose.Entity;
import com.github.jacokoo.kosql.compose.Table;
import com.github.jacokoo.kosql.compose.statement.DeleteData;
import com.github.jacokoo.kosql.compose.statement.DeleteFromPart;
import com.github.jacokoo.kosql.compose.statement.DeleteWherePart;

import java.util.Arrays;
import java.util.List;

public interface Delete {
    default DeleteFromPart DELETE(Table<?, ? extends Entity<?>>... tables) {
        return new DeleteFromPart(new DeleteData(Arrays.asList(tables), null, List.of(), null));
    }

    default DeleteWherePart DELETE_FROM(Table<?, ? extends Entity<?>> table) {
        return new DeleteWherePart(new DeleteData(List.of(), table, List.of(), null));
    }
}
