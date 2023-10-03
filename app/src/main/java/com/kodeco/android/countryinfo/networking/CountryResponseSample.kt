package com.kodeco.android.countryinfo.networking

import com.kodeco.android.countryinfo.data.Country
import com.kodeco.android.countryinfo.data.CountryFlags
import com.kodeco.android.countryinfo.data.CountryName

val sampleCountries = listOf(
    Country(
        name = CountryName(common = "United States"),
        capital = listOf("Washington, D.C."),
        population = 328_239_523,
        area = 9_833_520f,
        flags = CountryFlags(png = ""),
    ),
    Country(
        name = CountryName(common = "Canada"),
        capital = listOf("Ottawa"),
        population = 37_742_154,
        area = 9_984_670f,
        flags = CountryFlags(png = ""),
    ),
    Country(
        name = CountryName(common = "Mexico"),
        capital = listOf("Mexico City"),
        population = 126_014_024,
        area = 1_964_375f,
        flags = CountryFlags(png = ""),
    ),
    Country(
        name = CountryName(common = "Germany"),
        capital = listOf("Berlin"),
        population = 83_517_045,
        area = 137_847f,
        flags = CountryFlags(png = ""),
    ),
)

val sampleCountry = Country(
    name = CountryName(common = "United States"),
    capital = listOf("Washington, D.C."),
    population = 328_239_523,
    area = 9_833_520f,
    flags = CountryFlags(png = ""),
)
