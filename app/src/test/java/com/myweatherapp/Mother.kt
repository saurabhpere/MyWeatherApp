package com.myweatherapp

import com.myweatherapp.data.db.entities.Users
import com.myweatherapp.data.db.entities.WeatherHistory
import com.myweatherapp.data.request.CurrentWeatherRequest
import com.myweatherapp.data.response.Coord
import com.myweatherapp.data.response.CurrentLocationResponse
import com.myweatherapp.data.response.Main
import com.myweatherapp.data.response.Sys
import com.myweatherapp.data.response.Weather
import java.util.concurrent.ThreadLocalRandom

private val charPool: List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')
val random
    get() = ThreadLocalRandom.current()

fun generateWeatherDtoList(
    size: Int = randomPositiveInt(10),
    creationFunction: (Int) -> CurrentLocationResponse = { generateWeatherDto() }
): List<CurrentLocationResponse> = (0..size).map { creationFunction(it) }

//val coord: Coord?= null,
//    val weather: List<Weather>?= null,
//    val base: String?= null,
//    val timezone: Int?= null,
//    val id: Int?= null,
//    val name: String?= null,
//    val cod: Int?= null,
//    val sys: Sys?= null,
//    val main: Main?= null
fun generateWeatherDto(): CurrentLocationResponse =
    CurrentLocationResponse(
        name = randomString(),
        coord = Coord(randomDouble(), randomDouble()),
        weather = listOf(Weather(randomInt(), randomString(), randomString(), randomString())),
        base = randomString(),
        timezone = randomInt(),
        id = randomInt(),
        cod = randomInt(),
        sys = Sys(randomInt(), randomInt(), randomString(), randomLong(), randomLong()),
        main = Main(randomDouble())
    )

fun generateCurrentWeatherRequest(): CurrentWeatherRequest {
    return CurrentWeatherRequest(
        lat = randomDouble(),
        lon = randomDouble(),
        apiKey = randomString()
    )
}

fun generateUsers(): Users {
    return Users(
        userPass = randomString(),
        userName = randomString()
    )
}

fun generateWeatherHistory(): WeatherHistory{
    return WeatherHistory(weatherDetails = randomString())
}

fun randomPositiveInt(maxInt: Int = Int.MAX_VALUE - 1): Int = random.nextInt(maxInt + 1).takeIf { it > 0 } ?: randomPositiveInt(maxInt)
fun randomInt() = random.nextInt()
fun randomDouble() = random.nextDouble()
fun randomLong() = random.nextLong()
fun randomString(size: Int = 20): String = (0..size)
    .map { charPool[random.nextInt(0, charPool.size)] }
    .joinToString("")