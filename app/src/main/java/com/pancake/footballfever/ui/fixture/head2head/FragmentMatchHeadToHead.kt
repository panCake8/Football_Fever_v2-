package com.pancake.footballfever.ui.fixture.head2head

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentMatchStatsHeadToHeadBinding
import com.pancake.footballfever.ui.base.BaseFragment
import com.pancake.footballfever.ui.fixture.FixtureFragmentArgs
import com.pancake.footballfever.ui.fixture.FixtureFragmentDirections
import com.pancake.footballfever.ui.fixture.head2head.adapter.HeadToHeadParentAdapter
import com.pancake.footballfever.ui.fixture.head2head.uiState.HeadToHeadUiEvent
import com.pancake.footballfever.utilities.collectLast
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


        handleEvent()
        setRecycler()
    }
    private fun setRecycler() {
        binding.parentRecycler.adapter = HeadToHeadParentAdapter(viewModel)
    }

    private fun handleEvent() {
        collectLast(viewModel.headToHeadEvent) {
            it?.getContentIfNotHandled().let { onClick(it) }

        }
    }

    private fun onClick(event: HeadToHeadUiEvent?) {
        when (event) {
            is HeadToHeadUiEvent.ClickHeadToHeadEvent -> {
                event.headToHead.let {
                    val nav =
                        FixtureFragmentDirections.actionFixtureFragmentSelf(
                            date = it.date!!,
                            fixtureId = it.id!!,
                            season = it.season!!
                        )
                    findNavController().navigate(nav)
                }

            }

            else -> {}
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