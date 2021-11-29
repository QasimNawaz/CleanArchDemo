package com.clean.domain_layer.usecase

interface UseCase<in Params, out T> {
    fun execute(params: Params): T
}