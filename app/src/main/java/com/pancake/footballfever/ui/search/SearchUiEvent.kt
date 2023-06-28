package com.pancake.footballfever.ui.search

import com.pancake.footballfever.domain.models.SearchItem

sealed interface SearchUiEvent{
    data class ClickLeagueEvent(val item: SearchItem): SearchUiEvent

    data class ClickTeamEvent(val item: SearchItem): SearchUiEvent

}