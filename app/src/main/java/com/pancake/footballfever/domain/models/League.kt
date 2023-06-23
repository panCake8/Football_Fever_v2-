package com.pancake.footballfever.domain.models

data class League(
    val id: Int? = 0,
    val name: String?,
    val logo: String?,
    val country: String?,
    val season: Int?,
    val type: String?,
)