package com.example.uitest

import android.content.pm.ActivityInfo
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Rule
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    private val startText = ""
    private val endText = "Some text"

    @get:Rule
    var rule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testView() {
        onView(withId(R.id.button)).check(matches(ViewMatchers.isDisplayed()))
        onView(withId(R.id.edit_text)).check(matches(ViewMatchers.isDisplayed()))


    }

    @Test
    fun testRecreate() {
        onView(withId(R.id.edit_text)).check(matches(withText(startText)))

        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.edit_text)).perform(typeText(endText), closeSoftKeyboard())

        onView(withId(R.id.button)).check(matches(withText(R.string.clicked)))
        onView(withId(R.id.edit_text)).check(matches(withText(endText)))

        rule.scenario.recreate()
        onView(withId(R.id.button)).check(matches(withText(R.string.click_me)))
        onView(withId(R.id.edit_text)).check(matches(withText(endText)))

    }

    @Test
    fun testRotate() {
        onView(withId(R.id.edit_text)).perform(typeText(startText), closeSoftKeyboard())
        onView(withId(R.id.button)).perform(click())

        onView(withId(R.id.edit_text)).check(matches(withText(startText)))
        onView(withId(R.id.button)).check(matches(withText(R.string.clicked)))

        rule.scenario.onActivity { activity ->
            activity.setRequestedOrientation(
                ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
            )
        }
        Thread.sleep(1000)

        onView(withId(R.id.edit_text)).check(matches(withText(startText)))
        onView(withId(R.id.button)).check(matches(withText(R.string.click_me)))

        onView(withId(R.id.edit_text)).perform(typeText(endText), closeSoftKeyboard())
        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.edit_text)).check(matches(withText(endText)))
        onView(withId(R.id.button)).check(matches(withText(R.string.clicked)))

        rule.scenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }
        Thread.sleep(1000)

        onView(withId(R.id.edit_text)).check(matches(withText(endText)))
        onView(withId(R.id.button)).check(matches(withText(R.string.click_me)))
    }
}