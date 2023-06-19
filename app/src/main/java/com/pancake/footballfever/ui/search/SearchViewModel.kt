package com.pancake.footballfever.ui.search

import androidx.lifecycle.ViewModel
import com.pancake.footballfever.domain.models.SearchItem

class SearchViewModel:ViewModel(),SearchListener {




    override fun onClickClub(team: SearchItem) {
    }

    override fun onClickPlayer(player: SearchItem) {
    }

    override fun onClickCoach(player: SearchItem) {
    }
}