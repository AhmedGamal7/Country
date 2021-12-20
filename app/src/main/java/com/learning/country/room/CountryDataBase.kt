package com.learning.country.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.learning.country.data.models.Country
import com.learning.country.data.models.converters.*


@Database(entities = [Country::class], version = 2, exportSchema = false)
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

    companion object {
        @Volatile
        private var INSTANCE: CountryDataBase? = null

        fun getDatabase(context: Context): CountryDataBase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CountryDataBase::class.java,
                    "country_database"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}