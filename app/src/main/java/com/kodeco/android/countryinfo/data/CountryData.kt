package com.kodeco.android.countryinfo.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CountryName(
    val common: String
)

@JsonClass(generateAdapter = true)
data class CountryFlags(
    val png: String
)

@JsonClass(generateAdapter = true)
data class Country(
    val name: CountryName,
    val capital: List<String>?,
    val population: Long,
    val area: Float,
    val flags: CountryFlags
) {
    val mainCapital = capital?.firstOrNull() ?: "N/A"
    val commonName = name.common
    val flagUrl = flags.png
}
