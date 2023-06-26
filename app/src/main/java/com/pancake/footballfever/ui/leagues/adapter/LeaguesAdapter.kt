package com.pancake.footballfever.ui.leagues.adapter

import com.pancake.footballfever.R
import com.pancake.footballfever.domain.models.League
import com.pancake.footballfever.ui.base.BaseAdapter

class LeaguesAdapter(listener: LeaguesListener): BaseAdapter<League>(listener) {

    override val getLayoutId = R.layout.item_leagues

}