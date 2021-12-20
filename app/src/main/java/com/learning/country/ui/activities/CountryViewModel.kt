package com.learning.country.ui.activities

import android.content.Context
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.learning.country.data.models.Country
import com.learning.country.repositories.CountryRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class CountryViewModel(context: Context) : ViewModel() {

    val countryList: MutableState<List<Country>> = mutableStateOf(emptyList())

    init {
        val countryRepository = CountryRepository(context = context)
        viewModelScope.launch {
            countryRepository.getCountry().collect() { it ->
                countryList.value = it
            }
        }
    }
}

class CountryViewModelFactory(
    private val context: Context
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CountryViewModel::class.java)) {
            return CountryViewModel(context = context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}