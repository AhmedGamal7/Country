package com.learning.country.data.disk

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.learning.country.data.models.Country
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.io.IOException
import java.io.InputStream
import java.lang.reflect.Type
import java.nio.charset.StandardCharsets

class ReadAsset : KoinComponent {

    private val context: Context by inject()

    fun getCountriesFromAsset(): List<Country> {
        val json = getJsonDataFromAsset()
        val gson = Gson()
        val type: Type = object : TypeToken<List<Country>>() {}.type
        return gson.fromJson(json, type)
    }

    private fun getJsonDataFromAsset(): String? {
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