package com.learning.country.repositories

import com.learning.country.data.disk.ReadAsset
import com.learning.country.room.CountryDao
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CountryRepository(
    private val countryDao: CountryDao,
    private val readAsset: ReadAsset,

    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    suspend fun getCountry() = withContext(dispatcher) {
        if (countryDao.getRowsCount() == 0) {
            val countries = readAsset.getCountriesFromAsset()
            countryDao.insertCountries(countries)
        }
        return@withContext countryDao.getCountryFromDb()
    }

}
