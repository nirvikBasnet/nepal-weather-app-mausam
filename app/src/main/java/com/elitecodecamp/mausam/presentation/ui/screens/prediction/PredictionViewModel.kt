package com.elitecodecamp.mausam.presentation.ui.screens.prediction

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elitecodecamp.mausam.data.remote.prediction.PredictionDto
import com.elitecodecamp.mausam.domain.location.LocationTracker
import com.elitecodecamp.mausam.domain.repository.PredictionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class PredictionViewModel @Inject constructor(
    val repository : PredictionRepository,
    private val locationTracker: LocationTracker
) : ViewModel() {

    private val _predictionData = MutableStateFlow<PredictionDto?>(null)
    var predictionData: StateFlow<PredictionDto?> = _predictionData


    fun fetchWeatherData(){
        viewModelScope.launch {
            locationTracker.getCurrentLocation()?.let { location ->
               try {
                   val response = repository.getPredictionData(location.latitude,location.longitude,"Kathmandu")
                   _predictionData.value=response
               }catch (e:Exception){


               }
            }
                ?: kotlin.run {

                }
        }
    }
}