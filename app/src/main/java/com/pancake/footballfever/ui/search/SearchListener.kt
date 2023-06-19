package com.pancake.footballfever.ui.search

import com.pancake.footballfever.domain.models.SearchItem
import com.pancake.footballfever.ui.base.BaseAdapterListener

interface SearchListener: BaseAdapterListener {
    fun onClickClub(team: SearchItem)
    fun onClickPlayer(player: SearchItem)
    fun onClickCoach(player: SearchItem)
}