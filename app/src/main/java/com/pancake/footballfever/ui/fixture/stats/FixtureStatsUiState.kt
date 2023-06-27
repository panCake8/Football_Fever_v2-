package com.pancake.footballfever.ui.fixture.stats

import com.pancake.footballfever.domain.models.FixtureStatistics

data class FixtureStatsUiState(
    val isLoading: Boolean? = true,
    val error: Boolean? = null,
    val success: FixtureStatistics? = null,
)
