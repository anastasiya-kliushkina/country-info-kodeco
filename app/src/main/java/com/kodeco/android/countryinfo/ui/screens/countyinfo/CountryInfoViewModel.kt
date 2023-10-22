package com.kodeco.android.countryinfo.ui.screens.countyinfo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.kodeco.android.countryinfo.repository.CountryRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class CountryInfoViewModel(
    private val repository: CountryRepository
) : ViewModel() {

    private val _uptimeCounter = MutableStateFlow(0)
    private val _uiState =
        MutableStateFlow<CountryInfoState>(CountryInfoState.Loading(_uptimeCounter.value))

    val uiState: StateFlow<CountryInfoState> = _uiState

    init {
        startUptimeCounter()
        fetchCountries()
    }

    private fun startUptimeCounter() {
        viewModelScope.launch {
            while (true) {
                delay(1_000L)
                _uptimeCounter.value++
                if (_uiState.value is CountryInfoState.Loading) {
                    _uiState.value = CountryInfoState.Loading(_uptimeCounter.value)
                }
            }
        }
    }

    fun fetchCountries() {
        viewModelScope.launch {
            _uiState.value = CountryInfoState.Loading(_uptimeCounter.value)

            delay(1_000L)

            repository
                .fetchCountries()
                .catch {
                    _uiState.value = CountryInfoState.Error(it)
                }
                .collect {
                    _uiState.value = CountryInfoState.Success(it)
                }
        }
    }

    class CountryInfoViewModelFactory(private val repository: CountryRepository) :
        ViewModelProvider.NewInstanceFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            CountryInfoViewModel(repository) as T
    }

}
