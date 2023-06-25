package com.pancake.footballfever.domain.usecase

import com.pancake.footballfever.data.repository.LeagueMatchesRepository

class DeleteCachedLeagueMatchesUseCase(private val repository: LeagueMatchesRepository) {

    suspend fun deleteCachedLeagueMatches(){
        return repository.deleteAllLeagueMatches()
    }
}