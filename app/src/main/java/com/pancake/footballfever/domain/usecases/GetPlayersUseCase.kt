package com.pancake.footballfever.domain.usecases

import com.pancake.footballfever.data.local.database.entity.PlayerEntity
import com.pancake.footballfever.data.repository.PlayersRepository
import com.pancake.footballfever.domain.models.Player
import javax.inject.Inject

class GetPlayersUseCase @Inject constructor(private val repository: PlayersRepository) {

    suspend operator fun invoke(
        season: Int,
        team: Int
    ): List<Player> {
        return repository.getPlayers(season, team).fold(
            onSuccess = { it.map { it.toDomain() } },
            onFailure = { throw it })
    }

    private fun PlayerEntity.toDomain() =
        Player(
            name = name,
            photo = photo,
            goals = goals
        )
}