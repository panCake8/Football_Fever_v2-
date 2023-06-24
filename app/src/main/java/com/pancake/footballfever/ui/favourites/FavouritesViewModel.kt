package com.pancake.footballfever.ui.favourites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pancake.footballfever.domain.models.FavoriteTeam
import com.pancake.footballfever.domain.usecases.DeleteFromFavouriteTeamsUseCase
import com.pancake.footballfever.domain.usecases.GetAllFavouriteTeams
import com.pancake.footballfever.ui.favourites.adapter.FavouriteTeamListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavouritesViewModel @Inject constructor(
    private val getAllFavouriteTeamsUseCase: GetAllFavouriteTeams,
    private val deleteFavouriteTeamUseCase: DeleteFromFavouriteTeamsUseCase,
) : ViewModel(), FavouriteTeamListener {

    private var _favouriteTeams: MutableStateFlow<List<FavoriteTeam>> =
        MutableStateFlow(emptyList())

    val favouriteTeams: StateFlow<List<FavoriteTeam>> = _favouriteTeams
    init {
        viewModelScope.launch {
            _favouriteTeams.value = getAllFavouriteTeamsUseCase.getAllTeams()
        }
    }

    fun onClickUnfollow(id: Int) {
        viewModelScope.launch {
            deleteFavouriteTeamUseCase.deleteFavouriteTeam(id)
           _favouriteTeams.value = getAllFavouriteTeamsUseCase.getAllTeams()
        }
    }

    override fun onClickTeam(team: FavoriteTeam) {
        TODO("Not yet implemented")
    }
}