package com.vinyls.mobile

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.vinyls.mobile.view.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@LargeTest
@RunWith(AndroidJUnit4::class)
class CollectionActivityTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testViewListCollector(){
        Thread.sleep(5500)

        onView(withId(R.id.collections))
            .perform(ViewActions.click())
        Thread.sleep(5500)

        onView(withId(R.id.txtCollect))
            .check(matches(withText("Coleccionistas")))
        Thread.sleep(5500)
    }


    @Test
    fun testListCollector(){
        Thread.sleep(5500)

        onView(withId(R.id.collections))
            .perform(ViewActions.click())
        Thread.sleep(5500)

        onView(withId(R.id.recyclerViewCollectors))
            .check(matches(isDisplayed()))
        Thread.sleep(5500)
    }


    @Test
    fun testScrollListCollectors() {
        Thread.sleep(5500)

        onView(withId(R.id.collections))
            .perform(ViewActions.click())
        Thread.sleep(5500)

        onView(withId(R.id.recyclerViewCollectors)).perform(
            ScrollToBottomAction()
        )
        Thread.sleep(5000)
    }





}