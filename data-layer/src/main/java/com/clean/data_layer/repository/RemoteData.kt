package com.clean.data_layer.repository

import android.util.Log
import com.clean.data_layer.remote.WebService
import com.clean.domain_layer.model.BaseResponse
import com.clean.domain_layer.model.User
import com.clean.domain_layer.model.state.Resource
import com.clean.domain_layer.utils.ConnectivityException
import com.clean.domain_layer.utils.NetworkConnectivity
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject

class RemoteData @Inject constructor(
    private val webService: WebService,
    private val networkConnectivity: NetworkConnectivity
) : RemoteDataSource {

    override suspend fun loginUser(email: String, password: String): Resource<BaseResponse<User?>> {
        return if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Resource.DataError(Exception("Invalid Email!"))
        } else if (password.length < 4) {
            Resource.DataError(Exception("Password Must be greater than or equal to four characters!"))
        } else {
            processCall { webService.loginUser(email, password) }!!
        }
    }

    override suspend fun registerUser(name: String, email: String, password: String): Resource<BaseResponse<User?>> {
        return if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Resource.DataError(Exception("Invalid Email!"))
        } else if (password.length < 4) {
            Resource.DataError(Exception("Password Must be greater than or equal to four characters!"))
        } else {
            return processCall { webService.registerUser(name, email, password) }!!
        }
    }

    private suspend fun <T : Any?> processCall(responseCall: suspend () -> Response<T>): Resource<T>? {
        if (!networkConnectivity.isConnected()) {
            return Resource.DataError(ConnectivityException())
        }
        return try {
            val response = responseCall.invoke()
            Log.e("processCall", "${response.body()}")
            if (response.isSuccessful) {
                val body = response.body() as BaseResponse<T>
                if (body.code == 0) {
                    Resource.Success(response.body())
                } else {
                    Resource.DataError(Exception("${body.message}"))
                }
            } else {
                return try {
                    Resource.DataError(
                        Exception(
                            "${
                                response.errorBody()?.byteString().toString()
                            }\n${response.code()}"
                        )
                    )
                } catch (e: Exception) {
                    e.printStackTrace()
                    Resource.DataError(e)
                }

            }
        } catch (e: IOException) {
            Resource.DataError(e)
        }
    }
}