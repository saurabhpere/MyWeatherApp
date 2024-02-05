package com.myweatherapp.di.networkmodule

import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test

import com.myweatherapp.data.request.CurrentWeatherRequest
import com.myweatherapp.data.response.CurrentLocationResponse
import com.myweatherapp.generateWeatherDto
import com.myweatherapp.resource.Resource
import com.myweatherapp.resource.Status
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList

@OptIn(ExperimentalCoroutinesApi::class)
class ApiHelperImplTest {

    private lateinit var apiHelperImpl: ApiHelperImpl
    private lateinit var mockApiService: ApiService

    @Before
    fun setUp() {
        mockApiService = mockk()
        apiHelperImpl = ApiHelperImpl(mockApiService)
    }

    @Test
    fun `getCurrentWeather success should emit Loading and Success`() = runBlockingTest {
        // Arrange
        val currentWeatherRequest = CurrentWeatherRequest(apiKey = "fakeKey", lat = 0.0, lon = 0.0)
        val mockApiResponse = generateWeatherDto()

        coEvery {
            mockApiService.getCurrentWeatherData(currentWeatherRequest.apiKey, currentWeatherRequest.lat, currentWeatherRequest.lon)
        } returns mockApiResponse

        // Act
        val result = apiHelperImpl.getCurrentWeather(currentWeatherRequest).toList()

        // Assert
        assertEquals(2, result.size) // Loading and Success emitted
        assertTrue(result[0].status == Status.LOADING)
        assertTrue(result[1].status == Status.SUCCESS)
        assertEquals(mockApiResponse, (result[1] as Resource).data)
    }

    @Test
    fun `getCurrentWeather error should emit Loading and Error`() = runBlockingTest {
        // Arrange
        val currentWeatherRequest = CurrentWeatherRequest(apiKey = "fakeKey", lat = 0.0, lon = 0.0)
        val mockException = RuntimeException("Fake error message")

        coEvery {
            mockApiService.getCurrentWeatherData(currentWeatherRequest.apiKey, currentWeatherRequest.lat, currentWeatherRequest.lon)
        } throws mockException

        // Act
        val result = apiHelperImpl.getCurrentWeather(currentWeatherRequest).toList()

        // Assert
        assertEquals(2, result.size) // Loading and Error emitted
        assertTrue(result[0].status == Status.LOADING)
        assertTrue(result[1].status == Status.ERROR)
        assertEquals(mockException.localizedMessage, (result[1] as Resource).message)
    }
}
