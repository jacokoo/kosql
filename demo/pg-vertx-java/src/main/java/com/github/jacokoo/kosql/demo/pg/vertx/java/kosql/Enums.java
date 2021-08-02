package com.github.jacokoo.kosql.demo.pg.vertx.java.kosql;

import com.github.jacokoo.kosql.compose.type.DataType;
import com.github.jacokoo.kosql.demo.pg.vertx.java.entity.UserStatus;

import java.util.Arrays;

public class Enums {

    public static abstract class IntEnumType<T extends Enum<?>> implements DataType<T> {
        public abstract Class<T> getClazz();

        public T fromDb(Object o) {
            if (o == null) return getNullValue();
            int idx = 0;
            if (o instanceof Short) idx = (Short)o;
            else if (o instanceof Byte) idx = (Byte)o;
            else idx = (Integer)o;
            return getClazz().getEnumConstants()[idx];
        }

        public Object toDb(Object o) {
            if (o != null) {
                var enums = getClazz().getEnumConstants();
                for (var i = 0; i < enums.length; i ++) {
                    if (o == enums[i]) return i;
                }
            }
            return null;
        }
    }

    public static class UserStatusEnumType extends IntEnumType<UserStatus> {
        @Override
        public Class<UserStatus> getClazz() {
            return UserStatus.class;
        }

        @Override
        public UserStatus getNullValue() {
            return UserStatus.Normal;
        }
    }
}
