package com.example.myapplication

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RecreateTest {

    @get:Rule
    val rule = ActivityScenarioRule(MainActivity::class.java)

    private fun rotateScreen() {
        rule.scenario.onActivity {
            it.apply {
                requestedOrientation = (requestedOrientation + 1) % 2
            }
        }
        Thread.sleep(1000)
    }


    @Test
    fun fromFirst() {
        checkDisplay(R.id.fragment1)
        rotateScreen()
        checkDisplay(R.id.fragment1)
    }

    @Test
    fun fromSecond3() {
        performClick(R.id.bnToSecond)
        rotateScreen()
        checkDisplay(R.id.fragment2)
        performClick(R.id.bnToThird)
        checkDisplay(R.id.fragment3)
    }

    @Test
    fun fromSecond1() {
        performClick(R.id.bnToSecond)
        rotateScreen()
        checkDisplay(R.id.fragment2)
        performClick(R.id.bnToFirst)
        checkDisplay(R.id.fragment1)
    }

    @Test
    fun fromThird1() {
        performClick(R.id.bnToSecond)
        performClick(R.id.bnToThird)
        rotateScreen()
        checkDisplay(R.id.fragment3)
        performClick(R.id.bnToFirst)
        checkDisplay(R.id.fragment1)
    }

    @Test
    fun fromThird2() {
        performClick(R.id.bnToSecond)
        performClick(R.id.bnToThird)
        rotateScreen()
        checkDisplay(R.id.fragment3)
        performClick(R.id.bnToSecond)
        checkDisplay(R.id.fragment2)
    }


}