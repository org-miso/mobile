package com.vinyls.mobile

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.vinyls.mobile.view.AlbumCreateActivity
import org.hamcrest.Matchers
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.anything
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class AlbumCreateActivityTest {

    @get:Rule
    val activityRule = ActivityTestRule(AlbumCreateActivity::class.java)

    @Test
    fun testCreateAlbum(){
        Thread.sleep(5500)

        val nombre = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.edtiTextName),
                ViewMatchers.isDisplayed()
            )
        )

        nombre.perform(ViewActions.typeText(getRandomString(20)),closeSoftKeyboard())
        Thread.sleep(1000)
        nombre.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Thread.sleep(3000)

        val fecha = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.editTextDate),
                ViewMatchers.isDisplayed()
            )
        )

        fecha.perform(ViewActions.typeText("2022-11-16"),closeSoftKeyboard())
        Thread.sleep(1000)
        fecha.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Thread.sleep(3000)


        val cover = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.editTextCover),
                ViewMatchers.isDisplayed()
            )
        )

        cover.perform(ViewActions.typeText(getRandomString(20)),closeSoftKeyboard())
        Thread.sleep(1000)
        cover.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Thread.sleep(3000)


        val description = Espresso.onView(
            Matchers.allOf(
                ViewMatchers.withId(R.id.editTextDescription),
                ViewMatchers.isDisplayed()
            )
        )

        description.perform(ViewActions.typeText(getRandomString(20)),closeSoftKeyboard())
        Thread.sleep(1000)
        description.check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Thread.sleep(3000)

        onData(anything()).inAdapterView(withId(R.id.editTextGenre)).atPosition(2).perform(click())
        Thread.sleep(4000)

        val boton = onView(
            allOf(
                withId(R.id.buttonSave),
                isDisplayed()
            )
        )

        /*
        boton.perform(click())
        Thread.sleep(2000)
         */
    }


    fun getRandomString(length: Int) : String {
        val charset = "ABCDEFGHIJKLMNOPQRSTUVWXTZabcdefghiklmnopqrstuvwxyz0123456789"
        return (1..length)
            .map { charset.random() }
            .joinToString("")
    }
}