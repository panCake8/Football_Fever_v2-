package com.pancake.footballfever.di

import com.pancake.footballfever.data.local.database.repository.PlayerRepository
import com.pancake.footballfever.data.local.database.repository.PlayerRepositoryImpl
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
    ) : PlayerRepository
}