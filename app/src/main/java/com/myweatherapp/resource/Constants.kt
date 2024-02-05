package com.myweatherapp.resource

object Constants {

    init {
        System.loadLibrary("native-lib")
    }

    external fun getBaseUrl(): String

    external fun getImageUrl(): String

}