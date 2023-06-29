package com.pancake.footballfever.ui.leagues

import android.os.Bundle
import android.view.View
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentLeagueBinding
import com.pancake.footballfever.ui.base.BaseFragment
import com.pancake.footballfever.ui.leagues.adapter.LeaguesAdapter
import com.pancake.footballfever.ui.leagues.uiState.LeagueUiEvent
import com.pancake.footballfever.utilities.collectLast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LeagueFragment : BaseFragment<FragmentLeagueBinding, LeaguesViewModel>() {

    override val layoutId: Int = R.layout.fragment_league
    override val viewModel: LeaguesViewModel by viewModels()
    private val searchQueryFlow = MutableStateFlow("")
    private var searchJob: Job? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerAdapter()
        collectEvent()
        getSearchResultsBySearchTerm()


    }

    private fun setRecyclerAdapter() {
        binding.recyclerLeague.adapter = LeaguesAdapter(viewModel)
    }
    private fun collectEvent() {
        collectLast(viewModel.leagueEvent) {
            it?.getContentIfNotHandled()?.let { onEvent(it) }
        }
    }

    private fun onEvent(event: LeagueUiEvent) {
        when (event) {
            is LeagueUiEvent.ClickLeagueEvent -> {
                val nav =
                    LeagueFragmentDirections.actionLeagueFragmentToLeagueStateFragment(event.league.id!!, event.league.season!!)
                findNavController().navigate(nav)
            }
            is LeagueUiEvent.ClickRetryEvent -> {}
            is LeagueUiEvent.ClickBackEvent -> {}
        }
    }

    @OptIn(FlowPreview::class)
    private fun getSearchResultsBySearchTerm() {

        binding.searchBar.doOnTextChanged { text, _, _, _ ->
            searchQueryFlow.value = text.toString()
        }
        lifecycleScope.launch {
            searchQueryFlow
                .debounce(500) // Debounce for 500 milliseconds
                .distinctUntilChanged() // Ignore duplicate consecutive queries
                .collect { query ->
                    searchJob?.cancel() // Cancel any previous search job

                    searchJob = viewModel.onSearchInputChange(query)
                }
        }
    }

    private fun makeSearch(text: String) {
        if (text.isNotBlank()) {
            viewModel.onSearchInputChange(text)
        }
    }


    override fun showBottomNavBar(show: Boolean) {
        super.showBottomNavBar(true)
    }

}