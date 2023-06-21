package com.pancake.footballfever.ui.Club_stats

import com.pancake.footballfever.domain.models.FixtureModel

data class ClubUiState (
    val isLoading: Boolean = true,
    val fixture: FixtureModel? = null,
    val error: String? = null,
        )