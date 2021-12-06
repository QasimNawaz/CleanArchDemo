package com.clean.domain_layer.usecase.auth

import com.clean.domain_layer.model.BaseResponse
import com.clean.domain_layer.model.User
import com.clean.domain_layer.model.state.Resource
import com.clean.domain_layer.repository.AuthRepository
import com.clean.domain_layer.usecase.base.SuspendUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val authRepository: AuthRepository,
) : SuspendUseCase<LoginUseCase.Params, @JvmSuppressWildcards Flow<Resource<BaseResponse<User?>>>> {

    data class Params(val email: String, val password: String)

    override suspend fun execute(params: Params) =
        authRepository.loginUser(params.email, params.password)
}