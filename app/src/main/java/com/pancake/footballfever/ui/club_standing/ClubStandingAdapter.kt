package com.pancake.footballfever.ui.club_standing

import com.pancake.footballfever.R
import com.pancake.footballfever.domain.models.Standings
import com.pancake.footballfever.ui.base.BaseAdapter

class ClubStandingAdapter(listener: ClubStandingListener) : BaseAdapter<Standings>(listener) {
    override val getLayoutId: Int
        get() = R.layout.item_club_standing

}