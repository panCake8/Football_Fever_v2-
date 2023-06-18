package com.pancake.footballfever.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class FavoriteTeam(
    val id: Int,
    val name: String,
    val logo: String
) : Parcelable