package com.pancake.footballfever.ui.fixture.summary

import com.pancake.footballfever.domain.models.FixtureSummary

data class FixtureSummaryUiState(
    val isLoading: Boolean = false,
    val items: List<FixtureSummary> = emptyList(),
    val errorMsg: String? = null
)