package com.pancake.footballfever.ui.club_stats


import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.google.android.material.tabs.TabLayoutMediator
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentClubBinding
import com.pancake.footballfever.ui.base.BaseFragment
import com.pancake.footballfever.ui.league_state.standing.StandingFragment
import com.pancake.footballfever.ui.player.PlayersFragment
import com.pancake.footballfever.ui.team_fixture.TeamFixtureFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class ClubStatsFragment :BaseFragment<FragmentClubBinding, ClubViewModel>() {
    private val tabItems = listOf(PLAYERS, MATCHES, TABLE)
    private lateinit var clubStatsPagerAdapter: ClubStatsPagerAdapter
    override val layoutId: Int = R.layout.fragment_club
    override val viewModel: ClubViewModel by viewModels()
    val argument : ClubStatsFragmentArgs by navArgs()


    override fun setup() {
        super.setup()
        val club= viewModel.getClub(argument.teamId)
        viewModel.clubUiEvent.onEach {
            when (it){
                is ClubUiEvent.OnClickFollow -> {
                    binding.followButton.setOnClickListener {
                    if (binding.followButton.text == FOLLOW) {
                        viewModel.addFavoriteOneTeam()
                        binding.followButton.text = UN_FOLLOW
                    }}
                }
                is ClubUiEvent.OnClickUnFollow ->{
                    binding.followButton.setOnClickListener{
                if (binding.followButton.text == UN_FOLLOW) {
                    viewModel.deleteFavoriteOneTeam(argument.teamId)
                    binding.followButton.text = FOLLOW}
                }
            }

                else -> {}
            }
        }.flowWithLifecycle(lifecycle).launchIn(viewLifecycleOwner.lifecycleScope)
        initViewPager()
        initTabLayout()
    }
    private fun initViewPager() {
        clubStatsPagerAdapter = ClubStatsPagerAdapter(this)
        addFragmentsToViewPager()
        binding.pager.adapter = clubStatsPagerAdapter
    }
    private fun addFragmentsToViewPager() {
        clubStatsPagerAdapter.addFragment(PlayersFragment.newInstance(argument.season,argument.teamId))
        clubStatsPagerAdapter.addFragment(TeamFixtureFragment.newInstance(argument.season.toString(),argument.teamId.toString()))
        if(argument.leagueId!=0){
        clubStatsPagerAdapter.addFragment(StandingFragment.newInstance(argument.leagueId,argument.season,3))
    }}


    private fun initTabLayout() {
        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, position ->
            tab.text = tabItems[position]
            val tabs = binding.tabLayout.getChildAt(0) as ViewGroup
            for (i in 0 until tabs.childCount) {
                val tab = tabs.getChildAt(i)
                val layoutParams = tab.layoutParams as LinearLayout.LayoutParams
                layoutParams.marginEnd = 30
                tab.layoutParams = layoutParams
                binding.tabLayout.requestLayout()
            }
            }.attach()
    }

    companion object {
        private const val PLAYERS = "players"
        private const val MATCHES = "matches"
        private const val TABLE = "Table"
        private const val FOLLOW = "follow"
        private const val UN_FOLLOW = "un follow"

    }

}
