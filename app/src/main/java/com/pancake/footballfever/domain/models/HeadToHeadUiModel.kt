package com.pancake.footballfever.domain.models

data class HeadToHeadUiModel(
    val season: Int?,
    val leagueLogo: String?,
    val HeadToHeads: List<HeadToHead>,
)

fun Map<Int?, List<HeadToHead>>.toHeadToHeadUiModel(): List<HeadToHeadUiModel> {
    return entries.map { (key, items) ->
        HeadToHeadUiModel(key, items[0].leagueLogo, items)
    }

}