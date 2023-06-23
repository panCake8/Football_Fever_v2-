package com.pancake.footballfever.ui.club_standing

import com.pancake.footballfever.domain.models.Standings

data class ClubStandingUIState(
    val standings: List<Standings>? = null,
    val isLoading: Boolean = true,
    val errors: Error? = null
)