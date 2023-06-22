package com.pancake.footballfever.ui.Club_stats


import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentClubBinding
import com.pancake.footballfever.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ClubFragment() :
    BaseFragment<FragmentClubBinding, ClubViewModel>() {
    private val arguments by navArgs<ClubFragmentArgs>()
    override val layoutId: Int
        get() = R.layout.fragment_club
    override val viewModel: ClubViewModel by viewModels()


}