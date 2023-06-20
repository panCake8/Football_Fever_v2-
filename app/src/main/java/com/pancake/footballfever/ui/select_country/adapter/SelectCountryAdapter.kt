package com.pancake.footballfever.ui.select_country.adapter

import com.pancake.footballfever.R
import com.pancake.footballfever.domain.models.SelectCountry
import com.pancake.footballfever.ui.base.BaseAdapter

class SelectCountryAdapter(listener: SelectCountryListener) : BaseAdapter<SelectCountry>(listener) {
    override val getLayoutId = R.layout.select_country_item
}