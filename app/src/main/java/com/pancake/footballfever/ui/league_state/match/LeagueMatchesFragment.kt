package com.pancake.footballfever.ui.league_state.match

import android.os.Bundle
import android.view.View
import android.widget.AutoCompleteTextView
import androidx.fragment.app.viewModels
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentLeagueMatchBinding
import com.pancake.footballfever.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import java.util.Calendar

@AndroidEntryPoint
class LeagueMatchesFragment : BaseFragment<FragmentLeagueMatchBinding, LeagueMatchesViewModel>() {


    override val layoutId: Int
        get() = R.layout.fragment_league_match

    override val viewModel: LeagueMatchesViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        setRecycler()

    }

    private fun setRecycler() {
        binding.viewModel = viewModel
    }


}