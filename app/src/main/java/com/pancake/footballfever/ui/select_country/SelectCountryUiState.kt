package com.pancake.footballfever.ui.select_country

import com.pancake.footballfever.domain.models.SelectCountry


data class SelectCountryUiState(
    val isLoading: Boolean = true,
    val success: List<SelectCountry> = listOf(),
    val error: String? = null
)