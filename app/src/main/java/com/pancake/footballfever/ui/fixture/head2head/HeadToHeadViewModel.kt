package com.pancake.footballfever.ui.fixture.head2head

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pancake.footballfever.domain.models.HeadToHead
import com.pancake.footballfever.domain.usecases.MatchHeadToHeadUseCases.GetHeadToHeadsUseCase
import com.pancake.footballfever.ui.fixture.head2head.adapter.HeadToHeadListener
import com.pancake.footballfever.ui.fixture.head2head.uiState.HeadToHeadUiEvent
import com.pancake.footballfever.ui.fixture.head2head.uiState.HeadToHeadUiState
import com.pancake.footballfever.utilities.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HeadToHeadViewModel @Inject
constructor(
    private val getHeadToHeadsUseCase: GetHeadToHeadsUseCase,
) : ViewModel(), HeadToHeadListener {

    private val _HeadToHeads = MutableStateFlow(HeadToHeadUiState())

    val headToHead: StateFlow<HeadToHeadUiState>
        get() = _HeadToHeads

    private val _headToHeadEvent: MutableStateFlow<Event<HeadToHeadUiEvent>?> =
        MutableStateFlow(null)
    val headToHeadEvent = _headToHeadEvent.asStateFlow()

    fun getHeadToHeads(h2h: String) {
        viewModelScope.launch {
            try {
                withContext(IO) {
                    getHeadToHeadsUseCase.getHeadToHeads(h2h).let { list ->
                        _HeadToHeads.update {
                            it.copy(
                                isLoading = false,
                                success = list
                            )
                        }
                    }
                }

            } catch (e: Exception) {
                Log.i("ERROR", e.message.toString())
                _HeadToHeads.update {
                    it.copy(
                        isLoading = false,
                        error = e.message
                    )

                }

            }
        }

    }


    override fun onClick(headToHead: HeadToHead) {
        _headToHeadEvent.update { Event(HeadToHeadUiEvent.ClickHeadToHeadEvent(headToHead)) }
    }
}