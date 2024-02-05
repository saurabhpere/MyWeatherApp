package com.myweatherapp.data.response

import androidx.annotation.Keep

@Keep
data class CurrentLocationResponse (
    val coord: Coord?= null,
    val weather: List<Weather>?= null,
    val base: String?= null,
    val timezone: Int?= null,
    val id: Int?= null,
    val name: String?= null,
    val cod: Int?= null,
    val sys: Sys?= null,
    val main: Main?= null,
    var timeSaved: String?= null
)

@Keep
data class Coord (
    val lat: Double,
    val lon: Double
)

@Keep
data class Weather(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String,
)

@Keep
data class Sys(
    val type: Int,
    val id: Int,
    val country: String,
    val sunrise: Long,
    val sunset: Long,
    )

@Keep
data class Main(
    val temp: Double
)