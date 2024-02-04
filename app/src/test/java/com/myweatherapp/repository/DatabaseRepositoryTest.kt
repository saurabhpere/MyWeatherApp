package com.myweatherapp.repository

import com.google.common.truth.Truth
import com.myweatherapp.di.dbmodule.FakeDBHelper
import com.myweatherapp.generateUsers
import com.myweatherapp.generateWeatherHistory
import com.myweatherapp.randomString
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.test.runBlockingTest
import org.amshove.kluent.shouldEqual
import org.junit.Before
import org.junit.Test

class DatabaseRepositoryTest {

    lateinit var fakeDBHelper: FakeDBHelper
    lateinit var databaseRepository: DatabaseRepository

    @Before
    fun setUp() {
        fakeDBHelper = FakeDBHelper()
        databaseRepository = DatabaseRepository(fakeDBHelper)
    }

    @Test
    fun `Should insert Users in db successfully`() = runBlockingTest {
        val cityInfoDto = generateUsers()

        fakeDBHelper.insertUserData(cityInfoDto)

        databaseRepository.insertUserData(cityInfoDto)

        Truth.assertThat(true).isTrue()
    }

    @Test
    fun `Should get Users from db successfully`() = runBlockingTest {
        val cityInfoDto = generateUsers()

        fakeDBHelper.insertUserData(cityInfoDto)

        var result = databaseRepository.getUserList(randomString()).last().get(0)

        result.shouldEqual(cityInfoDto)
    }

    @Test
    fun `Should insert WeatherHistory in db successfully`() = runBlockingTest {
        val cityInfoDto = generateWeatherHistory()

        fakeDBHelper.insertHistory(cityInfoDto)

        databaseRepository.insertHistoryData(cityInfoDto)

        Truth.assertThat(true).isTrue()
    }

    @Test
    fun `Should get WeatherHistoryList from db successfully`() = runBlockingTest {
        val cityInfoDto = generateWeatherHistory()

        fakeDBHelper.insertHistory(cityInfoDto)

        var result = databaseRepository.getHistoryList().last().get(0)

        result.shouldEqual(cityInfoDto)
    }
}