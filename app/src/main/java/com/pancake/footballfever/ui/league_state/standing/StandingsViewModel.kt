package com.pancake.footballfever.ui.league_state.standing

import android.util.Log
import androidx.lifecycle.ViewModel
import com.pancake.footballfever.domain.usecase.FetchStandingsAndCacheUseCase
import com.pancake.footballfever.domain.usecase.GetCachedStandingsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject


@HiltViewModel
class StandingsViewModel @Inject constructor(
    private val fetchStandingsAndCacheUseCase: FetchStandingsAndCacheUseCase,
    private val getCachedStandingsUseCase: GetCachedStandingsUseCase

) : ViewModel(), StandingsListener {
    private val _uiState = MutableStateFlow(StandingsUIState())
    val uiState: StateFlow<StandingsUIState> = _uiState

    init {
        Log.i("test","test--------------------")
        fetchStandingsAndCacheUseCase


    }

}