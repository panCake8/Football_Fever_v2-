package com.pancake.footballfever.ui.fixture.head2head

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentMatchStatsHeadToHeadBinding
import com.pancake.footballfever.ui.base.BaseFragment
import com.pancake.footballfever.ui.fixture.FixtureFragmentArgs
import dagger.hilt.android.AndroidEntryPoint

private const val HOME_ID_ARG = "home_id_arg"

@AndroidEntryPoint
class FragmentMatchHeadToHead :
    BaseFragment<FragmentMatchStatsHeadToHeadBinding, HeadToHeadViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_match_stats_head_to_head
    override val viewModel: HeadToHeadViewModel by viewModels()



    override fun setup() {

        val teamIds = arguments?.getString(HOME_ID_ARG)
        teamIds?.let {
            viewModel.getHeadToHeads(it)
        }
    }


    companion object {
        @JvmStatic
        fun newInstance(teamIds: String?) =
            FragmentMatchHeadToHead().apply {
                arguments = Bundle().apply {
                    putString(HOME_ID_ARG, teamIds)
                }
            }
    }
}