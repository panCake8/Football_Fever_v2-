package com.pancake.footballfever.di

import com.pancake.footballfever.data.repository.CountriesRepository
import com.pancake.footballfever.data.repository.CountriesRepositoryImpl
import com.pancake.footballfever.data.repository.FixtureEventsRepository
import com.pancake.footballfever.data.repository.FixtureEventsRepositoryImpl
import com.pancake.footballfever.data.repository.FixtureRepository
import com.pancake.footballfever.data.repository.FixtureRepositoryImpl
import com.pancake.footballfever.data.repository.LeaguesRepository
import com.pancake.footballfever.data.repository.LeaguesRepositoryImpl
import com.pancake.footballfever.data.repository.TeamsRepository
import com.pancake.footballfever.data.repository.TeamsRepositoryImpl
import com.pancake.footballfever.data.repository.VenuesRepository
import com.pancake.footballfever.data.repository.VenuesRepositoryImpl
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
    abstract fun bindsCountriesRepository(
        countriesRepositoryImpl: CountriesRepositoryImpl
    ): CountriesRepository

    @Singleton
    @Binds
    abstract fun bindsVenuesRepository(
        venuesRepositoryImpl: VenuesRepositoryImpl
    ): VenuesRepository

    @Singleton
    @Binds
    abstract fun bindsLeaguesRepository(
        leaguesRepositoryImpl: LeaguesRepositoryImpl
    ): LeaguesRepository

    @Singleton
    @Binds
    abstract fun bindsTeamsRepository(
        teamsRepositoryImpl: TeamsRepositoryImpl
    ): TeamsRepository

    @Singleton
    @Binds
    abstract fun bindsFixturesRepository(
        fixtureRepositoryImpl: FixtureRepositoryImpl
    ): FixtureRepository

    @Singleton
    @Binds
    abstract fun bindFixtureEventsRepository(
        repository: FixtureEventsRepositoryImpl
    ): FixtureEventsRepository

}