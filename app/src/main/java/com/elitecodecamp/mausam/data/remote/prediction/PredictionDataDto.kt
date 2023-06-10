package com.elitecodecamp.mausam.data.remote.prediction

import com.squareup.moshi.Json

data class PredictionDataDto(
    @field:Json(name="time")
    val date:List<String>,
    @field:Json(name="temperature_2m_max")
    val temperature:List<Double>
)
