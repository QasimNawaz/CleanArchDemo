package com.clean.domain_layer.usecase

interface SuspendUseCase<in Params, out T> {
    suspend fun execute(params: Params) : T
}