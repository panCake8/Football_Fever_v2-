package com.pancake.footballfever.ui.league_state

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pancake.footballfever.domain.usecases.leaguesUsecase.GetCachedLeagueByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LeagueStateViewModel @Inject constructor(
    private val getCachedLeagueByIdUseCase: GetCachedLeagueByIdUseCase
): ViewModel() {

    private val _uiState = MutableStateFlow(LeagueUiState())
    val uiState = _uiState.asStateFlow()

    fun refreshData(fixtureId: Int) {
        getLeague(fixtureId)
    }


    fun getLeague(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _uiState.update { it.copy(loading = true) }
            try {
                val league = getCachedLeagueByIdUseCase(id)
                _uiState.update { it.copy(success = league, loading = false) }
            } catch (e: Exception) {
                _uiState.update { it.copy(errorMessage = "something went wrong :(", loading = false) }

            }
        }
    }

}