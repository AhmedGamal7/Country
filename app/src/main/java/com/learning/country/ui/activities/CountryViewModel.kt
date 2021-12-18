package com.learning.country.ui.activities

import android.content.Context
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.learning.country.data.Country
import com.learning.country.repositories.CountryRepository
import kotlinx.coroutines.launch

class CountryViewModel(context: Context) : ViewModel() {

    private val _countryList: MutableState<List<Country>> = mutableStateOf(emptyList())
    val countryList: State<List<Country>> get() = _countryList

    init {
        val countryRepository = CountryRepository(context = context)
        viewModelScope.launch {
            _countryList.value = countryRepository.countryList.value
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