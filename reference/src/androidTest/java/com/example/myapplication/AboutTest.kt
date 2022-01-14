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
class AboutTest {

    @get:Rule
    var rule = ActivityScenarioRule(MainActivity::class.java)

    private fun destroyCheck() = assertTrue(rule.scenario.state == Lifecycle.State.DESTROYED)

    @Test
    fun firstBack() {
        checkDisplay(R.id.fragment1)
        pressBackUnconditionally()
        destroyCheck()
    }

    @Test
    fun firstDoubleBack() {
        launchActivity<MainActivity>()
        openAbout()
        pressBackUnconditionally()
        pressBackUnconditionally()
        destroyCheck()
    }

    @Test
    fun firstUp() {
        //launchActivity<MainActivity>()
        openAbout()
        aboutUp()
        pressBackUnconditionally()
        destroyCheck()
    }

    @Test
    fun secondBack() {
        launchActivity<MainActivity>()
        performClick(R.id.bnToSecond)
        openAbout()
        pressBackUnconditionally()
        checkDisplay(R.id.fragment2)
        pressBackUnconditionally()
        firstBack()
    }


    @Test
    fun secondUp() {
        launchActivity<MainActivity>()
        performClick(R.id.bnToSecond)
        openAbout()
        aboutUp()
        checkDisplay(R.id.fragment2)
        pressBackUnconditionally()
        firstBack()
    }


    @Test
    fun thirdDoubleBack() {
        launchActivity<MainActivity>()
        performClick(R.id.bnToSecond)
        performClick(R.id.bnToThird)
        openAbout()
        pressBackUnconditionally()
        checkDisplay(R.id.fragment3)
        pressBackUnconditionally()
        checkDisplay(R.id.fragment2)
        pressBackUnconditionally()
        firstBack()
    }


    @Test
    fun thirdUpBack() {
        launchActivity<MainActivity>()
        performClick(R.id.bnToSecond)
        performClick(R.id.bnToThird)
        openAbout()
        aboutUp()
        checkDisplay(R.id.fragment3)
        pressBackUnconditionally()
        checkDisplay(R.id.fragment2)
        pressBackUnconditionally()
        firstBack()
    }


    @Test
    fun thirdBackToFirst() {
        launchActivity<MainActivity>()
        performClick(R.id.bnToSecond)
        performClick(R.id.bnToThird)
        openAbout()
        pressBackUnconditionally()
        checkDisplay(R.id.fragment3)
        performClick(R.id.bnToFirst)
        firstBack()
    }

    @Test
    fun thirdUpToFirst() {
        launchActivity<MainActivity>()
        performClick(R.id.bnToSecond)
        performClick(R.id.bnToThird)
        openAbout()
        aboutUp()
        checkDisplay(R.id.fragment3)
        performClick(R.id.bnToFirst)
        firstBack()
    }
}
