package com.pancake.footballfever.ui.home

import com.pancake.footballfever.domain.models.FixtureHome

data class HomeUiState(
    val isLoading: Boolean = true,
    val success: List<FixtureHome> = listOf(),
    val error: String? = null
)
