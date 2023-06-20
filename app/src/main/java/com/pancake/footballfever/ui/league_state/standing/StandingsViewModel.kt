package com.pancake.footballfever.ui.league_state.standing

import FetchStandingsWorker
import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.work.Constraints
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import androidx.work.workDataOf
import com.pancake.footballfever.domain.usecase.FetchStandingsAndCacheUseCase
import com.pancake.footballfever.domain.usecase.GetCachedStandingsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.concurrent.TimeUnit
import javax.inject.Inject


@HiltViewModel
class StandingsViewModel @Inject constructor(
    private val fetchStandingsAndCacheUseCase: FetchStandingsAndCacheUseCase,
    private val getCachedStandingsUseCase: GetCachedStandingsUseCase,
//    private val context: Context

) : ViewModel(), StandingsListener {
    private val _uiState = MutableStateFlow(StandingsUIState())
    val uiState: StateFlow<StandingsUIState> = _uiState

//    private val workManager = WorkManager.getInstance(context)

    init {

//        fetchDataPeriodically()


        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                fetchStandingsAndCacheUseCase.invoke(39, 2019)
                _uiState.update { it.copy(isLoading = true) }
                _uiState.update { it.copy(response = getCachedStandingsUseCase.invoke(39, 2019), isLoading = false) }
                Log.i("test","${ uiState.value.response?.get(0)?.teamName}")

            }
        }
    }

//    private fun fetchDataPeriodically() {
//        val constraints = Constraints.Builder()
//            .setRequiredNetworkType(NetworkType.CONNECTED)
//            .build()
//
//        val request = PeriodicWorkRequestBuilder<FetchStandingsWorker>(1, TimeUnit.HOURS)
//            .setConstraints(constraints)
//            .build()
//
//        workManager.enqueueUniquePeriodicWork(
//            FetchStandingsWorker.WORK_NAME,
//            ExistingPeriodicWorkPolicy.KEEP,
//            request
//        )
//    }

//    fun cancelFetchingData() {
//        FetchStandingsWorker.cancel(context)
//    }

//    fun fetchData() {
//        viewModelScope.launch {
//            val cachedData = getCachedStandingsUseCase.invoke(39,2019)
//            cachedData?.let { data->
//                _uiState.update { it.copy(response = data, isLoading = false)  }
//            }
//        }
//    }


}