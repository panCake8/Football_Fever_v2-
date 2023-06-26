package com.pancake.footballfever.ui.club_stats

import com.pancake.footballfever.domain.models.ClubModel

sealed interface ClubUiEvent{
    object OnClickFollow: ClubUiEvent
    object OnClickUnFollow : ClubUiEvent
}