package com.pancake.footballfever.ui.league_state.match.uiState

import com.pancake.footballfever.domain.models.LeagueMatchUiModel

data class LeagueMatchUiState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val errorMessage: String? = null,
    val success: List<LeagueMatchUiModel>? = listOf(),
)
