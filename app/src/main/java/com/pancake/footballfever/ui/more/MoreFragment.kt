package com.pancake.footballfever.ui.more

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentMoreBinding
import com.pancake.footballfever.ui.base.BaseFragment
import com.pancake.footballfever.utilities.EventObserver

class MoreFragment : BaseFragment<FragmentMoreBinding, MoreViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_more

    override val viewModel by viewModels<MoreViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeEvents()

    }

    private fun observeEvents(){

        viewModel.moreBackEvent.observe(viewLifecycleOwner, EventObserver{
            findNavController().popBackStack()
        })

        viewModel.moreInjuriesEvent.observe(viewLifecycleOwner,EventObserver{
            val nav = MoreFragmentDirections.actionMoreFragmentToInjuriesFragment()
            findNavController().navigate(nav)
        })

        viewModel.moreAboutEvent.observe(viewLifecycleOwner,EventObserver{
            val nav = MoreFragmentDirections.actionMoreFragmentToAboutFragment()
            findNavController().navigate(nav)

        })

    }

}