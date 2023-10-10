package com.elitecodecamp.mausam.data.location

import android.Manifest
import android.app.Application
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.elitecodecamp.mausam.domain.location.LocationTracker
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority
import kotlinx.coroutines.suspendCancellableCoroutine
import javax.inject.Inject
import kotlin.coroutines.resume


class DefaultLocationTracker @Inject constructor(
    private val locationClient:FusedLocationProviderClient,
    private val application: Application
) : LocationTracker{
    @RequiresApi(Build.VERSION_CODES.S)
    override suspend fun getCurrentLocation(): Location? {
        val hasAccessFineLocationPermission = ContextCompat.checkSelfPermission(
            application,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
        val hasAccessCoarseLocationPermission = ContextCompat.checkSelfPermission(
            application,
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

        val locationManager = application.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        val isGpsEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER) ||
                locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
        if(!hasAccessCoarseLocationPermission || !hasAccessFineLocationPermission || !isGpsEnabled) {
            return null
        }

        val locationRequest = LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY,100)
            .setWaitForAccurateLocation(false)
            .setMinUpdateIntervalMillis(100)
            .setMaxUpdateDelayMillis(150)
            .build()



        val locationCallback = object : LocationCallback(){
            override fun onLocationResult(locationResult: LocationResult) {

                locationResult.let { result->

                }

            }
        }




        return suspendCancellableCoroutine { cont ->
            LocationServices.getFusedLocationProviderClient(application)
                .requestLocationUpdates(locationRequest,locationCallback,null).addOnSuccessListener {
                    locationClient.lastLocation.apply {
                        if(isComplete) {
                            if(isSuccessful) {
                                cont.resume(result)
                            } else {
                                cont.resume(null)
                            }
                        }
                        addOnSuccessListener {
                            cont.resume(it)
                        }
                        addOnFailureListener {
                            cont.resume(null)
                        }
                        addOnCanceledListener {
                            cont.cancel()
                        }
                    }
                }

        }


    }

    fun requestLocation(){

    }
}