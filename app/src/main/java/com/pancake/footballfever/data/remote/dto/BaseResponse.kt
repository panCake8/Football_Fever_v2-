package com.example.footboolfever.data.remote.dto

import com.example.footboolfever.data.remote.dto.utils.Paging
import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @field:SerializedName("response")
    val response: List<T>? = null,

    @field:SerializedName("get")
    val get: String? = null,

    @field:SerializedName("paging")
    val paging: Paging? = null,

    @field:SerializedName("results")
    val results: Int? = null,
)
