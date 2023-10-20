package com.elitecodecamp.mausam.presentation.ui.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.elitecodecamp.mausam.ComposeButton
import com.elitecodecamp.mausam.R
import com.elitecodecamp.mausam.presentation.ui.screens.today.WeatherCard
import com.elitecodecamp.mausam.presentation.ui.screens.today.WeatherForecast
import com.elitecodecamp.mausam.presentation.ui.screens.today.WeatherViewModel
import com.elitecodecamp.mausam.presentation.ui.theme.NepalFlagRed
import com.elitecodecamp.navigationdrawer.drawer.AppBar

@Composable
fun TodayScreen(
    weatherViewModel: WeatherViewModel,
    drawerState: DrawerState,
)
{

        Scaffold(topBar = { AppBar(drawerState = drawerState, title = R.string.todays_weather) }) {
        Box(
            modifier = Modifier.fillMaxSize().padding(it),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                WeatherCard(
                    state = weatherViewModel.state,
                    backgroundColor = NepalFlagRed
                )
                Spacer(modifier = Modifier.height(16.dp))
                WeatherForecast(state = weatherViewModel.state)
                Spacer(modifier = Modifier.height(16.dp))

            }
            if(weatherViewModel.state.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            weatherViewModel.state.error?.let { error ->
                Column( modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp).align(Alignment.Center)) {
                    Text(
                        text = error,
                        color = Color.Red,
                        textAlign = TextAlign.Center,
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    ComposeButton(onClick = {

                        weatherViewModel.loadWeatherInfo()

                    })
                }


            }

        }

    }

}
