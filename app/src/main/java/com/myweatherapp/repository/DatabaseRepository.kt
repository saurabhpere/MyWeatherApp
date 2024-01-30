package com.myweatherapp.repository

import com.myweatherapp.di.db.entities.Users
import com.myweatherapp.di.dbmodule.DBHelper
import javax.inject.Inject

class DatabaseRepository @Inject constructor(private val dbHelper: DBHelper) {
    suspend fun insertUserData(users: Users) {
        dbHelper.insertUserData(users)
    }
}