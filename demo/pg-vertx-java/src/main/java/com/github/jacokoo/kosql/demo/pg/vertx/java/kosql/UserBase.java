package com.github.jacokoo.kosql.demo.pg.vertx.java.kosql;

import com.github.jacokoo.kosql.compose.Column;
import com.github.jacokoo.kosql.compose.Entity;
import com.github.jacokoo.kosql.compose.InnerTable;
import com.github.jacokoo.kosql.compose.Table;
import com.github.jacokoo.kosql.compose.type.LongType;
import com.github.jacokoo.kosql.compose.type.UUIDType;
import com.github.jacokoo.kosql.demo.pg.vertx.java.entity.User;
import com.github.jacokoo.kosql.demo.pg.vertx.java.entity.UserStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

import static com.github.jacokoo.kosql.compose.type.DatatypeKt.*;

public class UserBase implements Entity<Long> {
    private static final UserInnerTable INNER_USER = new UserInnerTable("");
    public static final UserTable USER = new UserTable(INNER_USER);

    private Long id = 0L;
    private UUID userId = ZERO_UUID;
    private UserStatus status = UserStatus.Normal;

    public UserBase() {}

    public UserBase(UserBase other) {
        this.id = other.id;
        this.userId = other.userId;
        this.status = other.status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    @Nullable
    @Override
    public Object get(@NotNull String name) {
        if (name.equals(INNER_USER.ID.getName())) return id;
        if (name.equals(INNER_USER.USER_ID.getName())) return userId;
        if (name.equals(INNER_USER.STATUS.getName())) return status;
        return null;
    }

    @Override
    public void set(@NotNull String name, @Nullable Object value) {
        if (name.equals(INNER_USER.ID.getName())) id = (Long)value;
        else if (name.equals(INNER_USER.USER_ID.getName())) userId = (UUID)value;
        else if (name.equals(INNER_USER.STATUS.getName())) status = (UserStatus)value;
    }

    @NotNull
    @Override
    public InnerTable<Long, ? extends Entity<Long>> innerTable() {
        return INNER_USER;
    }

    public static class UserInnerTable extends InnerTable<Long, User> {
        final Column<Long> ID = createPrimaryKey("f_id", new LongType(), true);
        final Column<UUID> USER_ID = createColumn("f_user_id", new UUIDType(), false, ZERO_UUID, false);
        final Column<UserStatus> STATUS = createColumn("f_status", new Enums.UserStatusEnumType(), false, UserStatus.Normal, false);

        private UserInnerTable(String alias) {
            super("t_user", alias == null ? "" : alias);
        }

        @Override
        public InnerTable<Long, ? extends User> AS(@NotNull String alias) {
            return new UserInnerTable(alias);
        }
    }

    public static class UserTable implements Table<Long, User> {
        private final UserInnerTable inner;
        public final Column<Long> ID;
        public final Column<UUID> USER_ID;
        public final Column<UserStatus> STATUS;

        public UserTable(UserInnerTable inner) {
            this.inner = inner;
            ID = inner.ID;
            USER_ID = inner.USER_ID;
            STATUS = inner.STATUS;
        }

        @Override
        public Table<Long, ? extends User> AS(@NotNull String alias) {
            return new UserTable((UserInnerTable)inner.AS(alias));
        }

        @NotNull
        @Override
        public InnerTable<Long, User> getInner() {
            return inner;
        }

        @NotNull
        @Override
        public User createEntity() {
            return new User();
        }

        @NotNull
        @Override
        public Column<Long> primaryKey() {
            return ID;
        }
    }
}
