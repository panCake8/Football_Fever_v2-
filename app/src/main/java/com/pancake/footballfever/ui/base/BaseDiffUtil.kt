package com.pancake.footballfever.ui.base

import androidx.recyclerview.widget.DiffUtil

class BaseDiffUtil<T> : DiffUtil.ItemCallback<T>() {

    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem?.equals(newItem) == true
    }

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return false
    }

}