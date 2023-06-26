package com.pancake.footballfever.ui.club_stats

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pancake.footballfever.domain.usecases.AddFavoriteOneTeamUseCase
import com.pancake.footballfever.domain.usecases.ClubUseCases.GetClubUseCase
import com.pancake.footballfever.domain.usecases.DeleteFavoriteTeamUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class ClubViewModel @Inject constructor(
    private val getClubUseCase: GetClubUseCase,
    private val addFavoriteOneTeamUseCase: AddFavoriteOneTeamUseCase,
    private val deleteFavoriteTeamUseCase: DeleteFavoriteTeamUseCase,

    ) : ViewModel() {
    private val _clubUiEvent = MutableSharedFlow<ClubUiEvent>()
    val clubUiEvent = _clubUiEvent.asSharedFlow()
    private val _clubUiState = MutableStateFlow(ClubUiState())
    val clubUiState = _clubUiState.asStateFlow()


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
    fun addFavoriteOneTeam(){
        viewModelScope.launch(IO) {
            addFavoriteOneTeamUseCase.addFavoriteOneTeam(clubUiState.value.success!!)
            _clubUiEvent.emit(ClubUiEvent.OnClickUnFollow)
        }
    }
    fun deleteFavoriteOneTeam(teamId:Int){
        viewModelScope.launch(IO) {
            deleteFavoriteTeamUseCase.deleteTeamFromFavorite(teamId)
            _clubUiEvent.emit(ClubUiEvent.OnClickFollow)
        }
    }



}