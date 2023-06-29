package com.pancake.footballfever.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.pancake.footballfever.domain.models.Transfers

@Entity(tableName = "TRANSFER_TABLE")
data class TransferEntity(
    @PrimaryKey
    val id:Int? = null,
    val playerName:String? = null,
    val date:String? = null,
    val transferType: String? = null,
    val clubNameIN: String? = null,
    val clubLogoIN: String? = null,
    val clubNameOut: String? = null,
    val clubLogoOut: String? = null,
)

fun TransferEntity.toTransferModel(): Transfers{
    return Transfers(
        playerName = playerName,
        date = date,
        transferType = transferType,
        clubNameIN = clubNameIN,
        clubLogoIN = clubLogoIN,
        clubNameOut = clubNameOut,
        clubLogoOut = clubLogoOut,
    )
}