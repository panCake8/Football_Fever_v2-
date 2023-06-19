package com.pancake.footballfever.ui.league_state.standing

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pancake.footballfever.ui.league_state.standing.StandingsListener
import com.pancake.footballfever.ui.league_state.standing.StandingsUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class StandingsViewModel @Inject constructor(
    private val getStandingsUseCase: GetStandingsUseCase

) : ViewModel(), StandingsListener {
    private val _uiState = MutableStateFlow(StandingsUIState())
    val uiState: StateFlow<StandingsUIState> = _uiState

    init {
        viewModelScope.launch {
            showStandingsLeague(39, 2019)

        }

    }

    private suspend fun showStandingsLeague(league: Int, season: Int) {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            _uiState.update {
                it.copy(response = getStandingsUseCase.invoke(league, season), isLoading = false)
            }
        }
    }
}