package com.simplegrpc.calculator.server

import io.grpc.Server
import io.grpc.ServerBuilder

class CalculatorServer(private val port: Int) {
    val server: Server = ServerBuilder
            .forPort(port)
            .addService(CalculatorServiceImpl())
            .build()

    fun start(){
        server.start()
        println("Server started, listening on $port")
        Runtime.getRuntime().addShutdownHook(
                Thread {
                    println("*** shutting down gRPC server since JVM is shutting down")
                    this@CalculatorServer.stop()
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
    println("Hello gRPC calculator server")

    val port = 50051
    val server = CalculatorServer(port)
    server.start()
    server.blockUntilShutdown()
}