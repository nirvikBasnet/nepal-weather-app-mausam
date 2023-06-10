package com.elitecodecamp.mausam.di

import android.app.Application
import com.elitecodecamp.mausam.data.remote.WeatherApi
import com.elitecodecamp.mausam.data.repository.PredictionRepositoryImpl
import com.elitecodecamp.mausam.domain.repository.PredictionRepository
import com.elitecodecamp.mausam.domain.util.LoggingInterceptor
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideOkHttpClient(loggingInterceptor: LoggingInterceptor):OkHttpClient{
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }


    @Provides
    @Singleton
    fun provideWeatherApi(okHttpClient: OkHttpClient): WeatherApi {
        return Retrofit.Builder()
            .baseUrl("https://api.open-meteo.com/")
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }

    @Provides
    fun providePredictionRepository(apiServices: WeatherApi):PredictionRepository{
        return PredictionRepositoryImpl(apiServices)
    }

    @Provides
    @Singleton
    fun provideFusedLocationProviderClient(app: Application): FusedLocationProviderClient {
        return LocationServices.getFusedLocationProviderClient(app)
    }

    @Provides
    fun provideLoggingInterceptor():LoggingInterceptor{
        return LoggingInterceptor()
    }
}