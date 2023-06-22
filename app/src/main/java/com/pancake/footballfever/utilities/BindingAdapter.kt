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
import com.pancake.footballfever.domain.models.LeagueMatchUiModel
import com.pancake.footballfever.ui.base.BaseAdapter
import com.pancake.footballfever.ui.base.BaseAdapterListener
import com.pancake.footballfever.ui.fixture.head2head.adapter.HeadToHeadListener
import com.pancake.footballfever.ui.fixture.head2head.adapter.HeadToHeadParentAdapter
import com.pancake.footballfever.ui.home.HomeUiState
import com.pancake.footballfever.ui.home.HomeViewModel
import com.pancake.footballfever.ui.home.adapter.FixtureHomeListener
import com.pancake.footballfever.ui.home.adapter.ParentHomeAdapter
import com.pancake.footballfever.ui.league_state.match.adapter.LeagueMatchesListener
import com.pancake.footballfever.ui.league_state.match.adapter.LeagueMatchesParentAdapter

@BindingAdapter(value = ["app:setRecyclerItems"])
fun <T> setRecyclerItems(recyclerView: RecyclerView, items: List<T?>?) {
    (recyclerView.adapter as BaseAdapter<T?>?)?.submitList(items)
}

@BindingAdapter(value = ["setLeagueChildAdapter"])
fun setChildRecyclerAdapter(recyclerView: RecyclerView,items:LeagueMatchesListener) {
    recyclerView.adapter = LeagueMatchesParentAdapter(items)
}

@BindingAdapter(value = ["setHeadToHeadRecyclerAdapter"])
fun setChildRecyclerAdapter(recyclerView: RecyclerView,items:HeadToHeadListener){
    recyclerView.adapter = HeadToHeadParentAdapter(items)
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