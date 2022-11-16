package com.vinyls.mobile

import android.view.View
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.vinyls.mobile.view.MainActivity
import org.hamcrest.Matcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.Description
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withClassName
import org.hamcrest.Matchers
import org.hamcrest.Matchers.`is`

@LargeTest
@RunWith(AndroidJUnit4::class)
class TrackAssociateToAlbumActivityTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    private val ITEM_BELOW_THE_FOLD = 4

    @Test
    fun testViewButtonAddTrack(){
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
    }

    @Test
    fun testAddTrackToFirstAlbum(){
        Thread.sleep(5500)
        Espresso.onView(ViewMatchers.withId(R.id.recyclerViewAlbums))
            .perform(ViewActions.click())
        Thread.sleep(5500)

        Espresso.onView(ViewMatchers.withId(R.id.buttonSong))
            .perform(ViewActions.click())
        Thread.sleep(5500)


        Espresso.onView(ViewMatchers.withId(R.id.buttonAddTrack))
            .perform(ViewActions.click())
        Thread.sleep(5500)


        val nombre = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.editTextName),
                ViewMatchers.isDisplayed()
            )
        )

        nombre.perform(ViewActions.typeText(getRandomString(20)), ViewActions.closeSoftKeyboard())
        Thread.sleep(1000)
        nombre.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Thread.sleep(3000)

        val hours = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.editTextHours),
                ViewMatchers.isDisplayed()
            )
        )

        hours.perform(ViewActions.typeText("5"), ViewActions.closeSoftKeyboard())
        Thread.sleep(1000)
        hours.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Thread.sleep(3000)


        val minutes = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.editTextMinutes),
                ViewMatchers.isDisplayed()
            )
        )

        minutes.perform(ViewActions.typeText("25"), ViewActions.closeSoftKeyboard())
        Thread.sleep(1000)
        minutes.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Thread.sleep(3000)

        val boton = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.buttonSave),
                ViewMatchers.isDisplayed()
            )
        )
        boton.perform(click())
        Thread.sleep(2000)


    }

    fun getRandomString(length: Int) : String {
        val charset = "ABCDEFGHIJKLMNOPQRSTUVWXTZabcdefghiklmnopqrstuvwxyz0123456789"
        return (1..length)
            .map { charset.random() }
            .joinToString("")
    }


    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }

}