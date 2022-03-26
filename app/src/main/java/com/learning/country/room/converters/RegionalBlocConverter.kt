package com.learning.country.data.models.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.learning.country.data.models.RegionalBloc

class RegionalBlocConverter {
    @TypeConverter
    fun fromListToString(list: List<RegionalBloc>): String {
        return Gson().toJson(list)
    }

    @TypeConverter
    fun fromStringToList(string: String): List<RegionalBloc> {
        val type = object : TypeToken<List<RegionalBloc>>() {}.type
        return Gson().fromJson(string, type)
    }
}