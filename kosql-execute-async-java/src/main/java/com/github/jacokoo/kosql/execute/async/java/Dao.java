package com.github.jacokoo.kosql.execute.async.java;

import com.github.jacokoo.kosql.compose.Column;
import com.github.jacokoo.kosql.compose.Entity;
import com.github.jacokoo.kosql.compose.Order;
import com.github.jacokoo.kosql.compose.Table;
import com.github.jacokoo.kosql.compose.expression.Count;
import com.github.jacokoo.kosql.compose.expression.Exp;
import com.github.jacokoo.kosql.compose.expression.Operator;
import com.github.jacokoo.kosql.compose.statement.*;
import com.github.jacokoo.kosql.compose.typesafe.Column1;
import io.vertx.core.Future;
import kotlin.Pair;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public interface Dao extends Executor, Operator {

    /**
     * Insert an entity to db
     * @param entity the entity to be inserted
     * @param <T> primary key type
     * @return null if insert failed, otherwise the generated primary key value
     */
    default <T> Future<T> save(Entity<T> entity) {
        var table = entity.innerTable();
        var key = table.primaryKey();
        var columns = table.getColumns()
            .stream().filter(it -> !it.getAutoIncrement() || !it.getType().getNullValue().equals(entity.get(it.getName())))
            .collect(Collectors.toList());

        var values = new Values(columns.stream().map(it -> entity.get(it.getName())).collect(Collectors.toList()));
        var insert = new InsertData<>(table, new Columns(columns), List.of(values), null, false);
        return execute(new InsertEnd<>(insert)).map(it -> {
            // consider throw an exception here
            if (it.getSecond() != 1) return null;
            if (key.getAutoIncrement()) entity.set(key.getName(), it.getFirst());
            return it.getFirst();
        });
    }

    /**
     * Retrieve data row by primary key
     * @param table the specified table
     * @param id primary key value
     * @return null if not found, otherwise the entity
     */
    default <T, E extends Entity<T>, R extends Table<T, E>> Future<E> byId(R table, T id) {
        var columns = new Columns(table.getInner().getColumns());
        var exp = EQ(table.primaryKey(), id);
        var data = new SelectData<>(columns, table, List.of(), exp, List.of(), null, List.of(), null, null);
        return query(new SelectEnd<>(data)).fetch(table).map(it -> it.isEmpty() ? null : it.get(0));
    }

    default <T, E extends Entity<T>, R extends Table<T, E>> Future<Integer> count(R table, Exp<?> exp) {
        var col = new Count<Object>("");
        var cs = new Column1<Integer>(col, List.of(col));
        var data = new SelectData<>(cs, table, List.of(), exp, List.of(), null, List.of(), null, null);
        return query1(new SelectEnd<>(data)).fetchValue();
    }

    default <T, E extends Entity<T>, R extends Table<T, E>> Future<List<E>> fetch(R table, Exp<?> exp, Pair<Column<?>, Order>...orders) {
        var cs = new Columns(table.getInner().getColumns());
        var data = new SelectData<>(cs, table, List.of(), exp, List.of(), null, Arrays.asList(orders), null, null);
        return query(new SelectEnd<>(data)).fetch(table);
    }

    default <T, E extends Entity<T>, R extends Table<T, E>> Future<Boolean> delete(R table, T key) {
        var data = new DeleteData(List.of(table), null, List.of(), EQ(table.primaryKey(), key));
        return execute(new DeleteEnd(data)).map(it -> it == 1);
    }

    default <T, E extends Entity<T>, R extends Table<T, E>> Future<Integer> delete(R table, Exp<?> exp) {
        var data = new DeleteData(List.of(table), null, List.of(), exp);
        return execute(new DeleteEnd(data));
    }
}
