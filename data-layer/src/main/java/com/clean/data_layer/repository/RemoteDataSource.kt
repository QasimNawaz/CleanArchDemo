package com.clean.data_layer.repository

import com.clean.domain_layer.model.BaseResponse
import com.clean.domain_layer.model.User
import com.clean.domain_layer.model.state.Resource

interface RemoteDataSource {
    suspend fun loginUser(email: String, password: String): Resource<BaseResponse<User?>>
    suspend fun registerUser(name: String, email: String, password: String): Resource<BaseResponse<User?>>
}