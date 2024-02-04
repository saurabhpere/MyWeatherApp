package com.myweatherapp.resource.extension

import android.os.Build
import androidx.annotation.RequiresApi
import com.myweatherapp.resource.Constants
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

fun String.isEmailValid(): Boolean {
    val emailRegex = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"
    return emailRegex.toRegex().matches(this)
}

@RequiresApi(Build.VERSION_CODES.O)
fun Long.convertTimeMillisToFormattedString(pattern: String = Constants.timePattern): String{
    val formatted = DateTimeFormatter.ofPattern(pattern)
        .withZone(ZoneId.systemDefault())
        .format(Instant.ofEpochMilli(this * 1000))
    return formatted
}

fun Double.convertTemperatureToCelsius(): String{
    return "" + String.format("%.2f", (this - 273.15))
        .toDouble() + "°C"
}