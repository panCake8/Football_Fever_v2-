package com.pancake.footballfever.ui.club_stats

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ClubStatsPagerAdapter(
    fragment: Fragment
) : FragmentStateAdapter(fragment) {
    private val fragments = ArrayList<Fragment>()
    override fun getItemCount() = fragments.size

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

    fun addFragment(fragment: Fragment) {
        fragments.add(fragment)
    }
}