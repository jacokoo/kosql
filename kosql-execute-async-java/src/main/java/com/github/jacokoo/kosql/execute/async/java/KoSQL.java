package com.github.jacokoo.kosql.execute.async.java;

import com.github.jacokoo.kosql.build.BuildResult;
import com.github.jacokoo.kosql.build.Builder;
import com.github.jacokoo.kosql.build.Context;
import com.github.jacokoo.kosql.compose.Entity;
import com.github.jacokoo.kosql.compose.InnerTable;
import com.github.jacokoo.kosql.compose.Table;
import com.github.jacokoo.kosql.compose.result.Mapper;
import com.github.jacokoo.kosql.compose.statement.*;
import io.vertx.core.Future;
import io.vertx.sqlclient.*;
import kotlin.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class KoSQL {
    private static final Logger LOG = LoggerFactory.getLogger(KoSQL.class);

    private final ContextFactory factory;
    private final SqlClient client;
    private final Builder builder;

    public KoSQL(SqlClient client, Builder builder, ContextFactory factory) {
        this.client = client;
        this.builder = builder;
        this.factory = factory;
    }

    public <T> Future<T> run(WithInnerKoSQL<T> fn) {
        return openConnection(client).compose(conn ->
            fn.with(new InnerKoSQL(conn)).eventually(it -> conn.close())
        );
    }

    public <T> Future<T> tx(WithInnerKoSQL<T> fn) {
        return openConnection(client).compose(conn ->
            new InnerKoSQL(conn).tx(fn).eventually(it -> conn.close())
        );
    }

    private void closeConnection(SqlConnection conn) {
        conn.close().onFailure(it -> LOG.error("Failed to close connection", it));
    }

    protected abstract Future<SqlConnection> openConnection(SqlClient client);
    protected abstract <T, R extends Entity<T>> T getGeneratedKey(RowSet<Row> row, InnerTable<T, R> table);

    @FunctionalInterface
    public interface ContextFactory {
        Context create(Builder builder);
    }

    @FunctionalInterface
    public interface WithInnerKoSQL<T> {
        Future<T> with(InnerKoSQL ko);
    }

    public class InnerKoSQL implements Dao {
        private final SqlConnection connection;
        private boolean started = false;

        private InnerKoSQL(SqlConnection connection) {
            this.connection = connection;
        }

        private <T> Future<T> tx(WithInnerKoSQL<T> fn) {
            if (started) return fn.with(this);

            return connection.begin().compose(tx ->
                fn.with(this)
                    .onFailure(it -> tx.rollback())
                    .compose(it -> tx.commit().map(it))
            ).onComplete(it -> started = false);
        }

        @Override
        public <K, T extends Table<K, ? extends Entity<K>>> Future<Integer> execute(UpdateStatement<K, T> update) {
            var result = builder.build(update, factory.create(builder));
            return execute(result).map(SqlResult::rowCount);
        }

        @Override
        public Future<Integer> execute(DeleteStatement delete) {
            var result = builder.build(delete, factory.create(builder));
            return execute(result).map(SqlResult::rowCount);
        }

        @Override
        public <T> Future<Pair<T, Integer>> execute(InsertStatement<T> insert) {
            var result = builder.build(insert, factory.create(builder));
            return execute(result).map(rs -> {
                var pk = insert.getData().getTable().primaryKey();
                var key = pk.getType().getNullValue();
                if (pk.getAutoIncrement()) {
                    key = pk.getType().fromDb(getGeneratedKey(rs, insert.getData().getTable()));
                }
                return new Pair<>(key, rs.rowCount());
            });
        }

        @Override
        public <T> Future<Integer> execute(BatchInsertStatement<T> insert) {
            var result = builder.build(insert, factory.create(builder));
            return prepare(result).compose(st ->{
                var params = result.getParams().stream()
                    .map(it -> Tuple.from((List<?>)it))
                    .collect(Collectors.toList());

                return st.query().executeBatch(params)
                    .eventually(i -> st.close())
                    .map(SqlResult::rowCount);
            });
        }

        @Override
        public <T, C extends ColumnList> Future<List<T>> execute(SelectStatement<C> select, Mapper<T> mapper) {
            var result = builder.build(select, factory.create(builder));
            return prepare(result).compose(st ->
                st.query().execute(Tuple.tuple(result.getParams()))
                    .map(rows -> {
                        List<T> list = new ArrayList<>();
                        for (var row : rows) {
                            var cs = select.getData().getColumns();
                            var source = new com.github.jacokoo.kosql.compose.result.Row(row::getValue, select.getData().getColumns());
                            list.add(mapper.map(source));
                        }
                        return list;
                    })
                    .eventually(i -> st.close())
            );
        }

        private Future<PreparedStatement> prepare(BuildResult result) {
            if (LOG.isDebugEnabled()) {
                var args = result.getParams().stream().map(Object::toString).collect(Collectors.joining(", "));
                LOG.debug("execute: \nSQL: {} \nwith params: {}", result.getSql(), args);
            }
            return connection.prepare(result.getSql());
        }

        private Future<RowSet<Row>> execute(BuildResult result) {
            return prepare(result).compose(st ->
                st.query()
                    .execute(Tuple.tuple(result.getParams()))
                    .eventually(t -> st.close())
            );
        }
    }
}
