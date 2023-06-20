package com.example.footboolfever.data.remote.dto

import com.example.footboolfever.data.remote.dto.utils.Birth
import com.example.footboolfever.data.remote.dto.utils.Team
import com.google.gson.annotations.SerializedName
import com.pancake.footballfever.data.local.database.entity.CoachEntity


data class CoachsDto(

	@field:SerializedName("firstname")
	val firstname: String? = null,

	@field:SerializedName("career")
	val career: List<CareerItem?>? = null,

	@field:SerializedName("nationality")
	val nationality: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("birth")
	val birth: Birth? = null,

	@field:SerializedName("weight")
	val weight: String? = null,

	@field:SerializedName("photo")
	val photo: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("team")
	val team: Team? = null,

	@field:SerializedName("age")
	val age: Int? = null,

	@field:SerializedName("lastname")
	val lastname: String? = null,

	@field:SerializedName("height")
	val height: String? = null
)

data class CareerItem(

	@field:SerializedName("start")
	val start: String? = null,

	@field:SerializedName("end")
	val end: Any? = null,

	@field:SerializedName("team")
	val team: Team? = null
)

fun CoachsDto.toCoachEntity() : CoachEntity{
	return CoachEntity(
		id = id,
		name = name,
		teamName = team?.name,
		photo = photo,
	)
}
