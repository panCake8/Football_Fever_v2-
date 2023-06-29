package com.pancake.footballfever.ui.fixture.stats

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pancake.footballfever.domain.usecases.FixtureStasticsUseCases.FetchFixtureStatisticsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FixtureStatsViewModel @Inject constructor(
    private val fetchFixtureStatisticsUseCase: FetchFixtureStatisticsUseCase,
) :
    ViewModel() {
    private val _fixtureStatistics = MutableStateFlow(FixtureStatsUiState())
    val fixtureStats = _fixtureStatistics.asStateFlow()


    fun fetchFixtureStats(fixtureId: Int) {
        viewModelScope.launch {
            val response = fetchFixtureStatisticsUseCase(fixtureId)
            if (response.isSuccess){
                _fixtureStatistics.update {
                    it.copy(
                        isLoading = false,
                        success = response.getOrNull()
                    )

                }
            }

        }

    }


}