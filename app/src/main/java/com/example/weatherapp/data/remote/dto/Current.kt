package com.example.weatherapp.data.remote.dto

import com.google.gson.annotations.SerializedName

data class Current(
    @SerializedName("interval")
    val interval: Int,

    @SerializedName("precipitation")
    val precipitation: Double,

    @SerializedName("rain")
    val rain: Double,

    @SerializedName("relative_humidity_2m")
    val relativeHumidity: Int,

    @SerializedName("temperature_2m")
    val temperature: Double,

    @SerializedName("time")
    val time: String,

    @SerializedName("wind_direction_10m")
    val windDirection: Int,

    @SerializedName("wind_speed_10m")
    val windSpeed: Double
)