package com.pancake.footballfever.ui.fixture.head2head.uiState

import com.pancake.footballfever.domain.models.HeadToHeadUiModel

data class HeadToHeadUiState(
    val isLoading: Boolean = true,
    val error: String? = null,
    val success: List<HeadToHeadUiModel>? = listOf(),
)
