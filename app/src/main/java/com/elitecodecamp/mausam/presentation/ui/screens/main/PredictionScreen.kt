package com.elitecodecamp.mausam.presentation.ui.screens.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.elitecodecamp.mausam.R
import com.elitecodecamp.mausam.presentation.ui.screens.prediction.PredictionList
import com.elitecodecamp.mausam.presentation.ui.screens.prediction.PredictionViewModel
import com.elitecodecamp.navigationdrawer.drawer.AppBar

@Composable
fun PredictionScreen(
    predictionViewModel: PredictionViewModel,
    drawerState: DrawerState
    ){
    Scaffold(
        topBar = { AppBar(drawerState = drawerState, title = R.string.weekly_prediction)}
    ) {
        Column(
            modifier = Modifier.padding(it),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PredictionList(predictionViewModel)
        }
    }

}