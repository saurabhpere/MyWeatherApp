package com.myweatherapp.di.dbmodule

import com.myweatherapp.data.db.dao.HistoryDao
import com.myweatherapp.data.db.dao.UsersDao
import com.myweatherapp.data.db.entities.Users
import com.myweatherapp.data.db.entities.WeatherHistory
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DBHelperImpl @Inject constructor(private val usersDao: UsersDao, private val historyDao: HistoryDao): DBHelper {

    override suspend fun insertUserData(users: Users) {
        usersDao.insertUser(users)
    }

    override suspend fun getUserList()= usersDao.getUserList()
    override suspend fun insertHistory(weatherHistory: WeatherHistory) {
        historyDao.insertHistory(weatherHistory)
    }

    override suspend fun getHistoryList() = historyDao.getHistoryList()
}