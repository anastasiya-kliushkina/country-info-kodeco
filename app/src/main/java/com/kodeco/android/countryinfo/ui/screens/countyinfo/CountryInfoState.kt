package com.kodeco.android.countryinfo.ui.screens.countyinfo

import com.kodeco.android.countryinfo.data.Country

sealed class CountryInfoState {
    data class Loading(val uptime: Int) : CountryInfoState() // object
    data class Success(val countries: List<Country>) : CountryInfoState()
    data class Error(val error: Throwable) : CountryInfoState()
}


