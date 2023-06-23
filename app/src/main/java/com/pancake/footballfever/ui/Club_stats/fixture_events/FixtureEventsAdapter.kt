package com.pancake.footballfever.ui.club_stats.fixture_events

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pancake.footballfever.databinding.ItemSummaryAwayBinding
import com.pancake.footballfever.databinding.ItemSummaryHomeBinding
import com.pancake.footballfever.domain.models.FixtureEvents


class FixtureEventsAdapter(private val homeId: Int) : ListAdapter<FixtureEvents, RecyclerView.ViewHolder>(
    COMPARATOR
) {
    class HomeViewHolder(private val binding: ItemSummaryHomeBinding) : RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup): HomeViewHolder {
                return HomeViewHolder(ItemSummaryHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            }
        }

        fun bind(item: FixtureEvents) {
            binding.item = item
            binding.executePendingBindings()
        }
    }

    class AwayViewHolder(private val binding: ItemSummaryAwayBinding) : RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup): AwayViewHolder {
                return AwayViewHolder(ItemSummaryAwayBinding.inflate(LayoutInflater.from(parent.context), parent, false))
            }
        }

        fun bind(item: FixtureEvents) {
            binding.item = item
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_HOME -> {
                HomeViewHolder.from(parent)
            }

            VIEW_TYPE_AWAY -> {
                AwayViewHolder.from(parent)
            }

            else -> {
                throw IllegalArgumentException("Unknown ViewHolder Type")
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is HomeViewHolder -> {
                holder.bind(getItem(position))
            }

            is AwayViewHolder -> {
                holder.bind(getItem(position))
            }
        }
    }


    override fun getItemViewType(position: Int): Int {
        return when (getItem(position).teamId == homeId) {
            true -> VIEW_TYPE_HOME
            false -> VIEW_TYPE_AWAY
        }
    }

    companion object {
        private const val VIEW_TYPE_HOME = 0
        private const val VIEW_TYPE_AWAY = 1
        private val COMPARATOR = object : DiffUtil.ItemCallback<FixtureEvents>() {
            override fun areItemsTheSame(oldItem: FixtureEvents, newItem: FixtureEvents): Boolean {
                return oldItem.teamId == newItem.teamId
            }

            override fun areContentsTheSame(oldItem: FixtureEvents, newItem: FixtureEvents): Boolean {
                return oldItem == newItem
            }
        }
    }
}