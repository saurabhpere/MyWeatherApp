package com.myweatherapp.data.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("token")
    val token: String?= null,
    @SerializedName("reason")
    val reason: String?= null)
