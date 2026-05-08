package com.example.weatherapp.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weatherapp.data.remote.api.RetrofitInstance
import com.example.weatherapp.data.repository.WeatherRepositoryImpl
import com.example.weatherapp.domain.model.Weather

@Composable
fun WeatherScreen() {
    val repository = remember {
        WeatherRepositoryImpl(
            api = RetrofitInstance.currentWeatherApi
        )
    }

    var weather by remember { mutableStateOf<Weather?>(null) }

    LaunchedEffect(Unit) {
        weather = repository.getCurrentWeather(
            latitude = 52.52,
            longitude = 13.41
        )
    }

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(text = "Weather App")

        Spacer(modifier = Modifier.height(16.dp))

        if (weather == null) {
            Text(text = "Loading...")
        } else {
            Text(text = "Temperature: ${weather!!.temperature} ${weather!!.temperatureUnit}")
            Text(text = "Rain: ${weather!!.rain} ${weather!!.rainUnit}")
            Text(text = "Wind speed: ${weather!!.windSpeed} ${weather!!.windSpeedUnit}")
            Text(text = "Wind direction: ${weather!!.windDirection} ${weather!!.windDirectionUnit}")
        }
    }
}