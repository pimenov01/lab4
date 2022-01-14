package com.example.myapplication

import androidx.lifecycle.Lifecycle
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.pressBackUnconditionally
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BackstackTest {

    @get:Rule
    var rule = ActivityScenarioRule(MainActivity::class.java)

    private fun destroyCheck() = assertTrue(rule.scenario.state == Lifecycle.State.DESTROYED)

    @Test
    fun fromFirst() { // 1 b> exit
        pressBackUnconditionally()
        destroyCheck()
    }

    @Test
    fun fromSecondBack() { // 1 -> 2 b> 1 b> exit
        launchActivity<MainActivity>()
        performClick(R.id.bnToSecond)
        pressBackUnconditionally()
        checkDisplay(R.id.fragment1)
        fromFirst()
    }

    @Test
    fun fromSecond() { // 1 -> 2 -> 1 b> exit
        launchActivity<MainActivity>()
        performClick(R.id.bnToSecond)
        performClick(R.id.bnToFirst)
        fromFirst()
    }

    @Test
    fun fromThird() { // 1 -> 2 -> 3 -> 1 b> exit
        launchActivity<MainActivity>()
        performClick(R.id.bnToSecond)
        performClick(R.id.bnToThird)
        performClick(R.id.bnToFirst)
        fromFirst()
    }

    @Test
    fun fromThirdBack() { // 1 -> 2 -> 3 b> 2 -> 1 b> exit
        launchActivity<MainActivity>()
        performClick(R.id.bnToSecond)
        performClick(R.id.bnToThird)
        pressBackUnconditionally()
        checkDisplay(R.id.fragment2)
        performClick(R.id.bnToFirst)
        checkDisplay(R.id.fragment1)
        fromFirst()
    }

    @Test
    fun fromThirdViaSecond() { // 1 -> 2 -> 3 -> 2 b> 1 b> exit
        launchActivity<MainActivity>()
        performClick(R.id.bnToSecond)
        performClick(R.id.bnToThird)
        performClick(R.id.bnToSecond)
        pressBackUnconditionally()
        checkDisplay(R.id.fragment1)
        fromFirst()
    }
}