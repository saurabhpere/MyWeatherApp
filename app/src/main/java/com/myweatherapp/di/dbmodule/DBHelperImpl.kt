package com.myweatherapp.di.dbmodule

import com.myweatherapp.di.db.dao.UsersDao
import com.myweatherapp.di.db.entities.Users
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DBHelperImpl @Inject constructor(private val usersDao: UsersDao): DBHelper {
    //    override fun getUsersList(): Flow<List<Users>> {
//
//    }
    override suspend fun insertUserData(users: Users) {
        usersDao.insertUser(users)
    }
}