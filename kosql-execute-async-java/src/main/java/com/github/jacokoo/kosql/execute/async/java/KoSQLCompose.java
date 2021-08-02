package com.github.jacokoo.kosql.execute.async.java;

import com.github.jacokoo.kosql.execute.async.java.compose.Compose;

public interface KoSQLCompose extends Compose {
    default <T, U> U USE(T t, Use1<T, U> fn) {
        return fn.use(t);
    }

    default <T, T2, U> U USE(T t1, T2 t2, Use2<T, T2, U> fn) {
        return fn.use(t1, t2);
    }

    default <T, T2, T3, U> U USE(T t1, T2 t2, T3 t3, Use3<T, T2, T3, U> fn) {
        return fn.use(t1, t2, t3);
    }

    default <T, T2, T3, T4, U> U USE(T t1, T2 t2, T3 t3, T4 t4, Use4<T, T2, T3, T4, U> fn) {
        return fn.use(t1, t2, t3, t4);
    }

    default <T, T2, T3, T4, T5, U> U USE(T t1, T2 t2, T3 t3, T4 t4, T5 t5, Use5<T, T2, T3, T4, T5, U> fn) {
        return fn.use(t1, t2, t3, t4, t5);
    }

    default <T, T2, T3, T4, T5, T6, U> U USE(T t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, Use6<T, T2, T3, T4, T5, T6, U> fn) {
        return fn.use(t1, t2, t3, t4, t5, t6);
    }

    default <T, T2, T3, T4, T5, T6, T7, U> U USE(T t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, Use7<T, T2, T3, T4, T5, T6, T7, U> fn) {
        return fn.use(t1, t2, t3, t4, t5, t6, t7);
    }

    default <T, T2, T3, T4, T5, T6, T7, T8, U> U USE(T t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, Use8<T, T2, T3, T4, T5, T6, T7, T8, U> fn) {
        return fn.use(t1, t2, t3, t4, t5, t6, t7, t8);
    }

    default <T, T2, T3, T4, T5, T6, T7, T8, T9, U> U USE(T t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9, Use9<T, T2, T3, T4, T5, T6, T7, T8, T9, U> fn) {
        return fn.use(t1, t2, t3, t4, t5, t6, t7, t8, t9);
    }

    default <T, T2, T3, T4, T5, T6, T7, T8, T9, T0, U> U USE(T t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9, T0 t10, Use10<T, T2, T3, T4, T5, T6, T7, T8, T9, T0, U> fn) {
        return fn.use(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10);
    }

    @FunctionalInterface
    public interface Use1<T, U> {
        U use(T t);
    }

    @FunctionalInterface
    public interface Use2<T, T2, U> {
        U use(T t1, T2 t2);
    }

    @FunctionalInterface
    public interface Use3<T, T2, T3, U> {
        U use(T t1, T2 t2, T3 t3);
    }

    @FunctionalInterface
    public interface Use4<T, T2, T3, T4, U> {
        U use(T t1, T2 t2, T3 t3, T4 t4);
    }

    @FunctionalInterface
    public interface Use5<T, T2, T3, T4, T5, U> {
        U use(T t1, T2 t2, T3 t3, T4 t4, T5 t5);
    }

    @FunctionalInterface
    public interface Use6<T, T2, T3, T4, T5, T6, U> {
        U use(T t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6);
    }

    @FunctionalInterface
    public interface Use7<T, T2, T3, T4, T5, T6, T7, U> {
        U use(T t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7);
    }

    @FunctionalInterface
    public interface Use8<T, T2, T3, T4, T5, T6, T7, T8, U> {
        U use(T t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8);
    }

    @FunctionalInterface
    public interface Use9<T, T2, T3, T4, T5, T6, T7, T8, T9, U> {
        U use(T t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9);
    }

    @FunctionalInterface
    public interface Use10<T, T2, T3, T4, T5, T6, T7, T8, T9, T0, U> {
        U use(T t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9, T0 t10);
    }
}
