package com.example.testapplication

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginTests2 {

    @get:Rule
    var scenarioRule = ActivityScenarioRule(LoginActivity::class.java)

    @Test
    fun CheckLoginSuccessful(){

    }
}