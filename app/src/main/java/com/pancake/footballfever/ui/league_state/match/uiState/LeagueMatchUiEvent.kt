package com.pancake.footballfever.ui.league_state.match.uiState

import com.pancake.footballfever.domain.models.LeagueMatch

sealed interface LeagueMatchUiEvent {

    data class LeagueMatchClickEvent(val match: LeagueMatch) : LeagueMatchUiEvent
}