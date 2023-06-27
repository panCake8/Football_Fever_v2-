package com.pancake.footballfever.ui.transfers

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pancake.footballfever.data.local.database.entity.toTransferModel
import com.pancake.footballfever.domain.models.Transfers
import com.pancake.footballfever.domain.usecases.transferUseCase.FetchTransfersUseCase
import com.pancake.footballfever.domain.usecases.transferUseCase.GetTransfersUseCase
import com.pancake.footballfever.ui.transfers.adapter.TransfersListener
import com.pancake.footballfever.utilities.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TransfersViewModel @Inject constructor(
    private val fetchTransfersUseCase: FetchTransfersUseCase,
    private val getTransfersUseCase: GetTransfersUseCase,
): ViewModel(),TransfersListener {

    private val _transfer = MutableStateFlow(TransfersUiState())
    val transfer: StateFlow<TransfersUiState>
        get() = _transfer

    val transferEvent = MutableLiveData<Event<Transfers>>()


    init {
        fetchTransfers()
    }

    fun fetchTransfers() {
        viewModelScope.launch {
            try {
                val transfer = fetchTransfersUseCase()
                _transfer.update {
                    it.copy(
                        isLoading = false,
                        success = transfer.getOrNull()!!.map { it.toTransferModel() }
                    )
                }
            } catch (e: Throwable) {
                _transfer.update { it.copy(error = e.message) }
            }
        }
        getTransfers()
    }

    private fun getTransfers(){
        viewModelScope.launch{
            val transfer = getTransfersUseCase()
            _transfer.update {
                it.copy(
                    isLoading = false,
                    success = transfer
                )
            }
        }
    }



    override fun onClickTransfer(transfer: Transfers) {
        transferEvent.postValue(Event(transfer))
    }
}