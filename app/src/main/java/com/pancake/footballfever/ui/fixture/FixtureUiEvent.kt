package com.pancake.footballfever.ui.fixture

import com.pancake.footballfever.domain.models.FixtureModel

sealed interface FixtureUiEvent {
    data class ClickTeamHomeLogoEvent(val fixtureModel: FixtureModel) : FixtureUiEvent
    data class ClickTeamAwayLogoEvent(val fixtureModel: FixtureModel) : FixtureUiEvent
}