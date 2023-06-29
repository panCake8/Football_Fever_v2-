package com.pancake.footballfever.ui.about

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentAboutBinding
import com.pancake.footballfever.ui.base.BaseFragment
import com.pancake.footballfever.utilities.EventObserver


class AboutFragment : BaseFragment<FragmentAboutBinding, AboutViewModel>() {

    override val layoutId: Int = R.layout.fragment_about

    override val viewModel: AboutViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeEvent()
    }

    private fun observeEvent(){
        viewModel.backEvent.observe(viewLifecycleOwner, EventObserver{
            findNavController().popBackStack()
        })
    }


}
