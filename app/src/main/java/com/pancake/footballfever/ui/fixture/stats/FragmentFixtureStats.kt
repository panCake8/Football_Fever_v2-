package com.pancake.footballfever.ui.fixture.stats

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentStaticisFixtureBinding
import com.pancake.footballfever.ui.base.BaseFragment
import com.pancake.footballfever.domain.Constants
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

private const val FIXTUREID = "fixtureId"

@AndroidEntryPoint
class FragmentFixtureStats : BaseFragment<FragmentStaticisFixtureBinding, FixtureStatsViewModel>() {
    override val layoutId: Int
        get() = R.layout.fragment_staticis_fixture
    override val viewModel by viewModels<FixtureStatsViewModel>()

    override fun setup() {
        super.setup()
        val fixtureId = requireArguments().getInt(FIXTUREID)
        fixtureId.let {
            viewModel.fetchFixtureStats(it)
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.fixtureStats.collect { fixtureStats ->
                val fixture = fixtureStats.success
                if (fixture != null) {
                    binding.item = fixture
                }
            }
        }

    }


    companion object {
        @JvmStatic
        fun newInstance(fixtureId: Int?) =
            FragmentFixtureStats().apply {
                arguments = Bundle().apply {
                    fixtureId?.let { putInt(FIXTUREID, it) }
                }
            }
    }

}