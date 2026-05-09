package com.example.weatherapp.data.mapper

import com.example.weatherapp.data.remote.dto.city.CountryDto
import com.example.weatherapp.domain.model.CountryCoordinates

fun CountryDto.toCountryCoordinates(): CountryCoordinates? {
    val latitude = latlng?.getOrNull(0)
    val longitude = latlng?.getOrNull(1)

    if (latitude == null || longitude == null) {
        return null
    }

    return CountryCoordinates(
        countryName = name?.common ?: "Unknown country",
        latitude = latitude,
        longitude = longitude
    )
}