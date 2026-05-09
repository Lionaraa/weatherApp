package com.example.weatherapp.data.remote.dto.city

import com.google.gson.annotations.SerializedName

class CountryName (
    @SerializedName("common")
    val common: String?
)