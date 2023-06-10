package com.elitecodecamp.mausam.data.repository

import com.elitecodecamp.mausam.data.mapper.toWeatherInfo
import com.elitecodecamp.mausam.data.remote.WeatherApi
import com.elitecodecamp.mausam.domain.repository.WeatherRepository
import com.elitecodecamp.mausam.domain.util.Resource
import com.elitecodecamp.mausam.domain.weather.WeatherInfo
import java.lang.Exception
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) :WeatherRepository{
    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(
                    lat = lat,
                    long = long
                ).toWeatherInfo()
            )

        }catch (e: Exception){
            e.printStackTrace()
            Resource.Error(e.message?:"An unknown error occured.")
        }
    }
}