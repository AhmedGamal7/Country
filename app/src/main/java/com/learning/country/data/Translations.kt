package com.learning.country.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Translations(
    @SerializedName("de") private var de: String? = null,
    @SerializedName("es") private var es: String? = null,
    @SerializedName("fr") private var fr: String? = null,
    @SerializedName("ja") private var ja: String? = null,
    @SerializedName("it") private var it: String? = null,
    @SerializedName("br") private var br: String? = null,
    @SerializedName("pt") private var pt: String? = null,
    @SerializedName("nl") private var nl: String? = null,
    @SerializedName("hr") private var hr: String? = null,
    @SerializedName("fa") private var fa: String? = null
) : Parcelable