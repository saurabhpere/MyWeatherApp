package com.myweatherapp.repository

import com.myweatherapp.data.db.entities.Users
import com.myweatherapp.data.db.entities.WeatherHistory
import com.myweatherapp.di.dbmodule.DBHelper
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DatabaseRepository @Inject constructor(private val dbHelper: DBHelper) {
    suspend fun insertUserData(users: Users) {
        dbHelper.insertUserData(users)
    }

    suspend fun getUserList() = dbHelper.getUserList()

    suspend fun insertHistoryData(weatherHistory: WeatherHistory) {
        dbHelper.insertHistory(weatherHistory)
    }

    suspend fun getHistoryList() = dbHelper.getHistoryList()
}