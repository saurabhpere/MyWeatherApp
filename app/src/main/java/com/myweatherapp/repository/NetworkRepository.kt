package com.myweatherapp.repository

import com.myweatherapp.di.networkmodule.ApiHelper
import com.myweatherapp.data.request.CurrentWeatherRequest
import com.myweatherapp.data.request.LoginRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NetworkRepository @Inject constructor(val apiHelper: ApiHelper) {

    fun login(loginRequest: LoginRequest) = apiHelper.login(loginRequest).flowOn(Dispatchers.IO)

    fun getCurrentWeather(currentWeatherRequest: CurrentWeatherRequest) = apiHelper.getCurrentWeather(currentWeatherRequest).flowOn(Dispatchers.IO)
}