package com.kodeco.android.countryinfo.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Loading(uptime: Int) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        Text(
            text = "Loading... App is running: $uptime seconds",
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview
@Composable
fun LoadingScreenPreview() {
    Loading(uptime = 1)
}
