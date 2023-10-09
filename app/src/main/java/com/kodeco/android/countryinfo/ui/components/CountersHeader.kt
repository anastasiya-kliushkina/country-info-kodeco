package com.kodeco.android.countryinfo.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CountersHeader() {
    val tapCountState = Flows.tapFlow.collectAsState(initial = 0)
    val backCountState = Flows.backFlow.collectAsState(initial = 0)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Taps: ${tapCountState.value}",
            modifier = Modifier.weight(1f)
        )

        Text(
            text = "Backs: ${backCountState.value}",
            modifier = Modifier.weight(1f)
        )
        // Refresh button
        Button(
            onClick = {
            },
            modifier = Modifier.size(48.dp)
        ) {
            Icon(imageVector = Icons.Default.Refresh, contentDescription = "Refresh")
        }
    }
}

@Preview
@Composable
fun CountersHeaderPreview() {
    CountersHeader()
}
