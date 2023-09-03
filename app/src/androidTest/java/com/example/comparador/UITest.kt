package com.example.comparador

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UITest {

    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity> = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testUI() {
        // Ingresa texto en los EditText
        onView(withId(R.id.editText1)).perform(typeText("Texto igual"))
        onView(withId(R.id.editText2)).perform(typeText("Texto igual"), closeSoftKeyboard())

        // Presiona el botón "Comparar"
        onView(withId(R.id.compareButton)).perform(click())

        // Verifica que el resultado se muestre correctamente en el TextView
        onView(withId(R.id.resultTextView)).check(matches(withText("Los textos son iguales")))
    }
}




