package com.pancake.footballfever.di

import android.content.Context
import androidx.room.Room
import com.pancake.footballfever.data.Constants
import com.pancake.footballfever.data.local.database.FootballDatabase
import com.pancake.footballfever.data.local.database.daos.FootballDao

import com.pancake.footballfever.data.local.database.daos.PlayerDao

import com.pancake.footballfever.data.local.database.daos.LeagueDao
import com.pancake.footballfever.data.local.database.daos.TeamDao

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

}