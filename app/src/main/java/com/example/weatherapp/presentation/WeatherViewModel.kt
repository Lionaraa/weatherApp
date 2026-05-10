package com.example.weatherapp.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.mapper.toCityCoordinates
import com.example.weatherapp.data.remote.api.RetrofitInstance
import com.example.weatherapp.data.repository.WeatherRepositoryImpl
import com.example.weatherapp.domain.model.CityCoordinates
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {
    private val weatherRepository = WeatherRepositoryImpl(
        api = RetrofitInstance.currentWeatherApi
    )
    private val _state = mutableStateOf(WeatherState())
    val state: State<WeatherState> = _state

    fun onCityInputChange(newValue: String) {
        _state.value = _state.value.copy(
            cityInput = newValue
        )
    }

    fun searchWeatherByCountry() {
        val cityName = _state.value.cityInput.trim()

        if (cityName.isBlank()) {
            _state.value = _state.value.copy(
                error = "Write country name first"
            )
            return
        }

        getWeather(cityName)
    }


    private fun getWeather(cityName: String) {
        viewModelScope.launch {
            _state.value = WeatherState(
                cityInput = cityName,
                isLoading = true
            )

            try {
                val city = RetrofitInstance.citiesApi.getCity(
                    cityName = cityName
                )

                val cityCoordinates = city.toCityCoordinates()

                if (cityCoordinates == null) {
                    _state.value = WeatherState(
                        cityInput = cityName,
                        error = "Country not found"
                    )
                    return@launch
                }

                val weather = weatherRepository.getCurrentWeather(
                    latitude = cityCoordinates.latitude,
                    longitude = cityCoordinates.longitude
                )

                _state.value = WeatherState(
                    cityInput = cityName,
                    cityName = cityCoordinates.cityName,
                    latitude = cityCoordinates.latitude,
                    longitude = cityCoordinates.longitude,
                    weather = weather
                )

            } catch (e: Exception) {
                _state.value = WeatherState(
                    cityInput = cityName,
                    error = e.message ?: "Unexpected error occurred"
                )
            }
        }
    }
}