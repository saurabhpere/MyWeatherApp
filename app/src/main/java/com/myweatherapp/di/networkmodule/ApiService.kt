package com.myweatherapp.di.networkmodule

import com.myweatherapp.data.response.CurrentLocationResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("weather")
    suspend fun getCurrentWeatherData(
        @Query("appid") key: String,
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
    ): CurrentLocationResponse
}