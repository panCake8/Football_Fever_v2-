package com.pancake.footballfever.ui.club_stats.player

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pancake.footballfever.domain.models.Player
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
) : ViewModel(), PlayersAdapter.PlayerClickListener {
    private var _playersUiState = MutableStateFlow(PlayerUiState())
    val playersUiState = _playersUiState.asStateFlow()


    fun getPlayers(season: Int, team: Int) {
        _playersUiState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            try {
                _playersUiState.update {
                    it.copy(
                        isLoading = false,
                        items = playersUseCase(season, team)
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

    override fun onClick(player: Player) {

    }
}

