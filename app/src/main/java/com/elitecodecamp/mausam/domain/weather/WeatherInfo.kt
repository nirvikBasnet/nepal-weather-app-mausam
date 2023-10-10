package com.elitecodecamp.mausam.domain.weather

import com.elitecodecamp.mausam.data.remote.prediction.PredictionDataDto

data class WeatherInfo (
    val weatherDataPerDay: Map<Int, List<WeatherData>>,
    val currentWeatherData: WeatherData?
        )

data class PredictionInfo (
    val predictionData: PredictionDataDto?
)

