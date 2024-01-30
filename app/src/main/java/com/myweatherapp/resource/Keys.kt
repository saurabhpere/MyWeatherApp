package com.myweatherapp.resource

object Keys {
    init {
        System.loadLibrary("native-lib")
    }

    external fun apiKey(): String
}