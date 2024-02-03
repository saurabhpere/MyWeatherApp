package com.myweatherapp.ui.feature.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myweatherapp.data.db.entities.Users
import com.myweatherapp.repository.DatabaseRepository
import com.myweatherapp.resource.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(val databaseRepository: DatabaseRepository): ViewModel() {

    fun checkIfUserExist(users: Users, callback: (Int)-> Unit){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                databaseRepository.getUserList(users.userName).collect{
                    withContext(Dispatchers.Main) {
                        if (it.isNotEmpty()) {
                            if (users.userPass == it[0].userPass) {
                                callback(Constants.LOGIN_SUCCESS)
                            } else {
                                callback(Constants.PASS_MISMATCH)
                            }
                        } else {
                            callback(Constants.EMAIL_NOT_FOUND)
                        }
                    }
                }
            }
        }

    }

}