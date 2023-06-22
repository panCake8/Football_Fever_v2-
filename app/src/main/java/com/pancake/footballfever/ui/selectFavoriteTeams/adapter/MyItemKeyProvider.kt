package com.pancake.footballfever.ui.selectFavoriteTeams.adapter

import androidx.recyclerview.selection.ItemKeyProvider
import com.pancake.footballfever.domain.models.FavoriteTeam

class MyItemKeyProvider(private val adapter: SelectFavoriteTeamsAdapter) :
    ItemKeyProvider<FavoriteTeam>(SCOPE_CACHED) {

    override fun getKey(position: Int): FavoriteTeam = adapter.getCurrentItem(position)
    override fun getPosition(key: FavoriteTeam): Int = adapter.getPosition(key.name!!)
}