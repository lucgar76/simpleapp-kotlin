package com.example.testapplication

import android.app.Activity
import android.app.Instrumentation.ActivityResult
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers.hasPackage
import androidx.test.espresso.matcher.ViewMatchers.withHint
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DocumentUploadScreenTest {

    @get:Rule
    var scenarioRule = ActivityScenarioRule(DocumentUploadActivity::class.java)

    @Before
    fun setUp() {
        Intents.init()
        // The emulator does not have Google Maps installed. Stub the external
        // intent so the click is recorded without crashing the activity.
        Intents.intending(hasPackage("com.google.android.apps.maps"))
            .respondWith(ActivityResult(Activity.RESULT_OK, null))
    }

    @After
    fun tearDown() {
        Intents.release()
    }

    @Test
    fun checkDocumentUploadScreen() {
        onView(withId(R.id.input_name)).check(matches(withHint("Enter your name")))
        onView(withId(R.id.input_name)).perform(typeText("Silvia"), closeSoftKeyboard())

        onView(withId(R.id.button_open_maps)).perform(click())
        Intents.intended(hasPackage("com.google.android.apps.maps"))
    }
}