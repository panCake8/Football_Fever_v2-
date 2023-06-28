package com.pancake.footballfever.ui.league_state.top_assist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pancake.footballfever.domain.usecases.topAssistUseCase.FetchTopAssistsUseCase
import com.pancake.footballfever.domain.usecases.topAssistUseCase.GetTopAssistsCachedDataUseCase
import com.pancake.footballfever.ui.league_state.top_assist.adapter.TopAssistListener
import com.pancake.footballfever.ui.league_state.top_assist.ui_state.TopAssistUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class TopAssistViewModel @Inject constructor(
    private val getTopAssistsCachedDataUseCase: GetTopAssistsCachedDataUseCase,
    private val fetchTopAssistsUseCase: FetchTopAssistsUseCase,
) : ViewModel(), TopAssistListener {

    private val _uiState = MutableStateFlow(TopAssistUiState())
    val uiState: StateFlow<TopAssistUiState> = _uiState


    fun fetchData(leagues: Int, seasons: Int) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                fetchTopAssistsUseCase(leagues, seasons)

                _uiState.update { it.copy(isLoading = true) }
                _uiState.update {
                    it.copy(
                        topAssistsList = getTopAssistsCachedDataUseCase(leagues, seasons),
                        isLoading = false
                    )
                }

                _uiState.update { it.copy(error = "THERE IS NOTHING TO SHOW GO AWAY :P") }


            }
        }
    }
}