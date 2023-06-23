package com.pancake.footballfever.ui.favourites

import android.os.Bundle

import android.view.View

import androidx.fragment.app.viewModels
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentFavouritesBinding
import com.pancake.footballfever.ui.base.BaseFragment
import com.pancake.footballfever.ui.favourites.adapter.FavouriteTeamsAdapter
import com.pancake.footballfever.ui.search.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FavouritesFragment : BaseFragment<FragmentFavouritesBinding, FavouritesViewModel>() {
    override val layoutId = R.layout.fragment_favourites
    override val viewModel: FavouritesViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.favouritesRecyclerView.adapter = FavouriteTeamsAdapter(viewModel)
    }

}