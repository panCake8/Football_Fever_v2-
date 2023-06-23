package com.pancake.footballfever.ui.club_standing

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

private const val HOME_TEAM_ID = "teamId"
private const val SEASON = "season"
@HiltViewModel
class ClubStandingViewModel @Inject constructor(
    private val fetchStandingsAndCacheUseCase: FetchStandingsAndCacheUseCase,
    private val getCachedStandingsUseCase: GetCachedStandingsUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel(), ClubStandingListener {
    private val _uiState = MutableStateFlow(ClubStandingUIState())
    val uiState: StateFlow<ClubStandingUIState> = _uiState
    val teamId = savedStateHandle.get<Int>(HOME_TEAM_ID)!!
    val season = savedStateHandle.get<Int>(SEASON)!!

    init {

        viewModelScope.launch(Dispatchers.IO) {

            fetchStandingsAndCacheUseCase.invoke(teamId, season)

            _uiState.update {
                it.copy(
                    isLoading = false,
                    standings = getCachedStandingsUseCase.invoke(teamId, season)
                )
            }

        }
    }
}