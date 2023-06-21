package com.pancake.footballfever.ui.coach

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentCoachBinding
import com.pancake.footballfever.ui.base.BaseFragment
import com.pancake.footballfever.ui.coach.adapter.CoachAdapter


class CoachFragment : BaseFragment<FragmentCoachBinding,CoachViewModel>() {

    override val layoutId: Int = R.layout.fragment_coach
    override val viewModel: CoachViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }


    private fun setupRecyclerView() {
        binding.coachesRecycler.adapter = CoachAdapter(viewModel)
    }


}