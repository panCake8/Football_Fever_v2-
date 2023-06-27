package com.pancake.footballfever.ui.favourites

import com.pancake.footballfever.domain.models.FavoriteTeam

sealed interface FavoriteEvent{
    data class ClickFavoriteEvent(val favoriteTeam: FavoriteTeam) : FavoriteEvent
}