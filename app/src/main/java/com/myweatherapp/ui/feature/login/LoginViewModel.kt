package com.myweatherapp.ui.feature.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myweatherapp.data.db.entities.Users
import com.myweatherapp.repository.DatabaseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(val databaseRepository: DatabaseRepository): ViewModel() {


    fun checkIfUserExist(users: Users, callback: (Int) -> Unit) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val result = determineLoginResult(users)
                withContext(Dispatchers.Main) {
                    callback(result)
                }
            }
        }
    }

    suspend fun determineLoginResult(users: Users): Int {
        val userList = databaseRepository.getUserList(users.userName).first().firstOrNull()

        return if (userList != null) {
            if (users.userPass == userList.userPass) {
                200 // LOGIN_SUCCESS
            } else {
                402 //PASSWORD_MISMATCH
            }
        } else {
            404 // USER_NOT_FOUND
        }
    }

    fun deleteData(){
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                databaseRepository.deleteAllData()
            }
        }
    }

}