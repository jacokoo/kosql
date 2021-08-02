package com.github.jacokoo.kosql.demo.pg.vertx.java.kosql;

public interface Copyable<T> {
    T copy(CopyBlock<T> fn);

    @FunctionalInterface
    interface CopyBlock<T> {
        void copy(T t);
    }
}
