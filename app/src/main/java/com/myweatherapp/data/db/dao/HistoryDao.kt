package com.myweatherapp.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.myweatherapp.data.db.entities.Users
import com.myweatherapp.data.db.entities.WeatherHistory
import kotlinx.coroutines.flow.Flow

@Dao
interface HistoryDao {
    @Insert
    fun insertHistory(users: WeatherHistory)

    @Query("select * from weatherhistory")
    fun getHistoryList(): Flow<List<WeatherHistory>>

    @Query("DELETE FROM weatherhistory")
    fun deleteData()
}