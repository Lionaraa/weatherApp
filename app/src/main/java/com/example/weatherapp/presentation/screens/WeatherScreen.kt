package com.example.weatherapp.presentation.screens

import WeatherViewModel
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.weatherapp.data.remote.api.RetrofitInstance
import com.example.weatherapp.data.repository.WeatherRepositoryImpl
import com.example.weatherapp.domain.model.Weather

@Composable
fun WeatherScreen(
    viewModel: WeatherViewModel = viewModel()
) {
    val state = viewModel.state.value

    Column {
        OutlinedTextField(
            value = state.countryInput,
            onValueChange = { viewModel.onCountryInputChange(it) },
            label = { Text("Country name") }
        )

        Button(
            onClick = {
                viewModel.searchWeatherByCountry()
            }
        ) {
            Text("Search")
        }

        if (state.isLoading) {
            Text("Loading...")
        }

        if (state.error != null) {
            Text("Error: ${state.error}")
        }

        if (state.countryName != null) {
            Text("Country: ${state.countryName}")
        }

        if (state.latitude != null && state.longitude != null) {
            Text("Latitude: ${state.latitude}")
            Text("Longitude: ${state.longitude}")
        }

        if (state.weather != null) {
            Text("Temperature: ${state.weather.temperature} ${state.weather.temperatureUnit}")
            Text("Rain: ${state.weather.rain} ${state.weather.rainUnit}")
            Text("Wind speed: ${state.weather.windSpeed} ${state.weather.windSpeedUnit}")
            Text("Wind direction: ${state.weather.windDirection} ${state.weather.windDirectionUnit}")
        }
    }
}