package com.clean.domain_layer.model

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(

    @field:SerializedName("code")
    val code: Int? = null,

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("data")
    val data: T? = null,
)
