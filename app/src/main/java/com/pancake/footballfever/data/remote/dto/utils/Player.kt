package com.example.footboolfever.data.remote.dto.utils

import com.google.gson.annotations.SerializedName

data class Player(

    @field:SerializedName("injured")
    val injured: Boolean? = null,

    @field:SerializedName("firstname")
    val firstname: String? = null,

    @field:SerializedName("nationality")
    val nationality: String? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("birth")
    val birth: Birth? = null,

    @field:SerializedName("weight")
    val weight: String? = null,

    @field:SerializedName("photo")
    val photo: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("age")
    val age: Int? = null,

    @field:SerializedName("lastname")
    val lastname: String? = null,

    @field:SerializedName("height")
    val height: String? = null
)
