package com.github.jacokoo.kosql.demo.pg.vertx.java;

import static com.github.jacokoo.kosql.demo.pg.vertx.java.kosql.UserBase.*;

import com.github.jacokoo.kosql.demo.pg.vertx.java.entity.UserStatus;
import com.github.jacokoo.kosql.execute.async.java.compose.Insert;
import com.github.jacokoo.kosql.execute.async.java.compose.Update;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Demo2 implements Update, Insert {
    void demo() {
        UPDATE(USER).SET(it -> {
            it.set(USER.ID, 10L);
        }).WHERE(USER.ID).EQ(10L);

        INSERT_INTO(USER, USER.ID, USER.STATUS).VALUES(V(10L, UserStatus.Disabled));
    }

    static void walk(int[] arr, int target, List<Integer> current, int sum, int idx, List<Integer[]> result) {
        if (idx == arr.length) {
            return;
        }

        int ss = sum + arr[idx];
        if (ss > target) {
            walk(arr, target, current, sum, idx + 1, result);
            return;
        }
        if (ss == target) {
            current.add(idx);
            result.add(current.toArray(new Integer[0]));
            current.remove(current.size() - 1);
            walk(arr, target, current, sum, idx + 1, result);
            return;
        }

        current.add(idx);
        walk(arr, target, current, ss, idx + 1, result);
        current.remove(current.size() - 1);
        walk(arr, target, current, sum, idx + 1, result);
    }

    static List<Integer[]> doIt(int[] arr) {
        var result = new ArrayList<Integer[]>();
        walk(arr, 100, new ArrayList<>(), 0, 0, result);
        return result;
    }

    public static void main(String[] args) {
        var random = new Random(System.currentTimeMillis());
        var length = random.nextInt(10) + 10;
        var arr = new int[length];
        for (var i = 0; i < length; i ++) {
            arr[i] = random.nextInt(100) + 1;
        }

        System.out.println(Arrays.toString(arr));
        doIt(arr).forEach(it -> {
            System.out.print("indexes: " + Arrays.toString(it) + " items: ");
            System.out.println(Arrays.stream(it).map(i -> arr[i]).collect(Collectors.toList()));
        });
    }
}
