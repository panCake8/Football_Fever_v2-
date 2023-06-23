package com.pancake.footballfever.ui.club_stats.fixture_events

import com.pancake.footballfever.domain.models.FixtureEvents

data class FixtureEventsUiState(
    val isLoading: Boolean = false,
    val items: List<FixtureEvents> = emptyList(),
    val errorMsg: String? = null
)