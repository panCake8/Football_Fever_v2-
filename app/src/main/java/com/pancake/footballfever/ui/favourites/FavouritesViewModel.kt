package com.pancake.footballfever.ui.favourites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pancake.footballfever.domain.models.FavoriteTeam
import com.pancake.footballfever.domain.usecases.DeleteFromFavouriteTeamsUseCase
import com.pancake.footballfever.domain.usecases.GetAllFavouriteTeams
import com.pancake.footballfever.ui.favourites.adapter.FavouriteTeamListener
import com.pancake.footballfever.utilities.DataState
import com.pancake.footballfever.utilities.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavouritesViewModel @Inject constructor(
    private val getAllFavouriteTeamsUseCase: GetAllFavouriteTeams,
    private val deleteFavouriteTeamUseCase: DeleteFromFavouriteTeamsUseCase,
) : ViewModel(), FavouriteTeamListener {

    private var _favouriteTeams: MutableStateFlow<DataState<Any>> =
        MutableStateFlow(DataState.Error("error"))

    val favouriteTeams: StateFlow<DataState<Any>> = _favouriteTeams

    private val _teamEvent: MutableStateFlow<Event<FavouriteUiEvent>?> = MutableStateFlow(null)
    val teamEvent = _teamEvent.asStateFlow()

    init {
        getAllFavouriteLocal()
        viewModelScope.launch {
                _favouriteTeams.value =
                    if(getAllFavouriteTeamsUseCase.getAllTeams().isNotEmpty())
                    DataState.Success(getAllFavouriteTeamsUseCase.getAllTeams())
                    else DataState.Error("error")
        }
    }

    private fun getAllFavouriteLocal(){
        viewModelScope.launch {
            getAllFavouriteTeamsUseCase.getAllTeams()
        }
    }
    fun onClickUnfollow(id: Int) {
        viewModelScope.launch {
            deleteFavouriteTeamUseCase.deleteFavouriteTeam(id)
            _favouriteTeams.value =
                if(getAllFavouriteTeamsUseCase.getAllTeams().isNotEmpty())
                    DataState.Success(getAllFavouriteTeamsUseCase.getAllTeams())
                else DataState.Error("error")
        }
    }

    override fun onClickTeam(team: FavoriteTeam) {
        _teamEvent.update { Event(FavouriteUiEvent.ClickTeamEvent(team)) }
    }
}