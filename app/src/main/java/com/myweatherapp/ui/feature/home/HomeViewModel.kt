package com.myweatherapp.ui.feature.home

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.myweatherapp.data.db.entities.WeatherHistory
import com.myweatherapp.repository.DatabaseRepository
import com.myweatherapp.repository.NetworkRepository
import com.myweatherapp.resource.LocationLiveData
import com.myweatherapp.resource.Status
import com.myweatherapp.data.request.CurrentWeatherRequest
import com.myweatherapp.data.response.CurrentLocationResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: NetworkRepository, private val dbRepository: DatabaseRepository,
                                        @ApplicationContext appContext: Context
): ViewModel() {

    private val locationData = LocationLiveData(context = appContext)

    fun getLocationData() = locationData

    var weatherResponseState = mutableStateOf(CurrentLocationResponse(null, null, null, null, null, null, null,null, null))

    var loading = mutableStateOf(false)

    var savedWeatherHistoryList = mutableStateListOf<CurrentLocationResponse>()

    var dataSaved = false

    @RequiresApi(Build.VERSION_CODES.O)
    fun getCurrentWeatherData(currentWeatherRequest: CurrentWeatherRequest){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                repository.getCurrentWeather(currentWeatherRequest).collectLatest {
                    when(it.status){
                        Status.LOADING-> loading.value = true
                        Status.SUCCESS-> {
                            loading.value = false
                            weatherResponseState.value = it.data!!

                            if (!dataSaved) {
                                dataSaved = true
                                val weatherHistory = WeatherHistory(Gson().toJson(it.data))
                                dbRepository.insertHistoryData(weatherHistory = weatherHistory)
                            }
                        }
                        Status.ERROR-> {
                            loading.value = false
                        }
                    }
                }
            }
        }
    }

    fun getSavedWeatherHistory(){
        viewModelScope.launch{
            withContext(Dispatchers.IO){
                dbRepository.getHistoryList().collect{
                    savedWeatherHistoryList.clear()
                    savedWeatherHistoryList.addAll(it.map { it.getWeatherDetailsModel() })
                }
            }
        }
    }
}