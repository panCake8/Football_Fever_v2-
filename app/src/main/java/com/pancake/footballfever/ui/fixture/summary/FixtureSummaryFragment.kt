package com.pancake.footballfever.ui.fixture.summary

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentFixtureSummaryBinding
import com.pancake.footballfever.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

private const val HOME_ID_ARG = "home_id_arg"
private const val FIXTURE_ID_ARG = "fixture_id_arg"

@AndroidEntryPoint
class FixtureSummaryFragment private constructor() :
    BaseFragment<FragmentFixtureSummaryBinding, FixtureSummaryViewModel>() {
    override val layoutId = R.layout.fragment_fixture_summary
    override val viewModel: FixtureSummaryViewModel by viewModels()

    override fun setup() {
        super.setup()
        val homeId = requireArguments().getString(HOME_ID_ARG)?.toInt()!!
        val fixtureId = requireArguments().getString(FIXTURE_ID_ARG)!!
        viewModel.getFixtureEvents(fixtureId)
        binding.homeId = homeId
    }

    companion object {
        @JvmStatic
        fun newInstance(fixtureId: String, homeId: String) =
            FixtureSummaryFragment().apply {
                arguments = Bundle().apply {
                    putString(FIXTURE_ID_ARG, fixtureId)
                    putString(HOME_ID_ARG, homeId)
                }
            }
    }

}