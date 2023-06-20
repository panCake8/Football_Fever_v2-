package com.pancake.footballfever.ui.coach

import com.pancake.footballfever.domain.models.Coaches
import com.pancake.footballfever.ui.base.BaseAdapterListener

interface CoachesListener: BaseAdapterListener {

    fun onClickCoach(coach: Coaches)
}