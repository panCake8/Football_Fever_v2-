package com.pancake.footballfever.ui.search

import android.os.Build
import android.util.Log
import androidx.activity.addCallback
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.chip.Chip
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentSearchBinding
import com.pancake.footballfever.domain.models.SearchKeyword
import com.pancake.footballfever.ui.base.BaseFragment
import com.pancake.footballfever.utilities.collect
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch
import java.time.Year

@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding, SearchViewModel>() {

    override val layoutId: Int = R.layout.fragment_search
    override val viewModel: SearchViewModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.O)
    private val season=Year.now().value

    @RequiresApi(Build.VERSION_CODES.O)
    override fun setup() {
        binding.searchRecycler.adapter = SearchAdapter(viewModel)

        lifecycleScope.launch {
            viewModel.searchKeyword.collect { searchKeywords ->
                makeSuggestKeywordToChips(searchKeywords)
            }
        }
        doEvent()
        searchViewListener()
        handleOnBackPressed()
    }


    private fun handleOnBackPressed() {
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            findNavController().navigate(R.id.homeFragment)
        }
    }

    @OptIn(FlowPreview::class)
    private fun searchViewListener() {
        lifecycleScope.launch {
            callbackFlow {
                binding.searchBar.doOnTextChanged { text, _, _, _ ->
                    text?.let { channel.trySend(it.toString()).isSuccess }
                    if (text.isNullOrEmpty()) {
                        viewModel.showKeywordSuggests()
                        Log.i("x3x", viewModel.searchKeyword.value.toString())
                    }
                }
                awaitClose()
            }
                .debounce(1_000)
                .collect { text ->
                    makeSearch(text)
                }
        }
    }

    private fun makeSearch(text: String) {
        if (text.isNotBlank()) {
            viewModel.cacheKeyword(text)
            viewModel.getDataBySearchText()
        }
    }

    private fun makeSuggestKeywordToChips(items: List<SearchKeyword>?) {
        binding.searchSuggest.removeAllViews()
        items?.take(8)?.forEach { searchKeyword ->
            val chip = Chip(context).apply {
                text = searchKeyword.keyword
                isCloseIconVisible = false
                setTextColor(ContextCompat.getColor(context, R.color.white87))
                setChipBackgroundColorResource(R.color.search_bar_background)
                setOnClickListener {
                    binding.searchBar.setText(searchKeyword.keyword)
                }
            }
            binding.searchSuggest.addView(chip)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun doEvent() {
        collect(viewModel.searchEvent) {
            it?.getContentIfNotHandled()?.let { onEvent(it) }
        }
    }
    @RequiresApi(Build.VERSION_CODES.O)
    private fun onEvent(event: SearchUiEvent) {
        when (event) {
            is SearchUiEvent.ClickLeagueEvent -> {
                val nav =
                    SearchFragmentDirections.actionHiltSearchFragmentToLeagueStateFragment(event.item.id!!,season)
                findNavController().navigate(nav)
            }
            is SearchUiEvent.ClickTeamEvent -> {
                val nav =
                    SearchFragmentDirections.actionHiltSearchFragmentToClubFragment(event.item.id!!,event.item.id!!,season)
                findNavController().navigate(nav)
            }
            else->{}
        }
    }


    override fun showBottomNavBar(show: Boolean) {
        super.showBottomNavBar(true)
    }
}