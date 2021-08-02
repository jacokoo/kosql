package com.github.jacokoo.kosql.execute.async.java.compose;

import com.github.jacokoo.kosql.compose.Column;
import com.github.jacokoo.kosql.compose.Entity;
import com.github.jacokoo.kosql.compose.Table;
import com.github.jacokoo.kosql.compose.statement.Columns;
import com.github.jacokoo.kosql.compose.statement.Fields;
import com.github.jacokoo.kosql.compose.typesafe.*;

import java.util.Arrays;
import java.util.List;

public interface Insert extends ValueSupport {

    default <K, T extends Table<K, ? extends Entity<K>>> Fields<K> INSERT_INTO(T table, Column<?>...columns) {
        return new Fields<>(table, new Columns(Arrays.asList(columns)));
    }

    default <K, T extends Table<K, ? extends Entity<K>>, T1> Field1<K, T1> INSERT_INTO(T table, Column<T1> col) {
        return new Field1<>(table, new Column1<>(col, List.of(col)));
    }

    default <K, T extends Table<K, ? extends Entity<K>>, T1, T2> Field2<K, T1, T2> INSERT_INTO(T table, Column<T1> c1, Column<T2> c2) {
        return new Field2<>(table, new Column2<>(c1, c2, List.of(c1, c2)));
    }

    default <K, T extends Table<K, ? extends Entity<K>>, T1, T2, T3> Field3<K, T1, T2, T3> INSERT_INTO(T table, Column<T1> c1, Column<T2> c2, Column<T3> c3) {
        return new Field3<>(table, new Column3<>(c1, c2, c3, List.of(c1, c2, c3)));
    }

    default <K, T extends Table<K, ? extends Entity<K>>, T1, T2, T3, T4> Field4<K, T1, T2, T3, T4> INSERT_INTO(T table, Column<T1> c1, Column<T2> c2, Column<T3> c3, Column<T4> c4) {
        return new Field4<>(table, new Column4<>(c1, c2, c3, c4, List.of(c1, c2, c3, c4)));
    }

    default <K, T extends Table<K, ? extends Entity<K>>, T1, T2, T3, T4, T5> Field5<K, T1, T2, T3, T4, T5> INSERT_INTO(T table, Column<T1> c1, Column<T2> c2, Column<T3> c3, Column<T4> c4, Column<T5> c5) {
        return new Field5<>(table, new Column5<>(c1, c2, c3, c4, c5, List.of(c1, c2, c3, c4, c5)));
    }

    default <K, T extends Table<K, ? extends Entity<K>>, T1, T2, T3, T4, T5, T6> Field6<K, T1, T2, T3, T4, T5, T6> INSERT_INTO(T table, Column<T1> c1, Column<T2> c2, Column<T3> c3, Column<T4> c4, Column<T5> c5, Column<T6> c6) {
        return new Field6<>(table, new Column6<>(c1, c2, c3, c4, c5, c6, List.of(c1, c2, c3, c4, c5, c6)));
    }

    default <K, T extends Table<K, ? extends Entity<K>>, T1, T2, T3, T4, T5, T6, T7> Field7<K, T1, T2, T3, T4, T5, T6, T7> INSERT_INTO(T table, Column<T1> c1, Column<T2> c2, Column<T3> c3, Column<T4> c4, Column<T5> c5, Column<T6> c6, Column<T7> c7) {
        return new Field7<>(table, new Column7<>(c1, c2, c3, c4, c5, c6, c7, List.of(c1, c2, c3, c4, c5, c6, c7)));
    }

    default <K, T extends Table<K, ? extends Entity<K>>, T1, T2, T3, T4, T5, T6, T7, T8> Field8<K, T1, T2, T3, T4, T5, T6, T7, T8> INSERT_INTO(T table, Column<T1> c1, Column<T2> c2, Column<T3> c3, Column<T4> c4, Column<T5> c5, Column<T6> c6, Column<T7> c7, Column<T8> c8) {
        return new Field8<>(table, new Column8<>(c1, c2, c3, c4, c5, c6, c7, c8, List.of(c1, c2, c3, c4, c5, c6, c7, c8)));
    }

    default <K, T extends Table<K, ? extends Entity<K>>, T1, T2, T3, T4, T5, T6, T7, T8, T9> Field9<K, T1, T2, T3, T4, T5, T6, T7, T8, T9> INSERT_INTO(T table, Column<T1> c1, Column<T2> c2, Column<T3> c3, Column<T4> c4, Column<T5> c5, Column<T6> c6, Column<T7> c7, Column<T8> c8, Column<T9> c9) {
        return new Field9<>(table, new Column9<>(c1, c2, c3, c4, c5, c6, c7, c8, c9, List.of(c1, c2, c3, c4, c5, c6, c7, c8, c9)));
    }

    default <K, T extends Table<K, ? extends Entity<K>>, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> Field10<K, T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> INSERT_INTO(T table, Column<T1> c1, Column<T2> c2, Column<T3> c3, Column<T4> c4, Column<T5> c5, Column<T6> c6, Column<T7> c7, Column<T8> c8, Column<T9> c9, Column<T10> c10) {
        return new Field10<>(table, new Column10<>(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, List.of(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10)));
    }
}
