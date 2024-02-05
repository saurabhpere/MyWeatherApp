package com.myweatherapp

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import org.junit.rules.TestRule
import org.junit.runner.Description
import org.junit.runners.model.Statement

@OptIn(ExperimentalCoroutinesApi::class)
class CoroutineRule(val testDispatcher: TestCoroutineDispatcher = TestCoroutineDispatcher()) : TestRule {

    override fun apply(base: Statement, description: Description): Statement {
        return object : Statement() {
            override fun evaluate() {
                try {
                    testDispatcher.runBlockingTest {
                        base.evaluate()
                    }
                } finally {
                    testDispatcher.cleanupTestCoroutines()
                }
            }
        }
    }
}
