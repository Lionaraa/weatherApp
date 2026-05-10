package com.example.weatherapp.data.remote.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import kotlin.jvm.java

// object declaration means that therer is created only on instance
// and only create when its used
object RetrofitInstance {

    private const val BASE_URL = "https://api.open-meteo.com/"
    private const val COUNTRIES_BASE_URL = "https://restcountries.com/"
    private const val CITIES_BASE_URL = "https://geocoding-api.open-meteo.com/"
    val currentWeatherApi: CurrentWeatherApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CurrentWeatherApi::class.java)
    }

    val citiesApi: CitiesApi by lazy {
        Retrofit.Builder()
            .baseUrl(CITIES_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CitiesApi::class.java)
    }
}