package com.pancake.footballfever.ui.search

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pancake.footballfever.domain.models.SearchItem
import com.pancake.footballfever.domain.usecase.GetCoachSearchUseCase
import com.pancake.footballfever.domain.usecase.GetLeagueSearchUseCase
import com.pancake.footballfever.domain.usecase.GetTeamSearchUseCase
import com.pancake.footballfever.utilities.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getTeamSearchUseCase: GetTeamSearchUseCase,
    private val getCoachSearchUseCase: GetCoachSearchUseCase,
    private val getLeagueSearchUseCase: GetLeagueSearchUseCase
):ViewModel(),SearchListener {


    private val _searchResult =
        MutableStateFlow<DataState<Any>>(DataState.Loading)
    val searchResult: StateFlow<DataState<Any>> get() = _searchResult

    val searchText = MutableStateFlow("")

    private val _searchStatus =
        MutableStateFlow(SearchStatus.LEAGUE)
    private val searchStatus: StateFlow<SearchStatus> get() = _searchStatus


    fun getDataBySearchText() {
        when (searchStatus.value) {
            SearchStatus.TEAM -> {
                getTeamsData()
            }
            SearchStatus.LEAGUE -> {
                getLeaguesData()
            }
            SearchStatus.COACH -> {
                getCoachsData()
            }
        }
    }


    private fun getLeaguesData() {
        viewModelScope.launch {
            try{
                val list=getLeagueSearchUseCase.invoke(searchText.value)
                Log.i("x3x",list.toString())
                _searchResult.value=DataState.Success(list)
            }catch (e:Exception){
                Log.e("x3x", "Error occurred: ${e.message}")
                _searchResult.value=DataState.Error("Error")
            }
        }
    }
    private fun getTeamsData() {
        viewModelScope.launch {
            try{
                val list=getTeamSearchUseCase.invoke(searchText.value)
                Log.i("x3x",list.toString())
                _searchResult.value=DataState.Success(list)
            }catch (e:Exception){
                Log.e("x3x", "Error occurred: ${e.message}")
                _searchResult.value=DataState.Error("Error")
            }
        }
    }


    private fun getCoachsData() {
        viewModelScope.launch {
            try{
                val list=getCoachSearchUseCase.invoke(searchText.value)
                Log.i("x3x",list.toString())
                _searchResult.value=DataState.Success(list)
            }catch (e:Exception){
                Log.e("x3x", "Error occurred: ${e.message}")
                _searchResult.value=DataState.Error("Error")
            }
        }
    }

    fun onClickLeagueChip() {
        _searchStatus.value=SearchStatus.LEAGUE
        getDataBySearchText()
    }

    fun onClickTeamChip() {
        _searchStatus.value=SearchStatus.TEAM
        getDataBySearchText()
    }



    fun onClickCoachChip() {
        _searchStatus.value=SearchStatus.COACH
        getDataBySearchText()
    }






    override fun onClickClub(team: SearchItem) {
    }

    override fun onClickPlayer(player: SearchItem) {
    }

    override fun onClickCoach(player: SearchItem) {
    }
}