package com.pancake.footballfever.ui.fixture.head2head

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentMatchStatsHeadToHeadBinding
import com.pancake.footballfever.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

private const val HOME_ID_ARG = "home_id_arg"
private const val FIXTURE_ID_ARG = "fixture_id_arg"

@AndroidEntryPoint
class FragmentMatchHeadToHead :
    BaseFragment<FragmentMatchStatsHeadToHeadBinding, HeadToHeadViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_match_stats_head_to_head
    override val viewModel: HeadToHeadViewModel by viewModels()


    companion object {
        @JvmStatic
        fun newInstance(fixtureId: Int?, teamIds: String?) =
            FragmentMatchHeadToHead().apply {
                arguments = Bundle().apply {
                    fixtureId?.let { putInt(FIXTURE_ID_ARG, it) }
                    putString(HOME_ID_ARG, teamIds)
                }
            }
    }
}