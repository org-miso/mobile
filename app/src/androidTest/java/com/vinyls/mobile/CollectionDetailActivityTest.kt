package com.vinyls.mobile

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
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
class CollectionDetailActivityTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testViewDetailCollectionNotExists(){
        onView(withText("Salsa")).check(doesNotExist())
    }

    @Test
    fun testViewSecondCollectorInList(){
        Thread.sleep(5500)

        onView(withId(R.id.collections))
            .perform(click())
        Thread.sleep(5500)

        onView(withId(R.id.recyclerViewCollectors))
            .perform(click())
        Thread.sleep(2500)

        onView(withId(R.id.email)).check(matches(withText("jmonsalve@rtvc.com.co")))

        Thread.sleep(2500)

        onView(withId(R.id.phone)).check(matches(withText("3012357936")))

        Thread.sleep(2500)

         }

    @Test
    fun testViewNameSecondCollectorInList(){
        Thread.sleep(5500)

        onView(withId(R.id.collections))
            .perform(click())
        Thread.sleep(5500)

        onView(withId(R.id.recyclerViewCollectors))
            .perform(click())
        Thread.sleep(2500)

        onView(withId(R.id.name)).check(matches(withText("Jaime Monsalve")))

        Thread.sleep(2500)

    }

}