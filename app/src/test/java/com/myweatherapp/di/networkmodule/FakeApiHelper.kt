package com.myweatherapp.di.networkmodule

import com.myweatherapp.data.request.CurrentWeatherRequest
import com.myweatherapp.data.response.CurrentLocationResponse
import com.myweatherapp.generateWeatherDto
import com.myweatherapp.resource.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeApiHelper: ApiHelper {
    var weatherdto = generateWeatherDto()
    override fun getCurrentWeather(currentWeatherRequest: CurrentWeatherRequest): Flow<Resource<CurrentLocationResponse>> {
        return flowOf(Resource.Success(weatherdto))
    }
}