package com.pancake.footballfever.ui.fixture.head2head.adapter

import com.pancake.footballfever.R
import com.pancake.footballfever.domain.models.HeadToHead
import com.pancake.footballfever.ui.base.BaseAdapter

class HeadToHeadChildAdapter(private val listener: HeadToHeadListener):BaseAdapter<HeadToHead>(listener) {
    override val getLayoutId: Int
        get() = R.layout.item_match_stats_head_to_head_child_recycler
}