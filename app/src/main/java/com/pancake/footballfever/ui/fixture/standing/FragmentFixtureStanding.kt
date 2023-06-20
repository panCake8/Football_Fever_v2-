package com.pancake.footballfever.ui.fixture.standing

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentStaticisFixtureBinding
import com.pancake.footballfever.ui.base.BaseFragment
import com.pancake.footballfever.utilities.Constants

class FragmentFixtureStanding :
    BaseFragment<FragmentStaticisFixtureBinding, FixtureStandingViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_staticis_fixture
    override val viewModel by viewModels<FixtureStandingViewModel>()


    companion object {
        @JvmStatic
        fun newInstance(leagueId: Int?) =
            FragmentFixtureStanding().apply {
                arguments = Bundle().apply {
                    leagueId?.let { putInt(Constants.LEAGUE_ID, it) }
                }
            }
    }
}