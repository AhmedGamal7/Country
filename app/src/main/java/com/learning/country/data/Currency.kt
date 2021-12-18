package com.learning.country.data

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Currency(
    @SerializedName("code")  var code: String? = null,
    @SerializedName("name")  val name: String? = null,
    @SerializedName("symbol")  var symbol: String? = null
) : Parcelable