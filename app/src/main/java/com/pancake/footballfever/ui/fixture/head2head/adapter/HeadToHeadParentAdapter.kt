package com.pancake.footballfever.ui.fixture.head2head.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.ItemMatchStatsHeadToHeadParenRecyclerBinding
import com.pancake.footballfever.domain.models.HeadToHeadUiModel
import com.pancake.footballfever.ui.base.BaseAdapter

class HeadToHeadParentAdapter(private val listener: HeadToHeadListener) :
    BaseAdapter<HeadToHeadUiModel>(listener) {
    override val getLayoutId: Int
        get() = R.layout.item_match_stats_head_to_head_paren_recycler

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val binding = DataBindingUtil.inflate<ItemMatchStatsHeadToHeadParenRecyclerBinding>(
            LayoutInflater.from(parent.context),
            getLayoutId,
            parent,
            false
        )
        return HeadToHeadParentItemViewHolder(binding)
    }

    override fun bind(holder: ItemViewHolder, position: Int) {
        super.bind(holder, position)

        val currentItem = getItem(position)
        val parentHolder = holder as HeadToHeadParentItemViewHolder
        parentHolder.recycler.adapter = HeadToHeadChildAdapter(listener)
        parentHolder.binding.item = currentItem
    }

    class HeadToHeadParentItemViewHolder(override val binding: ItemMatchStatsHeadToHeadParenRecyclerBinding) :
        ItemViewHolder(binding) {
        val recycler = binding.head2HeadRecycler
    }
}