package com.example.listascompra


import android.widget.ImageView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
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
    fun textViewProductosTest() {
        val textViewProductos = onView(
            allOf(
                withId(R.id.textViewMainActivityProductos),
                isDisplayed()
            )
        )
        textViewProductos.check(matches(withText("Productos")))
    }

    @Test
    fun textViewListasTest() {
        val textViewListas = onView(
            allOf(
                withId(R.id.textViewMainActivityLista),
                isDisplayed()
            )
        )
        textViewListas.check(matches(withText("Listas")))

    }

    @Test
    fun imageviewProductosTest() {
        val imageviewProductos = onView(
            allOf(
                withId(R.id.imageViewProductos),
                isDisplayed()
            )
        )
        imageviewProductos.check(matches(isDisplayed()))

    }

    @Test
    fun imageviewListasTest() {
        val imageviewListas = onView(
            allOf(
                withId(R.id.imageViewListas),
                isDisplayed()
            )
        )
        imageviewListas.check(matches(isDisplayed()))
    }
}
