package com.pancake.footballfever.ui.leagues

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pancake.footballfever.domain.models.League
import com.pancake.footballfever.domain.usecases.leaguesUsecase.FetchCurrentLeagueUseCase
import com.pancake.footballfever.domain.usecases.leaguesUsecase.GetCurrentLeagueCachedDataUseCase
import com.pancake.footballfever.domain.usecases.leaguesUsecase.SearchLeagueUseCase
import com.pancake.footballfever.ui.leagues.adapter.LeaguesListener
import com.pancake.footballfever.ui.leagues.uiState.CurrentLeagueUiState
import com.pancake.footballfever.ui.leagues.uiState.LeagueUiEvent
import com.pancake.footballfever.utilities.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
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
    private val searchLeagueUseCase: SearchLeagueUseCase,
) : ViewModel(), LeaguesListener {

    private val _uiState = MutableStateFlow(CurrentLeagueUiState())
    val uiState = _uiState.asStateFlow()

    private val _leagueEvent: MutableStateFlow<Event<LeagueUiEvent>?> = MutableStateFlow(null)
    val leagueEvent = _leagueEvent.asStateFlow()

    init {
        fetchData()
    }

    fun fetchData() {
        viewModelScope.launch {
            _uiState.update { it.copy(loading = true) }
            withContext(Dispatchers.IO) {
                if (getCurrentLeagueCachedDataUseCase().isEmpty()) {
                    val result = fetchCurrentLeagueUseCase()
                    if (result.isSuccess) {
                        _uiState.update {
                            it.copy(
                                leagueList = getCurrentLeagueCachedDataUseCase(),
                                loading = false
                            )
                        }
                    } else if (result.isFailure) {
                        _uiState.update { it.copy(error = "") }
                    }
                } else {
                    _uiState.update {
                        it.copy(
                            leagueList = getCurrentLeagueCachedDataUseCase(),
                            loading = false
                        )
                    }
                }
            }
        }
    }

    fun onSearchInputChange(searchTerm: String) : Job {
        _uiState.update { it.copy(searchInput = searchTerm.toString(), loading = true) }
        return viewModelScope.launch {
            withContext(Dispatchers.IO) {
                if (searchLeagueUseCase(searchTerm.toString()).isEmpty()) {
                    _uiState.update {
                        it.copy(
                            error = "search for something that does exist :((((",
                            leagueList = emptyList(),
                            loading = false
                        )
                    }
                }  else {
                    _uiState.update { it.copy(loading = true) }
                    _uiState.update {
                        it.copy(
                            error = null,
                            leagueList = searchLeagueUseCase(it.searchInput),
                            loading = false
                        )
                    }
                }
            }
        }
    }

    override fun onClickLeague(league: League) {
        _leagueEvent.update { Event(LeagueUiEvent.ClickLeagueEvent(league)) }
    }

    fun refreshData() {
        fetchData()
    }

    fun onClickBack() {
        _leagueEvent.update { Event(LeagueUiEvent.ClickBackEvent) }
    }

}