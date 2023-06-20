package com.pancake.footballfever.ui.select_country

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentSelectCountryBinding
import com.pancake.footballfever.ui.base.BaseFragment
import com.pancake.footballfever.ui.select_country.adapter.SelectCountryAdapter
import com.pancake.footballfever.utilities.EventObserver
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SelectCountryFragment : BaseFragment<FragmentSelectCountryBinding, SelectCountryViewModel>() {
    override val layoutId = R.layout.fragment_select_country
    override val viewModel: SelectCountryViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerAdapter()
        observeEvent()
    }

    private fun setRecyclerAdapter() {
        binding.countryRecycler.adapter = SelectCountryAdapter(viewModel)
    }

    private fun observeEvent() {
        viewModel.countryEvent.observe(viewLifecycleOwner, EventObserver {
            val nav =
                SelectCountryFragmentDirections.actionSelectCountryFragmentToSelectFavoriteTeamsFragment(
                    it.name!!
                )
            findNavController().navigate(nav)
        })
    }
}