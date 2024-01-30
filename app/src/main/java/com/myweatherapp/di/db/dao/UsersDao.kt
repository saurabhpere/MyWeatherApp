package com.myweatherapp.di.db.dao

import androidx.room.Dao
import androidx.room.Insert
import com.myweatherapp.di.db.entities.Users

@Dao
interface UsersDao {
    @Insert
    fun insertUser(users: Users)
}