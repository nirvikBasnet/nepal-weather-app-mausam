package com.elitecodecamp.mausam.presentation.ui.screens.prediction

import com.elitecodecamp.mausam.data.remote.prediction.PredictionDataDto
import com.elitecodecamp.mausam.data.remote.prediction.PredictionDto
import com.elitecodecamp.mausam.domain.weather.WeatherInfo

data class PredictionState(
    val predictionInfo: PredictionDto? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
