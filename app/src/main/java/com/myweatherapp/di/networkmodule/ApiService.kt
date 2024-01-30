package com.myweatherapp.di.networkmodule

import com.myweatherapp.resource.request.LoginRequest
import com.myweatherapp.resource.response.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {


    @POST("auth")
    suspend fun login(@Body loginRequest: LoginRequest): LoginResponse
}