package com.learning.country.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.util.*

@kotlinx.parcelize.Parcelize
data class Country(
    @SerializedName("name") var name: String?,
    @SerializedName("topLevelDomain") var topLevelDomain: ArrayList<String>?,
    @SerializedName("alpha2Code") var alpha2Code: String? = null,
    @SerializedName("alpha3Code") var alpha3Code: String? = null,
    @SerializedName("callingCodes") var callingCodes: List<String>? = null,
    @SerializedName("capital") var capital: String? = null,
    @SerializedName("altSpellings") var altSpellings: List<String>? = null,
    @SerializedName("region") var region: String? = null,
    @SerializedName("subregion") var subregion: String? = null,
    @SerializedName("population") var population: Int? = null,
    @SerializedName("latlng") var latlng: List<Double?>? = null,
    @SerializedName("demonym") var demonym: String? = null,
    @SerializedName("area") var area: Double? = null,
    @SerializedName("gini") var gini: Double? = null,
    @SerializedName("timezones") var timezones: List<String>? = null,
    @SerializedName("borders") var borders: List<String>? = null,
    @SerializedName("nativeName") var nativeName: String? = null,
    @SerializedName("numericCode") var numericCode: String? = null,
    @SerializedName("currencies")  var currencies: List<Currency>? = null,
    @SerializedName("languages") var languages: List<Language>? = null,
    @SerializedName("translations") var translations: Translations? = null,
    @SerializedName("flag") var flag: String? = null,
    @SerializedName("regionalBlocs") private var regionalBlocs: List<RegionalBloc>? = null,
    @SerializedName("cioc") var cioc: String? = null
) : Parcelable