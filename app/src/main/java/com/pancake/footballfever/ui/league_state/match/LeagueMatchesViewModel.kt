package com.pancake.footballfever.ui.league_state.match

import android.accounts.NetworkErrorException
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pancake.footballfever.domain.models.LeagueMatch
import com.pancake.footballfever.domain.usecases.LeagueMatchesUseCases.GetLeagueMatchesUseCase
import com.pancake.footballfever.ui.league_state.match.adapter.LeagueMatchesListener
import com.pancake.footballfever.ui.league_state.match.uiState.LeagueMatchUiEvent
import com.pancake.footballfever.ui.league_state.match.uiState.LeagueMatchUiState
import com.pancake.footballfever.utilities.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class LeagueMatchesViewModel @Inject constructor(private val leagueMatchesUseCase: GetLeagueMatchesUseCase) :
    ViewModel(), LeagueMatchesListener {

    private val _leagueMatches = MutableStateFlow(LeagueMatchUiState())

    val leagueMatches: StateFlow<LeagueMatchUiState>
        get() = _leagueMatches

    private val _LeagueMatchEvent: MutableStateFlow<Event<LeagueMatchUiEvent>?> =
        MutableStateFlow(null)

    val leagueMatchUiEvent = _LeagueMatchEvent.asStateFlow()

    fun getAllLeagueMatches(season: Int, league: Int) {

        viewModelScope.launch {
            try {
                withContext(IO) {

                    leagueMatchesUseCase.getLeagueMatches(season, league).let { list ->

                        _leagueMatches.update {
                            it.copy(
                                isLoading = false,
                                success = list,
                                error = null,
                                errorMessage = null,
                            )
                        }
                        Log.i("TAG", "${list?.size}")

                    }
                }
                if (leagueMatchesUseCase.getLeagueMatches(season, league)?.isEmpty() == true) {
                    _leagueMatches.update {
                        it.copy(
                            isLoading = false,
                            error = null,
                            errorMessage = "THERE IS NOTHING TO SEE GO AWAY :P",
                        )
                    }
                }

            } catch (e: IOException) {
                _leagueMatches.update {
                    it.copy(
                        isLoading = false,
                        errorMessage = null,
                        error = e.message,
                    )
                }
            }
        }
    }
    fun refreshData( seasons: Int,leagues: Int) {
        getAllLeagueMatches(seasons, leagues)
    }

    override fun onItemClick(leagueMatch: LeagueMatch) {
        _LeagueMatchEvent.update { Event(LeagueMatchUiEvent.LeagueMatchClickEvent(leagueMatch)) }
    }

}