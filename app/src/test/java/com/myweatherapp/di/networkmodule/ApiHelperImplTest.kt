package com.myweatherapp.di.networkmodule

import com.myweatherapp.generateCurrentWeatherRequest
import com.myweatherapp.generateWeatherDto
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.test.runBlockingTest
import org.amshove.kluent.shouldEqual
import org.junit.Before
import org.junit.Test


class ApiHelperImplTest {

    private lateinit var weatherRepositoryImpl: ApiHelperImpl
    private lateinit var fakeOpenWeatherApi: FakeApiService

    @Before
    fun setUp() {
        fakeOpenWeatherApi = FakeApiService()
        weatherRepositoryImpl = ApiHelperImpl(fakeOpenWeatherApi)
    }

    @Test
    fun `Should return CurrentLocationResponse successfully`() = runBlockingTest {
        val cityInfoDto = generateWeatherDto()

        fakeOpenWeatherApi.initResponse(cityInfoDto)

        val result = weatherRepositoryImpl.getCurrentWeather(generateCurrentWeatherRequest()).last().data

        result.shouldEqual(cityInfoDto)
    }

}