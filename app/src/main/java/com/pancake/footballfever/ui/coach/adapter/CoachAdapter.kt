package com.pancake.footballfever.ui.coach.adapter

import com.pancake.footballfever.R
import com.pancake.footballfever.domain.models.Coaches
import com.pancake.footballfever.ui.base.BaseAdapter

class CoachAdapter(listener: CoachesListener) : BaseAdapter<Coaches>(listener) {

    override val getLayoutId: Int
        get() = R.layout.item_coaches
}