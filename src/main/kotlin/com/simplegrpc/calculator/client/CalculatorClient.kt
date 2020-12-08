package com.simplegrpc.calculator.client

import com.proto.calculator.CalculatorServiceGrpcKt
import com.proto.calculator.SumRequest
import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import java.io.Closeable
import java.util.concurrent.TimeUnit

class CalculatorClient(private  val channel: ManagedChannel) :
        Closeable {
    private val calculatorStub: CalculatorServiceGrpcKt.CalculatorServiceCoroutineStub by lazy {
        CalculatorServiceGrpcKt.CalculatorServiceCoroutineStub(channel)
    }

    suspend fun sum(){
        val sumRequest = SumRequest.newBuilder()
                .setA(10)
                .setB(3)
                .build()

        val sumResponse = calculatorStub.sum(sumRequest)
        println("Received: ${sumResponse.result}")
    }

    override fun close() {
        println("Shutting down channel")
        channel.shutdown()
                .awaitTermination(5, TimeUnit.SECONDS)
    }
}

suspend fun main(args:Array<String>){
    println("Hello I'm a gRPC calculator client")

    val port = 50051
    val channel = ManagedChannelBuilder
            .forAddress("localhost", port)
            .usePlaintext()
            .build()

    println("Creating Stub")
    val client = CalculatorClient(channel)

    println("Call sum()")
    client.sum()

    println("Close channel")
    client.close()

}