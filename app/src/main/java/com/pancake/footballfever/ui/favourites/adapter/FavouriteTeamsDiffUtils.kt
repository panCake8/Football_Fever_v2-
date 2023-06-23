package com.pancake.footballfever.ui.favourites.adapter
import androidx.recyclerview.widget.DiffUtil
import com.pancake.footballfever.domain.models.FavoriteTeam

class FavouriteTeamsDiffUtils(
    private val oldItems: List<FavoriteTeam>,
    private val newItems: List<FavoriteTeam>,
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldItems.size
    override fun getNewListSize() = newItems.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItems[oldItemPosition].id == newItems[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        areItemsTheSame(oldItemPosition, newItemPosition)
}