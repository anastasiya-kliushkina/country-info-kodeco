package com.kodeco.android.countryinfo.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CountryName(
    val common: String
)
