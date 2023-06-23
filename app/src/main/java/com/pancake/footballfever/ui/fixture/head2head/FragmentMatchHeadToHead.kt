package com.pancake.footballfever.ui.fixture.head2head

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentMatchStatsHeadToHeadBinding
import com.pancake.footballfever.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentMatchHeadToHead :
    BaseFragment<FragmentMatchStatsHeadToHeadBinding, HeadToHeadViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_match_stats_head_to_head
    override val viewModel: HeadToHeadViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
    }

    private fun setAdapter() {
        binding.apply {
            viewModel = viewModel
        }
    }
}