package com.pancake.footballfever.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.HomeMoreMatchesItemBinding
import com.pancake.footballfever.domain.models.FixtureHome
import com.pancake.footballfever.ui.base.BaseAdapter

class HomeMoreMatchesAdapter(private val listener: FixtureHomeListener) :
    BaseAdapter<FixtureHome>(listener) {

    override val getLayoutId = R.layout.home_more_matches_item

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return HomeMoreMatchesViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                getLayoutId,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        when (holder) {
            is HomeMoreMatchesViewHolder -> bindMoreMatches(holder, position)
        }
    }

    private fun bindMoreMatches(holder: HomeMoreMatchesViewHolder, position: Int) {
        val currentItem = currentList[position]
        if (position != 0) {
            holder.binding.apply {
                item = currentItem
                listener = this@HomeMoreMatchesAdapter.listener
            }
        } else {
            holder.binding.apply {
                val layoutParams = cardView.layoutParams
                layoutParams.height = 0
                cardView.layoutParams = layoutParams
            }
        }
    }

    class HomeMoreMatchesViewHolder(val binding: HomeMoreMatchesItemBinding) :
        BaseViewHolder(binding)
}