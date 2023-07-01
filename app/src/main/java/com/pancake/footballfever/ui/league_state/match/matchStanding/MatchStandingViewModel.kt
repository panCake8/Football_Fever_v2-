package com.pancake.footballfever.ui.league_state.match.matchStanding

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pancake.footballfever.domain.usecases.leagueStandingUseCase.FetchStandingsAndCacheUseCase
import com.pancake.footballfever.domain.usecases.leagueStandingUseCase.GetCachedStandingsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val HOME_TEAM_ID = "homeTeamId"
private const val AWAY_TEAM_ID = "awayTeamId"
private const val SEASON = "season"
@HiltViewModel
class MatchStandingViewModel @Inject constructor(
    private val fetchStandingsAndCacheUseCase: FetchStandingsAndCacheUseCase,
    private val getCachedStandingsUseCase: GetCachedStandingsUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel(), MatchStandingListener {
    private val _uiState = MutableStateFlow(MatchStandingUIState())
    val uiState: StateFlow<MatchStandingUIState> = _uiState

    val homeTeamId = savedStateHandle.get<Int>(HOME_TEAM_ID)!!
    val awayTeamId = savedStateHandle.get<Int>(AWAY_TEAM_ID)!!
    val season = savedStateHandle.get<Int>(SEASON)!!

    init {


        viewModelScope.launch(Dispatchers.IO) {

             fetchStandingsAndCacheUseCase.invoke(homeTeamId,season)

            _uiState.update {
                it.copy(
                    isLoading = false,
                    standings = getCachedStandingsUseCase.invoke(homeTeamId, season),
                )
            }

        }
    }


}