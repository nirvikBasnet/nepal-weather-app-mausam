package com.elitecodecamp.mausam

import android.Manifest
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.elitecodecamp.mausam.presentation.ui.MainCompose
import com.elitecodecamp.mausam.presentation.ui.screens.main.PredictionScreen
import com.elitecodecamp.mausam.presentation.ui.screens.main.TodayScreen
import com.elitecodecamp.mausam.presentation.ui.screens.prediction.PredictionList
import com.elitecodecamp.mausam.presentation.ui.screens.prediction.PredictionViewModel
import com.elitecodecamp.mausam.presentation.ui.screens.today.WeatherCard
import com.elitecodecamp.mausam.presentation.ui.screens.today.WeatherForecast
import com.elitecodecamp.mausam.presentation.ui.screens.today.WeatherViewModel
import com.elitecodecamp.mausam.presentation.ui.theme.MausamTheme
import com.elitecodecamp.mausam.presentation.ui.theme.NepalFlagRed
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val weatherViewModel: WeatherViewModel by viewModels()
    private val predictionViewModel: PredictionViewModel by viewModels()
    private lateinit var permissionLauncher: ActivityResultLauncher<Array<String>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        permissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) {
            weatherViewModel.loadWeatherInfo()
            predictionViewModel.fetchWeatherData()
        }
        permissionLauncher.launch(arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
        ))


        setContent {
            MausamTheme {
              MainCompose(predictionViewModel,weatherViewModel, lifecycleCoroutineScope = lifecycleScope)
            }
        }

    }



}

@Composable
fun ComposeButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.padding(16.dp).fillMaxWidth()
    ) {
        Text(text = "Refresh")
    }
}




