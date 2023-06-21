package com.pancake.footballfever.ui.selectCountry

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pancake.footballfever.domain.models.SelectCountry
import com.pancake.footballfever.domain.usecases.GetAllCountriesUseCase
import com.pancake.footballfever.ui.selectCountry.adapter.SelectCountryListener
import com.pancake.footballfever.utilities.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SelectCountryViewModel @Inject constructor(
    private val getAllCountriesUseCase: GetAllCountriesUseCase
) : ViewModel(), SelectCountryListener {

    private val _countries = MutableStateFlow(SelectCountryUiState())
    val countries: StateFlow<SelectCountryUiState>
        get() = _countries

    val countryEvent = MutableLiveData<Event<SelectCountry>>()

    init {
        getAllCountries()
    }

    private fun getAllCountries() {
        viewModelScope.launch {
            try {
                val countries = getAllCountriesUseCase.getAllCountries()
                _countries.update {
                    it.copy(isLoading = false, success = countries)
                }
            } catch (e: Throwable) {
                _countries.update { it.copy(error = e.message) }
            }
        }
    }

    override fun onClickCountry(country: SelectCountry) {
        countryEvent.postValue(Event(country))
    }
}