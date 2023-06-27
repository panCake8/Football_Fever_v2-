package com.pancake.footballfever.ui.favourites

import com.pancake.footballfever.domain.models.FavoriteTeam

sealed interface FavouriteUiEvent{
    data class ClickTeamEvent(val team: FavoriteTeam): FavouriteUiEvent
}