package com.example.weatherapp.data.remote.dto.country

import com.google.gson.annotations.SerializedName

data class CountryDto (
    @SerializedName("name")
    val name: CountryName?,
    @SerializedName("latlng")
    val latlng: List<Double>?
)
