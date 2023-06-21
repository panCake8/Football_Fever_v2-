package com.pancake.footballfever.utilities

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pancake.footballfever.R
import com.pancake.footballfever.domain.models.FixtureEvents
import com.pancake.footballfever.ui.base.BaseAdapter
import com.pancake.footballfever.ui.fixture_events.FixtureEventsAdapter
import com.pancake.footballfever.ui.home.HomeUiState
import com.pancake.footballfever.ui.home.HomeViewModel
import com.pancake.footballfever.ui.home.adapter.FixtureHomeListener
import com.pancake.footballfever.ui.home.adapter.ParentHomeAdapter

@BindingAdapter(value = ["app:setRecyclerItems"])
fun <T> setRecyclerItems(recyclerView: RecyclerView, items: List<T?>?) {
    (recyclerView.adapter as BaseAdapter<T?>?)?.submitList(items)
}

@BindingAdapter(value = ["app:setImageUrl"])
fun setImageUrl(image: ImageView, url: String?) {
    url?.let {
        Glide.with(image).load(it).into(image)
    }
}

@BindingAdapter("app:showIfLoading")
fun ProgressBar.showIfLoading(isLoading: Boolean) {
    visibility = when (isLoading) {
        true -> View.VISIBLE
        false -> View.INVISIBLE
    }
}

@BindingAdapter("app:showIfError")
fun ImageView.showIfError(errorMsg: String?) {
    visibility = when (errorMsg) {
        null -> View.INVISIBLE
        else -> View.VISIBLE
    }
}

@BindingAdapter("app:errorMessage")
fun TextView.errorMessage(errorMsg: String?) {
    when (errorMsg) {
        null -> visibility = View.INVISIBLE
        else -> {
            visibility = View.VISIBLE
            text = errorMsg
        }
    }
}

@BindingAdapter("app:bindFixtureEventImg")
fun ImageView.bindFixtureEventImg(type: String) {
    setImageDrawable(
        when (type) {
            "Goal" -> ResourcesCompat.getDrawable(resources, R.drawable.goal, null)
            "Card" -> ResourcesCompat.getDrawable(resources, R.drawable.card_red_yellow, null)
            "subst" -> ResourcesCompat.getDrawable(resources, R.drawable.ic_player_subst, null)
            else -> null
        }
    )
}

@BindingAdapter(value = ["app:setHomeItem", "app:setHomeListener"], requireAll = true)
fun RecyclerView.setHomeItem(item: HomeUiState, listener: FixtureHomeListener) {
    adapter = ParentHomeAdapter(item, listener)
}

@BindingAdapter(value = ["summaryItems", "homeId"], requireAll = true)
fun RecyclerView.bindSummaryAdapterItems(summaryItems: List<FixtureEvents>?, homeId: Int) {
    summaryItems?.let {
        adapter = FixtureEventsAdapter(homeId).also {
            it.submitList(summaryItems)
        }

    }
}