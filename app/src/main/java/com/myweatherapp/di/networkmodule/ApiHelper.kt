package com.myweatherapp.di.networkmodule

import com.myweatherapp.resource.Resource
import com.myweatherapp.data.request.CurrentWeatherRequest
import com.myweatherapp.data.response.CurrentLocationResponse
import kotlinx.coroutines.flow.Flow

interface ApiHelper {

    fun getCurrentWeather(currentWeatherRequest: CurrentWeatherRequest): Flow<Resource<CurrentLocationResponse>>
}