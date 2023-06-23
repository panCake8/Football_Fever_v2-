package com.pancake.footballfever.ui.favourites.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.pancake.footballfever.R
import com.pancake.footballfever.BR
import com.pancake.footballfever.databinding.ItemFavouritesBinding
import com.pancake.footballfever.domain.models.FavoriteTeam

class FavouriteTeamsAdapter(
    private var items: List<FavoriteTeam>,
) : RecyclerView.Adapter<FavouriteTeamsAdapter.FavouriteTeamHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouriteTeamHolder {
        return FavouriteTeamHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_favourites,
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holder: FavouriteTeamHolder, position: Int) {
        val currentItem = items[position]
        holder.binding.apply {
            setVariable(BR.item, currentItem)
        }
    }

    fun setItems(newItems: List<FavoriteTeam>) {
        val diffUtils = DiffUtil.calculateDiff(FavouriteTeamsDiffUtils(items, newItems))
        items = newItems
        diffUtils.dispatchUpdatesTo(this)
    }

    override fun getItemCount() = items.size

    inner class FavouriteTeamHolder(val binding: ItemFavouritesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun getItemDetails(): ItemDetailsLookup.ItemDetails<FavoriteTeam> =
            object : ItemDetailsLookup.ItemDetails<FavoriteTeam>() {
                override fun getPosition() = adapterPosition
                override fun getSelectionKey(): FavoriteTeam = items[position]
            }
    }

}