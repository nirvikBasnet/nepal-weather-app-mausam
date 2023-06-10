package com.elitecodecamp.mausam.data.remote.prediction

import com.squareup.moshi.Json

data class PredictionDto(
    @field:Json(name = "daily")
    val predictionData : PredictionDataDto
)
