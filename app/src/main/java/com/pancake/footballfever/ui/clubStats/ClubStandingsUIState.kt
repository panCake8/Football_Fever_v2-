package com.pancake.footballfever.ui.clubStats

import com.pancake.footballfever.domain.models.Standings

data class ClubStandingsUIState (
    val response: List<Standings>? = null,
    val isLoading: Boolean = true,
    val errors: Error? =null
)