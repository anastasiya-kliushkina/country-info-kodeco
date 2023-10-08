package com.kodeco.android.countryinfo.ui.components

import com.kodeco.android.countryinfo.data.Country

sealed class CountryInfoState {
    object Loading : CountryInfoState()
    data class Success(val countries: List<Country>) : CountryInfoState()
    data class Error(val error: Throwable) : CountryInfoState()
}


