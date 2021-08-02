package com.github.jacokoo.kosql.pg.vertx.java;

import com.github.jacokoo.kosql.build.pg.PostgresBuilder;
import com.github.jacokoo.kosql.build.pg.PostgresContext;
import com.github.jacokoo.kosql.compose.Entity;
import com.github.jacokoo.kosql.compose.InnerTable;
import com.github.jacokoo.kosql.execute.async.java.KoSQL;
import io.vertx.core.Future;
import io.vertx.pgclient.PgPool;
import io.vertx.sqlclient.Row;
import io.vertx.sqlclient.RowSet;
import io.vertx.sqlclient.SqlClient;
import io.vertx.sqlclient.SqlConnection;

public class PostgresKoSQL extends KoSQL {
    public PostgresKoSQL(PgPool pool) {
        super(pool, new PostgresBuilder(), (it) -> new PostgresContext());
    }

    @Override
    protected Future<SqlConnection> openConnection(SqlClient client) {
        return ((PgPool)client).getConnection();
    }

    @Override
    protected <T, R extends Entity<T>> T getGeneratedKey(RowSet<Row> row, InnerTable<T, R> table) {
        var key = table.primaryKey();
        var value = row.iterator().next().getValue(key.getName());
        return key.getType().fromDb(value);
    }
}
