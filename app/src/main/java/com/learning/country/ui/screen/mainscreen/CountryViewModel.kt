package com.learning.country.ui.screen.mainscreen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.learning.country.data.models.Country
import com.learning.country.repositories.CountryRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class CountryViewModel(
    private val countryRepository: CountryRepository
) : ViewModel() {

    private val _countryList: MutableState<List<Country>> = mutableStateOf(emptyList())
    val countryList: State<List<Country>> get() = _countryList

    init {
        viewModelScope.launch {
            countryRepository.getCountry().collect { countries ->
                _countryList.value = countries
            }
        }
    }
}
