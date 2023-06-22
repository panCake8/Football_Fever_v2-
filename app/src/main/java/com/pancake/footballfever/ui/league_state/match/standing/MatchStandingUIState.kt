package com.pancake.footballfever.ui.league_state.match.standing

import com.pancake.footballfever.domain.models.Standings

data class MatchStandingUIState(
    val response: List<Standings>? = null,
    val isLoading: Boolean = true,
    val errors: Error? =null
)