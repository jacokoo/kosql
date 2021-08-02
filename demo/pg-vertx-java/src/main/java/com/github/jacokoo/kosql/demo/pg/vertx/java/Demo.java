package com.github.jacokoo.kosql.demo.pg.vertx.java;

import com.github.jacokoo.kosql.demo.pg.vertx.java.entity.User;
import com.github.jacokoo.kosql.demo.pg.vertx.java.entity.UserStatus;
import com.github.jacokoo.kosql.execute.async.java.KoSQL;
import com.github.jacokoo.kosql.execute.async.java.KoSQLCompose;

import static com.github.jacokoo.kosql.demo.pg.vertx.java.kosql.UserBase.USER;

public class Demo implements KoSQLCompose {
    private KoSQL kosql;

    void demo() {
        kosql.run(ko -> USE(USER, u ->
            ko.query(SELECT(u).FROM(u).WHERE(u.ID).EQ(10L))
                .fetch(u)
                .compose(users -> {
                    System.out.println(users);
                    return ko.query1(SELECT(count()).FROM(u)).fetchValue();
                })
        )).onSuccess(System.out::println);

        var u = new User();

        var u2 = u.copy(it -> {
            it.setId(10L);
        });

        kosql.tx(ko -> {
            ko.save(u);
            ko.save(u2).map(it -> {
                System.out.println(it);
                return it;
            });

            ko.execute(DELETE_FROM(USER).WHERE(USER.ID).EQ(10L));

            return ko.execute(UPDATE(USER).SET(it -> {
                it.set(USER.STATUS, UserStatus.Disabled);
            }).WHERE(USER.ID).EQ(10L));
        });
    }
}
