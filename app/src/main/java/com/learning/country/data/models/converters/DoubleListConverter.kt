package com.learning.country.data.models.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DoubleListConverter {
    @TypeConverter
    fun fromListToString(list: List<Double>): String {
        return Gson().toJson(list)
    }

    @TypeConverter
    fun fromStringToList(string: String): List<Double> {
        val type = object : TypeToken<List<Double>>() {}.type
        return Gson().fromJson(string, type)
    }
}