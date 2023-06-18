package com.example.footboolfever.data.remote.dto.teams

import com.google.gson.annotations.SerializedName

data class TeamsStatisticsDto(

	@field:SerializedName("failed_to_score")
	val failedToScore: FailedToScore? = null,

	@field:SerializedName("cards")
	val cards: Cards? = null,

	@field:SerializedName("form")
	val form: String? = null,

	@field:SerializedName("biggest")
	val biggest: Biggest? = null,

	@field:SerializedName("clean_sheet")
	val cleanSheet: CleanSheet? = null,

	@field:SerializedName("penalty")
	val penalty: Penalty? = null,

	@field:SerializedName("league")
	val league: League? = null,

	@field:SerializedName("team")
	val team: Team? = null,

	@field:SerializedName("fixtures")
	val fixtures: Fixtures? = null,

	@field:SerializedName("goals")
	val goals: Goals? = null,

	@field:SerializedName("lineups")
	val lineups: List<LineupsItem?>? = null
)

data class Minute61To75(

	@field:SerializedName("total")
	val total: Any? = null,

	@field:SerializedName("percentage")
	val percentage: Any? = null
)

data class JsonMemberFor(

	@field:SerializedName("average")
	val average: Average? = null,

	@field:SerializedName("total")
	val total: Total? = null,

	@field:SerializedName("minute")
	val minute: Minute? = null,

	@field:SerializedName("away")
	val away: Int? = null,

	@field:SerializedName("home")
	val home: Int? = null
)

data class Scored(

	@field:SerializedName("total")
	val total: Int? = null,

	@field:SerializedName("percentage")
	val percentage: String? = null
)

data class Average(

	@field:SerializedName("total")
	val total: String? = null,

	@field:SerializedName("away")
	val away: String? = null,

	@field:SerializedName("home")
	val home: String? = null
)

data class Minute46To60(

	@field:SerializedName("total")
	val total: Any? = null,

	@field:SerializedName("percentage")
	val percentage: Any? = null
)

data class Minute31To45(

	@field:SerializedName("total")
	val total: Any? = null,

	@field:SerializedName("percentage")
	val percentage: Any? = null
)

data class Red(

	@field:SerializedName("106-120")
	val minute106_120: Minute106To120? = null,

	@field:SerializedName("46-60")
	val minute46_60: Minute46To60? = null,

	@field:SerializedName("31-45")
	val minute31_45: Minute31To45? = null,

	@field:SerializedName("76-90")
	val minute76_90: Minute76To90? = null,

	@field:SerializedName("0-15")
	val minute0_15: Minute0To15? = null,

	@field:SerializedName("91-105")
	val minute91_105: Minute91To105? = null,

	@field:SerializedName("16-30")
	val minute16_30: Minute16To30? = null,

	@field:SerializedName("61-75")
	val minute61_75: Minute61To75? = null
)

data class CleanSheet(

	@field:SerializedName("total")
	val total: Int? = null,

	@field:SerializedName("away")
	val away: Int? = null,

	@field:SerializedName("home")
	val home: Int? = null
)

data class Total(

	@field:SerializedName("total")
	val total: Int? = null,

	@field:SerializedName("away")
	val away: Int? = null,

	@field:SerializedName("home")
	val home: Int? = null
)

data class Penalty(

	@field:SerializedName("total")
	val total: Int? = null,

	@field:SerializedName("scored")
	val scored: Scored? = null,

	@field:SerializedName("missed")
	val missed: Missed? = null
)

data class LineupsItem(

	@field:SerializedName("formation")
	val formation: String? = null,

	@field:SerializedName("played")
	val played: Int? = null
)

data class Goals(

	@field:SerializedName("against")
	val against: Against? = null,

	@field:SerializedName("for")
	val jsonMemberFor: JsonMemberFor? = null
)

data class Fixtures(

	@field:SerializedName("wins")
	val wins: Wins? = null,

	@field:SerializedName("loses")
	val loses: Loses? = null,

	@field:SerializedName("draws")
	val draws: Draws? = null,

	@field:SerializedName("played")
	val played: Played? = null
)

data class Yellow(

	@field:SerializedName("106-120")
	val minute106_120: Minute106To120? = null,

	@field:SerializedName("46-60")
	val minute46_60: Minute46To60? = null,

	@field:SerializedName("31-45")
	val minute31_45: Minute31To45? = null,

	@field:SerializedName("76-90")
	val minute76_90: Minute76To90? = null,

	@field:SerializedName("0-15")
	val minute0_15: Minute0To15? = null,

	@field:SerializedName("91-105")
	val minute91_105: Minute91To105? = null,

	@field:SerializedName("16-30")
	val minute16_30: Minute16To30? = null,

	@field:SerializedName("61-75")
	val minute61_75: Minute61To75? = null
)

data class Minute76To90(

	@field:SerializedName("total")
	val total: Any? = null,

	@field:SerializedName("percentage")
	val percentage: Any? = null
)



data class Minute91To105(

	@field:SerializedName("total")
	val total: Any? = null,

	@field:SerializedName("percentage")
	val percentage: Any? = null
)

data class Streak(

	@field:SerializedName("wins")
	val wins: Int? = null,

	@field:SerializedName("loses")
	val loses: Int? = null,

	@field:SerializedName("draws")
	val draws: Int? = null
)

data class League(

	@field:SerializedName("country")
	val country: String? = null,

	@field:SerializedName("flag")
	val flag: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("logo")
	val logo: String? = null,

	@field:SerializedName("season")
	val season: Int? = null,

	@field:SerializedName("id")
	val id: Int? = null
)

data class Missed(

	@field:SerializedName("total")
	val total: Int? = null,

	@field:SerializedName("percentage")
	val percentage: String? = null
)

data class Biggest(

	@field:SerializedName("wins")
	val wins: Wins? = null,

	@field:SerializedName("loses")
	val loses: Loses? = null,

	@field:SerializedName("streak")
	val streak: Streak? = null,

	@field:SerializedName("goals")
	val goals: Goals? = null
)

data class Minute0To15(

	@field:SerializedName("total")
	val total: Any? = null,

	@field:SerializedName("percentage")
	val percentage: Any? = null
)



data class Wins(

	@field:SerializedName("total")
	val total: Int? = null,

	@field:SerializedName("away")
	val away: String? = null,

	@field:SerializedName("home")
	val home: String? = null
)

data class Against(

	@field:SerializedName("average")
	val average: Average? = null,

	@field:SerializedName("total")
	val total: Total? = null,

	@field:SerializedName("minute")
	val minute: Minute? = null,

	@field:SerializedName("away")
	val away: Int? = null,

	@field:SerializedName("home")
	val home: Int? = null
)

data class Minute106To120(

	@field:SerializedName("total")
	val total: Any? = null,

	@field:SerializedName("percentage")
	val percentage: Any? = null
)

data class Loses(

	@field:SerializedName("total")
	val total: Int? = null,

	@field:SerializedName("away")
	val away: String? = null,

	@field:SerializedName("home")
	val home: String? = null
)

data class Played(

	@field:SerializedName("total")
	val total: Int? = null,

	@field:SerializedName("away")
	val away: Int? = null,

	@field:SerializedName("home")
	val home: Int? = null
)

data class Minute(

	@field:SerializedName("106-120")
	val minute106_120: Minute106To120? = null,

	@field:SerializedName("46-60")
	val minute46_60: Minute46To60? = null,

	@field:SerializedName("31-45")
	val minute31_45: Minute31To45? = null,

	@field:SerializedName("76-90")
	val minute76_90: Minute76To90? = null,

	@field:SerializedName("0-15")
	val minute0_15: Minute0To15? = null,

	@field:SerializedName("91-105")
	val minute91_105: Minute91To105? = null,

	@field:SerializedName("16-30")
	val minute16_30: Minute16To30? = null,

	@field:SerializedName("61-75")
	val minute61_75: Minute61To75? = null
)

data class Minute16To30(

	@field:SerializedName("total")
	val total: Any? = null,

	@field:SerializedName("percentage")
	val percentage: Any? = null
)


data class Cards(

	@field:SerializedName("red")
	val red: Red? = null,

	@field:SerializedName("yellow")
	val yellow: Yellow? = null
)

data class FailedToScore(

	@field:SerializedName("total")
	val total: Int? = null,

	@field:SerializedName("away")
	val away: Int? = null,

	@field:SerializedName("home")
	val home: Int? = null
)

data class Draws(

	@field:SerializedName("total")
	val total: Int? = null,

	@field:SerializedName("away")
	val away: Int? = null,

	@field:SerializedName("home")
	val home: Int? = null
)
