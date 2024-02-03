package com.myweatherapp.di.networkmodule


import android.os.Build
import androidx.annotation.RequiresApi
import com.myweatherapp.resource.Keys
import com.myweatherapp.resource.Resource
import com.myweatherapp.data.request.CurrentWeatherRequest
import com.myweatherapp.data.request.LoginRequest
import com.myweatherapp.data.response.CurrentLocationResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.nio.charset.Charset
import java.util.Base64
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(val apiService: ApiService): ApiHelper {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun getCurrentWeather(currentWeatherRequest: CurrentWeatherRequest): Flow<Resource<CurrentLocationResponse>> = flow {
        emit(Resource.Loading())
        try {
            val apiResponse = apiService.getCurrentWeatherData(Base64.getDecoder().decode(Keys.apiKey()).toString(
                Charset.defaultCharset()),currentWeatherRequest.lat, currentWeatherRequest.lon)
            emit(Resource.Success(apiResponse))
        } catch (ex: Exception){
            ex.printStackTrace()
            emit(Resource.Error(ex.localizedMessage))
        }
    }
}