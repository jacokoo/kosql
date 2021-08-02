package com.github.jacokoo.kosql.execute.async.java;

import com.github.jacokoo.kosql.compose.Entity;
import com.github.jacokoo.kosql.compose.Table;
import com.github.jacokoo.kosql.compose.result.Mapper;
import com.github.jacokoo.kosql.compose.result.Row;
import com.github.jacokoo.kosql.compose.statement.ColumnList;
import com.github.jacokoo.kosql.compose.statement.SelectStatement;
import com.github.jacokoo.kosql.compose.typesafe.*;
import io.vertx.core.Future;
import io.vertx.core.Promise;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Query<C extends ColumnList> {
    protected Executor executor;
    protected SelectStatement<C> statement;

    Query(Executor executor, SelectStatement<C> statement) {
        this.executor = executor;
        this.statement = statement;
    }

    public <T> Future<List<T>> fetch(Mapper<T> mapper) {
        return executor.execute(statement, mapper);
    }

    public <T, R extends Entity<T>> Future<List<R>> fetch(Table<T, R> table) {
        return executor.execute(statement, it -> {
            var data = it.into(table);
            if (data == null) {
                throw new RuntimeException("Can not fetch into the table, because:\n" +
                    "1. no column of the table is mentioned in select list\n" +
                    "2. there is a row in which all selected columns of the table are with a null value");
            }
            return data;
        });
    }

    public <T, R extends Entity<T>> Future<List<R>> fetch(Table<T, R> table, EntitySetter<T, R> setter) {
        var promise = Promise.<List<R>>promise();
        var key = table.primaryKey();
        var idx = statement.getData().getColumns().getColumns().indexOf(key);
        if (idx == -1) {
            throw new RuntimeException("To use this method, the primary key of the table must in select list");
        }

        executor.execute(statement, row -> row)
            .onSuccess(rows -> {
                var map = new LinkedHashMap<T, R>();
                for (var row: rows) {
                    var id = row.get(idx, key);
                    if (!map.containsKey(id)) {
                        map.put(id, row.into(table));
                    }
                    setter.set(map.get(id), row);
                }
                promise.complete(new ArrayList<>(map.values()));
            })
            .onFailure(promise::fail);

        return promise.future();
    }

    @FunctionalInterface
    public interface EntitySetter<T, R extends Entity<T>> {
        void set(R entity, Row row);
    }

    public static class Query1<T> extends Query<Column1<T>> {
        Query1(Executor executor, SelectStatement<Column1<T>> select) {
            super(executor, select);
        }

        public Future<Result1<T>> fetch() {
            return fetch(new Value1Mapper<>(statement.getData().getColumns()))
                .map(it -> new Result1<>(statement.getData().getColumns(), it));
        }

        public Future<T> fetchValue() {
            return fetch().map(it -> {
                if (!it.isEmpty()) {
                    return it.get(0).getV1();
                }
                throw new RuntimeException("Can not call fetchValue on a null value");
            });
        }
    }

    public static class Query2<T1, T2> extends Query<Column2<T1, T2>> {
        Query2(Executor executor, SelectStatement<Column2<T1, T2>> select) {
            super(executor, select);
        }

        public Future<Result2<T1, T2>> fetch() {
            return fetch(new Value2Mapper<>(statement.getData().getColumns()))
                .map(it -> new Result2<>(statement.getData().getColumns(), it));
        }
    }

    public static class Query3<T1, T2, T3> extends Query<Column3<T1, T2, T3>> {
        Query3(Executor executor, SelectStatement<Column3<T1, T2, T3>> select) {
            super(executor, select);
        }

        public Future<Result3<T1, T2, T3>> fetch() {
            return fetch(new Value3Mapper<>(statement.getData().getColumns()))
                .map(it -> new Result3<>(statement.getData().getColumns(), it));
        }
    }

    public static class Query4<T1, T2, T3, T4> extends Query<Column4<T1, T2, T3, T4>> {
        Query4(Executor executor, SelectStatement<Column4<T1, T2, T3, T4>> select) {
            super(executor, select);
        }

        public Future<Result4<T1, T2, T3, T4>> fetch() {
            return fetch(new Value4Mapper<>(statement.getData().getColumns()))
                .map(it -> new Result4<>(statement.getData().getColumns(), it));
        }
    }

    public static class Query5<T1, T2, T3, T4, T5> extends Query<Column5<T1, T2, T3, T4, T5>> {
        Query5(Executor executor, SelectStatement<Column5<T1, T2, T3, T4, T5>> select) {
            super(executor, select);
        }

        public Future<Result5<T1, T2, T3, T4, T5>> fetch() {
            return fetch(new Value5Mapper<>(statement.getData().getColumns()))
                .map(it -> new Result5<>(statement.getData().getColumns(), it));
        }
    }

    public static class Query6<T1, T2, T3, T4, T5, T6> extends Query<Column6<T1, T2, T3, T4, T5, T6>> {
        Query6(Executor executor, SelectStatement<Column6<T1, T2, T3, T4, T5, T6>> select) {
            super(executor, select);
        }

        public Future<Result6<T1, T2, T3, T4, T5, T6>> fetch() {
            return fetch(new Value6Mapper<>(statement.getData().getColumns()))
                .map(it -> new Result6<>(statement.getData().getColumns(), it));
        }
    }

    public static class Query7<T1, T2, T3, T4, T5, T6, T7> extends Query<Column7<T1, T2, T3, T4, T5, T6, T7>> {
        Query7(Executor executor, SelectStatement<Column7<T1, T2, T3, T4, T5, T6, T7>> select) {
            super(executor, select);
        }

        public Future<Result7<T1, T2, T3, T4, T5, T6, T7>> fetch() {
            return fetch(new Value7Mapper<>(statement.getData().getColumns()))
                .map(it -> new Result7<>(statement.getData().getColumns(), it));
        }
    }

    public static class Query8<T1, T2, T3, T4, T5, T6, T7, T8> extends Query<Column8<T1, T2, T3, T4, T5, T6, T7, T8>> {
        Query8(Executor executor, SelectStatement<Column8<T1, T2, T3, T4, T5, T6, T7, T8>> select) {
            super(executor, select);
        }

        public Future<Result8<T1, T2, T3, T4, T5, T6, T7, T8>> fetch() {
            return fetch(new Value8Mapper<>(statement.getData().getColumns()))
                .map(it -> new Result8<>(statement.getData().getColumns(), it));
        }
    }

    public static class Query9<T1, T2, T3, T4, T5, T6, T7, T8, T9> extends Query<Column9<T1, T2, T3, T4, T5, T6, T7, T8, T9>> {
        Query9(Executor executor, SelectStatement<Column9<T1, T2, T3, T4, T5, T6, T7, T8, T9>> select) {
            super(executor, select);
        }

        public Future<Result9<T1, T2, T3, T4, T5, T6, T7, T8, T9>> fetch() {
            return fetch(new Value9Mapper<>(statement.getData().getColumns()))
                .map(it -> new Result9<>(statement.getData().getColumns(), it));
        }
    }

    public static class Query10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> extends Query<Column10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>> {
        Query10(Executor executor, SelectStatement<Column10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>> select) {
            super(executor, select);
        }

        public Future<Result10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>> fetch() {
            return fetch(new Value10Mapper<>(statement.getData().getColumns()))
                .map(it -> new Result10<>(statement.getData().getColumns(), it));
        }
    }
}
