package com.pancake.footballfever.ui.league_state.standing

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pancake.footballfever.domain.usecases.FetchStandingsAndCacheUseCase
import com.pancake.footballfever.domain.usecases.GetCachedStandingsUseCase
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

    init {

        viewModelScope.launch(Dispatchers.IO) {

            fetchStandingsAndCacheUseCase.invoke(39, 2019)

            _uiState.update {
                it.copy(
                    response = getCachedStandingsUseCase.invoke(39, 2019),
                    isLoading = false
                )
            }

        }
    }

}