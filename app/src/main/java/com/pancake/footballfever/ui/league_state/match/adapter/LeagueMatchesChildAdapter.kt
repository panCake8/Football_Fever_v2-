package com.pancake.footballfever.ui.league_state.match.adapter

import com.pancake.footballfever.R
import com.pancake.footballfever.domain.models.LeagueMatch
import com.pancake.footballfever.ui.base.BaseAdapter

class LeagueMatchesChildAdapter(private val listener: LeagueMatchesListener):BaseAdapter<LeagueMatch>(listener) {
    override val getLayoutId: Int
        get() = R.layout.item_league_matches_child_recycler
}