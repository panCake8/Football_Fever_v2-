package com.pancake.footballfever.ui.club_stats

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pancake.footballfever.data.local.database.entity.toFixtureModel
import com.pancake.footballfever.domain.usecases.ClubUseCases.DeleteClubDataCachedUseCase
import com.pancake.footballfever.domain.usecases.ClubUseCases.GetClubUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class ClubViewModel @Inject constructor(
    private val getClubUseCase: GetClubUseCase,

) : ViewModel() {
    private val _clubUiState = MutableStateFlow(ClubUiState())
    val clubUiState = _clubUiState.asStateFlow()

    init {
        getClub(36)
    }
    private fun getClub(clubId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val club = getClubUseCase.getClubById(clubId)
            _clubUiState.update {
                it.copy(
                    isLoading = false,
                    success = club
                )
            }
        }
    }



}