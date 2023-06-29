package com.pancake.footballfever.di

import android.content.Context
import androidx.room.Room
import com.pancake.footballfever.data.Constants
import com.pancake.footballfever.data.local.database.FootballDatabase
import com.pancake.footballfever.data.local.database.daos.ClubDao
import com.pancake.footballfever.data.local.database.daos.FixtureDao
import com.pancake.footballfever.data.local.database.daos.FootballDao
import com.pancake.footballfever.data.local.database.daos.LeagueDao
import com.pancake.footballfever.data.local.database.daos.PlayerDao
import com.pancake.footballfever.data.local.database.daos.TeamDao
import com.pancake.footballfever.data.local.database.daos.TransferDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Singleton
    @Provides
    fun provideFootballDatabase(
        @ApplicationContext context: Context
    ): FootballDatabase =
        Room.databaseBuilder(
            context,
            FootballDatabase::class.java,
            Constants.DATABASE_NAME,
        ).build()

    @Singleton
    @Provides
    fun provideFootBallDao(footballDataBase: FootballDatabase): FootballDao {
        return footballDataBase.footballDao
    }

    @Singleton
    @Provides
    fun providePlayerDao(footballDataBase: FootballDatabase): PlayerDao {
        return footballDataBase.playerDao
    }

    @Singleton
    @Provides
    fun provideLeagueDao(footballDataBase: FootballDatabase): LeagueDao {
        return footballDataBase.leagueDao
    }

    @Singleton
    @Provides
    fun provideTeamDao(footballDataBase: FootballDatabase): TeamDao {
        return footballDataBase.teamDao
    }

    @Singleton
    @Provides
    fun provideFixtureDao(footballDataBase: FootballDatabase): FixtureDao {
        return footballDataBase.fixtureDao
    }


    @Singleton
    @Provides
    fun provideFixtureEventsDao(footballDataBase: FootballDatabase) = footballDataBase.fixtureSummaryDao

    @Singleton
    @Provides
    fun providePlayersDao(footballDataBase: FootballDatabase) = footballDataBase.playersDao

    @Singleton
    @Provides
    fun provideTeamFixtureDao(footballDataBase: FootballDatabase) = footballDataBase.teamFixtureEventsDao


    @Singleton
    @Provides
    fun provideLeagueMatchesDao(footballDataBase: FootballDatabase) = footballDataBase.leagueMatches

    @Singleton
    @Provides
    fun provideHeadToHeadsDao(footballDataBase: FootballDatabase) = footballDataBase.headToHead
    @Singleton
    @Provides
    fun provideClubDao(footballDataBase: FootballDatabase): ClubDao {
        return footballDataBase.clubDao
    }

    @Singleton
    @Provides
    fun provideTransferDao(footballDataBase: FootballDatabase): TransferDao {
        return footballDataBase.transferDao
    }

}