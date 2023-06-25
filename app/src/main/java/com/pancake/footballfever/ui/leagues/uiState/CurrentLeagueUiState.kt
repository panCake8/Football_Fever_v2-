package com.pancake.footballfever.ui.leagues.uiState

import com.pancake.footballfever.domain.models.League


data class CurrentLeagueUiState(
    val searchInput: String = "",
    val leagueList: List<League>? = emptyList(),
    val searchLeagues : List<League>? = emptyList(),
    val loading: Boolean = false,
    val isEmpty: Boolean = false,
    val error : List<Error> = emptyList(),
)