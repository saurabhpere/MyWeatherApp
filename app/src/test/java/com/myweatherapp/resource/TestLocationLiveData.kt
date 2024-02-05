package com.myweatherapp.resource

import android.content.Context
import android.location.Location
import androidx.lifecycle.LiveData
import com.myweatherapp.data.location.LocationModel

class TestLocationLiveData(private val context: Context) : LiveData<LocationModel>() {

    override fun onActive() {
        // Simulate the behavior you need during testing
        setLocationData(LocationModel(0.0, 0.0))  // Set a default location for testing
    }

    override fun onInactive() {
        // Cleanup or simulate behavior if needed during testing
    }

    private fun setLocationData(location: LocationModel) {
        value = location
    }
}
