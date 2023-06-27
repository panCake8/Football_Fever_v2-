package com.pancake.footballfever.ui.transfers

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentTransfersBinding
import com.pancake.footballfever.ui.base.BaseFragment
import com.pancake.footballfever.ui.transfers.adapter.TransfersAdapter


class TransfersFragment : BaseFragment<FragmentTransfersBinding,TransfersViewModel>() {

    override val layoutId: Int = R.layout.fragment_transfers

    override val viewModel: TransfersViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.recyclerTransfers.adapter = TransfersAdapter(viewModel)
    }


}