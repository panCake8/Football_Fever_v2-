package com.pancake.footballfever.ui.league_state.match.adapter

import com.pancake.footballfever.domain.models.LeagueMatch
import com.pancake.footballfever.ui.base.BaseAdapterListener

interface LeagueMatchesListener:BaseAdapterListener {

    fun onItemClick(leagueMatch: LeagueMatch)

}