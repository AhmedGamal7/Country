package com.learning.country.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.learning.country.data.models.Country
import com.learning.country.data.models.converters.*


@Database(entities = [Country::class], version = 1, exportSchema = false)
@TypeConverters(
    CurrencyConverter::class,
    LanguageConverter::class,
    RegionalBlocConverter::class,
    TranslationsConverter::class,
    StringListConverter::class,
    DoubleListConverter::class
)
abstract class CountryDataBase : RoomDatabase() {
    abstract fun countryDao(): CountryDao
}