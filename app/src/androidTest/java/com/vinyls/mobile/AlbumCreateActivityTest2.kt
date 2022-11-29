package com.vinyls.mobile

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
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
class AlbumCreateActivityTest2 {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testViewCreateAlbumViewButton() {
        Thread.sleep(2500)
        Espresso.onView(ViewMatchers.withId(R.id.floatingActionButton))
            .perform(ViewActions.click())
        Thread.sleep(5500)
    }
}