package com.github.jacokoo.kosql.execute.async.java;

import com.github.jacokoo.kosql.compose.Entity;
import com.github.jacokoo.kosql.compose.Table;
import com.github.jacokoo.kosql.compose.result.Mapper;
import com.github.jacokoo.kosql.compose.statement.*;
import com.github.jacokoo.kosql.compose.typesafe.*;
import io.vertx.core.Future;
import kotlin.Pair;

import java.util.List;

import static com.github.jacokoo.kosql.execute.async.java.Query.*;

public interface Executor {
    <K, T extends Table<K, ? extends Entity<K>>> Future<Integer> execute(UpdateStatement<K, T> update);

    Future<Integer> execute(DeleteStatement delete);

    <T> Future<Pair<T, Integer>> execute(InsertStatement<T> insert);

    <T> Future<Integer> execute(BatchInsertStatement<T> insert);

    <T, C extends ColumnList> Future<List<T>> execute(SelectStatement<C> select, Mapper<T> mapper);

    default <C extends ColumnList> Query<C> query(SelectStatement<C> select) {
        return new Query<>(this, select);
    }

    default <T1> Query1<T1> query1(SelectStatement<Column1<T1>> select) {
        return new Query1<>(this, select);
    }

    default <T1, T2> Query2<T1, T2> query2(SelectStatement<Column2<T1, T2>> select) {
        return new Query2<>(this, select);
    }

    default <T1, T2, T3> Query3<T1, T2, T3> query3(SelectStatement<Column3<T1, T2, T3>> select) {
        return new Query3<>(this, select);
    }

    default <T1, T2, T3, T4> Query4<T1, T2, T3, T4> query4(SelectStatement<Column4<T1, T2, T3, T4>> select) {
        return new Query4<>(this, select);
    }

    default <T1, T2, T3, T4, T5> Query5<T1, T2, T3, T4, T5> query5(SelectStatement<Column5<T1, T2, T3, T4, T5>> select) {
        return new Query5<>(this, select);
    }

    default <T1, T2, T3, T4, T5, T6> Query6<T1, T2, T3, T4, T5, T6> query6(SelectStatement<Column6<T1, T2, T3, T4, T5, T6>> select) {
        return new Query6<>(this, select);
    }

    default <T1, T2, T3, T4, T5, T6, T7> Query7<T1, T2, T3, T4, T5, T6, T7> query7(SelectStatement<Column7<T1, T2, T3, T4, T5, T6, T7>> select) {
        return new Query7<>(this, select);
    }

    default <T1, T2, T3, T4, T5, T6, T7, T8> Query8<T1, T2, T3, T4, T5, T6, T7, T8> query8(SelectStatement<Column8<T1, T2, T3, T4, T5, T6, T7, T8>> select) {
        return new Query8<>(this, select);
    }

    default <T1, T2, T3, T4, T5, T6, T7, T8, T9> Query9<T1, T2, T3, T4, T5, T6, T7, T8, T9> query9(SelectStatement<Column9<T1, T2, T3, T4, T5, T6, T7, T8, T9>> select) {
        return new Query9<>(this, select);
    }

    default <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> Query10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> query10(SelectStatement<Column10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>> select) {
        return new Query10<>(this, select);
    }
}
