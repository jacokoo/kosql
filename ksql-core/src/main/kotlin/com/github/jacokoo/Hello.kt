package com.github.jacokoo

import com.github.jacokoo.demo.CITY
import com.github.jacokoo.demo.COUNTRY
import com.github.jacokoo.demo.entity.City
import com.github.jacokoo.ksql.Query
import com.github.jacokoo.ksql.statements.SQLBuilder

fun main(args: Array<String>) {
    with(Query) {
        // select * from t_user
        SELECT(*CITY()) FROM CITY

        // select f_id, f_name from t_user where f_id = 1
        SELECT(CITY.ID, CITY.NAME) FROM CITY WHERE (CITY.ID EQ 1)

        // select u.f_id, g.f_name from t_user as u left join t_group as g where u.f_id = 1
        SELECT(CITY.ID, COUNTRY.NAME) FROM CITY LEFT_JOIN COUNTRY ON (CITY.COUNTRY_ID EQ COUNTRY.ID) WHERE
                (CITY.ID EQ 1)

        // select u.*, g.f_id from t_user u left join (
        //      select f_id, f_name from t_group where f_name like '%name%'
        // ) as g on u.f_group_id = g.f_id
        val g = (SELECT(COUNTRY.ID, COUNTRY.NAME) FROM COUNTRY WHERE (COUNTRY.NAME LIKE "%name%")).AS("g")
        val a = SELECT (*CITY(), g[COUNTRY.ID]) FROM CITY LEFT_JOIN g ON (CITY.COUNTRY_ID EQ g[COUNTRY.ID])

        // select f_group_id, count(f_id) from t_user group by f_group_id
        SELECT(CITY.COUNTRY_ID, count(CITY.ID)) FROM CITY GROUP_BY CITY.COUNTRY_ID

        // update t_user set f_group_id = f_id + 1, f_name = 'abc' where f_id = 1
        UPDATE (CITY) SET {
            it[CITY.COUNTRY_ID] = CITY.ID + 1
            it[CITY.NAME] = "abc"
        } WHERE (CITY.ID EQ 1)

        // update t_user u left join t_group g on u.f_group_id = g.f_id set u.f_name = 'abc' where g.f_id = 1
        UPDATE (CITY) LEFT_JOIN COUNTRY ON (CITY.COUNTRY_ID EQ COUNTRY.ID) SET {
            it[CITY.NAME] = "abc"
        } WHERE (COUNTRY.ID EQ 1)

        // insert into t_user(f_id, f_name, f_group_id) values
        //      (1, 'ab', 3), (2, 'cd', 3);
        INSERT INTO CITY(CITY.ID, CITY.NAME, CITY.COUNTRY_ID) VALUES
                V(1, "ab", 3) AND
                V(2, "cd", 3)

        // Compile error, v2 can only be string
        // INSERT INTO CITY(CITY.ID, CITY.NAME) VALUES V(1, 2)

        // insert entities
        val u = City().also {
            it.id = 10
            it.name = "abc"
        }
        val u2 = City().also {
            it.id = 20
            it.name = "def"
        }

        // insert into t_user(f_id, f_name) values (10, 'abc'), (20, 'def');
        INSERT(u, u2)

        // insert into t_user(f_id) values (10), (20);
        INSERT INTO CITY(CITY.ID) VALUES E(u, u2)

        // insert into t_user(f_id, f_name)
        //      select f_id, f_name from t_user where f_id = 1
        INSERT INTO CITY(CITY.ID, CITY.NAME) FROM (
                SELECT(CITY.ID, CITY.NAME) FROM CITY WHERE (CITY.ID EQ 1)
                )

        // delete u, g from t_user u left join t_group g on u.f_group_id = g.f_id where u.f_id = 1
        DELETE(CITY, COUNTRY) FROM CITY LEFT_JOIN COUNTRY ON (CITY.COUNTRY_ID EQ COUNTRY.ID) WHERE (CITY.ID EQ 1)

        // delete from f_user where f_id = 1
        DELETE FROM CITY WHERE (CITY.ID EQ 1)

        val builder = SQLBuilder()
        println(builder.build(a).sql)
    }

}