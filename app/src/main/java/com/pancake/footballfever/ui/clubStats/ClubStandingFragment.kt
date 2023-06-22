
package com.pancake.footballfever.ui.clubStats

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentClubStandingBinding
import com.pancake.footballfever.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ClubStandingFragment:BaseFragment<FragmentClubStandingBinding , ClubStandingsViewModel>(){

    override val layoutId: Int= R.layout.fragment_club_standing
    override val viewModel: ClubStandingsViewModel by viewModels()
    val argument : ClubStandingFragmentArgs by navArgs()


    override fun setup() {
        super.setup()

        val adapter = ClubStandingAdapter(viewModel ,argument.teamId )
        binding.recyclerStandingLeague.adapter = adapter
    }
}