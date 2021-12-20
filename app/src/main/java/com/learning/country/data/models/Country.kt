package com.learning.country.data.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import com.learning.country.data.models.converters.*
import kotlinx.parcelize.Parcelize

@Entity(tableName = "Country")
@Parcelize
data class Country(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @SerializedName("name") var name: String?,
    @TypeConverters(StringListConverter::class)
    @SerializedName("topLevelDomain") var topLevelDomain: List<String>?,
    @SerializedName("alpha2Code") var alpha2Code: String? = null,
    @SerializedName("alpha3Code") var alpha3Code: String? = null,
    @TypeConverters(StringListConverter::class)
    @SerializedName("callingCodes") var callingCodes: List<String>? = null,
    @SerializedName("capital") var capital: String? = null,
    @TypeConverters(StringListConverter::class)
    @SerializedName("altSpellings") var altSpellings: List<String>? = null,
    @SerializedName("region") var region: String? = null,
    @SerializedName("subregion") var subregion: String? = null,
    @SerializedName("population") var population: Int? = null,
    @TypeConverters(DoubleListConverter::class)
    @SerializedName("latlng") var latlng: List<Double?>? = null,
    @SerializedName("demonym") var demonym: String? = null,
    @SerializedName("area") var area: Double? = null,
    @SerializedName("gini") var gini: Double? = null,
    @TypeConverters(StringListConverter::class)
    @SerializedName("timezones") var timezones: List<String>? = null,
    @TypeConverters(StringListConverter::class)
    @SerializedName("borders") var borders: List<String>? = null,
    @SerializedName("nativeName") var nativeName: String? = null,
    @SerializedName("numericCode") var numericCode: String? = null,
    @TypeConverters(CurrencyConverter::class)
    @SerializedName("currencies") var currencies: List<Currency>? = null,
    @TypeConverters(LanguageConverter::class)
    @SerializedName("languages") var languages: List<Language>? = null,
    @TypeConverters(TranslationsConverter::class)
    @SerializedName("translations") var translations: Translations? = null,
    @SerializedName("flag") var flag: String? = null,
    @TypeConverters(RegionalBlocConverter::class)
    @SerializedName("regionalBlocs")  var regionalBlocs: List<RegionalBloc>? = null,
    @SerializedName("cioc") var cioc: String? = null
) : Parcelable