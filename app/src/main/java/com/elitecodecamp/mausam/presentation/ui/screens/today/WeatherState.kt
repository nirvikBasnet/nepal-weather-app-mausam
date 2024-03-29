package com.elitecodecamp.mausam.presentation.ui.screens.today

import com.elitecodecamp.mausam.domain.weather.WeatherInfo

data class WeatherState(
    val weatherInfo: WeatherInfo? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
