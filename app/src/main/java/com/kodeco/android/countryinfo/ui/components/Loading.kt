package com.kodeco.android.countryinfo.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kodeco.android.countryinfo.flows.Flows
import kotlinx.coroutines.flow.StateFlow

@Composable
fun Loading() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        CounterFlowText(counterFlow = Flows.counterFlow)
    }
}

@Composable
fun CounterFlowText(counterFlow: StateFlow<Int>) {

    val counter = counterFlow.collectAsState(initial = 0)

    Column {
        Text(
            text = "Loading... App is running: ${counter.value} seconds",
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview
@Composable
fun LoadingScreenPreview() {
    Loading()
}
