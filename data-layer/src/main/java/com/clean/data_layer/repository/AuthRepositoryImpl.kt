package com.clean.data_layer.repository

import com.clean.data_layer.di.IoDispatcher
import com.clean.domain_layer.model.BaseResponse
import com.clean.domain_layer.model.User
import com.clean.domain_layer.model.state.Resource
import com.clean.domain_layer.repository.AuthRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val remoteData: RemoteData,
    @IoDispatcher private val dispatcher: CoroutineDispatcher,
) : AuthRepository {

    override suspend fun loginUser(email: String, password: String): Flow<Resource<BaseResponse<User?>>> {
        return flow {
            emit(remoteData.loginUser(email, password))
        }.flowOn(dispatcher)
    }

    override suspend fun registerUser(name: String, email: String, password: String): Flow<Resource<BaseResponse<User?>>> {
        return flow {
            emit(remoteData.registerUser(name, email, password))
        }.flowOn(dispatcher)
    }
}
