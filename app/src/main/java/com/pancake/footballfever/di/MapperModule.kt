package com.pancake.footballfever.di

import com.pancake.footballfever.domain.mappers.country.SelectCountryDtoToUiMapper
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
    fun provideSelectCountryDtoToUiMapper() = SelectCountryDtoToUiMapper()
}