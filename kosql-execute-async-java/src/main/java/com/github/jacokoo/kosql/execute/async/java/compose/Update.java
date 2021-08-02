package com.github.jacokoo.kosql.execute.async.java.compose;

import com.github.jacokoo.kosql.compose.Entity;
import com.github.jacokoo.kosql.compose.Table;
import com.github.jacokoo.kosql.compose.statement.*;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

public interface Update {

    default <K, T extends Table<K, ? extends Entity<K>>> SetPart<K, T> UPDATE(T table) {
        return new SetPart<>(new UpdateData<>(table, List.of(), Map.of(), null));
    }

    @FunctionalInterface
    interface UpdateCollectFunction {
        void collect(UpdateCollector collector);
    }

    interface SetOperate<K, T extends Table<K, ? extends Entity<K>>> extends UpdateStatement<K, T> {
        default UpdateWherePart<K, T> SET(UpdateCollectFunction fn) {
            var collector = new UpdateCollector();
            fn.collect(collector);
            var data = getData();
            return new UpdateWherePart<>(new UpdateData<>(data.getTable(), data.getJoins(), collector.getData(), null));
        }
    }

    class SetPart<K, T extends Table<K, ? extends Entity<K>>> implements SetOperate<K, T>, UpdateJoinOperate<K, T>, UpdateStatement<K, T> {
        private final UpdateData<K, T> data;

        public SetPart(UpdateData<K, T> data) {
            this.data = data;
        }

        @NotNull
        @Override
        public UpdateData<K, T> getData() {
            return data;
        }
    }
}
