package com.pancake.footballfever.data.local.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.footboolfever.data.remote.dto.BaseResponse
import com.example.footboolfever.data.remote.dto.CoachsDto
import com.pancake.footballfever.data.local.database.entity.CoachEntity
import com.pancake.footballfever.data.local.database.entity.CountryEntity
import com.pancake.footballfever.data.local.database.entity.FavoriteTeamEntity
import com.pancake.footballfever.data.local.database.entity.FixtureHomeEntity
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

    @Query("select * from FIXTURE_TEAM_TABLE")
    fun getAllFixtureHome(): Flow<List<FixtureHomeEntity>>

    @Query("delete from FIXTURE_TEAM_TABLE ")
    fun deleteAllFixtureHome()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCoaches(coaches: List<CoachEntity>)

    @Query("SELECT * FROM COACHES_TABLE ORDER BY id DESC")
    suspend fun getAllCoaches(): List<CoachEntity>
}