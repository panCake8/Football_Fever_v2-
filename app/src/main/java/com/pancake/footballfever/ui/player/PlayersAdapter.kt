package com.pancake.footballfever.ui.player

import com.pancake.footballfever.R
import com.pancake.footballfever.domain.models.Player
import com.pancake.footballfever.ui.base.BaseAdapter
import com.pancake.footballfever.ui.base.BaseAdapterListener

class PlayersAdapter(listener: PlayerClickListener) : BaseAdapter<Player>(listener) {
    override val getLayoutId = R.layout.item_player

    interface PlayerClickListener : BaseAdapterListener {
        fun onClick(player: Player)
    }
}

