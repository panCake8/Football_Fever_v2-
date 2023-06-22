package com.pancake.footballfever.ui.league_state.match.standing

import androidx.core.content.ContextCompat
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.ItemStandingsBinding
import com.pancake.footballfever.domain.models.Standings
import com.pancake.footballfever.ui.base.BaseAdapter

class MatchStandingAdapter(
    listener: MatchStandingListener,
    private val homeTeamId: Int,
    private val awayTeamId: Int
) : BaseAdapter<Standings>(listener) {
    override val getLayoutId: Int
        get() = R.layout.item_standings

    override fun bind(holder: ItemViewHolder, position: Int) {
        super.bind(holder, position)
        val currentItem = getItem(position)
        (holder.binding as ItemStandingsBinding).apply {

            val primaryColor = ContextCompat.getColor(root.context, R.color.Primary_color)
            val secondryColor = ContextCompat.getColor(root.context, R.color.Secondary_color)

            itemRecycle.setBackgroundColor(
                if (currentItem.teamId == homeTeamId ||currentItem.teamId == awayTeamId ) secondryColor
                else primaryColor
            )

        }
    }
}