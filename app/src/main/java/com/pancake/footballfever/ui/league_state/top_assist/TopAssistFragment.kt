package com.pancake.footballfever.ui.league_state.top_assist

import androidx.fragment.app.viewModels
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentTopAssistBinding
import com.pancake.footballfever.ui.base.BaseFragment
import com.pancake.footballfever.ui.league_state.top_assist.adapter.TopAssistAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class TopAssistFragment : BaseFragment<FragmentTopAssistBinding, TopAssistViewModel>() {

    override val layoutId: Int =  R.layout.fragment_top_assist
    override val viewModel: TopAssistViewModel by viewModels()

    override fun setup() {
        super.setup()

        val adapter = TopAssistAdapter(viewModel)
        binding.recyclerViewAssist.adapter = adapter
    }

}