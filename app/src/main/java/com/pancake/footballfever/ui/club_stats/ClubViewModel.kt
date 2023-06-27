package com.pancake.footballfever.ui.club_stats

import android.provider.Settings.Global
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pancake.footballfever.domain.usecases.AddFavoriteOneTeamUseCase
import com.pancake.footballfever.domain.usecases.ClubUseCases.GetClubUseCase
import com.pancake.footballfever.domain.usecases.DeleteFavoriteTeamUseCase
import com.pancake.footballfever.domain.usecases.GetPremierLeagueTeamsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClubViewModel @Inject constructor(
    private val getClubUseCase: GetClubUseCase,
    private val addFavoriteOneTeamUseCase: AddFavoriteOneTeamUseCase,
    private val deleteFavoriteTeamUseCase: DeleteFavoriteTeamUseCase,
    private val getPremierLeagueTeamsUseCase: GetPremierLeagueTeamsUseCase

) : ViewModel() {
    private val _clubUiEvent = MutableSharedFlow<ClubUiEvent>()
    val clubUiEvent = _clubUiEvent.asSharedFlow()
    private val _clubUiState = MutableStateFlow(ClubUiState())
    val clubUiState = _clubUiState.asStateFlow()
    private val _leagueId = MutableStateFlow(0)
    val leagueId = _leagueId.asStateFlow()


    fun getClub(clubId: Int) {
        viewModelScope.launch(IO) {
            val club = getClubUseCase.getClubById(clubId)
            _clubUiState.update {
                it.copy(
                    isLoading = false,
                    success = club
                )
            }
            _clubUiEvent.emit(ClubUiEvent.OnClickFollow)
        }
    }

    fun getLeagueIdByCountryName() {
        viewModelScope.launch(IO) {
            clubUiState.collect {
                if (it.success != null) {
                Log.i("TAG3", "${it.success.countryName}")
                getPremierLeagueTeamsUseCase.getLeagueIdByCountryName(it.success?.countryName.toString())
                    .let { leagueId ->
                        _leagueId.update {
                            leagueId
                        }
                    }}
            }
        }
    }

    fun addFavoriteOneTeam() {
        viewModelScope.launch(IO) {
            addFavoriteOneTeamUseCase.addFavoriteOneTeam(clubUiState.value.success!!)
            _clubUiEvent.emit(ClubUiEvent.OnClickUnFollow)
        }
    }

    fun deleteFavoriteOneTeam(teamId: Int) {
        viewModelScope.launch(IO) {
            deleteFavoriteTeamUseCase.deleteTeamFromFavorite(teamId)
            _clubUiEvent.emit(ClubUiEvent.OnClickFollow)
        }
    }


}