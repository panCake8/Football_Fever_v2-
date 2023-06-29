package com.pancake.footballfever.ui.transfers.adapter

import com.pancake.footballfever.domain.models.Transfers
import com.pancake.footballfever.ui.base.BaseAdapterListener

interface TransfersListener:BaseAdapterListener {

    fun onClickTransfer(transfer: Transfers)
}