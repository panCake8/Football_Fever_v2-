package com.pancake.footballfever.ui.fixture.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class FixtureStatsPagerAdapter(
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