package com.pancake.footballfever.ui.selectFavoriteTeams.adapter

import android.view.MotionEvent
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.widget.RecyclerView
import com.pancake.footballfever.domain.models.FavoriteTeam

class MyItemDetailsLookup(private val recycler: RecyclerView) :
    ItemDetailsLookup<FavoriteTeam>() {
    override fun getItemDetails(event: MotionEvent): ItemDetails<FavoriteTeam>? {
        val view = recycler.findChildViewUnder(event.x, event.y)
        view?.let {
            return (recycler.getChildViewHolder(view) as SelectFavoriteTeamsAdapter.FavoriteTeamsViewHolder)
                .getItemDetails()
        }
        return null
    }
}