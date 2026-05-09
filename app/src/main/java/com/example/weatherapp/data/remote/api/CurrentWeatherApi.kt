package com.example.weatherapp.data.remote.api

import com.example.weatherapp.data.remote.dto.weather.WeatherResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrentWeatherApi {
    @GET("v1/forecast")
    suspend fun getWeather(
    @Query("latitude") latitude: Double,
    @Query("longitude") longitude: Double,
    @Query("current") current: String =
        "temperature_2m,relative_humidity_2m,rain,precipitation,wind_speed_10m,wind_direction_10m",
    @Query("forecast_days") forecastDays: Int = 1
    ): WeatherResponseDto
}