package com.simplegrpc.greeting.server

import io.grpc.Server
import io.grpc.ServerBuilder

class GreetingServer(private val port: Int) {
    val server: Server = ServerBuilder
        .forPort(port)
        .build()

    fun start(){
        server.start()
        println("Server started, listening on $port")
        Runtime.getRuntime().addShutdownHook(
            Thread {
                println("*** shutting down gRPC server since JVM is shutting down")
                this@GreetingServer.stop()
                println("*** server shut down")
            }
        )
    }

    private fun stop() {
        server.shutdown()
    }

    fun blockUntilShutdown() {
        server.awaitTermination()
    }
}

fun main() {
    println("Hello gRPC")

    val port = 50051
    val server = GreetingServer(port)
    server.start()
    server.blockUntilShutdown()
}