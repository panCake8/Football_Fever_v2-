package com.pancake.footballfever.ui.standings

import com.pancake.footballfever.domain.models.Standings

data class StandingsUIState(
    val response: List<Standings>? = null,
    val isLoading: Boolean = false,
    val errors: List<Error> = emptyList()
)