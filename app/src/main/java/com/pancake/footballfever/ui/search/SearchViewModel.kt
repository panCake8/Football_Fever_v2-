package com.pancake.footballfever.ui.search

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pancake.footballfever.domain.models.SearchItem
import com.pancake.footballfever.domain.models.SearchKeyword
import com.pancake.footballfever.domain.usecases.GetCoachSearchUseCase
import com.pancake.footballfever.domain.usecases.GetLeagueSearchUseCase
import com.pancake.footballfever.domain.usecases.GetSearchKeywordsUseCase
import com.pancake.footballfever.domain.usecases.GetTeamSearchUseCase
import com.pancake.footballfever.utilities.DataState
import com.pancake.footballfever.utilities.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getTeamSearchUseCase: GetTeamSearchUseCase,
    private val getCoachSearchUseCase: GetCoachSearchUseCase,
    private val getLeagueSearchUseCase: GetLeagueSearchUseCase,
    private val getSearchKeywordsUseCase: GetSearchKeywordsUseCase
) : ViewModel(), SearchListener {

    private val _searchResult =
        MutableStateFlow<DataState<Any>>(DataState.Loading)
    val searchResult: StateFlow<DataState<Any>> = _searchResult

    private val _searchEvent: MutableStateFlow<Event<SearchUiEvent>?> = MutableStateFlow(null)
    val searchEvent = _searchEvent.asStateFlow()



    val searchText = MutableStateFlow("")

    private val _searchStatus =
        MutableStateFlow(SearchStatus.LEAGUE)
    private val searchStatus: StateFlow<SearchStatus> = _searchStatus

    private val _searchKeyword =
        MutableStateFlow<List<SearchKeyword>>(emptyList())
    val searchKeyword: StateFlow<List<SearchKeyword>> = _searchKeyword

    init {

        _searchResult.value = DataState.ShowKeywordSuggests
        viewModelScope.launch {
            _searchKeyword.value = getSearchKeywordsUseCase.getSearchKeywords()
            Log.i("aboood", _searchKeyword.value.toString())
        }

    }

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
        _searchStatus.value = SearchStatus.LEAGUE
        getDataBySearchText()
    }

    fun onClickTeamChip() {
        _searchStatus.value = SearchStatus.TEAM
        getDataBySearchText()
    }

    fun onClickCoachChip() {
        _searchStatus.value = SearchStatus.COACH
        getDataBySearchText()
    }

    fun showKeywordSuggests() {
        viewModelScope.launch {
            _searchResult.value = DataState.ShowKeywordSuggests
            _searchKeyword.value = getSearchKeywordsUseCase.getSearchKeywords()
            Log.i("xx3xx", _searchKeyword.value.toString())
        }
    }

    fun cacheKeyword(text: String) {
        viewModelScope.launch {
            if (searchKeyword.value.none { it.keyword == text }) {
                getSearchKeywordsUseCase.insertSearchKeywords(SearchKeyword(text))
            }
        }
    }


    override fun onClick(league: SearchItem) {
        when(searchStatus.value){
            SearchStatus.LEAGUE ->_searchEvent.update { Event(SearchUiEvent.ClickLeagueEvent(league)) }
            SearchStatus.TEAM ->   _searchEvent.update { Event(SearchUiEvent.ClickTeamEvent(league)) }
            SearchStatus.COACH -> TODO()
        }

    }

}