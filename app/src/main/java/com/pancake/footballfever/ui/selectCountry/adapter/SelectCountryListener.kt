package com.pancake.footballfever.ui.selectCountry.adapter

import com.pancake.footballfever.domain.models.SelectCountry
import com.pancake.footballfever.ui.base.BaseAdapterListener

interface SelectCountryListener : BaseAdapterListener {
    fun onClickCountry(country: SelectCountry)
}