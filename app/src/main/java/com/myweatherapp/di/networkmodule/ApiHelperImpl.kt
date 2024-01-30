package com.myweatherapp.di.networkmodule


import com.myweatherapp.resource.Resource
import com.myweatherapp.resource.request.LoginRequest
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(val apiService: ApiService): ApiHelper {

    override fun login(loginRequest: LoginRequest) = flow {
        emit(Resource.Loading())
        try {
            val apiResponse = apiService.login(loginRequest)
            emit(Resource.Success(apiResponse))
        } catch (ex: Exception){
            ex.printStackTrace()
            emit(Resource.Error(ex.localizedMessage))
        }
    }
}