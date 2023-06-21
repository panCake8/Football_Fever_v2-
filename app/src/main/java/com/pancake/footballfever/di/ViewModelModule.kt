package com.pancake.footballfever.di

import com.pancake.footballfever.domain.usecase.GetCoachSearchUseCase
import com.pancake.footballfever.domain.usecase.GetLeagueSearchUseCase
import com.pancake.footballfever.domain.usecase.GetSearchKeywordsUseCase
import com.pancake.footballfever.domain.usecase.GetTeamSearchUseCase
import com.pancake.footballfever.ui.search.SearchViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {
    @ViewModelScoped
    @Provides
    fun provideSearchViewModel(
        getTeamSearchUseCase: GetTeamSearchUseCase,
        getCoachSearchUseCase: GetCoachSearchUseCase,
        getLeagueSearchUseCase: GetLeagueSearchUseCase,
        getSearchKeywordsUseCase: GetSearchKeywordsUseCase
    ) = SearchViewModel(getTeamSearchUseCase,
        getCoachSearchUseCase,
        getLeagueSearchUseCase,
        getSearchKeywordsUseCase)

}