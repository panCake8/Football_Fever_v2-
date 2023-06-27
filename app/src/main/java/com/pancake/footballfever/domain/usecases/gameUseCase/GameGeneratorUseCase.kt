package com.pancake.footballfever.domain.usecases.gameUseCase

import com.pancake.footballfever.data.repository.game.GameRepository
import com.pancake.footballfever.domain.mappers.toLeagues
import com.pancake.footballfever.domain.models.League
import javax.inject.Inject

class GameGeneratorUseCase @Inject constructor(
    private val gameRepository: GameRepository,
){
    private var currentRandomLeague: League? = null
    private var cachedLeagues: List<League>? = null


    suspend operator fun invoke() = generateLeagueAnswers()

    private suspend fun getShuffledCachedLeagues(): List<League> {
        if (cachedLeagues == null) {
            cachedLeagues = gameRepository.getCachedGameLeagues().map {it.toLeagues()}
        }
        return cachedLeagues!!.shuffled()
    }


    private suspend fun generateLeagueAnswers(): List<League> {

        val selectedLeagues = mutableListOf<League>()
        val allLeagues = getShuffledCachedLeagues()

        repeat(3) {
            val randomLeague = allLeagues.random()
            if (randomLeague !in selectedLeagues) {
                selectedLeagues.add(randomLeague)
            }
        }

        return selectedLeagues.shuffled()
    }

    private suspend fun getAnswers(): List<League> {
        val answers = generateLeagueAnswers()
        currentRandomLeague = answers.random()
        return answers
    }

    suspend fun getTextAnswers(): List<String> {
        return getAnswers().map { it.name!! }
    }

    suspend fun getImageAnswers(): List<String> {
        return getAnswers().map {it.logo!!}
    }

    fun isRightAns(ans: String, currentRandomLeague: League): Boolean {
        return ans == currentRandomLeague.name
    }
}