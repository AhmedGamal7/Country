package com.learning.country.data.models.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.learning.country.data.models.Currency

class CurrencyConverter {
    @TypeConverter
    fun fromListToString(list: List<Currency>): String {
        return Gson().toJson(list)
    }

    @TypeConverter
    fun fromStringToList(string: String): List<Currency> {
        val type = object : TypeToken<List<Currency>>() {}.type
        return Gson().fromJson(string, type)
    }
}