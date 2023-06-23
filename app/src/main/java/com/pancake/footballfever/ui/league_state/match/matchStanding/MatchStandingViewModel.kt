package com.pancake.footballfever.ui.league_state.match.matchStanding

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


@HiltViewModel
class MatchStandingViewModel @Inject constructor(
    private val fetchStandingsAndCacheUseCase: FetchStandingsAndCacheUseCase,
    private val getCachedStandingsUseCase: GetCachedStandingsUseCase,


    ) : ViewModel(), MatchStandingListener {
    private val _uiState = MutableStateFlow(MatchStandingUIState())
    val uiState: StateFlow<MatchStandingUIState> = _uiState
    init {

        viewModelScope.launch(Dispatchers.IO) {

            fetchStandingsAndCacheUseCase.invoke(39, 2019)

            _uiState.update {
                it.copy(
                    standings = getCachedStandingsUseCase.invoke(39, 2019),
                    isLoading = false
                )
            }

        }
    }


}