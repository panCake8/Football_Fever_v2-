package com.pancake.footballfever.ui.fixture.head2head

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pancake.footballfever.domain.models.HeadToHead
import com.pancake.footballfever.domain.usecase.GetHeadToHeadsUseCase
import com.pancake.footballfever.ui.fixture.head2head.adapter.HeadToHeadListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeadToHeadViewModel @Inject
constructor(
    private val getHeadToHeadsUseCase: GetHeadToHeadsUseCase,
) : ViewModel(), HeadToHeadListener {

    private val _HeadToHeads = MutableStateFlow(HeadToHeadUiState())

    val headToHead: StateFlow<HeadToHeadUiState>
        get() = _HeadToHeads



     fun getHeadToHeads(h2h: String) {
        viewModelScope.launch {
            getHeadToHeadsUseCase.getHeadToHeads(h2h).let { list ->
                _HeadToHeads.update {
                    it.copy(
                        isLoading = false,
                        success = list
                    )
                }
                Log.i("TAG", "${list?.size}")
            }
        }

    }


    override fun onClick(headToHead: HeadToHead) {

    }
}