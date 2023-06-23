package com.pancake.footballfever.ui.fixture.summary

import com.pancake.footballfever.domain.models.FixtureEvents

data class FixtureSummaryUiState(
    val isLoading: Boolean = false,
    val items: List<FixtureEvents> = emptyList(),
    val errorMsg: String? = null
)