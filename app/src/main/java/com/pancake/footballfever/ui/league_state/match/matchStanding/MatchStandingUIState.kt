package com.pancake.footballfever.ui.league_state.match.matchStanding

import com.pancake.footballfever.domain.models.Standings

data class MatchStandingUIState(
    val standings: List<Standings>? = null,
    val isLoading: Boolean = true,
    val errors: Error? =null
)