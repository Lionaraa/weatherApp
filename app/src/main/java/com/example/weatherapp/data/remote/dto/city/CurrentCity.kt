package com.example.weatherapp.data.remote.dto.city

import com.google.gson.annotations.SerializedName

data class CurrentCity(
    @SerializedName("latitude")
    val latitude: Double?,
    @SerializedName("longitude")
    val longitude: Double?,
    @SerializedName("name")
    val cityName: String?,
    @SerializedName("country")
    val countryName: String?
)
