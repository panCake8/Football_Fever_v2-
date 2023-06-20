package com.pancake.footballfever.ui.coach

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.Glide.init
import com.pancake.footballfever.domain.models.Coaches
import com.pancake.footballfever.domain.usecase.GetCachedCoachUseCase
import com.pancake.footballfever.ui.coach.adapter.CoachesListener
import com.pancake.footballfever.utilities.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoachViewModel @Inject constructor(
    private val getCachedCoachUseCase: GetCachedCoachUseCase,
): ViewModel(),CoachesListener {


    private val _coach = MutableStateFlow(CoachUiState())
    val coach: StateFlow<CoachUiState>
        get() = _coach

    val coachEvent = MutableLiveData<Event<Coaches>>()

    init {
        getCoaches()
    }

    private fun getCoaches() {
        viewModelScope.launch {
            try {
                val coach = getCachedCoachUseCase.invoke()
                _coach.update {
                    it.copy(isLoading = false, success = it.success)
                }
            } catch (e: Throwable) {
                _coach.update { it.copy(error = e.message) }
            }
        }
    }

    override fun onClickCoach(coach: Coaches) {
        coachEvent.postValue(Event(coach))

    }

}

