package com.clean.domain_layer.repository

import com.clean.domain_layer.model.BaseResponse
import com.clean.domain_layer.model.User
import com.clean.domain_layer.model.state.Resource
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun loginUser(email: String, password: String): Flow<Resource<BaseResponse<User?>>>
    suspend fun registerUser(name: String, email: String, password: String): Flow<Resource<BaseResponse<User?>>>
}