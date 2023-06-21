package com.pancake.footballfever.ui.league_state.standing

import com.pancake.footballfever.domain.models.Standings

data class StandingsUIState(
    val response: List<Standings>? = null,
    val isLoading: Boolean = true,
    val errors: Error? =null
)