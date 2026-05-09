package com.example.weatherapp.domain.repository

import com.example.weatherapp.domain.model.Weather

interface WeatherRepository {
    suspend fun getCurrentWeather(
        latitude: Double?,
        longitude: Double?
    ): Weather

}