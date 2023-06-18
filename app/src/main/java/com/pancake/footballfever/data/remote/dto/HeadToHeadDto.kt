package com.example.footboolfever.data.remote.dto

import com.example.footboolfever.data.remote.dto.utils.Fixture
import com.example.footboolfever.data.remote.dto.utils.Teams
import com.google.gson.annotations.SerializedName

data class HeadToHeadDto(

	@field:SerializedName("fixture")
	val fixture: Fixture? = null,

	@field:SerializedName("score")
	val score: FixturesScore? = null,

	@field:SerializedName("teams")
	val teams: Teams? = null,

	@field:SerializedName("league")
	val league: FixturesLeague? = null,

	@field:SerializedName("goals")
	val goals: FixturesGoals? = null
)




