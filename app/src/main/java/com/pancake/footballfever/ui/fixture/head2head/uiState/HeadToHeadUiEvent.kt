package com.pancake.footballfever.ui.fixture.head2head.uiState

import com.pancake.footballfever.domain.models.HeadToHead

sealed interface HeadToHeadUiEvent {

    data class ClickHeadToHeadEvent(val headToHead: HeadToHead) : HeadToHeadUiEvent

}