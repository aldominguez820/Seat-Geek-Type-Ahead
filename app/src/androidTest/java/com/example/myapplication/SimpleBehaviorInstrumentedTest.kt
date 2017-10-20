package com.example.myapplication

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.runner.AndroidJUnit4

import com.example.myapplication.ui.main.MainActivity
import android.support.test.rule.ActivityTestRule
import android.support.v7.widget.RecyclerView
import org.hamcrest.Matchers.not

import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by user on 10/20/17.
 */

@RunWith(AndroidJUnit4::class)
class SimpleBehaviorInstrumentedTest {
    @Rule
    @JvmField
    val activity = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test
    fun testTypingText() {
        // TODO 10/20/17: Add idling resources to handle right API lookup

        onView(withId(R.id.a_main_et))
                .perform(typeText("Texas Rangers"))

        onView(withId(R.id.a_main_recycler))
                .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(1, click()))

        onView(withId(R.id.a_details_title))
                .check(matches(not(withText(""))))
    }
}