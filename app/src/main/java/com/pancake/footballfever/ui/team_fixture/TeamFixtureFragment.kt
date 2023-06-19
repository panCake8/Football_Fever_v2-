package com.pancake.footballfever.ui.team_fixture

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentTeamFixturesBinding
import com.pancake.footballfever.domain.models.Fixture
import com.pancake.footballfever.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TeamFixturesFragment : BaseFragment<FragmentTeamFixturesBinding, TeamFixturesViewModel>() {
    override val layoutId = R.layout.fragment_team_fixtures
    override val viewModel: TeamFixturesViewModel by viewModels()
    private val args: TeamFixturesFragmentArgs by navArgs()

    override fun setup() {
        viewModel.getFixtures(args.season, args.team)
        val adapter = TeamFixturesAdapter(object : FixturesClickListener {
            override fun onClick(fixture: Fixture) {

            }
        })
        binding.rv.adapter = adapter
    }

}