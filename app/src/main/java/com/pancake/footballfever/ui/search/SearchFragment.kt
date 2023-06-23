package com.pancake.footballfever.ui.search

import android.util.Log
import androidx.core.content.ContextCompat
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.google.android.material.chip.Chip
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentSearchBinding
import com.pancake.footballfever.domain.models.SearchKeyword
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

           lifecycleScope.launch {
               viewModel.searchKeyword.collect { searchKeywords ->
                   Log.i("Abdallahx3x", searchKeywords.toString())
                   makeSuggestKeywordToChips(searchKeywords)
               }
           }

        searchViewListener()
    }

    private fun searchViewListener() {
        lifecycleScope.launch {
            callbackFlow {
                binding.searchBar.doOnTextChanged { text, _, _, _ ->
                    text?.let { channel.trySend(it.toString()).isSuccess }
                    if (text.isNullOrEmpty()) {
                        viewModel.showKeywordSuggests()
                        Log.i("x3x",viewModel.searchKeyword.value.toString())
                    }
                }
                awaitClose()
            }
                .debounce(1_000)
                .collect {text->
                       makeSearch(text)
                }
        }
    }

    private  fun  makeSearch(text:String){
        if (text.isNotBlank()) {
            viewModel.cacheKeyword(text)
            viewModel.getDataBySearchText()
        }
    }

    private fun makeSuggestKeywordToChips(items: List<SearchKeyword>?) {
        binding.searchSuggest.removeAllViews()
        items?.take(8)?.forEach {searchKeyword->
            val chip = Chip(context).apply {
                text = searchKeyword.keyword
                isCloseIconVisible = false
                setTextColor(ContextCompat.getColor(context, R.color.white87))
                setChipBackgroundColorResource(R.color.search_bar_background)
                setOnClickListener{
                    binding.searchBar.setText(searchKeyword.keyword)
                }
            }
            binding.searchSuggest.addView(chip)
        }
    }


    override fun showBottomNavBar(show: Boolean) {
        super.showBottomNavBar(true)
    }
}