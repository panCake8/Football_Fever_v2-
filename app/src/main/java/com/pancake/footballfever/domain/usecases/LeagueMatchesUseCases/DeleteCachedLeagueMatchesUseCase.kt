package com.pancake.footballfever.domain.usecases.LeagueMatchesUseCases

import com.pancake.footballfever.data.repository.LeagueMatchesRepository

class DeleteCachedLeagueMatchesUseCase(private val repository: LeagueMatchesRepository) {

    suspend fun deleteCachedLeagueMatches(){
        return repository.deleteAllLeagueMatches()
    }
}