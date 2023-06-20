package com.pancake.footballfever.ui.select_country.adapter

import com.pancake.footballfever.domain.models.SelectCountry
import com.pancake.footballfever.ui.base.BaseAdapterListener

interface SelectCountryListener : BaseAdapterListener {
    fun onClickCountry(country: SelectCountry)
}