package com.pancake.footballfever.ui.club_stats

import com.pancake.footballfever.domain.models.ClubModel

data class ClubUiState (
    val isLoading: Boolean = true,
    val success: ClubModel? = null,
    val error: String? = null,
    val isFavorite: Boolean = false,
        )