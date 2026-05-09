package com.example.weatherapp.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.mapper.toCountryCoordinates
import com.example.weatherapp.data.remote.api.RetrofitInstance
import com.example.weatherapp.data.repository.WeatherRepositoryImpl
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {
    private val weatherRepository = WeatherRepositoryImpl(
        api = RetrofitInstance.currentWeatherApi
    )
    private val _state = mutableStateOf(WeatherState())
    val state: State<WeatherState> = _state

    fun onCountryInputChange(newValue: String) {
        _state.value = _state.value.copy(
            countryInput = newValue
        )
    }

    fun searchWeatherByCountry() {
        val countryName = _state.value.countryInput.trim()

        if (countryName.isBlank()) {
            _state.value = _state.value.copy(
                error = "Write country name first"
            )
            return
        }

        getWeather(countryName)
    }


    private fun getWeather(countryName: String) {
        viewModelScope.launch {
            _state.value = WeatherState(
                countryInput = countryName,
                isLoading = true
            )

            try {
                val countries = RetrofitInstance.countriesApi.getCountryByName(
                    countryName = countryName
                )

                val countryCoordinates = countries
                    .firstOrNull()
                    ?.toCountryCoordinates()

                if (countryCoordinates == null) {
                    _state.value = WeatherState(
                        countryInput = countryName,
                        error = "Country not found"
                    )
                    return@launch
                }

                val weather = weatherRepository.getCurrentWeather(
                    latitude = countryCoordinates.latitude,
                    longitude = countryCoordinates.longitude
                )

                _state.value = WeatherState(
                    countryInput = countryName,
                    countryName = countryCoordinates.countryName,
                    latitude = countryCoordinates.latitude,
                    longitude = countryCoordinates.longitude,
                    weather = weather
                )

            } catch (e: Exception) {
                _state.value = WeatherState(
                    countryInput = countryName,
                    error = e.message ?: "Unexpected error occurred"
                )
            }
        }
    }
}