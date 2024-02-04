package com.myweatherapp.repository

import com.myweatherapp.di.networkmodule.FakeApiHelper
import com.myweatherapp.generateCurrentWeatherRequest
import com.myweatherapp.generateWeatherDto
import com.myweatherapp.generateWeatherHistory
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.test.runBlockingTest
import org.amshove.kluent.shouldEqual
import org.junit.Before
import org.junit.Test

class NetworkRepositoryTest {

    lateinit var fakeApiHelper: FakeApiHelper
    lateinit var networkRepository: NetworkRepository

    @Before
    fun setUp() {
        fakeApiHelper = FakeApiHelper()
        networkRepository = NetworkRepository(fakeApiHelper)
    }

    @Test
    fun `Should get CurrentWeather successfully`() = runBlockingTest {
        var result = networkRepository.getCurrentWeather(generateCurrentWeatherRequest()).last().data

        result.shouldEqual(fakeApiHelper.weatherdto)
    }
}