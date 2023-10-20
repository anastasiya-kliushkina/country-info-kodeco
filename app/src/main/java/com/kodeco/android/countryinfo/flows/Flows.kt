package com.kodeco.android.countryinfo.flows

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

object Flows {

    private val _tapFlow = MutableStateFlow(0)
    val tapFlow = _tapFlow.asStateFlow()

    private val _backFlow = MutableStateFlow(0)
    val backFlow = _backFlow.asStateFlow()

    private val _counterFlow = MutableStateFlow(0)
    val counterFlow = _counterFlow.asStateFlow()

    init {
        // Launch a coroutine to update counterFlow every second
        GlobalScope.launch {
            delay(1000) // delay on update start
            var counter = 0
            while (true) {
                delay(1000) // Delay for 1 second
                counter++
                _counterFlow.value = counter
            }
        }
    }

    fun tap() {
        val currentValue = _tapFlow.value
        _tapFlow.value = currentValue + 1
    }

    fun tapBack() {
        val currentValue = _backFlow.value
        _backFlow.value = currentValue + 1
    }
}
