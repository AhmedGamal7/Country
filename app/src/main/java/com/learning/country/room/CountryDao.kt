package com.learning.country.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.learning.country.data.models.Country
import kotlinx.coroutines.flow.Flow

@Dao
interface CountryDao {
    @Query("SELECT COUNT(id) FROM Country ")
    fun getRowsCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCountries(list: List<Country>): LongArray

    @Query("SELECT * FROM Country")
    fun getCountryFromDb(): Flow<List<Country>>
}