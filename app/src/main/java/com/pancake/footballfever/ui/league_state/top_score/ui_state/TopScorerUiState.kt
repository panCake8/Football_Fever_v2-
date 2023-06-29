package com.pancake.footballfever.ui.league_state.top_score.ui_state

import com.pancake.footballfever.domain.models.TopGoals

data class TopScorerUiState(
    val success: List<TopGoals>? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
    val errorMessage: String? = null,
)