package com.pancake.footballfever.ui.injuries

import com.pancake.footballfever.domain.models.Injuries

data class InjuriesUiState(
    val isLoading: Boolean = true,
    val success: List<Injuries> = listOf(),
    val error: String? = null,
)
