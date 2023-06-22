package com.pancake.footballfever.ui.injuries.adapter

import com.pancake.footballfever.R
import com.pancake.footballfever.domain.models.Injuries

class InjuriesAdapter(listener: InjuriesListener) : com.pancake.footballfever.ui.base.BaseAdapter<Injuries>(listener) {

    override val getLayoutId: Int = R.layout.item_injuries

}