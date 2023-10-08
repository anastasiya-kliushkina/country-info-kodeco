package com.kodeco.android.countryinfo.ui.components

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
import kotlinx.coroutines.delay
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
            is CountryInfoState.Success -> CountryInfoList(curState.countries)
            is CountryInfoState.Error -> CountryErrorScreen(curState.error) {
                state = CountryInfoState.Loading
            }
        }
    }

    if (state == CountryInfoState.Loading) {
        LaunchedEffect(key1 = "fetch-countries") {
            launch {
                delay(1_000)
                state = try {
                    val countriesResponse = service.getAllCountries()

                    if (countriesResponse.isSuccessful) {
                        CountryInfoState.Success(countriesResponse.body()!!)
                    } else {
                        CountryInfoState.Error(Throwable("Request failed: ${countriesResponse.message()}"))
                    }
                } catch (exception: Exception) {
                    CountryInfoState.Error(exception)
                }
            }
        }
    }
}

@Preview
@Composable
fun CountryInfoScreenPreview() {
    CountryInfoScreen(object : CountryApiService {
        override suspend fun getAllCountries(): Response<List<Country>> =
            Response.success(sampleCountries)
    })
}
