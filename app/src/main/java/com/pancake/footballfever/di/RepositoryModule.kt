package com.pancake.footballfever.di

import com.pancake.footballfever.data.repository.PlayerRepository
import com.pancake.footballfever.data.repository.PlayerRepositoryImpl
import dagger.Binds
import com.pancake.footballfever.data.repository.StandingsRepository
import com.pancake.footballfever.data.repository.StandingsRepositoryImp
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

    @Singleton
    @Binds
    abstract fun bindsStandingsRepository(
        standingsRepositoryImp: StandingsRepositoryImp
    ): StandingsRepository

}