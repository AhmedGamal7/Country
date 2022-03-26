package com.learning.country.data.models.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.learning.country.data.models.Translations

class TranslationsConverter {
    @TypeConverter
    fun fromListToString(translations: Translations): String {
        return Gson().toJson(translations)
    }

    @TypeConverter
    fun fromStringToList(string: String): Translations {
        val type = object : TypeToken<Translations>() {}.type
        return Gson().fromJson(string, type)
    }
}