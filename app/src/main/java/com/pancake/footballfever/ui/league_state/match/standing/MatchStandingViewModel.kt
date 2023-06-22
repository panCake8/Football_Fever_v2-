package com.pancake.footballfever.ui.league_state.match.standing

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
class MatchStandingViewModel @Inject constructor(
    private val fetchStandingsAndCacheUseCase: FetchStandingsAndCacheUseCase,
    private val getCachedStandingsUseCase: GetCachedStandingsUseCase,
    state: SavedStateHandle
) : ViewModel(), MatchStandingListener {
    private val _uiState = MutableStateFlow(MatchStandingUIState())
    val uiState: StateFlow<MatchStandingUIState> = _uiState
    private val machStandingArgs = MatchStandingFragmentArgs.fromSavedStateHandle(state)

    init {

        viewModelScope.launch(Dispatchers.IO) {

            fetchStandingsAndCacheUseCase.invoke(machStandingArgs.homeTeamId, machStandingArgs.season)

            _uiState.update {
                it.copy(
                    response = getCachedStandingsUseCase.invoke(machStandingArgs.homeTeamId, machStandingArgs.season),
                    isLoading = false
                )
            }

        }
    }

}