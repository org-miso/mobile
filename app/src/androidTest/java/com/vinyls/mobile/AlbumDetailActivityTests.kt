package com.vinyls.mobile

import androidx.test.espresso.Espresso
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
class AlbumDetailActivityTests {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testTitleDisplayAlbum(){
        Espresso.onView(ViewMatchers.withText("Álbumes"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testViewDetailAlbum(){
        println(R.id.recyclerViewAlbums)
        Espresso.onView(ViewMatchers.withId(R.id.recyclerViewAlbums)).
        check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

}