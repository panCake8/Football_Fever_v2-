package com.pancake.footballfever.ui.league_state.match

import com.pancake.footballfever.domain.models.LeagueMatch

data class LeagueMatchUiState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val success: Map<String?, List<LeagueMatch>> = mapOf(),
)
