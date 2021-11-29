package com.clean.domain_layer.model.state

import java.lang.Exception

// A generic class that contains data and status about loading this data.
sealed class Resource<T>(
    private val data: T? = null,
    private val exception: Exception? = null
) {
    class Success<T>(val data: T?) : Resource<T>(data)
    class Loading<T>(val data: T? = null) : Resource<T>(data)
    class DataError<T>(val e: Exception) : Resource<T>(null, e)

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=::data]"
            is DataError -> "Error[exception=$exception]"
            is Loading<T> -> "Loading"
        }
    }
}