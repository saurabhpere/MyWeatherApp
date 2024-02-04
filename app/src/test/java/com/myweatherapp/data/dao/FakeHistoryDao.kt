package com.myweatherapp.data.dao

import com.myweatherapp.data.db.dao.HistoryDao
import com.myweatherapp.data.db.entities.WeatherHistory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeHistoryDao: HistoryDao {

    val historyList = ArrayList<WeatherHistory>()

    override fun insertHistory(users: WeatherHistory) {
        historyList.add(users)
    }

    override fun getHistoryList(): Flow<List<WeatherHistory>> {
        return flowOf(historyList)
    }
}