package com.pancake.footballfever.ui.league_state.match

import com.pancake.footballfever.domain.models.LeagueMatchUiModel

data class LeagueMatchUiState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val success: List<LeagueMatchUiModel>? = listOf(),
)
