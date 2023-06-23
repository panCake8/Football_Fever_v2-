package com.pancake.footballfever.ui.leagues

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pancake.footballfever.domain.models.League
import com.pancake.footballfever.domain.usecases.leaguesUsecase.FetchCurrentLeagueUseCase
import com.pancake.footballfever.domain.usecases.leaguesUsecase.GetCurrentLeagueCachedDataUseCase
import com.pancake.footballfever.ui.leagues.adapter.LeaguesListener
import com.pancake.footballfever.ui.leagues.uiState.CurrentLeagueUiState
import com.pancake.footballfever.ui.leagues.uiState.LeagueUiEvent
import com.pancake.footballfever.utilities.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LeaguesViewModel @Inject constructor(
    private val fetchCurrentLeagueUseCase: FetchCurrentLeagueUseCase,
    private val getCurrentLeagueCachedDataUseCase: GetCurrentLeagueCachedDataUseCase,
) : ViewModel(), LeaguesListener {

    private val _uiState = MutableStateFlow(CurrentLeagueUiState())
    val uiState = _uiState.asStateFlow()

    private val _leagueEvent: MutableStateFlow<Event<LeagueUiEvent>?> = MutableStateFlow(null)
    val leagueEvent = _leagueEvent.asStateFlow()
    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val result = fetchCurrentLeagueUseCase()

                if (result.isSuccess) {
                    val x = getCurrentLeagueCachedDataUseCase()
                    _uiState.update { it.copy(leagueList = x, loading = false) }
                } else if (result.isFailure) {
                    _uiState.update { it.copy(error = true) }
                }
            }
        }
    }

    override fun onClickLeague(league: League) {
        _leagueEvent.update { Event(LeagueUiEvent.ClickLeagueEvent(league)) }
    }

}