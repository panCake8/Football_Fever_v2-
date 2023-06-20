package com.pancake.footballfever.ui.coach

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentCoachBinding
import com.pancake.footballfever.ui.base.BaseFragment


class CoachFragment : BaseFragment<FragmentCoachBinding,CoachViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_coach

    override val viewModel: CoachViewModel by viewModels()



}