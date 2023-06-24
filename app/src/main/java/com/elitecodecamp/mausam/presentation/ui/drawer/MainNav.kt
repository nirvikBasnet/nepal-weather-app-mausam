package com.elitecodecamp.navigationdrawer.drawer

import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.elitecodecamp.mausam.presentation.ui.NavRoutes
import com.elitecodecamp.mausam.presentation.ui.screens.main.PredictionScreen
import com.elitecodecamp.mausam.presentation.ui.screens.main.TodayScreen
import com.elitecodecamp.mausam.presentation.ui.screens.prediction.PredictionViewModel
import com.elitecodecamp.mausam.presentation.ui.screens.today.WeatherViewModel

@OptIn(ExperimentalMaterial3Api::class)
fun NavGraphBuilder.mainGraph(
    drawerState: DrawerState,
    predictionViewModel: PredictionViewModel,
    weatherViewModel: WeatherViewModel

    ) {
    navigation(startDestination = MainNavOption.TodayScreen.name, route = NavRoutes.MainRoute.name) {
        composable(MainNavOption.TodayScreen.name){
            TodayScreen(weatherViewModel,drawerState)
        }
        composable(MainNavOption.PredictionScreen.name){
            PredictionScreen(predictionViewModel,drawerState)
        }

    }
}

enum class MainNavOption {
    TodayScreen,
    PredictionScreen,
}