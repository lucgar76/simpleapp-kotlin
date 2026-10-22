package com.example.testapplication

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.hasErrorText
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withHint
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginTests {
    private val username = "Admin"
    private val password = "123456"

    @get:Rule
    var scenarioRule = ActivityScenarioRule(LoginActivity::class.java)

    @Test
    fun checkLoginSuccessful() {
        onView(withId(R.id.username)).perform(typeText(username), closeSoftKeyboard())
        onView(withHint(R.string.password_hint_text)).perform(typeText(password), closeSoftKeyboard())
        onView(withText(R.string.login_button_text)).perform(click())
        onView(withId(R.id.welcome_text)).check(matches(allOf(withText(R.string.welcome_qa_family), isDisplayed())))
    }


    @Test
    fun checkEmptyUsername() {
        onView(withId(R.id.password)).perform(typeText(password), closeSoftKeyboard())
        onView(withId(R.id.login_button)).perform(click())
        onView(withId(R.id.username)).check(matches(hasErrorText(getTextFromStringResource(R.string.empty_username))))
    }

    private fun getTextFromStringResource(stringResource: Int) =
        InstrumentationRegistry.getInstrumentation().targetContext.getString(stringResource)
}