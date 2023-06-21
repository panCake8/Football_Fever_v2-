package com.pancake.footballfever.ui.clubStats

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pancake.footballfever.domain.usecases.FetchStandingsAndCacheUseCase
import com.pancake.footballfever.domain.usecases.GetCachedStandingsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClubStandingsViewModel @Inject constructor(
    private val fetchStandingsAndCacheUseCase: FetchStandingsAndCacheUseCase,
    private val getCachedStandingsUseCase: GetCachedStandingsUseCase,
    state: SavedStateHandle
) : ViewModel(), ClubStandingListener {
    private val _uiState = MutableStateFlow(ClubStandingsUIState())
    val uiState: StateFlow<ClubStandingsUIState> = _uiState
    private val clubStandingArgs = ClubStandingFragmentArgs.fromSavedStateHandle(state)

    init {
        getStandings()
    }

    private fun getStandings() {
        val teamId = clubStandingArgs.teamId
        val season = clubStandingArgs.seasonId
        viewModelScope.launch(Dispatchers.IO) {
            fetchStandingsAndCacheUseCase.invoke(teamId, season)
            _uiState.update {
                it.copy(
                    response = getCachedStandingsUseCase.invoke(teamId, season),
                    isLoading = false
                )
            }
        }
    }


}
