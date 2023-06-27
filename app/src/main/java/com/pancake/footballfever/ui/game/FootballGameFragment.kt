package com.pancake.footballfever.ui.game

import androidx.fragment.app.viewModels
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentFootballGameBinding
import com.pancake.footballfever.ui.base.BaseFragment


class FootballGameFragment : BaseFragment<FragmentFootballGameBinding, FootballGameViewModel>() {
    override val layoutId: Int = R.layout.fragment_football_game
    override val viewModel: FootballGameViewModel by viewModels()




}