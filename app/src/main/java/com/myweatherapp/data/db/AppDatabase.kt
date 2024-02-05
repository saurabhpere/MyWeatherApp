package com.myweatherapp.data.db

import androidx.annotation.Keep
import androidx.room.Database
import androidx.room.RoomDatabase
import com.myweatherapp.data.db.dao.HistoryDao
import com.myweatherapp.data.db.dao.UsersDao
import com.myweatherapp.data.db.entities.Users
import com.myweatherapp.data.db.entities.WeatherHistory

@Keep
@Database(entities = [Users::class, WeatherHistory::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun usersDao(): UsersDao
    abstract fun historyDao(): HistoryDao
}