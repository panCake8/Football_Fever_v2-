package com.pancake.footballfever.di

import com.pancake.footballfever.data.repository.IListCoachRepository
import com.pancake.footballfever.data.repository.ListCoachRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun listCoachRepository(
        listRepository: ListCoachRepository
    ): IListCoachRepository


}

