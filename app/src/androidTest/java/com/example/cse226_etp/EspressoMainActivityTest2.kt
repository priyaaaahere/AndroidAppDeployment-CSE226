package com.example.cse226_etp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test
import unit6.expressoTesting.task2.EspressoTesting2

class EspressoMainActivityTest2 {
    @get:Rule
    val rule = ActivityScenarioRule(EspressoTesting2::class.java)

    @Test
    fun testNameIsDisplayedCorrectly() {

        // 1. Type text into EditText
        onView(withId(R.id.editTextName))
            .perform(typeText("John"), closeSoftKeyboard())

        // 2. Click the button
        onView(withId(R.id.btnShow))
            .perform(click())

        // 3. Check the result text
        onView(withId(R.id.textResult))
            .check(matches(withText("Hello, John")))
    }
}