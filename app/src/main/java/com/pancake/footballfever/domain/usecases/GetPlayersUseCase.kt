package com.pancake.footballfever.domain.usecases

import com.example.footboolfever.data.remote.dto.StatisticPlayersItem
import com.pancake.footballfever.data.repository.PlayersRepository
import com.pancake.footballfever.domain.models.Player
import javax.inject.Inject

class GetPlayersUseCase @Inject constructor(
    private val repository: PlayersRepository,
) {

    suspend operator fun invoke(
        fixture: String,
        team: String
    ): List<Player> {
        return repository.getPlayers(fixture, team).fold(
            onSuccess = {
                it.map { it.toDomain() }

            }, onFailure = {
                throw it
            })
    }

    private fun StatisticPlayersItem.toDomain() =
        Player(
            name = player?.name,
            photo = player?.photo,
            goals = statistics?.get(0)?.goals?.total ?: 0
        )
}