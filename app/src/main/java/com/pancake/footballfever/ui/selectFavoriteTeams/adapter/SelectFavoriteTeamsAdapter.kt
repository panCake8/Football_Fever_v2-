package com.pancake.footballfever.ui.selectFavoriteTeams.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.selection.SelectionTracker
import com.pancake.footballfever.BR
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.SelectFavoriteTeamsItemBinding
import com.pancake.footballfever.domain.models.FavoriteTeam
import com.pancake.footballfever.ui.base.BaseAdapter
import com.pancake.footballfever.ui.base.BaseAdapterListener

class SelectFavoriteTeamsAdapter(listener: BaseAdapterListener) :
    BaseAdapter<FavoriteTeam>(listener) {
    override val getLayoutId = R.layout.select_favorite_teams_item

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return FavoriteTeamsViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                getLayoutId,
                parent,
                false
            )
        )
    }

    var tracker: SelectionTracker<FavoriteTeam>? = null

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        when (holder) {
            is FavoriteTeamsViewHolder -> bindFavorite(holder, position)
        }
    }

    private fun bindFavorite(holder: FavoriteTeamsViewHolder, position: Int) {
        val currentItem = currentList[position]
        holder.itemView.isActivated = tracker?.isSelected(currentList[position])!!
        holder.binding.apply {
            setVariable(BR.item, currentItem)
        }
    }

    inner class FavoriteTeamsViewHolder(val binding: SelectFavoriteTeamsItemBinding) :
        BaseViewHolder(binding) {

        fun getItemDetails(): ItemDetailsLookup.ItemDetails<FavoriteTeam> =
            object : ItemDetailsLookup.ItemDetails<FavoriteTeam>() {
                override fun getPosition() = adapterPosition
                override fun getSelectionKey(): FavoriteTeam = currentList[position]
            }
    }

    fun getCurrentItem(position: Int) = currentList[position]
    fun getPosition(name: String) = currentList.indexOfFirst { it.name == name }
}