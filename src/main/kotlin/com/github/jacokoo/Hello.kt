package com.github.jacokoo

import com.github.jacokoo.demo.GROUP
import com.github.jacokoo.demo.USER
import com.github.jacokoo.demo.entity.User
import com.github.jacokoo.ksql.Query
import com.github.jacokoo.ksql.statements.SQLBuilder

fun main(args: Array<String>) {
    with(Query) {
        // select * from t_user
        SELECT(*USER()) FROM USER

        // select f_id, f_name from t_user where f_id = 1
        SELECT(USER.ID, USER.NAME) FROM USER WHERE (USER.ID EQ 1)

        // select u.f_id, g.f_name from t_user as u left join t_group as g where u.f_id = 1
        SELECT(USER.ID, GROUP.NAME) FROM USER LEFT_JOIN GROUP ON (USER.GROUP_ID EQ GROUP.ID) WHERE
                (USER.ID EQ 1)

        // select u.*, g.f_id from t_user u left join (
        //      select f_id, f_name from t_group where f_name like '%name%'
        // ) as g on u.f_group_id = g.f_id
        val g = (SELECT(GROUP.ID, GROUP.NAME) FROM GROUP WHERE (GROUP.NAME LIKE "%name%")).AS("g")
        SELECT (*USER(), g[GROUP.ID]) FROM USER LEFT_JOIN g ON (USER.GROUP_ID EQ g[GROUP.ID])

        // select f_group_id, count(f_id) from t_user group by f_group_id
        SELECT(USER.GROUP_ID, count(USER.ID)) FROM USER GROUP_BY USER.GROUP_ID

        // update t_user set f_group_id = f_id + 1, f_name = 'abc' where f_id = 1
        UPDATE (USER) SET {
            it[USER.GROUP_ID] = USER.ID + 1
            it[USER.NAME] = "abc"
        } WHERE (USER.ID EQ 1)

        // update t_user u left join t_group g on u.f_group_id = g.f_id set u.f_name = 'abc' where g.f_id = 1
        UPDATE (USER) LEFT_JOIN GROUP ON (USER.GROUP_ID EQ GROUP.ID) SET {
            it[USER.NAME] = "abc"
        } WHERE (GROUP.ID EQ 1)

        // insert into t_user(f_id, f_name, f_group_id) values
        //      (1, 'ab', 3), (2, 'cd', 3);
        INSERT INTO USER(USER.ID, USER.NAME, USER.GROUP_ID) VALUES
                V(1, "ab", 3) AND
                V(2, "cd", 3)

        // Compile error, v2 can only be string
        // INSERT INTO USER(USER.ID, USER.NAME) VALUES V(1, 2)

        // insert entities
        val u = User().also {
            it.id = 10
            it.name = "abc"
        }
        val u2 = User().also {
            it.id = 20
            it.name = "def"
        }

        // insert into t_user(f_id, f_name) values (10, 'abc'), (20, 'def');
        INSERT(u, u2)

        // insert into t_user(f_id) values (10), (20);
        INSERT INTO USER(USER.ID) VALUES E(u, u2)

        // insert into t_user(f_id, f_name)
        //      select f_id, f_name from t_user where f_id = 1
        INSERT INTO USER(USER.ID, USER.NAME) FROM (
                SELECT(USER.ID, USER.NAME) FROM USER WHERE (USER.ID EQ 1)
                )

        // delete u, g from t_user u left join t_group g on u.f_group_id = g.f_id where u.f_id = 1
        val a = DELETE(USER, GROUP) FROM USER LEFT_JOIN GROUP ON (USER.GROUP_ID EQ GROUP.ID) WHERE (USER.ID EQ 1)

        // delete from f_user where f_id = 1
        DELETE FROM USER WHERE (USER.ID EQ 1)

        val builder = SQLBuilder()
        println(builder.build(a).sql)
    }

}