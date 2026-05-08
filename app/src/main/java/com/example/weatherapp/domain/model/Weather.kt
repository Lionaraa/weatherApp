package com.example.weatherapp.domain.model

data class Weather(
    val temperature: Double,
    val temperatureUnit: String,
    val rain: Double,
    val rainUnit: String,
    val windSpeed: Double,
    val windSpeedUnit: String,
    val windDirection: Int,
    val windDirectionUnit: String,

)