package com.example.weatherapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class WeatherResponseDto(
    @SerializedName("current")
    val current: Current,

    @SerializedName("current_units")
    val currentUnits: CurrentUnits
)