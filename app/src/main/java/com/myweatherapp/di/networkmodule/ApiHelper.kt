package com.myweatherapp.di.networkmodule

import com.myweatherapp.resource.Resource
import com.myweatherapp.data.request.CurrentWeatherRequest
import com.myweatherapp.data.request.LoginRequest
import com.myweatherapp.data.response.CurrentLocationResponse
import com.myweatherapp.data.response.LoginResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface ApiHelper {

    fun getCurrentWeather(currentWeatherRequest: CurrentWeatherRequest): Flow<Resource<CurrentLocationResponse>>
}