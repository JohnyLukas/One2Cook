package com.example.one2cook.domain.useCase

interface SuspendUseCase<in Input> {

    suspend operator fun invoke(param: Input)

}