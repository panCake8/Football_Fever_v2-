package com.pancake.footballfever.ui.club_stats.team_fixture

import com.pancake.footballfever.domain.models.Fixture

data class TeamFixtureUiState(
    val isLoading: Boolean = false,
    val items: List<Fixture> = emptyList(),
    val errorMsg: String? = null
)