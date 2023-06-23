package com.pancake.footballfever.data.local.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pancake.footballfever.data.local.database.entity.CountryEntity
import com.pancake.footballfever.data.local.database.entity.FavoriteTeamEntity
import com.pancake.footballfever.data.local.database.entity.FixtureHomeEntity
import com.pancake.footballfever.data.local.database.entity.InjuriesEntity
import com.pancake.footballfever.data.local.database.entity.SearchKeywordEntity
import com.pancake.footballfever.data.local.database.entity.StandingsEntity
import com.pancake.footballfever.data.local.database.entity.VenueEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FootballDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVenues(venues: List<VenueEntity>)

    @Query("SELECT * FROM VENUE_TABLE ORDER BY id DESC")
    fun getAllVenues(): List<VenueEntity>

    @Query("SELECT * FROM VENUE_TABLE WHERE id = :venueId")
    fun getVenueById(venueId: Int): VenueEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCountries(countries: List<CountryEntity>)

    @Query("SELECT * FROM COUNTRY_TABLE ORDER BY id DESC")
    fun getAllCountries(): List<CountryEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavoriteTeam(team: List<FavoriteTeamEntity>)

    @Query("select * from FAVORITE_TEAM_TABLE")
    suspend fun getAllFavoriteTeams(): List<FavoriteTeamEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFixtureHome(teams: List<FixtureHomeEntity>)

    @Query("select * from FIXTURE_HOME_TABLE")
    fun getAllFixtureHome(): Flow<List<FixtureHomeEntity>>

    @Query("delete from FIXTURE_HOME_TABLE ")
    fun deleteAllFixtureHome()
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStandings(standings: List<StandingsEntity>)

    @Query("SELECT * FROM STANDINGS_TABLE WHERE leagueId =:leagueId AND season =:season")
    fun getAllStandings(leagueId:Int,season:Int): List<StandingsEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInjuries(injuries: List<InjuriesEntity>)

    @Query("SELECT * FROM INJURIES_TABLE")
    suspend fun getAllInjuries(): List<InjuriesEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSearchKeyword(keyword: SearchKeywordEntity)

    @Query("SELECT * FROM KEYWORD_SEARCH_TABLE ORDER BY id DESC")
    suspend fun getAllSearchKeywords(): List<SearchKeywordEntity>
}