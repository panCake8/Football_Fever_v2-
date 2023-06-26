package com.pancake.footballfever.di

import com.pancake.footballfever.data.repository.TeamRepository
import com.pancake.footballfever.data.repository.search.CoachSearchRepository
import com.pancake.footballfever.data.repository.search.LeagueSearchRepository
import com.pancake.footballfever.data.repository.search.SearchKeywordsRepository
import com.pancake.footballfever.data.repository.search.TeamSearchRepository
import com.pancake.footballfever.domain.usecases.DeleteFromFavouriteTeamsUseCase
import com.pancake.footballfever.domain.usecases.GetAllFavouriteTeams
import com.pancake.footballfever.domain.usecases.GetCoachSearchUseCase
import com.pancake.footballfever.domain.usecases.GetLeagueSearchUseCase
import com.pancake.footballfever.domain.usecases.GetSearchKeywordsUseCase
import com.pancake.footballfever.domain.usecases.GetTeamSearchUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun provideTeamSearchUseCase(
        teamSearchRepository: TeamSearchRepository,
    ) = GetTeamSearchUseCase(teamSearchRepository)


    @Singleton
    @Provides
    fun provideLeagueSearchUseCase(
        leagueSearchRepository: LeagueSearchRepository,
    ) = GetLeagueSearchUseCase(leagueSearchRepository)

    @Singleton
    @Provides
    fun provideCoachSearchUseCase(
        coachSearchRepository: CoachSearchRepository,
    ) = GetCoachSearchUseCase(coachSearchRepository)

    @Singleton
    @Provides
    fun provideSearchKeywordsUseCase(
      searchKeywordsRepository: SearchKeywordsRepository,
    ) = GetSearchKeywordsUseCase(searchKeywordsRepository)

    @Singleton
    @Provides
    fun provideDeleteFromFavouriteTeamsUseCase(
        teamRepository: TeamRepository,
    ) = DeleteFromFavouriteTeamsUseCase(teamRepository)

    @Singleton
    @Provides
    fun provideAllFavouriteTeamsUseCase(
        teamRepository: TeamRepository,
    ) = GetAllFavouriteTeams(teamRepository)



}