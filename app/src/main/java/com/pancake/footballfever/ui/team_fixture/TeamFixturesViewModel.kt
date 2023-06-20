package com.pancake.footballfever.ui.team_fixture

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pancake.footballfever.domain.usecases.GetTeamFixturesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeamFixturesViewModel @Inject constructor(
    private val fixturesUseCase: GetTeamFixturesUseCase
) : ViewModel() {
    private var _fixturesUiState = MutableStateFlow(TeamFixtureUiState())
    val fixturesUiState = _fixturesUiState.asStateFlow()


    fun getFixtures(season: String, team: String) {
        _fixturesUiState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            try {
                _fixturesUiState.update {
                    it.copy(
                        isLoading = false,
                        items = fixturesUseCase(season, team)
                    )
                }
            } catch (e: Exception) {
                _fixturesUiState.update {
                    it.copy(
                        isLoading = false,
                        errorMsg = e.message
                    )
                }
            }
        }

    }
}
