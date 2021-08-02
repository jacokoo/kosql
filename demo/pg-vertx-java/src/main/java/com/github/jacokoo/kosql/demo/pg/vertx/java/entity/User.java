package com.github.jacokoo.kosql.demo.pg.vertx.java.entity;

import com.github.jacokoo.kosql.demo.pg.vertx.java.kosql.Copyable;
import com.github.jacokoo.kosql.demo.pg.vertx.java.kosql.UserBase;

public class User extends UserBase implements Copyable<User> {

    public User() {}
    public User(User other) {
        super(other);
    }

    @Override
    public User copy(CopyBlock<User> fn) {
        User n = new User(this);
        fn.copy(n);
        return n;
    }
}
