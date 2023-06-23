package com.pancake.footballfever.ui.injuries.adapter

import com.pancake.footballfever.domain.models.Injuries
import com.pancake.footballfever.ui.base.BaseAdapterListener

interface InjuriesListener:BaseAdapterListener {

    fun onClickInjury(injuries: Injuries)
}