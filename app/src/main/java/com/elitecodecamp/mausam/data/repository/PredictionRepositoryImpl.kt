package com.elitecodecamp.mausam.data.repository

import com.elitecodecamp.mausam.data.mapper.toWeatherInfo
import com.elitecodecamp.mausam.data.remote.WeatherApi
import com.elitecodecamp.mausam.data.remote.prediction.PredictionDataDto
import com.elitecodecamp.mausam.data.remote.prediction.PredictionDto
import com.elitecodecamp.mausam.domain.repository.PredictionRepository
import com.elitecodecamp.mausam.domain.util.Resource
import java.lang.Exception
import javax.inject.Inject

class PredictionRepositoryImpl @Inject constructor(
    private val api: WeatherApi
): PredictionRepository {
    override suspend fun getPredictionData(lat: Double, long: Double): PredictionDto {

       return api.getWeeklyPredictionData(
            lat = lat,
            long = long
        )
    }
}





