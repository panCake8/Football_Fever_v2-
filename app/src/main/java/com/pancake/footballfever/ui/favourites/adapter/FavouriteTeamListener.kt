package com.pancake.footballfever.ui.favourites.adapter

import com.pancake.footballfever.domain.models.FavoriteTeam
import com.pancake.footballfever.ui.base.BaseAdapterListener

interface FavouriteTeamListener: BaseAdapterListener {
    fun onClickTeam(team: FavoriteTeam)
}