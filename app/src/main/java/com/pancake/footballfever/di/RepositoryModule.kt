package com.pancake.footballfever.di


import com.pancake.footballfever.data.repository.CountryRepository
import com.pancake.footballfever.data.repository.CountryRepositoryImpl
import com.pancake.footballfever.data.repository.FixtureEventsRepository
import com.pancake.footballfever.data.repository.FixtureEventsRepositoryImpl
import com.pancake.footballfever.data.repository.FixtureRepository
import com.pancake.footballfever.data.repository.FixtureRepositoryImpl
import com.pancake.footballfever.data.repository.InjuriesRepository
import com.pancake.footballfever.data.repository.InjuriesRepositoryImpl
import com.pancake.footballfever.data.repository.LeaguesRepository
import com.pancake.footballfever.data.repository.LeaguesRepositoryImpl
import com.pancake.footballfever.data.repository.PlayerRepository
import com.pancake.footballfever.data.repository.PlayerRepositoryImpl
import com.pancake.footballfever.data.repository.PlayersRepository
import com.pancake.footballfever.data.repository.PlayersRepositoryImpl
import com.pancake.footballfever.data.repository.TeamFixturesRepository
import com.pancake.footballfever.data.repository.TeamFixturesRepositoryImpl
import com.pancake.footballfever.data.repository.standingsRepo.StandingsRepository
import com.pancake.footballfever.data.repository.standingsRepo.StandingsRepositoryImp
import com.pancake.footballfever.data.repository.TeamRepository
import com.pancake.footballfever.data.repository.TeamRepositoryImpl
import com.pancake.footballfever.data.repository.search.CoachSearchRepository
import com.pancake.footballfever.data.repository.search.CoachSearchRepositoryImpl
import com.pancake.footballfever.data.repository.search.LeagueSearchRepository
import com.pancake.footballfever.data.repository.search.LeagueSearchRepositoryImpl
import com.pancake.footballfever.data.repository.search.SearchKeywordsRepository
import com.pancake.footballfever.data.repository.search.SearchKeywordsRepositoryImpl
import com.pancake.footballfever.data.repository.search.TeamSearchRepository
import com.pancake.footballfever.data.repository.search.TeamSearchRepositoryImpl
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

    @Binds
    @Singleton
    abstract fun injuriesRepository(
        injuriesRepository: InjuriesRepositoryImpl
    ): InjuriesRepository

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
    abstract fun bindsTeamSearchRepository(
        teamSearchRepositoryImpl: TeamSearchRepositoryImpl
    ): TeamSearchRepository

    @Singleton
    @Binds
    abstract fun bindsLeagueSearchRepository(
        leagueSearchRepositoryImpl: LeagueSearchRepositoryImpl
    ): LeagueSearchRepository

    @Singleton
    @Binds
    abstract fun bindsCoachSearchRepository(
        coachSearchRepositoryImpl: CoachSearchRepositoryImpl
    ): CoachSearchRepository

    @Singleton
    @Binds
    abstract fun bindsSearchKeywordsRepository(
        searchKeywordsRepositoryImpl: SearchKeywordsRepositoryImpl
    ): SearchKeywordsRepository

}