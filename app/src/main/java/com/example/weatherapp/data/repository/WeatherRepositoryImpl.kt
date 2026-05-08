package com.example.weatherapp.data.repository

import com.example.weatherapp.data.mapper.toWeather
import com.example.weatherapp.data.remote.api.CurrentWeatherApi
import com.example.weatherapp.domain.model.Weather
import com.example.weatherapp.domain.repository.WeatherRepository

class WeatherRepositoryImpl(
    private val api: CurrentWeatherApi
) : WeatherRepository {

    override suspend fun getCurrentWeather(
        latitude: Double,
        longitude: Double
    ): Weather {
        val response = api.getWeather(
            latitude = latitude,
            longitude = longitude
        )

        return response.toWeather()
    }
}