package com.pancake.footballfever.domain.models


data class LeagueMatchUiModel(
    val date: String?,
    val matches: List<LeagueMatch>?,
)

fun Map<String?, List<LeagueMatch>>.toLeagueMatchUi(): List<LeagueMatchUiModel> {
    return entries.map { (keys, value) ->
        LeagueMatchUiModel(date = keys, matches = value)
    }
}
