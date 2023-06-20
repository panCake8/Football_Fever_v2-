package com.pancake.footballfever.ui.league_state.top_score

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pancake.footballfever.domain.usecases.FetchTopGoalsUseCase
import com.pancake.footballfever.domain.usecases.GetTopGoalsCachedDataUseCase
import com.pancake.footballfever.ui.league_state.top_score.adapter.TopScorerListener
import com.pancake.footballfever.ui.league_state.top_score.ui_state.TopScorerUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TopScorerViewModel @Inject constructor(
    private val getTopGoalsCachedDataUseCase: GetTopGoalsCachedDataUseCase,
    private val fetchTopGoalsUseCase: FetchTopGoalsUseCase
): ViewModel(), TopScorerListener {

    private val _uiState = MutableStateFlow(TopScorerUiState())
    val uiState: StateFlow<TopScorerUiState> = _uiState

    init {
        viewModelScope.launch {

        }
    }

    private fun showTopScorer(league: Int, season: Int) {
        viewModelScope.launch {

        }
    }
//    fun fetchData(leagues: Int, seasons: Int) {
//        viewModelScope.launch {
//            val result = fetchTopGoalsUseCase(leagues, seasons)
//            if (result.isSuccess) {
//                _uiState.update { it.copy(isLoading = true) }
//                _uiState.update { it.copy(response = getAllScorerUseCase.invoke(league, season), isLoading = false) }
//            } else if (result.isFailure) {
//                // do something else
//            }
//        }
//    }
//
//    fun getCachedDataData() {
//        viewModelScope.launch {
//            val cachedData = getTopGoalsCachedDataUseCase()
//            cachedData?.let {
//                // give it the value :)
//            }
//        }
//    }

}