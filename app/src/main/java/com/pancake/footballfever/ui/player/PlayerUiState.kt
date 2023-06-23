package com.pancake.footballfever.ui.player

import com.pancake.footballfever.domain.models.Player

data class PlayerUiState(
    val isLoading: Boolean = false,
    val items: List<Player> = emptyList(),
    val errorMsg: String? = null
)