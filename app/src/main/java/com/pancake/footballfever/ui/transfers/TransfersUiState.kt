package com.pancake.footballfever.ui.transfers

import com.pancake.footballfever.domain.models.Transfers

data class TransfersUiState(
    val isLoading: Boolean = true,
    val success: List<Transfers> = listOf(),
    val error: String? = null,
)
