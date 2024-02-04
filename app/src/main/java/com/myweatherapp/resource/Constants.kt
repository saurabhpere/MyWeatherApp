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
    val savedTimePattern = "dd MMM, HH:mm"
    val sessionConst = "loggedin"

    //routes
    val homeRoute = "home"
    val loginRoute = "login"
    val registrationRoute = "registration"

    //error codes
    val LOGIN_SUCCESS = 200
    val EMAIL_NOT_FOUND = 404
    val PASS_MISMATCH = 402

    //msgs
    val passwordError = "Wrong Password"
    val emailNotFoundError = "Email not found in db"
    val invalidEmailError = "Please enter valid email"
    val passwordConfirmError = "Password does not match"
}