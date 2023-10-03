package com.kodeco.android.countryinfo.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.kodeco.android.countryinfo.data.Country
import com.kodeco.android.countryinfo.networking.sampleCountries

@Composable
fun CountryInfoList(countries: List<Country>) {
    var selectedCountry: Country? by remember { mutableStateOf(null) }

    selectedCountry?.let { country ->
        CountryDetailsScreen(country) { selectedCountry = null }
    } ?: run {
        LazyColumn {
            items(countries) { country ->
                CountryInfoRow(country) {
                    selectedCountry = country
                }
            }
        }
    }
}
@Preview
@Composable
fun CountryInfoListPreview() {
    CountryInfoList(sampleCountries)
}
