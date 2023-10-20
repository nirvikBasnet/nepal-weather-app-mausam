package com.elitecodecamp.navigationdrawer.drawer

import android.app.Activity.RESULT_OK
import android.content.Context
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.elitecodecamp.mausam.presentation.sign_in.SignInViewModel
import com.elitecodecamp.mausam.presentation.ui.NavRoutes
import com.elitecodecamp.mausam.presentation.ui.screens.main.PredictionScreen
import com.elitecodecamp.mausam.presentation.ui.screens.main.TodayScreen
import com.elitecodecamp.mausam.presentation.ui.screens.prediction.PredictionViewModel
import com.elitecodecamp.mausam.presentation.ui.screens.today.WeatherViewModel
@OptIn(ExperimentalMaterial3Api::class)
fun NavGraphBuilder.mainGraph(
    drawerState: DrawerState,
    predictionViewModel: PredictionViewModel,
    weatherViewModel: WeatherViewModel,

    ) {

    navigation(startDestination = MainNavOption.TodayScreen.name, route = NavRoutes.MainRoute.name) {
        composable(MainNavOption.TodayScreen.name){
            TodayScreen(weatherViewModel,drawerState)
        }
        composable(MainNavOption.PredictionScreen.name){
            PredictionScreen(predictionViewModel,drawerState)
        }
        composable(MainNavOption.SignInScreen.name){
            val viewModel = viewModel<SignInViewModel>()
            val state by viewModel.state.collectAsState()

            val launcher = rememberLauncherForActivityResult(
                contract = ActivityResultContracts.StartIntentSenderForResult(),
                onResult = {
                    result ->
                    if(result.resultCode == RESULT_OK) {

                    }
                }
            )
        }

    }
}

enum class MainNavOption {
    SignInScreen,
    TodayScreen,
    PredictionScreen,
}