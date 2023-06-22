package com.pancake.footballfever.ui.league_state.match

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pancake.footballfever.domain.models.LeagueMatch
import com.pancake.footballfever.domain.usecase.GetLeagueMatchesUseCase
import com.pancake.footballfever.ui.league_state.match.adapter.LeagueMatchesListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LeagueMatchesViewModel @Inject constructor(private val leagueMatchesUseCase: GetLeagueMatchesUseCase) :
    ViewModel(), LeagueMatchesListener {

    private val _leagueMatches = MutableStateFlow(LeagueMatchUiState())

    val leagueMatches: StateFlow<LeagueMatchUiState>
        get() = _leagueMatches

    init {
        getAllLeagueMatches(2022, 39)
    }

    private val _dayDate = MutableLiveData<String>()
    val dayDate: LiveData<String>
        get() = _dayDate

    fun getAllLeagueMatches(season: Int, league: Int) {

        viewModelScope.launch {
            leagueMatchesUseCase.getLeagueMatches(season, league).let { list ->

                _leagueMatches.update {
                    it.copy(
                        isLoading = false,
                        success = list
                    )
                }
                Log.i("TAG", "${list?.size}")

            }
        }

    }



    override fun onItemClick(leagueMatch: LeagueMatch) {

    }

}