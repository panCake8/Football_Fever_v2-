package com.pancake.footballfever.ui.leagues.uiState

import com.pancake.footballfever.domain.models.League

sealed interface LeagueUiEvent {
    data class ClickLeagueEvent(val league: League): LeagueUiEvent
    object ClickBackEvent : LeagueUiEvent
    object ClickRetryEvent : LeagueUiEvent
}