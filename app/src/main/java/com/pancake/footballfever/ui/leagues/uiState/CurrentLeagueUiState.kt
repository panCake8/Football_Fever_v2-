package com.pancake.footballfever.ui.leagues.uiState

import com.pancake.footballfever.domain.models.League


data class CurrentLeagueUiState(
    val leagueList: List<League>? = null,
    val loading: Boolean = true,
    val error: Boolean = false,
)