package com.pancake.footballfever.ui.favourites.adapter


import com.pancake.footballfever.R
import com.pancake.footballfever.domain.models.FavoriteTeam
import com.pancake.footballfever.ui.base.BaseAdapter

class FavouriteTeamsAdapter(
    listener: FavouriteTeamListener
) : BaseAdapter<FavoriteTeam>(listener) {
    override val getLayoutId = R.layout.item_favourites
}