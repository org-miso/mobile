package com.vinyls.mobile


import androidx.test.espresso.Espresso.onView
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
class AlbumActivityTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testTitleDisplayAlbum(){
        onView(withText("Álbumes")).check(matches(isDisplayed()))
        Thread.sleep(5000)
    }

    @Test
    fun testListAlbum(){
        println(R.id.recyclerViewAlbums)
        onView(withId(R.id.recyclerViewAlbums)).
                check(matches(isDisplayed()))
        Thread.sleep(5000)
    }

    @Test
    fun testScrollListAlbums() {
        Thread.sleep(5000)
        onView(withId(R.id.recyclerViewAlbums)).perform(
            ScrollToBottomAction()
        )
        Thread.sleep(5000)
  }



}