package com.learning.country.di

import android.app.Application
import androidx.room.Room
import com.learning.country.data.disk.ReadAsset
import com.learning.country.repositories.CountryRepository
import com.learning.country.room.CountryDao
import com.learning.country.room.CountryDataBase
import com.learning.country.ui.screen.mainscreen.CountryViewModel
import kotlinx.coroutines.CoroutineScope
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val module = module {

    single { provideDataBase(androidApplication()) }
    single { provideDao(get()) }
    single { ReadAsset() }
    single { CountryRepository(get(), get()) }

    viewModel { CountryViewModel(get()) }
}

fun provideDataBase(application: Application): CountryDataBase {
    return Room.databaseBuilder(application, CountryDataBase::class.java, "CountryDB")
        .fallbackToDestructiveMigration()
        .build()
}

fun provideDao(dataBase: CountryDataBase): CountryDao {
    return dataBase.countryDao()
}