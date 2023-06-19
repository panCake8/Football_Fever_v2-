package com.pancake.footballfever.ui.fixture

import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentFixtureBinding
import com.pancake.footballfever.ui.base.BaseFragment

class FixtureFragment : BaseFragment<FragmentFixtureBinding, FixtureViewModel>() {

    private val arguments by navArgs<FixtureFragmentArgs>()

    override val layoutId = R.layout.fragment_fixture

    override val viewModel by activityViewModels<FixtureViewModel>()

    override fun setup() {
        val fixtureId = arguments.fixtureId
    }
}