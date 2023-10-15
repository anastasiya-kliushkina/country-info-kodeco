package com.kodeco.android.countryinfo.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CountryErrorScreen(error: Throwable, onRetry: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Log.e("CountryErrorScreen", "Error: ${error.message}")
        Text(text = "Error: ${error.message}")
        Button(onClick = onRetry) {
            Text(text = "Retry")
        }
    }
}

@Preview
@Composable
fun CountryErrorScreenPreview() {
    CountryErrorScreen(
        error = Throwable("Error message"),
        onRetry = {},
    )
}