package com.pancake.footballfever.ui.transfers.adapter

import com.pancake.footballfever.R
import com.pancake.footballfever.domain.models.Transfers
import com.pancake.footballfever.ui.base.BaseAdapter

class TransfersAdapter(listener: TransfersListener):BaseAdapter<Transfers>(listener) {

    override val getLayoutId: Int = R.layout.item_transfers

}