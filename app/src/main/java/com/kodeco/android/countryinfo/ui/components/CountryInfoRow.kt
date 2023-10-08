package com.kodeco.android.countryinfo.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kodeco.android.countryinfo.data.Country
import com.kodeco.android.countryinfo.networking.sampleCountry

@Composable
fun CountryInfoRow(
    country: Country,
    onClick: () -> Unit,
) {
    Card(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(all = 8.dp),
    ) {
        Column(modifier = Modifier.padding(all = 8.dp)) {
            Text(text = "Name: ${country.commonName}")
            Text(text = "Capital: ${country.capital?.firstOrNull() ?: "N/A"}")
        }
    }
}

@Preview
@Composable
fun CountryInfoRowPreview() {
    CountryInfoRow(
        country = sampleCountry,
        onClick = {},
    )
}
