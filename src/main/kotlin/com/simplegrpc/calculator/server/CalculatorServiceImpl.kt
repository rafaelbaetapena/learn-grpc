package com.simplegrpc.calculator.server

import com.proto.calculator.CalculatorServiceGrpcKt
import com.proto.calculator.SumRequest
import com.proto.calculator.SumResponse

class CalculatorServiceImpl :
        CalculatorServiceGrpcKt.CalculatorServiceCoroutineImplBase(){
    override suspend fun sum(request: SumRequest): SumResponse {
        val numberA = request.a
        val numberB = request.b
        val result = numberA + numberB

        return SumResponse.newBuilder()
                .setResult(result)
                .build()
    }
}