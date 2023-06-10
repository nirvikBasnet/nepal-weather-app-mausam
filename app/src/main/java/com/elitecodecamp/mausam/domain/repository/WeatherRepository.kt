package com.elitecodecamp.mausam.domain.repository

import com.elitecodecamp.mausam.domain.util.Resource
import com.elitecodecamp.mausam.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat:Double,long:Double):Resource<WeatherInfo>
}