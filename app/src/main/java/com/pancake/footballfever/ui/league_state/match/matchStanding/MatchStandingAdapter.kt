package com.pancake.footballfever.ui.league_state.match.matchStanding

import com.pancake.footballfever.R
import com.pancake.footballfever.domain.models.Standings
import com.pancake.footballfever.ui.base.BaseAdapter

class MatchStandingAdapter(listener: MatchStandingListener) : BaseAdapter<Standings>(listener) {
    override val getLayoutId: Int
        get() = R.layout.item_match_standing

}