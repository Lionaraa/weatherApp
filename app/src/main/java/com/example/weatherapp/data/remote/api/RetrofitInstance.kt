package com.example.weatherapp.data.remote.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
// object declaration means that therer is created only on instance
// and only create when its used
object RetrofitInstance {

    private const val BASE_URL = "https://api.open-meteo.com/"

    val currentWeatherApi: CurrentWeatherApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CurrentWeatherApi::class.java)
    }
}