package com.pancake.footballfever.utilities

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pancake.footballfever.R
import com.pancake.footballfever.domain.models.FixtureSummary
import com.pancake.footballfever.ui.base.BaseAdapter
import com.pancake.footballfever.ui.fixture.FixtureUiState
import com.pancake.footballfever.ui.fixture.head2head.adapter.HeadToHeadListener
import com.pancake.footballfever.ui.fixture.head2head.adapter.HeadToHeadParentAdapter
import com.pancake.footballfever.ui.fixture.summary.FixtureSummaryAdapter
import com.pancake.footballfever.ui.home.HomeUiState
import com.pancake.footballfever.ui.home.adapter.FixtureHomeListener
import com.pancake.footballfever.ui.home.adapter.ParentHomeAdapter
import com.pancake.footballfever.ui.league_state.match.adapter.LeagueMatchesListener
import com.pancake.footballfever.ui.league_state.match.adapter.LeagueMatchesParentAdapter
import java.text.SimpleDateFormat
import java.util.Locale

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
fun View.showIfError(errorMsg: String?) {
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

@BindingAdapter("app:showWhenSearchLoading")
fun <T> showWhenLoading(view: View, dataState: DataState<T>) {

    if (dataState is DataState.Loading) {
        view.visibility = View.VISIBLE
    } else
        view.visibility = View.GONE

}

@BindingAdapter("app:showWhenSearchSuccess")
fun <T> showWhenSuccess(view: View, dataState: DataState<T>) {

    if (dataState is DataState.Success) {
        view.visibility = View.VISIBLE
    } else
        view.visibility = View.GONE

}


@BindingAdapter("app:showWhenSearchError")
fun <T> showWhenError(view: View, dataState: DataState<T>) {

    if (dataState is DataState.Error) {
        view.visibility = View.VISIBLE
    } else
        view.visibility = View.GONE

}

@BindingAdapter("app:showWhenEmptySearch")
fun <T> showWhenEmptySearch(view: View, dataState: DataState<T>) {

    if (dataState is DataState.Empty) {
        view.visibility = View.VISIBLE
    } else
        view.visibility = View.GONE

}


@BindingAdapter(value = ["app:showWhenSearchInSearchSuggests"])
fun <T> showWhenSearchInSearchSuggests(view: View, dataState: DataState<T>) {

    if (dataState is DataState.ShowKeywordSuggests) {
        view.visibility = View.VISIBLE
    } else
        view.visibility = View.GONE

}


@BindingAdapter(value = ["summaryItems", "homeId"], requireAll = true)
fun RecyclerView.bindSummaryAdapterItems(summaryItems: List<FixtureSummary>?, homeId: Int) {
    summaryItems?.let {
        adapter = FixtureSummaryAdapter(homeId).also {
            it.submitList(summaryItems)
        }

    }
}

@BindingAdapter(value = ["app:time"])
fun setTime(textView: TextView, time: Int?) {
    val simpleDateFormat = SimpleDateFormat("dd MMMM yyyy, HH:mm:ss", Locale.ENGLISH)
    if (time != null)
        textView.text = simpleDateFormat.format(time * 1000L)

}


@BindingAdapter(value = ["showIfSuccess"])
fun showIfSuccess(view: View, fixtureUiState: FixtureUiState) {
    if (fixtureUiState.fixture != null)
        view.visibility = View.VISIBLE
    else
        view.visibility = View.GONE
}


@BindingAdapter(value = ["app:hideWhenSearch"])
fun hideWhenSearch(view: View, text: String) {
    view.isVisible = text.isBlank()
}

@BindingAdapter(value = ["app:searchInput", "app:errorSearch", "app:loadingSearch"])
fun <T> hideWhenSuccessSearch(view: View, text: String, error: List<T>?, loading: Boolean) {
    view.visibility = if (text.isNotBlank() && error.isNullOrEmpty() && !loading) {
        View.VISIBLE
    } else {
        View.INVISIBLE
    }
}