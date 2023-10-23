package com.kodeco.android.countryinfo.repository

import com.kodeco.android.countryinfo.data.Country
import kotlinx.coroutines.flow.Flow

interface CountryRepository {
    fun fetchCountries(): Flow<List<Country>>
    fun getCountry(index: Int): Country?

}
