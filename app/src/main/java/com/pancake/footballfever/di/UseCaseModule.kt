package com.pancake.footballfever.di

import com.pancake.footballfever.data.repository.search.CoachSearchRepository
import com.pancake.footballfever.data.repository.search.LeagueSearchRepository
import com.pancake.footballfever.data.repository.search.TeamSearchRepository
import com.pancake.footballfever.domain.mappers.search.CoachSearchMapper
import com.pancake.footballfever.domain.mappers.search.LeagueSearchMapper
import com.pancake.footballfever.domain.mappers.search.TeamSearchMapper
import com.pancake.footballfever.domain.usecase.GetCoachSearchUseCase
import com.pancake.footballfever.domain.usecase.GetLeagueSearchUseCase
import com.pancake.footballfever.domain.usecase.GetTeamSearchUseCase
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
        teamSearchMapper: TeamSearchMapper
    ) = GetTeamSearchUseCase(teamSearchRepository,
        teamSearchMapper,
    )


    @Singleton
    @Provides
    fun provideLeagueSearchUseCase(
        leagueSearchRepository: LeagueSearchRepository,
        leagueSearchMapper: LeagueSearchMapper
    ) = GetLeagueSearchUseCase(leagueSearchRepository,
        leagueSearchMapper,
    )

    @Singleton
    @Provides
    fun provideCoachSearchUseCase(
        coachSearchRepository: CoachSearchRepository,
        coachSearchMapper: CoachSearchMapper
    ) = GetCoachSearchUseCase(coachSearchRepository,
        coachSearchMapper,
    )

}