package com.github.jacokoo.kosql.demo.vertx

import io.vertx.core.Vertx

fun main() {
    System.setProperty("vertx.logger-delegate-factory-class-name", "io.vertx.core.logging.SLF4JLogDelegateFactory")

    Vertx.vertx().also {
        it.deployVerticle(DemoVerticle())
    }
}