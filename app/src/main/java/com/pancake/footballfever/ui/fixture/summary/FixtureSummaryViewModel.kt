package com.pancake.footballfever.ui.fixture.summary

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pancake.footballfever.domain.usecases.GetFixtureSummaryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FixtureSummaryViewModel @Inject constructor(
    private val fixtureEventsUseCase: GetFixtureSummaryUseCase
) : ViewModel() {

    private var _fixtureSummaryUiState = MutableStateFlow(FixtureSummaryUiState())
    val fixtureEventsUiState = _fixtureSummaryUiState.asStateFlow()


    fun getFixtureEvents(fixtureId: String) {
        _fixtureSummaryUiState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            try {
                _fixtureSummaryUiState.update {
                    it.copy(
                        isLoading = false,
                        items = fixtureEventsUseCase(fixtureId)
                    )
                }
            } catch (e: Exception) {
                _fixtureSummaryUiState.update {
                    it.copy(
                        isLoading = false,
                        errorMsg = e.message
                    )
                }
            }
        }

    }

}

