package com.pancake.footballfever.ui.league_state.standing

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pancake.footballfever.domain.usecase.FetchStandingsAndCacheUseCase
import com.pancake.footballfever.domain.usecase.GetCachedStandingsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class StandingsViewModel @Inject constructor(
    private val fetchStandingsAndCacheUseCase: FetchStandingsAndCacheUseCase,
    private val getCachedStandingsUseCase: GetCachedStandingsUseCase

) : ViewModel(), StandingsListener {
    private val _uiState = MutableStateFlow(StandingsUIState())
    val uiState: StateFlow<StandingsUIState> = _uiState



    init {
        _uiState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                fetchStandingsAndCacheUseCase.invoke(39, 2019)

                _uiState.update { it.copy(response = getCachedStandingsUseCase.invoke(39, 2019), isLoading = false) }
                Log.i("test","${_uiState.value}")

            }
        }
    }




//    private suspend fun showStandingsLeague(league: Int, season: Int) {
//        viewModelScope.launch {
//            _uiState.update { it.copy(isLoading = true) }
//            _uiState.update {
//                it.copy(response = getStandingsUseCase.invoke(league, season), isLoading = false)
//            }
//        }
//    }






}