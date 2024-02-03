package com.myweatherapp.di.dbmodule

import com.myweatherapp.data.db.entities.Users
import com.myweatherapp.data.db.entities.WeatherHistory
import kotlinx.coroutines.flow.Flow

interface DBHelper {

    suspend fun insertUserData(users: Users)

    suspend fun getUserList(): Flow<List<Users>>

    suspend fun insertHistory(weatherHistory: WeatherHistory)

    suspend fun getHistoryList(): Flow<List<WeatherHistory>>
}