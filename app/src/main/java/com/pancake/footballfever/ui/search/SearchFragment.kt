package com.pancake.footballfever.ui.search

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentSearchBinding
import com.pancake.footballfever.ui.base.BaseFragment


class SearchFragment : BaseFragment<FragmentSearchBinding, SearchViewModel>() {

    override val layoutId: Int= R.layout.fragment_search
    override val viewModel: SearchViewModel by viewModels()

    override fun setup() {
        binding.searchRecycler.adapter=SearchAdapter(viewModel)
    }



}