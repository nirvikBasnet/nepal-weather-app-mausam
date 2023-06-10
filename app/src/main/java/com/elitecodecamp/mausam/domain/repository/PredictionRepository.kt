package com.elitecodecamp.mausam.domain.repository

import com.elitecodecamp.mausam.data.remote.prediction.PredictionDataDto
import com.elitecodecamp.mausam.data.remote.prediction.PredictionDto
import com.elitecodecamp.mausam.domain.util.Resource

interface PredictionRepository {
    suspend fun getPredictionData(lat:Double,long:Double): PredictionDto
}