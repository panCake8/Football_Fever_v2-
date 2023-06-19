package com.pancake.footballfever.ui.search

import androidx.lifecycle.ViewModel
import com.pancake.footballfever.domain.models.SearchItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SearchViewModel: ViewModel(),SearchListener {

    private val _searchResult = MutableStateFlow<List<Any>>(emptyList())
    val searchResult: StateFlow<List<Any>> get() = _searchResult

    val searchText = MutableStateFlow("")

    private val _searchStatus = MutableStateFlow(SearchStatus.PLAYER)
    private val searchStatus: StateFlow<SearchStatus> get() = _searchStatus




    fun onClickClubChip() {
        _searchStatus.value=SearchStatus.CLUB

    }

    fun onClickPlayerChip() {
        _searchStatus.value=SearchStatus.PLAYER
    }

    fun onClickCoachChip() {
        _searchStatus.value=SearchStatus.COACH
    }

    override fun onClickClub(team: SearchItem) {
    }

    override fun onClickPlayer(player: SearchItem) {
    }

    override fun onClickCoach(player: SearchItem) {
    }


}