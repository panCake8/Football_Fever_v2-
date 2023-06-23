package com.pancake.footballfever.ui.clupStanding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pancake.footballfever.domain.usecases.leagueStandingUseCase.FetchStandingsAndCacheUseCase
import com.pancake.footballfever.domain.usecases.leagueStandingUseCase.GetCachedStandingsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClubStandingViewModel @Inject constructor(
    private val fetchStandingsAndCacheUseCase: FetchStandingsAndCacheUseCase,
    private val getCachedStandingsUseCase: GetCachedStandingsUseCase,
) : ViewModel(), ClubStandingListener {
    private val _uiState = MutableStateFlow(ClubStandingUIState())
    val uiState: StateFlow<ClubStandingUIState> = _uiState


    init {

        viewModelScope.launch(Dispatchers.IO) {

            fetchStandingsAndCacheUseCase.invoke(39, 2019)

            _uiState.update {
                it.copy(
                    isLoading = false,
                    standings = getCachedStandingsUseCase.invoke(39, 2019)
                )
            }

        }
    }
}