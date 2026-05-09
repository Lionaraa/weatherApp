package com.example.weatherapp.data.mapper

import com.example.weatherapp.data.remote.dto.weather.WeatherResponseDto
import com.example.weatherapp.domain.model.Weather

fun WeatherResponseDto.toWeather(): Weather {
    return Weather(
        temperature = current.temperature,
        temperatureUnit = currentUnits.temperature,

        rain = current.rain,
        rainUnit = currentUnits.rain,

        windSpeed = current.windSpeed,
        windSpeedUnit = currentUnits.windSpeed,

        windDirection = current.windDirection,
        windDirectionUnit = currentUnits.windDirection
    )
}

