package com.pancake.footballfever.ui.search

import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentSearchBinding
import com.pancake.footballfever.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding, SearchViewModel>() {

    override val layoutId: Int= R.layout.fragment_search
    override val viewModel: SearchViewModel by viewModels()

    override fun setup() {
        binding.searchRecycler.adapter=SearchAdapter(viewModel)
        doSearch()
    }

    private fun doSearch() {
        lifecycleScope.launch {
            callbackFlow {
                binding.searchBar.doOnTextChanged { text, _, _, _ ->
                    text?.let { channel.trySend(it.toString()).isSuccess }
                }
                awaitClose()
            }
                .debounce(1_000)
                .collect {
                    viewModel.getDataBySearchText()
                }
        }
    }



}