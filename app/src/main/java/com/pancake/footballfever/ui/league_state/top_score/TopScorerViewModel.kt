package com.pancake.footballfever.ui.league_state.top_score

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pancake.footballfever.domain.usecases.topScorerUsecase.FetchTopGoalsUseCase
import com.pancake.footballfever.domain.usecases.topScorerUsecase.GetTopGoalsCachedDataUseCase
import com.pancake.footballfever.ui.league_state.top_score.adapter.TopScorerListener
import com.pancake.footballfever.ui.league_state.top_score.ui_state.TopScorerUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class TopScorerViewModel @Inject constructor(
    private val getTopGoalsCachedDataUseCase: GetTopGoalsCachedDataUseCase,
    private val fetchTopGoalsUseCase: FetchTopGoalsUseCase
) : ViewModel(), TopScorerListener {

    private val _uiState = MutableStateFlow(TopScorerUiState())
    val uiState: StateFlow<TopScorerUiState> = _uiState

    fun fetchData(leagues: Int, seasons: Int) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _uiState.update { it.copy(isLoading = true) }
                val topScore = fetchTopGoalsUseCase(leagues, seasons)
                if (topScore.isFailure) {
                    _uiState.update { it.copy(error = "") }

                    _uiState.update { it.copy(isLoading = false, error = "THERE IS NOTHING TO SHOW GO AWAY :P") }
                }
                if (getTopGoalsCachedDataUseCase(leagues, seasons).isEmpty()) {
                    _uiState.update { it.copy(isLoading = false, errorMessage = "THERE IS NOTHING TO SHOW GO AWAY :P") }

                }
                _uiState.update {
                    it.copy(
                        success = getTopGoalsCachedDataUseCase(leagues, seasons),
                        isLoading = false
                    )
                }


            }

        }
    }

}