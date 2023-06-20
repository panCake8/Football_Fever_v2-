package com.pancake.footballfever.ui.league_state.match

import android.os.Bundle
import android.view.View
import android.widget.AutoCompleteTextView
import androidx.fragment.app.viewModels
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentLeagueMatchBinding
import com.pancake.footballfever.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import java.util.Calendar

@AndroidEntryPoint
class LeagueMatchesFragment : BaseFragment<FragmentLeagueMatchBinding, LeagueMatchesViewModel>() {


    override val layoutId: Int
        get() = R.layout.fragment_league_match

    override val viewModel: LeagueMatchesViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecycler()



    }

    private fun setRecycler() {

    }

    private fun setDropDown(dropdown: AutoCompleteTextView) {


        val items = listOf(
            "$year-${month + 1}-$day",
            "$year-${month + 1}-${day - 1}",
            "$year-${month + 1}-${day - 2}",
            "$year-${month + 1}-${day - 3}",
            "$year-${month + 1}-${day - 4}",
            "$year-${month + 1}-${day - 5}",
            "$year-${month + 1}-${day - 6}",
        )




    }

    private fun updateScreen(year: Int, league: Int, date: String) {
        viewModel.getAllLeagueMatches(year - 1 , league, date)

        viewModel.updateDate(date)

    }

    companion object {

        val day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        val month = Calendar.getInstance().get(Calendar.MONTH)
        val year = Calendar.getInstance().get(Calendar.YEAR)

    }

}