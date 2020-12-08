package com.simplegrpc.greeting.server

import com.proto.greet.GreetRequest
import com.proto.greet.GreetResponse
import com.proto.greet.GreetServiceGrpcKt

class GreetServiceImpl : GreetServiceGrpcKt.GreetServiceCoroutineImplBase() {
    override suspend fun greet(request: GreetRequest): GreetResponse {
        val greeting = request.greeting
        val firstName = greeting.firstName

        val result = "Hello $firstName"

        return GreetResponse.newBuilder()
                .setResult(result)
                .build()
    }
}