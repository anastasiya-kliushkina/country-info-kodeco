package com.kodeco.android.countryinfo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kodeco.android.countryinfo.networking.CountryApiService
import com.kodeco.android.countryinfo.repository.CountryRepositoryImpl
import com.kodeco.android.countryinfo.ui.screens.countyinfo.CountryInfoScreen
import com.kodeco.android.countryinfo.ui.screens.countyinfo.CountryInfoViewModel
import com.kodeco.android.countryinfo.ui.theme.MyApplicationTheme
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


private const val BASE_URL = "https://restcountries.com/v3.1/"
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

        val service: CountryApiService = retrofit.create(CountryApiService::class.java)

        setContent {
            MyApplicationTheme {
                CountryInfoScreen(
                    viewModel = viewModel(
                        factory = CountryInfoViewModel.CountryInfoViewModelFactory(
                            repository = CountryRepositoryImpl(service),
                        ),
                    ),
                )
            }
        }
    }
}
