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
class AlbumDetailActivityTests {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)


    @Test
    fun testViewDetailAlbumNotExists(){
       onView(withText("Metallica")).check(doesNotExist())
    }

    @Test
    fun testViewFirstAlbumInList(){
        Thread.sleep(2500)
        onView(withId(R.id.recyclerViewAlbums))
            .perform(click())
        Thread.sleep(2500)

        onView(withId(R.id.genderAlbumView)).check(matches(withText("Salsa")))

        Thread.sleep(2500)

        onView(withId(R.id.recordLabel)).check(matches(withText("Elektra")))

    }

    @Test
    fun testViewImageFirstAlbumInList(){
        Thread.sleep(5500)
        onView(withId(R.id.recyclerViewAlbums))
            .perform(click())
        Thread.sleep(5000)

        onView(withId(R.id.imageAlbum)).check(matches(isDisplayed()))

        Thread.sleep(5500)

    }







}