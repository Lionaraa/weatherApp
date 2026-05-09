package com.example.weatherapp.data.remote.api

import com.example.weatherapp.data.remote.dto.city.CountryDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CountriesApi {
    @GET("v3.1/name/{countryName}")
    suspend fun getCountryByName(
        @Path("countryName") countryName: String?,
        @Query("fields") fields: String = "name, latlng"
    ): List<CountryDto>
}