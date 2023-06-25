package com.pancake.footballfever.ui.league_state

import com.pancake.footballfever.domain.models.League

data class LeagueUiState(
    val success: League? = null,
    val loading: Boolean = false,
    val error: Boolean = false,
    val errorMessage: String? = null,
)