package com.pancake.footballfever.ui.selectFavoriteTeams

import com.pancake.footballfever.domain.models.FavoriteTeam

data class SelectFavoriteTeamsUiState(
    val isLoading: Boolean = true,
    val success: List<FavoriteTeam> = listOf(),
    val error: String? = null
)