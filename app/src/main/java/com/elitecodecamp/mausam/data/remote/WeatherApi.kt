package com.elitecodecamp.mausam.data.remote

import com.elitecodecamp.mausam.data.remote.prediction.PredictionDataDto
import com.elitecodecamp.mausam.data.remote.prediction.PredictionDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("v1/forecast?hourly=temperature_2m,weathercode,relativehumidity_2m,windspeed_10m,pressure_msl")
    suspend fun getWeatherData(
        @Query("latitude") lat: Double,
        @Query ("longitude") long : Double
    ) : WeatherDto

    @GET("v1/forecast?daily=temperature_2m_max")
    suspend fun getWeeklyPredictionData(
        @Query("latitude") lat: Double,
        @Query ("longitude") long : Double,
    @Query("timezone") timezone : String
    ) : PredictionDto
}
