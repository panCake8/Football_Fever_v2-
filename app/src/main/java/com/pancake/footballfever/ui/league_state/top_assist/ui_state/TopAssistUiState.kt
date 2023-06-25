package com.pancake.footballfever.ui.league_state.top_assist.ui_state

import com.pancake.footballfever.domain.models.TopAssists

data class TopAssistUiState (
    val topAssistsList: List<TopAssists>? = null,
    val isLoading: Boolean = false,
    val error: Boolean = false,
)