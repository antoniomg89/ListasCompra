package com.example.listascompra


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.containsString
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun mainActivityTest() {
        val textView = onView(
            allOf(
                withId(R.id.textViewMainActivityProductos),
                //withText("CY8RReL7orU5fFqSniLIVfAGf822"),
                ViewMatchers.withParent(ViewMatchers.withParent(withId(android.R.id.content))),
                ViewMatchers.isDisplayed()
            )
        )
        //textView.check(matches(withText(containsString("Productos"))))
        textView.check(matches(withText("Productos")))
    }
}
