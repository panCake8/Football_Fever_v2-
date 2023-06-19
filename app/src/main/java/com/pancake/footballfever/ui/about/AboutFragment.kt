package com.pancake.footballfever.ui.about

import androidx.fragment.app.viewModels
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentAboutBinding
import com.pancake.footballfever.ui.base.BaseFragment

class AboutFragment : BaseFragment<FragmentAboutBinding, AboutViewModel>() {
    override val layoutId = R.layout.fragment_about
    override val viewModel by viewModels<AboutViewModel>()

}