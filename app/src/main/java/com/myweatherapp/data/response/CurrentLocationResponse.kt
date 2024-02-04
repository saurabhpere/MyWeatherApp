package com.myweatherapp.data.response

data class CurrentLocationResponse (
    val coord: Coord?= null,
    val weather: List<Weather>?= null,
    val base: String?= null,
    val timezone: Int?= null,
    val id: Int?= null,
    val name: String?= null,
    val cod: Int?= null,
    val sys: Sys?= null,
    val main: Main?= null
)
data class Coord (
    val lat: Double,
    val lon: Double
)

data class Weather(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String,
)

data class Sys(
    val type: Int,
    val id: Int,
    val country: String,
    val sunrise: Long,
    val sunset: Long,
    )

data class Main(
    val temp: Double
)