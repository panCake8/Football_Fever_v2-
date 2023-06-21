package com.pancake.footballfever.di

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