package com.example.weatherapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CurrentUnits(
    @SerializedName("interval")
    val interval: String,

    @SerializedName("precipitation")
    val precipitation: String,

    @SerializedName("rain")
    val rain: String,

    @SerializedName("relative_humidity_2m")
    val relativeHumidity: String,

    @SerializedName("temperature_2m")
    val temperature: String,

    @SerializedName("time")
    val time: String,

    @SerializedName("wind_direction_10m")
    val windDirection: String,

    @SerializedName("wind_speed_10m")
    val windSpeed: String
)