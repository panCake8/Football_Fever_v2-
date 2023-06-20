package com.pancake.footballfever.ui.select_country

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pancake.footballfever.domain.models.SelectCountry
import com.pancake.footballfever.domain.usecases.GetAllCountriesUseCase
import com.pancake.footballfever.ui.select_country.adapter.SelectCountryListener
import com.pancake.footballfever.utilities.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SelectCountryViewModel @Inject constructor(
    private val getAllCountriesUseCase: GetAllCountriesUseCase
) : ViewModel(), SelectCountryListener {

    private val _countries = MutableLiveData<List<SelectCountry>>()
    val countries: LiveData<List<SelectCountry>>
        get() = _countries

    val countryEvent = MutableLiveData<Event<SelectCountry>>()

    init {
        getAllCountries()
    }

    private fun getAllCountries() {
        viewModelScope.launch {
            val countries = getAllCountriesUseCase.getAllCountries()
            _countries.postValue(countries)
        }
    }

    override fun onClickCountry(country: SelectCountry) {
        countryEvent.postValue(Event(country))
    }
}