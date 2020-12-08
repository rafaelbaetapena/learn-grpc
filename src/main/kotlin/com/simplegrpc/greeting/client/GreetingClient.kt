package com.simplegrpc.greeting.client

import com.proto.simple.SimpleServiceGrpcKt
import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import java.io.Closeable
import java.util.concurrent.TimeUnit

class GreetingClient(private val channel: ManagedChannel) : Closeable {
    private val simpleStub: SimpleServiceGrpcKt.SimpleServiceCoroutineStub by lazy {
        SimpleServiceGrpcKt.SimpleServiceCoroutineStub(channel)
    }

    override fun close() {
        println("Shutting down channel")
        channel.shutdown()
            .awaitTermination(5, TimeUnit.SECONDS)
    }
}

fun main(args:Array<String>){
    println("Hello I'm a gRPC client")

    val port = 50051
    val channel = ManagedChannelBuilder
        .forAddress("localhost", port)
        .usePlaintext()
        .build()

    println("Creating Stub")
    val client = GreetingClient(channel)

    client.close();
}