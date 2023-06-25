package com.pancake.footballfever.ui.league_state.top_assist.adapter

import com.pancake.footballfever.R
import com.pancake.footballfever.domain.models.TopAssists
import com.pancake.footballfever.ui.base.BaseAdapter

class TopAssistAdapter(listener: TopAssistListener) : BaseAdapter<TopAssists>(listener) {

    override val getLayoutId: Int
        get() = R.layout.item_assist

}