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
import unit6.expressoTesting.task1.EspressoTaskMain
import kotlin.jvm.java

class EspressoMainActivityTest {
    @get:Rule
    var activityRule = ActivityScenarioRule(EspressoTaskMain::class.java)

    @Test
    fun testAddButton() {
        onView(withId(R.id.etNumber1)).perform(typeText("5"), closeSoftKeyboard())
        onView(withId(R.id.etNumber2)).perform(typeText("10"), closeSoftKeyboard())
        onView(withId(R.id.btnAdd)).perform(click())
        onView(withId(R.id.tvResult)).check(matches(withText("15")))
    }
}