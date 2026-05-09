package com.example.weatherapp.data.remote.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

// object declaration means that therer is created only on instance
// and only create when its used
object RetrofitInstance {

    private const val BASE_URL = "https://api.open-meteo.com/"
    private const val COUNTRIES_BASE_URL = "https://restcountries.com/"
    val currentWeatherApi: CurrentWeatherApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CurrentWeatherApi::class.java)
    }

    val countriesApi: CountriesApi by lazy {
        Retrofit.Builder()
            .baseUrl(COUNTRIES_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CountriesApi::class.java)
    }
}