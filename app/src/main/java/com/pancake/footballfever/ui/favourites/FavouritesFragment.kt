package com.pancake.footballfever.ui.favourites

import android.os.Build

import androidx.annotation.RequiresApi

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentFavouritesBinding
import com.pancake.footballfever.ui.base.BaseFragment
import com.pancake.footballfever.ui.favourites.adapter.FavouriteTeamsAdapter
import com.pancake.footballfever.utilities.collect
import dagger.hilt.android.AndroidEntryPoint
import java.time.Year


@AndroidEntryPoint
class FavouritesFragment : BaseFragment<FragmentFavouritesBinding, FavouritesViewModel>() {
    override val layoutId = R.layout.fragment_favourites
    override val viewModel: FavouritesViewModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.O)
    private val season= Year.now().value


    @RequiresApi(Build.VERSION_CODES.O)
    override fun setup() {

        binding.favouritesRecyclerView.adapter = FavouriteTeamsAdapter(
            viewModel,
            onClickUnFollow = {teamid->
                viewModel.onClickUnfollow(teamid)},
            onCardClick = {team->
                viewModel.onClickTeam(team)}
        )

        doEvent()

    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun doEvent() {
        collect(viewModel.teamEvent) {
            it?.getContentIfNotHandled()?.let { onEvent(it) }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun onEvent(event: FavoriteEvent) {
        when (event) {
            is FavoriteEvent.ClickFavoriteEvent -> {
                val nav =
                    FavouritesFragmentDirections.actionFavouritesFragmentToClubFragment(event.favoriteTeam.id!!,0,season)
                findNavController().navigate(nav)
            }
        }
    }

    override fun showBottomNavBar(show: Boolean) {
        super.showBottomNavBar(true)
    }

}