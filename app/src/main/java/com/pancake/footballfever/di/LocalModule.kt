package com.pancake.footballfever.di

import android.app.Application
import androidx.room.Room
import com.pancake.footballfever.data.Constants
import com.pancake.footballfever.data.local.database.FootballDatabase
import com.pancake.footballfever.data.local.database.daos.FootballDao
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
        @ApplicationContext application: Application
    ): FootballDatabase =
        Room.databaseBuilder(
            application,
            FootballDatabase::class.java,
            Constants.DATABASE_NAME,
        ).build()

    @Singleton
    @Provides
    fun provideFootBallDao(footballDataBase: FootballDatabase): FootballDao {
        return footballDataBase.footballDao
    }


}