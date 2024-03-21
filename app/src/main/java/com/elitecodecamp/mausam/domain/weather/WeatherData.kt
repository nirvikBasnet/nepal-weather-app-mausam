package com.elitecodecamp.mausam.domain.weather

import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter

data class WeatherData(
    val time: LocalDateTime,
    val temperatureCelsius: Double,
    val pressure: Double,
    val windSpeed: Double,
    val humidity: Double,
    val weatherType: WeatherType
)
