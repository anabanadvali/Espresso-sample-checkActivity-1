package com.ghedamsisabri.ui_testing_for_beginner

import android.view.View
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.ghedamsisabri.ui_testing_for_beginner.Helper.getText
import com.ghedamsisabri.ui_testing_for_beginner.Helper.isTextOnScreen
import com.ghedamsisabri.ui_testing_for_beginner.Helper.isViewDisplayed
import com.ghedamsisabri.ui_testing_for_beginner.Helper.tap
import org.hamcrest.Matcher
import org.junit.Assert

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Rule
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText


@RunWith(AndroidJUnit4::class)
@LargeTest
class ExampleInstrumentedTest {

    @get:Rule
    var activityScenarioRule = activityScenarioRule<MainActivity>()


    @Test
    fun checkSecondPage() {
        onView(withText("Main Page")).check(matches(isDisplayed()))
        onView(NextBtn).perform(click())
        onView(secondPageActivity).check(matches(isDisplayed()))
        onView(withText("Second Page")).check(matches(isDisplayed()))
        Assert.assertEquals("Second Page", "Second Page")
    }

    @Test
    fun navigateToSecondPageAndBack() {
        onView(withText("Main Page")).check(matches(isDisplayed()))
        onView(NextBtn).perform(click())
        onView(secondPageActivity).check(matches(isDisplayed()))
        onView(withId(R.id.button_back)).perform(click())
        onView(withText("Main Page")).check(matches(isDisplayed()))
        onView(NextBtn).check(matches(isDisplayed()))
    }

    companion object {
        val NextBtn: Matcher<View> by lazy { withId(R.id.button_next_activity) }
        val secondPageActivity: Matcher<View> by lazy { withId(R.id.activity_secondary_title) }
    }
}
