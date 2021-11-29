package com.clean.data_layer.repository

import androidx.annotation.MainThread
import com.clean.domain_layer.model.state.ErrorHandler
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import retrofit2.Response
import java.io.IOException
import com.clean.domain_layer.model.state.Result

/**
 * A generic class that can provide a resource backed by both the sqlite database and the network.
 *
 * Adapted from: Guide to app architecture
 * https://developer.android.com/jetpack/guide
 *
 * @param <ResultType> Represents the domain model
 * @param <RequestType> Represents the (converted) network > database model
 */
abstract class NetworkBoundResource<RequestType>(
    private val errorHandler: ErrorHandler,
) {

    fun asFlow() = flow {
        emit(Result.Loading(null)) // start loading state immediately
        try {
            emit(Result.Loading(null)) // update loading state with cached data
            val apiResponse = fetchFromRemote()

            if (apiResponse.isSuccessful) {
                emit(Result.Success(apiResponse.body()))
            } else {
                emit(Result.Error(errorHandler.getApiError(apiResponse.code()), apiResponse.body()))
            }
        } catch (e: Exception) {
            emit(Result.Error(errorHandler.getError(e), fetchFromRemote()))
        }
    }

    @MainThread
    protected abstract suspend fun fetchFromRemote(): Response<RequestType>
}