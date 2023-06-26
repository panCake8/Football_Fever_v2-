package com.pancake.footballfever.ui.league_state.standing

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pancake.footballfever.domain.models.Standings
import com.pancake.footballfever.domain.usecases.leagueStandingUseCase.FetchStandingsAndCacheUseCase
import com.pancake.footballfever.domain.usecases.leagueStandingUseCase.GetCachedStandingsUseCase
import com.pancake.footballfever.utilities.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class StandingsViewModel @Inject constructor(
    private val fetchStandingsAndCacheUseCase: FetchStandingsAndCacheUseCase,
    private val getCachedStandingsUseCase: GetCachedStandingsUseCase,


    ) : ViewModel(), StandingsListener {
    private val _uiState = MutableStateFlow(StandingsUIState())
    val uiState: StateFlow<StandingsUIState> = _uiState
    val standingEvent = MutableLiveData<Event<Standings>>()

    fun fetchData(leagueId: Int, season: Int) {
        viewModelScope.launch(Dispatchers.IO) {

            fetchStandingsAndCacheUseCase.invoke(leagueId, season)

            _uiState.update {
                it.copy(
                    response = getCachedStandingsUseCase.invoke(leagueId, season),
                    isLoading = false
                )
            }

        }
    }

    override fun onClickClub(standing:Standings) {
        standingEvent.postValue(Event(standing))
    }


}