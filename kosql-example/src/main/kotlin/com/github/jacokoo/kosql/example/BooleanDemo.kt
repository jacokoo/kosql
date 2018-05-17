package com.github.jacokoo.kosql.example

import com.github.jacokoo.kosql.compose.then
import com.github.jacokoo.kosql.compose.thenDo

fun main(args: Array<String>) {
    val n1 = 3
    val n2 = 5
    val n3 = -2

    val max = if (n1 > n2) {
        if (n1 > n3)
            n1
        else
            n3
    } else {
        if (n2 > n3)
            n2
        else
            n3
    }

    val m = (n1 > n2).then {
        (n1 > n3).then { n1 }.or { n3 }
    }.or {
        (n2 > n3).then { n2 }.or { n3 }
    }

    println("max = $max, $m")


    (2 < 1).thenDo { println("1") }
        .or(3 > 4) { println("2") }
        .or(true) { println("4") }
        .or { println("3") }


    val a = (2 < 1).then { 1 }
        .or(3 > 4) {2}
        .or(5 < 6) {4}
        .or { 3 }

    println(a)
}
