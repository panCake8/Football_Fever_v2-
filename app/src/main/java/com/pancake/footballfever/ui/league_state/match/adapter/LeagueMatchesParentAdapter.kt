package com.pancake.footballfever.ui.league_state.match.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.ItemLeagueMatchesParentRecyclerBinding
import com.pancake.footballfever.domain.models.LeagueMatchUiModel
import com.pancake.footballfever.ui.base.BaseAdapter

class LeagueMatchesParentAdapter(private val listener: LeagueMatchesListener) :
    BaseAdapter<LeagueMatchUiModel>(listener) {
    override val getLayoutId: Int
        get() = R.layout.item_league_matches_parent_recycler

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val binding = DataBindingUtil.inflate<ItemLeagueMatchesParentRecyclerBinding>(
            LayoutInflater.from(parent.context),
            getLayoutId,
            parent,
            false
        )
        return LeagueMatchParentItemViewHolder(binding)
    }

    override fun bind(holder: ItemViewHolder, position: Int) {
        super.bind(holder, position)

        val currentItem = getItem(position)
        val parentHolder = holder as LeagueMatchParentItemViewHolder
        parentHolder.recycler.adapter = LeagueMatchesChildAdapter(listener)
        parentHolder.binding.item = currentItem

    }

    class LeagueMatchParentItemViewHolder(override val binding: ItemLeagueMatchesParentRecyclerBinding) :
        ItemViewHolder(binding) {

        val recycler: RecyclerView = binding.leagueMatchesRecycler
    }
}
