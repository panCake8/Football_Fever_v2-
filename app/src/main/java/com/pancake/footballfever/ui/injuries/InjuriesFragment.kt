package com.pancake.footballfever.ui.injuries


import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentInjuriesBinding
import com.pancake.footballfever.ui.base.BaseFragment
import com.pancake.footballfever.ui.injuries.adapter.InjuriesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InjuriesFragment : BaseFragment<FragmentInjuriesBinding,InjuriesViewModel>() {

    override val layoutId: Int = R.layout.fragment_injuries

    override val viewModel: InjuriesViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }


    private fun setupRecyclerView() {
        binding.injuriesRecyclerView.adapter = InjuriesAdapter(viewModel)
    }


}