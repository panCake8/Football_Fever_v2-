package com.pancake.footballfever.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.FragmentHomeBinding
import com.pancake.footballfever.ui.base.BaseFragment
import com.pancake.footballfever.utilities.EventObserver
import com.prolificinteractive.materialcalendarview.CalendarDay
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.Calendar

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {
    override val layoutId = R.layout.fragment_home
    override val viewModel: HomeViewModel by viewModels()

    private val calender = Calendar.getInstance()
    private var dateFormatter = ""
    private var seasonFormatter = 0
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        callFixtures()
        setUpCalender()
        onCalenderClick()
        observeEvents()
    }

    private fun callFixtures() {
        clearCalender()
        formatDate()
        viewModel.refreshFixtures(dateFormatter, seasonFormatter)
    }

    private fun setUpCalender() {
        binding.calendarView.selectedDate = CalendarDay.today()
    }

    private fun onCalenderClick() {
        binding.calendarView.setOnDateChangedListener { widget, date, selected ->
            if (selected) {
                calender.set(Calendar.YEAR, date.year)
                calender.set(Calendar.MONTH, date.month - 1)
                calender.set(Calendar.DAY_OF_MONTH, date.day)
                refreshData()
            }
        }
    }

    private fun refreshData() {
        clearCalender()
        formatDate()
        viewModel.deleteAllFixtures()
        viewModel.refreshFixtures(dateFormatter, seasonFormatter)
    }

    private fun clearCalender() {
        calender.set(Calendar.MILLISECOND, 0)
        calender.set(Calendar.SECOND, 0)
        calender.set(Calendar.MINUTE, 0)
        calender.set(Calendar.HOUR, 0)
    }

    private fun formatDate() {
        dateFormatter = SimpleDateFormat("YYYY-MM-dd").format(calender.time)
        seasonFormatter = SimpleDateFormat("YYYY").format(calender.time).toInt().minus(1)
    }

    private fun observeEvents() {
        viewModel.fixtureEvent.observe(viewLifecycleOwner, EventObserver {
            formatDate()
            val nav = HomeFragmentDirections.actionHomeFragmentToFixtureFragment(
                it.fixture!!,
                seasonFormatter,
                dateFormatter
            )
            findNavController().navigate(nav)
        })
    }
}