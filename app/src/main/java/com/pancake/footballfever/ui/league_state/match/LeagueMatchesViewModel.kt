package com.pancake.footballfever.ui.league_state.match

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pancake.footballfever.domain.models.LeagueMatch
import com.pancake.footballfever.domain.usecase.GetLeagueMatchesUseCase
import com.pancake.footballfever.ui.league_state.match.adapter.LeagueMatchesListener
import kotlinx.coroutines.launch
import javax.inject.Inject

class LeagueMatchesViewModel @Inject constructor(private val leagueMatchesUseCase: GetLeagueMatchesUseCase) :
    ViewModel(), LeagueMatchesListener {

    private val _leagueMatches = MutableLiveData<List<LeagueMatch>>()

    val leagueMatches: LiveData<List<LeagueMatch>>
        get() = _leagueMatches


    private val _dayDate = MutableLiveData<String>()
    val dayDate: LiveData<String>
        get() = _dayDate

    fun getAllLeagueMatches(season: Int, league: Int,) {

        viewModelScope.launch {
            leagueMatchesUseCase.getLeagueMatches(season, league).let {

                _leagueMatches.postValue(it)
                Log.i("TAG", "$it")

            }
        }

    }

    fun updateDate(date: String) {
        _dayDate.postValue(date)

    }

    override fun onItemClick(leagueMatch: LeagueMatch) {

    }

}