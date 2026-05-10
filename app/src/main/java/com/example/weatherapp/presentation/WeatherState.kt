package com.example.weatherapp.presentation

import com.example.weatherapp.domain.model.Weather

data class WeatherState (
    val cityInput: String = "",
    val cityName: String? = null,

    val latitude: Double? = null,
    val longitude: Double? = null,

    val weather: Weather? = null,

    val isLoading: Boolean = false,
    val error: String? = null
)
