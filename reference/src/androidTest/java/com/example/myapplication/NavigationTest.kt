package com.example.myapplication

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */


@RunWith(AndroidJUnit4::class)
class NavigationTest {
    @get:Rule
    val rule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun fromFirst() {
        checkDisplay(R.id.fragment1)
        openAbout() // 1 -> About
        checkDisplay(R.id.activity_about)

        aboutUp()
        checkDisplay(R.id.fragment1)

        performClick(R.id.bnToSecond) // 1 -> 2
        checkDisplay(R.id.fragment2)
    }

    @Test
    fun fromSecond() {
        performClick(R.id.bnToSecond)
        checkDisplay(R.id.fragment2)

        openAbout()
        checkDisplay(R.id.activity_about) // 2 -> About
        aboutUp()
        checkDisplay(R.id.fragment2)

        performClick(R.id.bnToFirst) // 2 -> 1
        checkDisplay(R.id.fragment1)
        performClick(R.id.bnToSecond)
        checkDisplay(R.id.fragment2)

        performClick(R.id.bnToThird) // 2 -> 3
        checkDisplay(R.id.fragment3)
    }

    @Test
    fun fromThird() {
        performClick(R.id.bnToSecond)
        performClick(R.id.bnToThird)
        checkDisplay(R.id.fragment3)

        openAbout()
        checkDisplay(R.id.activity_about) // 3 -> About
        aboutUp()
        checkDisplay(R.id.fragment3)

        performClick(R.id.bnToSecond) // 3 -> 2
        checkDisplay(R.id.fragment2)
        performClick(R.id.bnToThird)
        checkDisplay(R.id.fragment3)

        performClick(R.id.bnToFirst) // 3 -> 1
        checkDisplay(R.id.fragment1)
    }
}