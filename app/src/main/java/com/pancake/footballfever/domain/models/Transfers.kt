package com.pancake.footballfever.domain.models

data class Transfers(
    val playerName: String? = "",
    val date: String? = "",
    val transferType: String? = "",
    val clubNameIN: String? = "",
    val clubLogoIN: String? = "",
    val clubNameOut: String? = "",
    val clubLogoOut: String? = "",
)
