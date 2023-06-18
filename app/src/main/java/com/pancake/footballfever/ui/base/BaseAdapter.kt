package com.pancake.footballfever.ui.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pancake.footballfever.BR

abstract class BaseAdapter<T>(
    private val listener: BaseAdapterListener
) : ListAdapter<T, BaseAdapter.BaseViewHolder>(BaseDiffUtil()) {

    abstract val getLayoutId: Int

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return ItemViewHolder(
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
            is ItemViewHolder -> bind(holder, position)
        }
    }

    open fun bind(holder: ItemViewHolder, position: Int) {
        holder.binding.apply {
            val currentItem = getItem(position)
            setVariable(BR._all, currentItem)
            setVariable(BR._all, listener)
        }
    }

    abstract class BaseViewHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)
    class ItemViewHolder(val binding: ViewDataBinding) : BaseViewHolder(binding)

}