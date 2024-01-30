package com.myweatherapp.di.dbmodule

import com.myweatherapp.di.db.entities.Users
import kotlinx.coroutines.flow.Flow

interface DBHelper {
//    fun getUsersList(): Flow<List<Users>>

    suspend fun insertUserData(users: Users)
}