package com.clean.domain_layer.model

import com.google.gson.annotations.SerializedName

data class User(

    @field:SerializedName("Email")
    val email: String? = null,

    @field:SerializedName("Token")
    val token: String? = null,

    @field:SerializedName("Id")
    val id: Int? = null,

    @field:SerializedName("Name")
    val name: String? = null
)
