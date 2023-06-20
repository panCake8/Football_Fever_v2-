package com.pancake.footballfever.ui.fixture_events

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pancake.footballfever.domain.usecases.GetFixtureEventsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FixtureEventsViewModel @Inject constructor(
    private val fixtureEventsUseCase: GetFixtureEventsUseCase
) : ViewModel() {

    private var _fixtureEventsUiState = MutableStateFlow(FixtureEventsUiState())
    val fixtureEventsUiState = _fixtureEventsUiState.asStateFlow()


    fun getFixtureEvents(fixtureId: String) {
        _fixtureEventsUiState.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            try {
                val e = fixtureEventsUseCase(fixtureId)
                _fixtureEventsUiState.update {
                    it.copy(
                        isLoading = false,
                        items = e
                    )
                }
            } catch (e: Exception) {
                _fixtureEventsUiState.update {
                    it.copy(
                        isLoading = false,
                        errorMsg = e.message
                    )
                }
            }
        }

    }

}

