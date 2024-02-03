package com.myweatherapp.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.myweatherapp.data.db.entities.Users
import kotlinx.coroutines.flow.Flow

@Dao
interface UsersDao {
    @Insert
    fun insertUser(users: Users)

    @Query("select * from users")
    fun getUserList(): Flow<List<Users>>
}