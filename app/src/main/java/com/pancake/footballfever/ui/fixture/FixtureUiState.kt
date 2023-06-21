package com.pancake.footballfever.ui.fixture

import com.pancake.footballfever.domain.models.FixtureModel

data class FixtureUiState(
    val isLoading: Boolean = true,
    val fixture: FixtureModel? = null,
    val error: String? = null,
)
