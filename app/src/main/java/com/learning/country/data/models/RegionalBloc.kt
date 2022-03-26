package com.learning.country.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RegionalBloc(
    val acronym: String?=null,
    val name: String?=null,
    val otherAcronyms: List<String>?=null,
    val otherNames: List<String>?=null
) : Parcelable