package com.pancake.footballfever.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pancake.footballfever.domain.models.FixtureHome
import com.pancake.footballfever.domain.usecases.DeleteAllFixturesHomeUseCase
import com.pancake.footballfever.domain.usecases.GetAllFixtureHomeLocalUseCase
import com.pancake.footballfever.domain.usecases.RefreshAllFixtureHomeUseCase
import com.pancake.footballfever.ui.home.adapter.FixtureHomeListener
import com.pancake.footballfever.utilities.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getFixturesLocalUseCase: GetAllFixtureHomeLocalUseCase,
    private val refreshFixtureUseCase: RefreshAllFixtureHomeUseCase,
    private val deleteAllFixturesUseCase: DeleteAllFixturesHomeUseCase
) : ViewModel(), FixtureHomeListener {

    private val _fixtures = MutableStateFlow(HomeUiState())
    val fixtures: StateFlow<HomeUiState>
        get() = _fixtures

    val fixtureEvent = MutableLiveData<Event<FixtureHome>>()

     fun getFixtureLocal() {
        viewModelScope.launch {
            getFixturesLocalUseCase.getAllFixtureHomeLocal()
                .stateIn(scope = viewModelScope)
                .collect { fixtures ->
                    _fixtures.update {
                        it.copy(isLoading = false, success = fixtures , error = null)
                    }
                }

        }
    }

    fun refreshFixtures(date: String, season: Int) {
        viewModelScope.launch {
            _fixtures.update { it.copy(isLoading = true, error = null) }
            val request = refreshFixtureUseCase.refreshAllFixtureHome(date, season)
            if (request.isFailure) {
                _fixtures.update { it.copy(error = request.exceptionOrNull()?.message) }
            }
        }
    }

    fun deleteAllFixtures() {
        viewModelScope.launch {
            deleteAllFixturesUseCase()
        }
    }

    override fun onClickFixture(fixture: FixtureHome) {
        fixtureEvent.postValue(Event(fixture))
    }
}