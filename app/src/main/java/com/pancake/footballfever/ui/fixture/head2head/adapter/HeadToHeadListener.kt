package com.pancake.footballfever.ui.fixture.head2head.adapter

import com.pancake.footballfever.domain.models.HeadToHead
import com.pancake.footballfever.ui.base.BaseAdapterListener

interface HeadToHeadListener:BaseAdapterListener {
    fun onClick(headToHead: HeadToHead)
}