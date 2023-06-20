package com.pancake.footballfever.ui.coach

import com.pancake.footballfever.domain.models.Coaches


data class CoachUiState(
    val isLoading: Boolean = true,
    val success: List<Coaches> = listOf(),
    val error: String? = null
)