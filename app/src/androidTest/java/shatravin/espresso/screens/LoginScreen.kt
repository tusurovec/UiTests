package shatravin.espresso.screens

import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import sharaev.slava.ra.espresso.R

object LoginScreen {

    private val loginInputViewMatcher : Matcher<View> = withId(R.id.login_input)
    private val passwordInputViewMatcher : Matcher<View> = withId(R.id.password_input)
    private val loginButtonViewMatcher : Matcher<View> = withId(R.id.login_button)

    fun checkLoginInputDisplayed() {
        onView(loginInputViewMatcher)
            .check(
                matches(
                    isDisplayed()
                )
            )
    }

    fun checkLoginInputHint(hint : String) {
        onView(loginInputViewMatcher)
            .check(
                matches(
                    allOf(
                        isDisplayed(),
                        hasDescendant(withHint(hint))
                    )
                )
            )
    }

    fun checkPasswordInputDisplayed() {
        onView(passwordInputViewMatcher)
            .check(
                matches(
                    isDisplayed()
                )
            )
    }


    fun checkPasswordInputText(text : String) {
        onView(passwordInputViewMatcher)
            .check(
                matches(
                    allOf(
                        isDisplayed(),
                        hasDescendant(withText(text))
                    )
                )
            )
    }

    fun checkPasswordInputHint(hint : String) {
        onView(passwordInputViewMatcher)
            .check(
                matches(
                    allOf(
                        isDisplayed(),
                        hasDescendant(withHint(hint))
                    )
                )
            )
    }


    fun checkLoginButtonDisplayed(text: String) {
        onView(loginButtonViewMatcher)
            .check(
                matches(
                    allOf(
                        isDisplayed(),
                        isEnabled(),
                        isClickable(),
                        withText(text)
                    )
                )
            )
    }

    fun clickLoginButton() {
        onView(loginButtonViewMatcher)
            .perform(
                ViewActions.click()
            )
    }

    fun typeLogin(text: String) {
        typeText(loginInputViewMatcher, text)
    }

    fun typePassword(text: String) {
        typeText(passwordInputViewMatcher, text)
    }

    private fun typeText(textInputMatcher : Matcher<View>, text: String) {
        getTextInputEditFieldInteraction(textInputMatcher)
            .check(
                matches(isDisplayed())
            )
            .perform(
                ViewActions.typeText(text)
            )
    }

    private fun getTextInputEditFieldInteraction(textInputMatcher : Matcher<View>) : ViewInteraction =
        onView(
            allOf(
                supportsInputMethods(),
                isDescendantOfA(textInputMatcher))
        )
}