package com.pancake.footballfever.ui.game.uiState

import com.pancake.footballfever.domain.models.FixtureHome

data class FootballUIState (
    val isLoading: Boolean = true,
    val success: List<FixtureHome> = listOf(),
    val error: String? = null
)