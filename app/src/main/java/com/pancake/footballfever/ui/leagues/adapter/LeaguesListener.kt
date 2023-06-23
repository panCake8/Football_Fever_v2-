package com.pancake.footballfever.ui.leagues.adapter

import com.pancake.footballfever.domain.models.League
import com.pancake.footballfever.ui.base.BaseAdapterListener

interface LeaguesListener : BaseAdapterListener {
    fun onClickLeague(league: League)
}