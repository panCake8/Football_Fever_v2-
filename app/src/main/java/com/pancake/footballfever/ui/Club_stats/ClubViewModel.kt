package com.pancake.footballfever.ui.Club_stats

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pancake.footballfever.data.repository.clubRepo.ClubRepository
import com.pancake.footballfever.data.repository.clubRepo.ClubRepositoryImpl
import com.pancake.footballfever.domain.usecases.ClubUseCases.GetCacheDataUseCase
import com.pancake.footballfever.domain.usecases.ClubUseCases.GetClubUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import javax.inject.Inject
@HiltViewModel
class ClubViewModel @Inject constructor(
    private val getClubUseCase: GetClubUseCase,
) : ViewModel() {

    private fun getClubById(clubId:Int){
        viewModelScope.launch {
            getClubUseCase.getClubById(clubId).let {
                Log.i("TAG", "$it")
            }
        }
    }
    init {
        getClubById(33)
    }

}