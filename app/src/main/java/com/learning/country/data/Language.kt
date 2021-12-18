package com.learning.country.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Language(
    @SerializedName("iso639_1") private var iso6391: String? = null,
    @SerializedName("iso639_2") private var iso6392: String? = null,
    @SerializedName("name")  var name: String? = null,
    @SerializedName("nativeName")  var nativeName: String? = null
) : Parcelable