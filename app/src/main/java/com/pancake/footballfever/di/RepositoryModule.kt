package com.pancake.footballfever.di

import com.pancake.footballfever.data.repository.FixtureEventsRepository
import com.pancake.footballfever.data.repository.FixtureEventsRepositoryImpl
import com.pancake.footballfever.data.repository.PlayersRepository
import com.pancake.footballfever.data.repository.PlayersRepositoryImpl
import com.pancake.footballfever.data.repository.TeamFixturesRepository
import com.pancake.footballfever.data.repository.TeamFixturesRepositoryImpl
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
    abstract fun bindFixtureEventsRepository(
        repository: FixtureEventsRepositoryImpl
    ): FixtureEventsRepository

    @Singleton
    @Binds
    abstract fun bindsTeamFixtureRepository(
        fixtureRepositoryImpl: TeamFixturesRepositoryImpl
    ): TeamFixturesRepository

    @Singleton
    @Binds
    abstract fun bindsPlayersRepository(
        playersRepositoryImpl: PlayersRepositoryImpl
    ): PlayersRepository
}