package com.pancake.footballfever.ui.player

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pancake.footballfever.domain.usecases.GetPlayersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PlayersViewModel @Inject constructor(
    private val playersUseCase: GetPlayersUseCase
) : ViewModel() {
    private var _playersUiState = MutableStateFlow(PlayerUiState())
    val playersUiState = _playersUiState.asStateFlow()


    fun getPlayers(fixture: String, team: String) {
        _playersUiState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            try {
                _playersUiState.update {
                    it.copy(
                        isLoading = false,
                        items = playersUseCase(fixture, team)
                    )
                }
            } catch (e: Exception) {
                _playersUiState.update {
                    it.copy(
                        isLoading = false,
                        errorMsg = e.message
                    )
                }
            }
        }

    }
}

