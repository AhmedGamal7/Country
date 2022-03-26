package com.learning.country.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Translations(
    val br: String?=null,
    val de: String?=null,
    val es: String?=null,
    val fa: String?=null,
    val fr: String?=null,
    val hr: String?=null,
    val it: String?=null,
    val ja: String?=null,
    val nl: String?=null,
    val pt: String?=null
) : Parcelable