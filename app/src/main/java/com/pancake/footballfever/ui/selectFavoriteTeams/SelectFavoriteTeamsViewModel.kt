package com.pancake.footballfever.ui.selectFavoriteTeams

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pancake.footballfever.domain.models.FavoriteTeam
import com.pancake.footballfever.domain.usecases.AddSelectedFavoriteTeamsUseCase
import com.pancake.footballfever.domain.usecases.GetPremierLeagueTeamsUseCase
import com.pancake.footballfever.ui.base.BaseAdapterListener
import com.pancake.footballfever.utilities.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SelectFavoriteTeamsViewModel @Inject constructor(
    private val getPremierLeagueTeamsUseCase: GetPremierLeagueTeamsUseCase,
    private val addSelectedFavoriteTeamsUseCase: AddSelectedFavoriteTeamsUseCase
) : ViewModel(), BaseAdapterListener {

    private val _teams = MutableStateFlow(SelectFavoriteTeamsUiState())
    val teams: StateFlow<SelectFavoriteTeamsUiState>
        get() = _teams

    val nextEvent = MutableLiveData<Event<Unit>>()

    val backEvent = MutableLiveData<Event<Unit>>()

    fun getPremierLeagueTeams(countryName: String, season: Int) {
        _teams.update { it.copy(isLoading = true, error = null) }
        viewModelScope.launch {
            try {
                val teams = getPremierLeagueTeamsUseCase.getPremierLeagueTeams(countryName, season)
                _teams.update {
                    it.copy(isLoading = false, success = teams)
                }
            } catch (e: Throwable) {
                _teams.update { it.copy(error = e.message) }
            }
        }
    }

    fun addFavoriteTeams(teams: List<FavoriteTeam>) {
        viewModelScope.launch {
            addSelectedFavoriteTeamsUseCase.addFavoriteTeams(teams)
        }
    }

    fun onNextClick() {
        nextEvent.postValue(Event(Unit))
    }

    fun onBackClick() {
        backEvent.postValue(Event(Unit))
    }
}