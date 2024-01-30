package com.myweatherapp.resource

data class Resource<out T>(val status: Status,
                           val data: T?,
                           val message: String?) {
    companion object{
        fun <T> Success(data: T?): Resource<T> {
            return Resource(status = Status.SUCCESS, data = data, null)
        }

        fun <T> Error(message: String?): Resource<T> {
            return Resource(status = Status.ERROR, data = null, message)
        }

        fun <T> Loading(): Resource<T> {
            return Resource(status = Status.LOADING, data = null, null)
        }
    }
}