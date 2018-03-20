package mgareta.themoviedb

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.closeSoftKeyboard
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import mgareta.themoviedb.base.BaseTest
import mgareta.themoviedb.base.Condition
import mgareta.themoviedb.ui.main.MainActivity
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by marc on 19/03/18.
 */

@RunWith(AndroidJUnit4::class)
class MainActivityTest : BaseTest() {

    @Rule
    @JvmField
    val mainActivityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    @Throws(InterruptedException::class)
    fun testMainActivityMovieList() {
        recyclerViewCheck(false)
    }

    @Test
    @Throws(InterruptedException::class)
    fun testMainActivitySearchMovieList() {

        // Type text on editText
        onView(withId(R.id.edit_text_search_movie))
                .perform(typeText("fifty"), closeSoftKeyboard())

        recyclerViewCheck(true)
    }

    private fun recyclerViewCheck(search: Boolean) {
        // Check that list adapter is set and populate
        val recyclerView = mainActivityRule.activity.findViewById<RecyclerView>(R.id.recycler_view_movie)

        waitForCondition(object : Condition {
            override val isSatisfied: Boolean
                get() = recyclerView.adapter != null
        }, 3000)

        Assert.assertNotNull(recyclerView)
        Assert.assertNotNull(recyclerView.adapter)

        onView(withId(R.id.recycler_view_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(recyclerView.adapter.itemCount - 1))

        Assert.assertNotSame(0, recyclerView.adapter.itemCount)
    }
}