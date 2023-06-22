package com.pancake.footballfever.ui.home.adapter

import com.pancake.footballfever.domain.models.FixtureHome
import com.pancake.footballfever.ui.base.BaseAdapterListener

interface FixtureHomeListener : BaseAdapterListener {
    fun onClickFixture(fixture: FixtureHome)
}