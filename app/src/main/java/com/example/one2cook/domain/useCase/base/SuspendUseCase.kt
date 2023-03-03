package com.example.one2cook.domain.useCase.base

interface SuspendUseCase<in Input, Unit> {

    suspend operator fun invoke(param: Input): Unit =
        execute(param)

    suspend fun execute(param: Input): Unit

}