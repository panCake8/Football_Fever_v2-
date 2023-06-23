package com.pancake.footballfever.ui.team_fixture


import com.pancake.footballfever.R
import com.pancake.footballfever.domain.models.Fixture
import com.pancake.footballfever.ui.base.BaseAdapter
import com.pancake.footballfever.ui.base.BaseAdapterListener

class TeamFixtureAdapter(listener: FixturesClickListener) : BaseAdapter<Fixture>(listener) {
    override val getLayoutId = R.layout.item_fixture
    interface FixturesClickListener : BaseAdapterListener {
        fun onClick(fixture: Fixture)
    }
}