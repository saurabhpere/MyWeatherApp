package com.myweatherapp.repository

import com.myweatherapp.di.networkmodule.ApiHelper
import com.myweatherapp.data.request.CurrentWeatherRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NetworkRepository @Inject constructor(val apiHelper: ApiHelper) {
    fun getCurrentWeather(currentWeatherRequest: CurrentWeatherRequest) = apiHelper.getCurrentWeather(currentWeatherRequest).flowOn(Dispatchers.IO)
}