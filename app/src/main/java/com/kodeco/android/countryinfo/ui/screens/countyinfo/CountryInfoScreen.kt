package com.kodeco.android.countryinfo.ui.screens.countyinfo

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.kodeco.android.countryinfo.data.Country
import com.kodeco.android.countryinfo.networking.CountryApiService
import com.kodeco.android.countryinfo.networking.sampleCountries
import com.kodeco.android.countryinfo.ui.components.CountryInfoList
import com.kodeco.android.countryinfo.ui.components.CountryError
import com.kodeco.android.countryinfo.ui.components.Loading
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import retrofit2.Response

@Composable
fun CountryInfoScreen(
    service: CountryApiService,
) {
    var state: CountryInfoState by remember { mutableStateOf(CountryInfoState.Loading) }

    Surface {
        when (val curState = state) {
            is CountryInfoState.Loading -> Loading()
            is CountryInfoState.Success -> CountryInfoList(curState.countries){
                state = CountryInfoState.Loading
            }
            is CountryInfoState.Error -> CountryError(curState.error) {
                state = CountryInfoState.Loading
            }
        }
    }

    if (state == CountryInfoState.Loading) {
        LaunchedEffect(key1 = "fetch-countries") {
            launch {
                delay(1_000)

                getCountryInfoFlow(service)
                    .catch { cause -> state = CountryInfoState.Error(cause) }
                    .collect { value -> state = value }
            }
        }
    }
}

private fun getCountryInfoFlow(service: CountryApiService): Flow<CountryInfoState> {

    val latestCountries: Flow<CountryInfoState> = flow {
        val countriesResponse = service.getAllCountries()

        if (countriesResponse.isSuccessful) {
            emit(CountryInfoState.Success(countriesResponse.body()!!))
        } else {
            emit(
                CountryInfoState.Error(
                    Throwable("Request failed: ${countriesResponse.message()}")
                )
            )
        }
    }
    return latestCountries
}

@Preview
@Composable
fun CountryInfoScreenPreview() {
    CountryInfoScreen(object : CountryApiService {
        override suspend fun getAllCountries(): Response<List<Country>> =
            Response.success(sampleCountries)
    })
}
