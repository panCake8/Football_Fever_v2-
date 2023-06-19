package com.pancake.footballfever.ui.fixture_events

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentFixtureEventsBinding
import com.pancake.footballfever.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FixtureEventsFragment : BaseFragment<FragmentFixtureEventsBinding, FixtureEventsViewModel>() {
    override val layoutId = R.layout.fragment_fixture_events
    override val viewModel: FixtureEventsViewModel by viewModels()
    private val args: FixtureEventsFragmentArgs by navArgs()

    override fun setup() {
        super.setup()
        viewModel.getFixtureEvents(args.fixtureId)
        binding.homeId = args.homeId.toInt()
    }

}