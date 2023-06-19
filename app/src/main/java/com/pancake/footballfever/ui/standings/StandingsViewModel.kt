package com.pancake.footballfever.ui.standings

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


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