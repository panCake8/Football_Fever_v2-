package com.pancake.footballfever.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.pancake.footballfever.R
import com.pancake.footballfever.databinding.ChildHomeFirstMatchCardBinding
import com.pancake.footballfever.databinding.ChildHomeMoreMatchesBinding
import com.pancake.footballfever.ui.home.HomeUiState

class ParentHomeAdapter(
    private val homeItem: HomeUiState,
    private val listener: FixtureHomeListener
) : Adapter<ParentHomeAdapter.BaseParentHomeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseParentHomeViewHolder {
        return when (viewType) {
            FIRST_ITEM -> HomeFirstMatchViewHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.child_home_first_match_card, parent, false
                )
            )

            else -> HomeMoreMatchesViewHolder(
                DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.child_home_more_matches, parent, false
                )
            )
        }
    }


    override fun onBindViewHolder(holder: BaseParentHomeViewHolder, position: Int) {
        when (holder) {
            is HomeFirstMatchViewHolder -> bindHomeFirstMatch(holder)
            is HomeMoreMatchesViewHolder -> bindHomeMoreMatches(holder)
        }
    }

    private fun bindHomeFirstMatch(holder: HomeFirstMatchViewHolder) {

        holder.binding.apply {
            if (homeItem.success.isNotEmpty()) {
                item = homeItem.success.first()
                listener = this@ParentHomeAdapter.listener
            } else {
                val layoutParams = cardView.layoutParams
                layoutParams.height = 0
                cardView.layoutParams = layoutParams
            }
        }

    }

    private fun bindHomeMoreMatches(holder: HomeMoreMatchesViewHolder) {
        holder.binding.apply {
            if (homeItem.success.isNotEmpty()) {
                item = homeItem
                childRecycler.adapter = HomeMoreMatchesAdapter(listener)
            } else {
                noMatchesMessage.isVisible = true
            }
        }
    }

    override fun getItemCount() = ITEMS_COUNT
    override fun getItemViewType(position: Int) = position

    abstract class BaseParentHomeViewHolder(binding: ViewDataBinding) : ViewHolder(binding.root)

    class HomeFirstMatchViewHolder(val binding: ChildHomeFirstMatchCardBinding) :
        BaseParentHomeViewHolder(binding)

    class HomeMoreMatchesViewHolder(val binding: ChildHomeMoreMatchesBinding) :
        BaseParentHomeViewHolder(binding)


    companion object {
        const val FIRST_ITEM = 0
        const val ITEMS_COUNT = 2
    }
}