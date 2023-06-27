package com.pancake.footballfever.ui.search

import com.pancake.footballfever.domain.models.SearchItem

sealed interface SearchUiEvent{

    data class ClickLeagueEvent(val league: SearchItem): SearchUiEvent

    data class ClickTeamEvent(val team: SearchItem): SearchUiEvent

    data class ClickCoachEvent(val coach: SearchItem): SearchUiEvent
}