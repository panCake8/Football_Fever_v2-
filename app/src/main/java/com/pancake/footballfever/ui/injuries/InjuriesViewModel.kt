package com.pancake.footballfever.ui.injuries

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pancake.footballfever.data.local.database.entity.toInjuriesModel
import com.pancake.footballfever.domain.models.Injuries
import com.pancake.footballfever.domain.usecases.FetchInjuriesUseCase
import com.pancake.footballfever.domain.usecases.GetInjuriesUseCase
import com.pancake.footballfever.ui.injuries.adapter.InjuriesListener
import com.pancake.footballfever.utilities.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InjuriesViewModel @Inject constructor(
    private val fetchInjuriesUseCase: FetchInjuriesUseCase,
    private val getInjuriesUseCase: GetInjuriesUseCase,
): ViewModel(), InjuriesListener {


    private val _injury = MutableStateFlow(InjuriesUiState())
    val injury: StateFlow<InjuriesUiState>
        get() = _injury

    val injuryEvent = MutableLiveData<Event<Unit>>()

    init {
        fetchInjuries()
    }

    fun fetchInjuries() {
        viewModelScope.launch {
            try {
                val injury = fetchInjuriesUseCase()
                _injury.update {
                    it.copy(
                        isLoading = false,
                        success = injury.getOrNull()!!.map { it.toInjuriesModel() }
                    )
                }
            } catch (e: Throwable) {
                _injury.update { it.copy(error = e.message) }
            }
        }
        getInjuries()
    }

    private fun getInjuries(){
        viewModelScope.launch{
            val injury = getInjuriesUseCase()
            _injury.update {
                it.copy(
                    isLoading = false,
                    success = injury
                )
            }
        }
    }

    override fun onClickInjury() {
        injuryEvent.postValue(Event(Unit))
    }

}