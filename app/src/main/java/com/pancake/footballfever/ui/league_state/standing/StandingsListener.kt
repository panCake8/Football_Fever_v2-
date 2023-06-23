package com.pancake.footballfever.ui.league_state.standing

import com.pancake.footballfever.domain.models.Standings
import com.pancake.footballfever.ui.base.BaseAdapterListener

interface StandingsListener : BaseAdapterListener {
    fun onClickClub(standing: Standings)
}