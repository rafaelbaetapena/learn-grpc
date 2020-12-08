package com.simplegrpc.greeting.client

import com.proto.greet.GreetManyTimesRequest
import com.proto.greet.GreetRequest
import com.proto.greet.GreetServiceGrpcKt
import com.proto.greet.Greeting
import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import kotlinx.coroutines.flow.collect
import java.io.Closeable
import java.util.concurrent.TimeUnit

class GreetingClient(private val channel: ManagedChannel) :
        Closeable {
    private val greetStub: GreetServiceGrpcKt.GreetServiceCoroutineStub by lazy {
        GreetServiceGrpcKt.GreetServiceCoroutineStub(channel)
    }

    suspend fun greet(){
        val greeting = Greeting.newBuilder()
                .setFirstName("Rafael")
                .setLastName("Pena")
                .build()

        val greetRequest = GreetRequest.newBuilder()
                .setGreeting(greeting)
                .build()

        val greetResponse = greetStub.greet(greetRequest)

        println("Received: ${greetResponse.result}")
    }

    suspend fun greetManyTimes(){
        val greeting = Greeting.newBuilder()
            .setFirstName("Rafael")
            .setLastName("Pena")
            .build()

        val greetManyTimesRequest = GreetManyTimesRequest.newBuilder()
            .setGreeting(greeting)
            .build()

        greetStub.greetManyTimes(greetManyTimesRequest)
            .collect {greetManyTimesResponse -> println("Received: ${greetManyTimesResponse.result}")}
    }

    override fun close() {
        println("Shutting down channel")
        channel.shutdown()
            .awaitTermination(5, TimeUnit.SECONDS)
    }
}

suspend fun main(args:Array<String>){
    println("Hello I'm a gRPC client")

    val port = 50051
    val channel = ManagedChannelBuilder
        .forAddress("localhost", port)
        .usePlaintext()
        .build()

    println("Creating Stub")
    val client = GreetingClient(channel)

    println("Call greet()")
    client.greet()

    println("Call greetManyTimes()")
    client.greetManyTimes()

    println("Close channel")
    client.close()
}