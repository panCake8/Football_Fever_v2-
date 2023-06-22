package com.pancake.footballfever.ui.fixture.head2head

import com.pancake.footballfever.domain.models.HeadToHeadUiModel

data class HeadToHeadUiState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val success: List<HeadToHeadUiModel>? = listOf(),
)
