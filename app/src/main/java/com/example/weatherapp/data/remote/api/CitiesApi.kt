package com.example.weatherapp.data.remote.api

import com.example.weatherapp.data.remote.dto.city.CitySearchResponseDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface CitiesApi {
    @GET("v1/search")
    suspend fun getCity (
        @Query("name") cityName: String,
        @Query("count") count: Int = 1,
        @Query("language") language: String = "en",
    ): CitySearchResponseDTO
}