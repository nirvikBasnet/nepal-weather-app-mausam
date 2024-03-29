package com.elitecodecamp.mausam.presentation.ui.screens.prediction

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.elitecodecamp.mausam.R
import com.elitecodecamp.mausam.presentation.ui.theme.NepalFlagBlue

@Composable
fun PredictionList(viewModel: PredictionViewModel) {
    val predictionData by viewModel.predictionData.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchWeatherData()
    }

    Row {
        if (predictionData != null) {
            LazyColumn {
                itemsIndexed(predictionData!!.predictionData.date) { index, time ->
                    val temperature = predictionData!!.predictionData.temperature[index]
                    weatherItem(time,temperature)

                }
            }
        } else {
//            if(viewModel.state.isLoading) {
//                CircularProgressIndicator(
//                    modifier = Modifier.align(Alignment.CenterVertically)
//                )
//            }

        }
    }


}

@Composable
fun weatherItem(
    date : String,
    temperature : Double,
    ){

        Card (modifier = Modifier.padding(5.dp).fillMaxWidth(),
            elevation = CardDefaults.cardElevation(2.dp)) {
            Row (modifier = Modifier.padding(10.dp).fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically) {
                Text(text = date)
                Text(text = "${temperature}°C", fontWeight = FontWeight.Bold)
            }
        }


}


@Composable
@Preview(showBackground = true)
fun weatherItemPreview(){
    weatherItem("12/06/2021",42.0)
}
