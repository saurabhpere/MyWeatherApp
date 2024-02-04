package com.myweatherapp.resource.extension

import com.google.common.truth.Truth
import org.amshove.kluent.shouldEqual
import org.junit.Test


class StringExtensionsKtTest {
    @Test
    fun `isEmailValid should return true for valid email`() {
        var result = "saurabh@gmail.com".isEmailValid()

        Truth.assertThat(result).isTrue()
    }

    @Test
    fun `isEmailValid should return false for invalid email`() {
        var result = "saurabh@.com".isEmailValid()

        Truth.assertThat(result).isFalse()
    }

    @Test
    fun `convertTimeMillisToFormattedString should return valid formatted string`() {
        var time = 1707022723555
        var result = time.convertTimeMillisToFormattedString("HH:mm:ss")

        println(result)

        result.shouldEqual("16:15:55")
    }

    @Test
    fun `convertTemperatureToCelsius should return valid celsius`() {
        var kelvin = 276.0
        var result = kelvin.convertTemperatureToCelsius()

        println(result)

        result.shouldEqual("2.85°C")
    }
}
