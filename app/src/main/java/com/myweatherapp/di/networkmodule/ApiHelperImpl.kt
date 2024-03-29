package com.myweatherapp.di.networkmodule


import android.os.Build
import androidx.annotation.Keep
import androidx.annotation.RequiresApi
import com.myweatherapp.resource.Resource
import com.myweatherapp.data.request.CurrentWeatherRequest
import com.myweatherapp.data.response.CurrentLocationResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@Keep
class ApiHelperImpl @Inject constructor(val apiService: ApiService): ApiHelper {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun getCurrentWeather(currentWeatherRequest: CurrentWeatherRequest): Flow<Resource<CurrentLocationResponse>> = flow {
        emit(Resource.Loading())
        try {
            val apiResponse = apiService.getCurrentWeatherData(currentWeatherRequest.apiKey,currentWeatherRequest.lat, currentWeatherRequest.lon)
            emit(Resource.Success(apiResponse))
        } catch (ex: Exception){
            ex.printStackTrace()
            emit(Resource.Error(ex.localizedMessage))
        }
    }
}