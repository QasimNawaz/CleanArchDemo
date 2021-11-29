package com.clean.data_layer.remote

import com.clean.domain_layer.model.BaseResponse
import com.clean.domain_layer.model.User
import retrofit2.Response
import retrofit2.http.*

interface WebService {

    @FormUrlEncoded
    @POST("login")
    suspend fun loginUser(
        @Field("email") email: String,
        @Field("password") password: String,
    ): Response<BaseResponse<User?>>

    @FormUrlEncoded
    @POST("registration")
    suspend fun registerUser(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String,
    ): Response<BaseResponse<User?>>
}