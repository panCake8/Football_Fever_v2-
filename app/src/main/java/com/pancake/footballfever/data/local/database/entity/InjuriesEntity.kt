package com.pancake.footballfever.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.pancake.footballfever.domain.models.Injuries

@Entity(tableName = "INJURIES_TABLE")
data class InjuriesEntity(
    @PrimaryKey
    val id:Int? = null,
    val name:String? = null,
    val photo: String? = null,
    val date: String? = null,
    val reason: String? = null,
    val logoTeam: String? = null,
)

fun InjuriesEntity.toInjuriesModel(): Injuries{
    return Injuries(
        name = name,
        photo = photo,
        date = date,
        reason = reason,
        logoTeam = logoTeam,
    )
}
