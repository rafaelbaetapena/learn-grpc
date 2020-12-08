package com.simplegrpc.greeting.server

import com.proto.greet.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GreetServiceImpl : GreetServiceGrpcKt.GreetServiceCoroutineImplBase() {
    override suspend fun greet(request: GreetRequest): GreetResponse {
        val greeting = request.greeting
        val firstName = greeting.firstName

        val result = "Hello $firstName"

        return GreetResponse.newBuilder()
                .setResult(result)
                .build()
    }

    override fun greetManyTimes(request: GreetManyTimesRequest): Flow<GreetManyTimesResponse> {
        return flow {
            val firstName = request.greeting.firstName

            for(i in 1..10){
                val result = "Hello $firstName, response number: $i"
                delay(1000)

                val response = GreetManyTimesResponse.newBuilder()
                        .setResult(result)
                        .build()

                emit(response)
            }
        }
    }
}