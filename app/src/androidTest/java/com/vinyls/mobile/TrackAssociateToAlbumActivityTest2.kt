package com.vinyls.mobile

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.vinyls.mobile.view.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class TrackAssociateToAlbumActivityTest2 {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testViewNewTrack(){
        Thread.sleep(5500)
        Espresso.onView(ViewMatchers.withId(R.id.recyclerViewAlbums))
            .perform(ViewActions.click())
        Thread.sleep(5500)

        Espresso.onView(ViewMatchers.withId(R.id.buttonSong))
            .perform(ViewActions.click())
        Thread.sleep(5500)

        Espresso.onView(ViewMatchers.withId(R.id.buttonAddTrack))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Thread.sleep(5500)

        Espresso.onView(ViewMatchers.withId(R.id.recyclerViewSongs)).perform(ViewActions.swipeDown())
        Thread.sleep(5000)

    }


}