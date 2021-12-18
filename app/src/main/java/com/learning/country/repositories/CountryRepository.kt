package com.learning.country.repositories

import android.content.Context
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.learning.country.data.Country
import java.io.IOException
import java.io.InputStream
import java.lang.reflect.Type
import java.nio.charset.StandardCharsets

class CountryRepository(context: Context) {
    private val mApplicationContext: Context = context.applicationContext
    private val _countryList: MutableState<List<Country>> = mutableStateOf(emptyList())
    val countryList: State<List<Country>> get() = _countryList

    init {
        val json = getJsonDataFromAsset(mApplicationContext)
        val gson = Gson()
        val type: Type = object : TypeToken<List<Country>>() {}.type
        _countryList.value = gson.fromJson(json, type)
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