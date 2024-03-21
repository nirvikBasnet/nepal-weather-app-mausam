package com.elitecodecamp.mausam.domain.weather

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import com.elitecodecamp.mausam.R
import com.elitecodecamp.mausam.presentation.ui.screens.today.weatherDataPreview
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter

sealed class WeatherType(
    val weatherDesc: String,
    @DrawableRes val iconRes: Int
) {
    object ClearSky : WeatherType(
        weatherDesc = "Clear sky",
        iconRes = R.drawable.ic_sunny
    )

    object MainlyClear : WeatherType(
        weatherDesc = "Mainly clear",

        iconRes = R.drawable.ic_cloudy
    )
    object PartlyCloudy : WeatherType(
        weatherDesc = "Partly cloudy",
        iconRes = R.drawable.ic_cloudy
    )
    object Overcast : WeatherType(
        weatherDesc = "Overcast",
        iconRes = R.drawable.ic_cloudy
    )
    object Foggy : WeatherType(
        weatherDesc = "Foggy",
        iconRes = R.drawable.ic_very_cloudy
    )
    object DepositingRimeFog : WeatherType(
        weatherDesc = "Depositing rime fog",
        iconRes = R.drawable.ic_very_cloudy
    )
    object LightDrizzle : WeatherType(
        weatherDesc = "Light drizzle",
        iconRes = R.drawable.ic_rainshower
    )
    object ModerateDrizzle : WeatherType(
        weatherDesc = "Moderate drizzle",
        iconRes = R.drawable.ic_rainshower
    )
    object DenseDrizzle : WeatherType(
        weatherDesc = "Dense drizzle",
        iconRes = R.drawable.ic_rainshower
    )
    object LightFreezingDrizzle : WeatherType(
        weatherDesc = "Slight freezing drizzle",
        iconRes = R.drawable.ic_snowyrainy
    )
    object DenseFreezingDrizzle : WeatherType(
        weatherDesc = "Dense freezing drizzle",
        iconRes = R.drawable.ic_snowyrainy
    )
    object SlightRain : WeatherType(
        weatherDesc = "Slight rain",
        iconRes = R.drawable.ic_rainy
    )
    object ModerateRain : WeatherType(
        weatherDesc = "Rainy",
        iconRes = R.drawable.ic_rainy
    )
    object HeavyRain : WeatherType(
        weatherDesc = "Heavy rain",
        iconRes = R.drawable.ic_rainy
    )
    object HeavyFreezingRain: WeatherType(
        weatherDesc = "Heavy freezing rain",
        iconRes = R.drawable.ic_snowyrainy
    )
    object SlightSnowFall: WeatherType(
        weatherDesc = "Slight snow fall",
        iconRes = R.drawable.ic_snowy
    )
    object ModerateSnowFall: WeatherType(
        weatherDesc = "Moderate snow fall",
        iconRes = R.drawable.ic_heavysnow
    )
    object HeavySnowFall: WeatherType(
        weatherDesc = "Heavy snow fall",
        iconRes = R.drawable.ic_heavysnow
    )
    object SnowGrains: WeatherType(
        weatherDesc = "Snow grains",
        iconRes = R.drawable.ic_heavysnow
    )
    object SlightRainShowers: WeatherType(
        weatherDesc = "Slight rain showers",
        iconRes = R.drawable.ic_rainshower
    )
    object ModerateRainShowers: WeatherType(
        weatherDesc = "Moderate rain showers",
        iconRes = R.drawable.ic_rainshower
    )
    object ViolentRainShowers: WeatherType(
        weatherDesc = "Violent rain showers",
        iconRes = R.drawable.ic_rainshower
    )
    object SlightSnowShowers: WeatherType(
        weatherDesc = "Light snow showers",
        iconRes = R.drawable.ic_snowy
    )
    object HeavySnowShowers: WeatherType(
        weatherDesc = "Heavy snow showers",
        iconRes = R.drawable.ic_snowy
    )
    object ModerateThunderstorm: WeatherType(
        weatherDesc = "Moderate thunderstorm",
        iconRes = R.drawable.ic_thunder
    )
    object SlightHailThunderstorm: WeatherType(
        weatherDesc = "Thunderstorm with slight hail",
        iconRes = R.drawable.ic_rainythunder
    )
    object HeavyHailThunderstorm: WeatherType(
        weatherDesc = "Thunderstorm with heavy hail",
        iconRes = R.drawable.ic_rainythunder
    )

    //Night Section

    companion object {
        fun fromWMO(code: Int, time: LocalDateTime): WeatherType {
            if(isNight(time)){
                return when(code) {
                    0 -> ClearSkyNight
                    1 -> MainlyClear
                    2 -> PartlyCloudy
                    3 -> Overcast
                    45 -> Foggy
                    48 -> DepositingRimeFog
                    51 -> LightDrizzle
                    53 -> ModerateDrizzle
                    55 -> DenseDrizzle
                    56 -> LightFreezingDrizzle
                    57 -> DenseFreezingDrizzle
                    61 -> SlightRain
                    63 -> ModerateRain
                    65 -> HeavyRain
                    66 -> LightFreezingDrizzle
                    67 -> HeavyFreezingRain
                    71 -> SlightSnowFall
                    73 -> ModerateSnowFall
                    75 -> HeavySnowFall
                    77 -> SnowGrains
                    80 -> SlightRainShowers
                    81 -> ModerateRainShowers
                    82 -> ViolentRainShowers
                    85 -> SlightSnowShowers
                    86 -> HeavySnowShowers
                    95 -> ModerateThunderstorm
                    96 -> SlightHailThunderstorm
                    99 -> HeavyHailThunderstorm
                    else -> ClearSky
                }
            }else{
                return when(code) {
                    0 -> ClearSky
                    1 -> MainlyClear
                    2 -> PartlyCloudy
                    3 -> Overcast
                    45 -> Foggy
                    48 -> DepositingRimeFog
                    51 -> LightDrizzle
                    53 -> ModerateDrizzle
                    55 -> DenseDrizzle
                    56 -> LightFreezingDrizzle
                    57 -> DenseFreezingDrizzle
                    61 -> SlightRain
                    63 -> ModerateRain
                    65 -> HeavyRain
                    66 -> LightFreezingDrizzle
                    67 -> HeavyFreezingRain
                    71 -> SlightSnowFall
                    73 -> ModerateSnowFall
                    75 -> HeavySnowFall
                    77 -> SnowGrains
                    80 -> SlightRainShowers
                    81 -> ModerateRainShowers
                    82 -> ViolentRainShowers
                    85 -> SlightSnowShowers
                    86 -> HeavySnowShowers
                    95 -> ModerateThunderstorm
                    96 -> SlightHailThunderstorm
                    99 -> HeavyHailThunderstorm
                    else -> ClearSky
                }
            }

        }

        private fun isNight(time: LocalDateTime):Boolean{

                val currentTime = LocalTime.parse(
                    time.format(
                        DateTimeFormatter.ofPattern("HH:mm")
                    ), DateTimeFormatter.ofPattern("HH:mm")
                )

                // Define the threshold for night time
                val nightStartTime = LocalTime.of(18, 0) // 6 PM
                val nightEndTime = LocalTime.of(6, 0)    // 6 AM the next day

                val isNightTime = when {
                    // If current time is after or equal to night start time
                    // OR current time is before night end time
                    // Then it's considered night time
                    currentTime >= nightStartTime || currentTime < nightEndTime -> true
                    else -> false
                }


            return isNightTime
        }
    }
}