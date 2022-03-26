package com.learning.country.data.models.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.learning.country.data.models.Language

class LanguageConverter {
    @TypeConverter
    fun fromListToString(list: List<Language>): String {
        return Gson().toJson(list)
    }

    @TypeConverter
    fun fromStringToList(string: String): List<Language> {
        val type = object : TypeToken<List<Language>>() {}.type
        return Gson().fromJson(string, type)
    }
}