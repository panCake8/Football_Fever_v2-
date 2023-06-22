package com.pancake.footballfever.di


import com.pancake.footballfever.data.repository.CountryRepository
import com.pancake.footballfever.data.repository.CountryRepositoryImpl
import com.pancake.footballfever.data.repository.FixtureRepository
import com.pancake.footballfever.data.repository.FixtureRepositoryImpl
import com.pancake.footballfever.data.repository.HeadToHeadRepository
import com.pancake.footballfever.data.repository.HeadToHeadRepositoryImpl
import com.pancake.footballfever.data.repository.LeaguesRepository
import com.pancake.footballfever.data.repository.LeaguesRepositoryImpl
import com.pancake.footballfever.data.repository.LeagueMatchesRepository
import com.pancake.footballfever.data.repository.LeagueMatchesRepositoryImpl
import com.pancake.footballfever.data.repository.PlayerRepository
import com.pancake.footballfever.data.repository.PlayerRepositoryImpl
import com.pancake.footballfever.data.repository.StandingsRepository
import com.pancake.footballfever.data.repository.StandingsRepositoryImp
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
        playerRepositoryImpl: PlayerRepositoryImpl,
    ): PlayerRepository

    @Singleton
    @Binds
    abstract fun bindsLeagueMatchesRepository(
        leagueMatchesRepositoryImpl: LeagueMatchesRepositoryImpl,
    ): LeagueMatchesRepository

    @Singleton
    @Binds
    abstract fun bindsHeadTOHeadsRepository(
        headToHeadRepository: HeadToHeadRepositoryImpl,
    ): HeadToHeadRepository

    @Singleton
    @Binds
    abstract fun bindsStandingsRepository(
        standingsRepositoryImp: StandingsRepositoryImp,
    ): StandingsRepository

    @Singleton
    @Binds
    abstract fun bindsCountryRepository(
        countryRepositoryImpl: CountryRepositoryImpl,
    ): CountryRepository

    @Singleton
    @Binds
    abstract fun bindsTeamRepository(
        teamRepositoryImpl: TeamRepositoryImpl,
    ): TeamRepository

    @Singleton
    @Binds
    abstract fun bindsLeaguesRepository(
        leaguesRepositoryImpl: LeaguesRepositoryImpl,
    ): LeaguesRepository

    @Singleton
    @Binds
    abstract fun bindsFixtureRepository(
        fixtureRepositoryImpl: FixtureRepositoryImpl,
    ): FixtureRepository
}