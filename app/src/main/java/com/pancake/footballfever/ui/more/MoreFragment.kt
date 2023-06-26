package com.pancake.footballfever.ui.more

import androidx.fragment.app.viewModels
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentMoreBinding
import com.pancake.footballfever.ui.base.BaseFragment

class MoreFragment : BaseFragment<FragmentMoreBinding, MoreViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_more

    override val viewModel by viewModels<MoreViewModel>()

}