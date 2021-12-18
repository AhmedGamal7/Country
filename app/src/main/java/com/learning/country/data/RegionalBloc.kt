package com.learning.country.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class RegionalBloc(
    @SerializedName("acronym") private var acronym: String? = null,
    @SerializedName("name") private var name: String? = null,
    @SerializedName("otherAcronyms") private var otherAcronyms: List<String?>? = null,
    @SerializedName("otherNames") private var otherNames: List<String?>? = null
) : Parcelable
