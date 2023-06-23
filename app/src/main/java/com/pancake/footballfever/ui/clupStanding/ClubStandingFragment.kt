package com.pancake.footballfever.ui.clupStanding

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentClubStandingBinding
import com.pancake.footballfever.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

private const val TEAM_ID = "teamId"
private const val SEASON = "season"

@AndroidEntryPoint
class ClubStandingFragment : BaseFragment<FragmentClubStandingBinding, ClubStandingViewModel>() {
    override val layoutId = R.layout.fragment_club_standing
    override val viewModel: ClubStandingViewModel by viewModels()

    override fun setup() {
        val adapter = ClubStandingAdapter(viewModel)
        binding.recyclerStandingLeague.adapter = adapter

    }

        companion object {
            @JvmStatic
            fun newInstance(teamId: Int, season: Int) =
                ClubStandingFragment().apply {
                    arguments = Bundle().apply {
                        putString(TEAM_ID, "$teamId")
                        putString(SEASON, "$season")
                    }
                }
        }
}