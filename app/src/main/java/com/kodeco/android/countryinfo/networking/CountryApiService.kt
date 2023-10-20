package com.kodeco.android.countryinfo.networking

import com.kodeco.android.countryinfo.data.Country
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET

interface CountryApiService {
    @GET("all")
    suspend fun getAllCountries(): Response<List<Country>>
}
