package com.pancake.footballfever.di

import com.pancake.footballfever.domain.mappers.search.CoachSearchMapper
import com.pancake.footballfever.domain.mappers.search.KeywordEntityToKeywordMapper
import com.pancake.footballfever.domain.mappers.search.KeywordToKeywordEntityMapper
import com.pancake.footballfever.domain.mappers.search.LeagueSearchMapper
import com.pancake.footballfever.domain.mappers.search.TeamSearchMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MapperModule {

    @Singleton
    @Provides
    fun provideTeamSearchMapper() = TeamSearchMapper()

    @Singleton
    @Provides
    fun provideLeagueSearchMapper() = LeagueSearchMapper()

    @Singleton
    @Provides
    fun provideCoachSearchMapper() = CoachSearchMapper()

    @Singleton
    @Provides
    fun provideKeywordEntityToKeywordMapper() = KeywordEntityToKeywordMapper()

    @Singleton
    @Provides
    fun provideKeywordToKeywordEntityMapper() = KeywordToKeywordEntityMapper()


}
