package com.pancake.footballfever.ui.search

import com.pancake.footballfever.R
import com.pancake.footballfever.domain.models.SearchItem
import com.pancake.footballfever.ui.base.BaseAdapter

class SearchAdapter (listener:SearchListener): BaseAdapter<SearchItem>(listener){
    override val getLayoutId= R.layout.item_search
}