package com.pancake.footballfever.ui.league_state.top_score.ui_state

import com.pancake.footballfever.domain.models.TopGoals

data class TopScorerUiState(
    val topGoalsList: List<TopGoals>? = null,
    val isLoading: Boolean = false,
    val error: Boolean = false,
)