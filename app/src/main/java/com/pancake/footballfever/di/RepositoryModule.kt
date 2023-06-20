package com.pancake.footballfever.di

import com.pancake.footballfever.data.repository.CountryRepository
import com.pancake.footballfever.data.repository.CountryRepositoryImpl
import com.pancake.footballfever.data.repository.LeaguesRepository
import com.pancake.footballfever.data.repository.LeaguesRepositoryImpl
import com.pancake.footballfever.data.repository.PlayerRepository
import com.pancake.footballfever.data.repository.PlayerRepositoryImpl
import com.pancake.footballfever.data.repository.TeamRepository
import com.pancake.footballfever.data.repository.TeamRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {


    @Singleton
    @Binds
    abstract fun bindsPlayerRepository(
        playerRepositoryImpl: PlayerRepositoryImpl
    ): PlayerRepository

    @Singleton
    @Binds
    abstract fun bindsCountryRepository(
        countryRepositoryImpl: CountryRepositoryImpl
    ): CountryRepository

    @Singleton
    @Binds
    abstract fun bindsTeamRepository(
        teamRepositoryImpl: TeamRepositoryImpl
    ): TeamRepository

    @Singleton
    @Binds
    abstract fun bindsLeaguesRepository(
        leaguesRepositoryImpl: LeaguesRepositoryImpl
    ): LeaguesRepository
}