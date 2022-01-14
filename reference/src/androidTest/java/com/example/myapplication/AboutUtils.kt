package com.example.myapplication

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.openContextualActionModeOverflowMenu
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*

private fun openAboutViaOptions() {
    openContextualActionModeOverflowMenu()
    onView(withText(R.string.title_about))
        .perform(click())
}

fun openAbout() = openAboutViaOptions()

fun checkDisplay(viewId: Int) {
    onView(withId(viewId)).check(matches(isDisplayed()))
}
fun performClick(viewId: Int) {
    onView(withId(viewId)).perform(click())
}
fun aboutUp() {
    onView(withContentDescription(R.string.nav_app_bar_navigate_up_description))
        .perform(click())
}
