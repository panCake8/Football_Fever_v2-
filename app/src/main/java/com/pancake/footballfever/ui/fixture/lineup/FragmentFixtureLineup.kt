package com.pancake.footballfever.ui.fixture.lineup

import android.os.Bundle
import androidx.fragment.app.viewModels
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentFixtureLineupBinding
import com.pancake.footballfever.ui.base.BaseFragment
import com.pancake.footballfever.domain.Constants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentFixtureLineup : BaseFragment<FragmentFixtureLineupBinding, FixtureLineupViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_fixture_lineup
    override val viewModel by viewModels<FixtureLineupViewModel>()


    companion object {
        @JvmStatic
        fun newInstance(fixtureId: Int?) =
            FragmentFixtureLineup().apply {
                arguments = Bundle().apply {
                    fixtureId?.let { putInt(Constants.FIXTURE_ID, it) }
                }
            }
    }
}