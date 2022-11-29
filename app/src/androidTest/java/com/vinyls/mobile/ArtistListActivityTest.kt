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
class ArtistListActivityTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testViewListArtistsTitle(){
        Thread.sleep(5500)

        Espresso.onView(ViewMatchers.withId(R.id.artists))
            .perform(ViewActions.click())
        Thread.sleep(2500)

        Espresso.onView(ViewMatchers.withId(com.vinyls.mobile.R.id.title))
            .check(ViewAssertions.matches(ViewMatchers.withText("Artistas")))

    }

    @Test
    fun testViewFirstArtistData(){
        Thread.sleep(5500)

        Espresso.onView(ViewMatchers.withId(R.id.artists))
            .perform(ViewActions.click())
        Thread.sleep(3500)

        Espresso.onView(ViewMatchers.withId(R.id.nameMusicianView))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Thread.sleep(3500)

        Espresso.onView(ViewMatchers.withId(R.id.image))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

    }

    @Test
    fun testViewListArtistsScrollDown(){
        Thread.sleep(5500)

        Espresso.onView(ViewMatchers.withId(R.id.artists))
            .perform(ViewActions.click())
        Thread.sleep(5500)

        Espresso.onView(ViewMatchers.withId(R.id.recyclerViewAlbums))
            .perform(ViewActions.swipeDown())
        Thread.sleep(5500)

    }
}