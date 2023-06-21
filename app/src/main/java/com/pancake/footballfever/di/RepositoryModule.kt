package com.pancake.footballfever.di


import com.pancake.footballfever.data.repository.CountryRepository
import com.pancake.footballfever.data.repository.CountryRepositoryImpl
import com.pancake.footballfever.data.repository.FixtureRepository
import com.pancake.footballfever.data.repository.FixtureRepositoryImpl
import com.pancake.footballfever.data.repository.LeaguesRepository
import com.pancake.footballfever.data.repository.LeaguesRepositoryImpl
import com.pancake.footballfever.data.repository.PlayerRepository
import com.pancake.footballfever.data.repository.PlayerRepositoryImpl
import com.pancake.footballfever.data.repository.StandingsRepository
import com.pancake.footballfever.data.repository.StandingsRepositoryImp
import com.pancake.footballfever.data.repository.TeamRepository
import com.pancake.footballfever.data.repository.TeamRepositoryImpl
import dagger.Binds
import com.pancake.footballfever.data.repository.PlayerRepository
import com.pancake.footballfever.data.repository.PlayerRepositoryImpl
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
    abstract fun bindsPlayerRepository(
        playerRepositoryImpl: PlayerRepositoryImpl
    ): PlayerRepository

    @Singleton
    @Binds
    abstract fun bindsStandingsRepository(
        standingsRepositoryImp: StandingsRepositoryImp
    ): StandingsRepository

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

    @Singleton
    @Binds
    abstract fun bindsFixtureRepository(
        fixtureRepositoryImpl: FixtureRepositoryImpl
    ): FixtureRepository
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
    @Singleton
    @Binds
    abstract fun bindsPlayerRepository(
        playerRepositoryImpl: PlayerRepositoryImpl
    ): PlayerRepository
}