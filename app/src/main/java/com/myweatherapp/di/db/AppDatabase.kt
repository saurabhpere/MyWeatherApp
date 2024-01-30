package com.myweatherapp.di.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.myweatherapp.di.db.dao.UsersDao
import com.myweatherapp.di.db.entities.Users

@Database(entities = [Users::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun usersDao(): UsersDao
}