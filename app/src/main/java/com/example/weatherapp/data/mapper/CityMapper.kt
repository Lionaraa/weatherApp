package com.example.weatherapp.data.mapper

import com.example.weatherapp.data.remote.dto.city.CitySearchResponseDTO
import com.example.weatherapp.domain.model.CityCoordinates

fun CitySearchResponseDTO.toCityCoordinates() : CityCoordinates? {
    val city = results?.firstOrNull()

    val latitude = city?.latitude
    val longitude = city?.longitude

    if (latitude == null || longitude == null) {
        return null
    }

    return CityCoordinates (
        cityName = city.cityName ?: "Unknown city",
        countryName = city.countryName ?: "Unknown country",
        latitude = latitude,
        longitude = longitude
    )
}