package com.example.cse226_etp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test
import unit6.expressoTesting.notesTask.NoteMain
import kotlin.jvm.java

class NotesActivityTest {
    @get:Rule
    val rule = ActivityScenarioRule(NoteMain::class.java)

    @Test
    fun testAddingNote() {
        onView(withId(R.id.etNote)).perform(typeText("My First Note"), closeSoftKeyboard())
        onView(withId(R.id.btnAdd)).perform(click())

        onView(withText("My First Note")).check(matches(isDisplayed()))
    }

    @Test
    fun testDeletingNote() {
        // adding note to delete
        onView(withId(R.id.etNote)).perform(typeText("Delete Me"), closeSoftKeyboard())
        onView(withId(R.id.btnAdd)).perform(click())

        // click delete button
        onView(withText("Delete")).perform(click())

        // verify it’s gone
        onView(withText("Delete Me")).check(doesNotExist())
    }
}