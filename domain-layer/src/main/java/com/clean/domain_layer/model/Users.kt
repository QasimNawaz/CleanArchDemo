package com.clean.domain_layer.model

import com.google.gson.annotations.SerializedName

data class Users(

	@field:SerializedName("per_page")
	val perPage: Int? = null,

	@field:SerializedName("totalrecord")
	val totalRecord: Int? = null,

	@field:SerializedName("data")
	val data: List<DataItem>? = null,

	@field:SerializedName("page")
	val page: Int? = null,

	@field:SerializedName("total_pages")
	val totalPages: Int? = null,
)

data class DataItem(

	@field:SerializedName("createdat")
	val createdAt: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("profilepicture")
	val profilePicture: String? = null,

	@field:SerializedName("location")
	val location: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("email")
	val email: String? = null,
)
