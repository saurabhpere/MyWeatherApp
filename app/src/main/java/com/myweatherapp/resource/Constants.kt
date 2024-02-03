package com.myweatherapp.resource

object Constants {

    init {
        System.loadLibrary("native-lib")
    }

    external fun getBaseUrl(): String

    external fun getImageUrl(): String

    val cityConst = "City:"
    val countryConst = "Country:"
    val sunriseConst = "Sunrise:"
    val sunsetConst = "Sunset:"
    val tempConst = "Temp:"

    val timePattern = "HH:mm:ss"
    val sessionConst = "loggedin"

    //routes
    val homeRoute = "home"
    val loginRoute = "login"
    val registrationRoute = "registration"
}