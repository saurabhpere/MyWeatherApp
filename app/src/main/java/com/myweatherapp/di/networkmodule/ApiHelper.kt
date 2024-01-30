package com.myweatherapp.di.networkmodule

import com.myweatherapp.resource.Resource
import com.myweatherapp.resource.request.LoginRequest
import com.myweatherapp.resource.response.LoginResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface ApiHelper {

    fun login(loginRequest: LoginRequest) : Flow<Resource<LoginResponse>>
}