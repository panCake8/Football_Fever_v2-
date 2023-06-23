package com.pancake.footballfever.data.remote.service

import com.example.footboolfever.data.remote.dto.BaseResponse
import com.example.footboolfever.data.remote.dto.CoachsDto
import com.example.footboolfever.data.remote.dto.CountryDto
import com.example.footboolfever.data.remote.dto.EventsDto
import com.example.footboolfever.data.remote.dto.FixturesDto
import com.example.footboolfever.data.remote.dto.HeadToHeadDto
import com.example.footboolfever.data.remote.dto.InjuriesDto
import com.example.footboolfever.data.remote.dto.LineUpsDto
import com.example.footboolfever.data.remote.dto.PlayerStatisticsDto
import com.example.footboolfever.data.remote.dto.RoundsDto
import com.example.footboolfever.data.remote.dto.StatisticsDto
import com.example.footboolfever.data.remote.dto.TopAssistsDto
import com.example.footboolfever.data.remote.dto.TopScoresDto
import com.example.footboolfever.data.remote.dto.TransfersDto
import com.example.footboolfever.data.remote.dto.VenueDto
import com.example.footboolfever.data.remote.dto.league.LeaguesDto
import com.example.footboolfever.data.remote.dto.standings.StandingsDto
import com.example.footboolfever.data.remote.dto.teams.TeamsDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    // region Countries requests
    @GET("countries")
    suspend fun getAllCountries(): Response<BaseResponse<CountryDto>>

    @GET("countries")
    suspend fun getCountryByName(
        @Query("search") name: String
    ): Response<CountryDto>

    @GET("countries")
    suspend fun getCountryByCode(
        @Query("code") code: String
    ): Response<CountryDto>

    // endregion

    // region leagues requests
    @GET("leagues")
    suspend fun getAllLeagues(): Response<BaseResponse<LeaguesDto>>

    @GET("leagues")
    suspend fun getLeagueById(
        @Query("id") id: Int,
    ): Response<LeaguesDto>

    @GET("leagues")
    suspend fun getLeagueByCountryName(
        @Query("country") country: String
    ): Response<BaseResponse<LeaguesDto>>

    @GET("leagues")
    suspend fun getLeagueByCountryCode(
        @Query("code") code: String
    ): Response<BaseResponse<LeaguesDto>>

    @GET("leagues")
    suspend fun getLeagueBySeason(
        @Query("season") season: Int  // YYYY
    ): Response<LeaguesDto>

    @GET("leagues")
    suspend fun getLeagueByTeamId(
        @Query("team") teamId: Int
    ): Response<BaseResponse<LeaguesDto>>

    @GET("leagues")
    suspend fun getLeaguesByType(
        @Query("type") type: String
    ): Response<LeaguesDto>

    @GET("leagues")
    suspend fun getCurrentLeague(
        @Query("current") current: String
    ): Response<BaseResponse<LeaguesDto>>        // return a list of active seasons

    @GET("leagues")
    suspend fun searchLeaguesByName(
        @Query("search") name: String,
    ): Response<LeaguesDto>

    @GET("leagues")
    suspend fun getLastLeague(
        @Query("last") last: Int
    ): Response<LeaguesDto>

    // endregion

    // region Venues requests
    @GET("venues")
    suspend fun getAllVenues(): Response<BaseResponse<VenueDto>>

    @GET("venues")
    suspend fun getVenuesById(
        @Query("id") id: Int
    ): Response<VenueDto>

    @GET("venues")
    suspend fun searchVenuesByNameCityCountry(
        @Query("search") search: String     // by name, city, country
    ): Response<VenueDto>

    // endregion

    // region fixtures requests
    @GET("fixtures")
    suspend fun getFixtures(
        @Query("live") live: String? = "all",
    ): Response<BaseResponse<FixturesDto>>

    @GET("fixtures")
    suspend fun getFixtureById(
        @Query("id") id: Int,
    ): Response<BaseResponse<FixturesDto>>

    @GET("fixtures")
    suspend fun getFixtureByDateAndTeamIdAndSeason(
        @Query("date") date: String,
        @Query("team") teamId: Int,
        @Query("season") season: Int
    ): Response<BaseResponse<FixturesDto>>

    @GET("fixtures")
    suspend fun getFixturesByLeague(
        @Query("league") league: Int,
        @Query("season") season: Int,

        ): Response<BaseResponse<FixturesDto>>

    @GET("fixtures/rounds")
    suspend fun getRoundsFixture(
        @Query("league") league: Int,
        @Query("season") season: Int,
    ): Response<BaseResponse<RoundsDto>>

    @GET("fixtures/headtohead")
    suspend fun getHeadToHeadFixtures(@Query("h2h") h2h: String): Response<BaseResponse<HeadToHeadDto>>

    @GET("fixtures/statistics")
    suspend fun getStatisticsFixtures(@Query("fixture") fixture: String): Response<BaseResponse<StatisticsDto>>

    @GET("fixtures/events")
    suspend fun getEventsFixtures(@Query("fixture") fixture: String): Response<BaseResponse<EventsDto>>

    @GET("fixtures/lineups")
    suspend fun getLineUpsFixtures(@Query("fixture") fixture: String): Response<BaseResponse<LineUpsDto>>

    @GET("fixtures/players")
    suspend fun getPlayerStatisticsFixtures(@Query("fixture") fixture: String): Response<BaseResponse<PlayerStatisticsDto>>

    // endregion

    // region injures requests
    @GET("injuries")
    suspend fun getInjuries(
        @Query("league") league: Int?,
        @Query("season") season: Int?,
    ): Response<BaseResponse<InjuriesDto>>

    // endregion

    // region transfers requests
    @GET("transfers")
    suspend fun getTransfers(
        @Query("player") player: Int?,
        @Query("team") team: Int?,
    ): Response<BaseResponse<TransfersDto>>

    // endregion

    //region standings league
    @GET("standings")
    suspend fun getStandingsLeague(
        @Query("league") league: Int,
        @Query("season") season: Int,
    ): Response<BaseResponse<StandingsDto>>

    //endregion


    // region Player
    @GET("players/topscorers")
    suspend fun getTopScorerPlayers(
        @Query("league") league: Int,
        @Query("season") season: Int,
    ): Response<BaseResponse<TopScoresDto>>

    @GET("players/topassists")
    suspend fun getTopAssistsPlayers(
        @Query("league") league: Int,
        @Query("season") season: Int,
    ): Response<BaseResponse<TopAssistsDto>>
    //endregion

    // region teams requests
    @GET("teams")
    suspend fun getPremierLeagueTeams(
        @Query("league") leagueId :Int,
        @Query("season") season :Int,
    ) : Response<BaseResponse<TeamsDto>>

    // endregion


    // region search requests
    @GET("leagues")
    suspend fun getLeagueBySearch(
        @Query("search") searchText:String
    ):Response<BaseResponse<LeaguesDto>>


    @GET("teams")
    suspend fun getTeamBySearch(
        @Query("search") searchText:String
    ):Response<BaseResponse<TeamsDto>>

    @GET("coachs")
    suspend fun getCoachBySearch(
        @Query("search") searchText:String
    ):Response<BaseResponse<CoachsDto>>

    // endregion

    @GET("fixtures")
    suspend fun getTeamFixtures(
        @Query("season") season: String? = null,
        @Query("team") team: String? = null,
    ): Response<BaseResponse<FixturesDto>>

    @GET("fixtures/players")
    suspend fun getTeamPlayerStatisticsFixtures(@Query("fixture") fixture: String,
                                                @Query("team") team: String): Response<BaseResponse<PlayerStatisticsDto>>

}