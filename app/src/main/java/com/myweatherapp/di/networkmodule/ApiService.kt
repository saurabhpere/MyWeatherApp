package com.myweatherapp.di.networkmodule

import com.myweatherapp.data.request.LoginRequest
import com.myweatherapp.data.response.CurrentLocationResponse
import com.myweatherapp.data.response.LoginResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @GET("weather")
    suspend fun getCurrentWeatherData(
        @Query("appid") key: String,
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
    ): CurrentLocationResponse
}