package com.learning.country.repositories

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.learning.country.data.models.Country
import com.learning.country.room.CountryDataBase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import java.io.IOException
import java.io.InputStream
import java.lang.reflect.Type
import java.nio.charset.StandardCharsets

class CountryRepository(context: Context) {

    private val mContext: Context = context

    private val countryDataBase = CountryDataBase.getDatabase(mContext)
    private val countryDao = countryDataBase.countryDao()

    fun getCountry() : Flow<List<Country>> {
        CoroutineScope(Dispatchers.IO).launch {
            if (countryDao.getRowsCount() == 0) {
                getCountriesFromAsset()
            }
        }
        return countryDao.getCountryFromDb()
    }

    private fun getCountriesFromAsset() {

        val json = getJsonDataFromAsset(mContext)
        val gson = Gson()
        val type: Type = object : TypeToken<List<Country>>() {}.type
        val countries: List<Country> = gson.fromJson(json, type)

        CoroutineScope(Dispatchers.IO).launch {

            val l = countryDao.insertCountries(countries)
            Log.i("Ahmed_dbi", "count : ${l.size}")

        }

    }

    private fun getJsonDataFromAsset(context: Context): String? {
        val jsonString: String = try {
            val inputStream: InputStream =
                context.assets.open("country")
            val size: Int = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            String(buffer, StandardCharsets.UTF_8)
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }

}