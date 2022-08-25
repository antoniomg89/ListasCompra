package com.example.listascompra


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginActivityTest {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(LoginActivity::class.java)

    @Test
    fun loginActivityTest() {
        val appCompatEditText = onView(withId(R.id.textview_username))
        appCompatEditText.perform(replaceText("testuser@listascompra.app"), closeSoftKeyboard())

        val appCompatEditText2 = onView(withId(R.id.textview_password))
        appCompatEditText2.perform(replaceText("ctrtestuser"), closeSoftKeyboard())

        val materialButton = onView(withId(R.id.button_login))
        materialButton.perform(click())
    }
}
