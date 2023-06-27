package com.pancake.footballfever.ui.fixture

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pancake.footballfever.data.local.database.entity.toFixtureModel
import com.pancake.footballfever.domain.models.FixtureModel
import com.pancake.footballfever.domain.models.HeadToHead
import com.pancake.footballfever.domain.usecases.fixutreUseCases.FetchAndCacheFixtureUseCase
import com.pancake.footballfever.domain.usecases.fixutreUseCases.GetCachedFixtureUseCase
import com.pancake.footballfever.ui.fixture.head2head.uiState.HeadToHeadUiEvent
import com.pancake.footballfever.utilities.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FixtureViewModel @Inject constructor(
    private val getCachedFixtureUseCase: GetCachedFixtureUseCase,
    private val fetchAndCacheFixtureUseCase: FetchAndCacheFixtureUseCase,
) : ViewModel() {
    private val _fixtureUiState = MutableStateFlow(FixtureUiState())
    val fixtureUiState = _fixtureUiState.asStateFlow()
    private val _fixtureEvent: MutableStateFlow<Event<FixtureUiEvent>?> =
        MutableStateFlow(null)
     val fixtureEvent = _fixtureEvent.asStateFlow()

    fun fetchFixture(fixtureId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val fixture = fetchAndCacheFixtureUseCase(fixtureId)
            if (fixture.isFailure) {
                _fixtureUiState.update {
                    it.copy(
                        isLoading = false,
                        error = fixture.exceptionOrNull()?.message.toString()
                    )
                }
                return@launch
            }
            _fixtureUiState.update {
                it.copy(
                    isLoading = false,
                    fixture = fixture.getOrNull()?.map { it.toFixtureModel() }?.get(0)
                )
            }
            getFixture(fixtureId)
        }
    }

    private fun getFixture(fixtureId: Int) {

        viewModelScope.launch(Dispatchers.IO) {
            val fixture = getCachedFixtureUseCase()
            if (fixture[0].id == fixtureId) {
                _fixtureUiState.update {
                    it.copy(
                        isLoading = false,
                        fixture = fixture[0]
                    )
                }

            }
        }
    }

    fun refreshData(fixtureId: Int) {
        fetchFixture(fixtureId)
    }
     fun onClickTeamHomeLogo(fixtureModel: FixtureModel) {
        _fixtureEvent.update { Event(FixtureUiEvent.ClickTeamHomeLogoEvent(fixtureModel)) }
            }
     fun onClickTeamAwayLogo(fixtureModel: FixtureModel) {
        _fixtureEvent.update { Event(FixtureUiEvent.ClickTeamAwayLogoEvent(fixtureModel)) }
    }
}
