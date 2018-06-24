package com.github.jacokoo.kosql.compose.test

import io.kotlintest.specs.FreeSpec

class HelloTest: FreeSpec({
    "hello" -  {
        "hello" {
            println("qn: ${HelloTest::class.qualifiedName}")
            println("jn: ${HelloTest::class.java.name}")
        }
    }
})
