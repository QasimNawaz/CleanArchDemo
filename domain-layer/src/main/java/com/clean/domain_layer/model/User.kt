package com.clean.domain_layer.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(

    @field:SerializedName("Email")
    val email: String? = null,

    @field:SerializedName("Token")
    val token: String? = null,

    @field:SerializedName("Id")
    val id: Int? = null,

    @field:SerializedName("Name")
    val name: String? = null
) : Parcelable
