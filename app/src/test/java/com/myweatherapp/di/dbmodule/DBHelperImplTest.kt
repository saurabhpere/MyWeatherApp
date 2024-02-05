package com.myweatherapp.di.dbmodule

import com.myweatherapp.data.dao.FakeHistoryDao
import com.myweatherapp.data.dao.FakeUsersDao
import com.myweatherapp.generateCurrentWeatherRequest
import com.myweatherapp.generateUsers
import com.myweatherapp.generateWeatherDto
import com.myweatherapp.generateWeatherHistory
import com.myweatherapp.randomString
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.test.runBlockingTest
import org.amshove.kluent.shouldContain
import org.amshove.kluent.shouldEqual
import org.junit.Before
import org.junit.Test


class DBHelperImplTest {

    private lateinit var historyDao: FakeHistoryDao
    private lateinit var usersDao: FakeUsersDao
    private lateinit var dbHelperImpl: DBHelperImpl

    @Before
    fun setUp() {
        historyDao = FakeHistoryDao()
        usersDao  = FakeUsersDao()
        dbHelperImpl = DBHelperImpl(usersDao, historyDao = historyDao)
    }

    @Test
    fun `Should insert Users in db successfully`() = runBlockingTest {
        val cityInfoDto = generateUsers()

        usersDao.insertUser(cityInfoDto)

        dbHelperImpl.insertUserData(cityInfoDto)

        usersDao.getUserList(cityInfoDto.userName).last().get(0).userName.shouldEqual(cityInfoDto.userName)
    }

    @Test
    fun `Should get Users from db successfully`() = runBlockingTest {
        val cityInfoDto = generateUsers()

        usersDao.insertUser(cityInfoDto)

        var result = dbHelperImpl.getUserList(randomString()).last().get(0)

        result.shouldEqual(cityInfoDto)
    }

    @Test
    fun `Should insert WeatherHistory in db successfully`() = runBlockingTest {
        val cityInfoDto = generateWeatherHistory()

        historyDao.insertHistory(cityInfoDto)

        dbHelperImpl.insertHistory(cityInfoDto)

        historyDao.getHistoryList().last().get(0).shouldEqual(cityInfoDto)
    }

    @Test
    fun `Should get WeatherHistoryList from db successfully`() = runBlockingTest {
        val cityInfoDto = generateWeatherHistory()

        historyDao.insertHistory(cityInfoDto)

        var result = dbHelperImpl.getHistoryList().last().get(0)

        result.shouldEqual(cityInfoDto)
    }

    @Test
    fun `deleteAllData should delete WeatherHistoryList db successfully`() = runBlockingTest {

        historyDao.deleteData()

        var result = dbHelperImpl.getHistoryList().last()

        result.size.shouldEqual(0)
    }
}