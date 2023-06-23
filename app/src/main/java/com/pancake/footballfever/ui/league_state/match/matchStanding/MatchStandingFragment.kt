package com.pancake.footballfever.ui.league_state.match.matchStanding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pancake.footballfever.R

private const val HOME_TEAM_ID = "homeTeamId"
private const val AWAY_TEAM_ID = "awayTeamId"
private const val SEASON = "season"

class MatchStandingFragment : Fragment() {
    private var homeTeamId: Int? = null
    private var awayTeamId: Int? = null
    private var season: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_match_standing, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance(homeTeamId: Int, awayTeamId: Int, season: Int) =
            MatchStandingFragment().apply {
                arguments = Bundle().apply {
                    putInt(HOME_TEAM_ID,homeTeamId)
                    putInt(AWAY_TEAM_ID,awayTeamId)
                    putInt(SEASON,season)
                }
            }
    }
}