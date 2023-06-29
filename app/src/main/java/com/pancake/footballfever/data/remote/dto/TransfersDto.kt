package com.example.footboolfever.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.pancake.footballfever.data.local.database.entity.TransferEntity

data class TransfersDto(

    @field:SerializedName("transfers")
    val transfers: List<TransfersItem?>? = null,

    @field:SerializedName("update")
    val update: String? = null,

    @field:SerializedName("player")
    val player: TransfersPlayer? = null
)

data class TransfersPlayer(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("id")
    val id: Int? = null
)

data class Out(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("logo")
    val logo: String? = null,

    @field:SerializedName("id")
    val id: Int? = null
)


data class In(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("logo")
    val logo: String? = null,

    @field:SerializedName("id")
    val id: Int? = null
)

data class TransfersItem(

    @field:SerializedName("date")
    val date: String? = null,

    @field:SerializedName("teams")
    val teams: TransfersTeams? = null,

    @field:SerializedName("type")
    val type: String? = null
)

data class TransfersTeams(

    @field:SerializedName("in")
    val on: In? = null,

    @field:SerializedName("out")
    val out: Out? = null
)

fun TransfersDto.toTransfersEntity(): TransferEntity{
    return TransferEntity(
        id = player?.id,
        playerName = player?.name,
        date = transfers?.get(0)?.date,
        transferType = transfers?.get(0)?.type,
        clubNameIN = transfers?.get(0)?.teams?.on?.name,
        clubLogoIN = transfers?.get(0)?.teams?.on?.logo,
        clubNameOut = transfers?.get(0)?.teams?.out?.name,
        clubLogoOut = transfers?.get(0)?.teams?.out?.logo,
    )
}
