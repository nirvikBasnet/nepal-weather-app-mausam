package com.elitecodecamp.mausam.presentation.ui.screens.prediction

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.elitecodecamp.mausam.R

@Composable
fun PredictionList(viewModel: PredictionViewModel) {
    val predictionData by viewModel.predictionData.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchWeatherData()
    }

    Column {
        if (predictionData != null) {
            LazyColumn {
                itemsIndexed(predictionData!!.predictionData.date) { index, time ->
                    val temperature = predictionData!!.predictionData.temperature[index]
                    weatherItem(time,temperature)

                }
            }
        } else {
            // Loading state or error state
            Text("Loading data...")
        }
    }


}

@Composable
fun weatherItem(
    date : String,
    temperature : Double,
    ){
    Row (modifier = Modifier.padding(10.dp).fillMaxWidth(),
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically){
        Text(text = date)
        Text(text = temperature.toString())
        Icon(
            imageVector = ImageVector.vectorResource(R.drawable.ic_cloudy),
            contentDescription = "cloudy",
            modifier = Modifier.size(32.dp)
        )
    }
}


@Composable
@Preview(showBackground = true)
fun weatherItemPreview(){
    weatherItem("12/06/2021",42.0)
}