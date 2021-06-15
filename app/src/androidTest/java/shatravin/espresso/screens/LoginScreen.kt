package shatravin.espresso.screens

import android.view.View
import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import sharaev.slava.ra.espresso.R

object LoginScreen {

    private val loginInputViewMatcher : Matcher<View> = ViewMatchers.withId(R.id.login_input)
    private val passwordInputViewMatcher : Matcher<View> = ViewMatchers.withId(R.id.password_input)
    private val loginButtonViewMatcher : Matcher<View> = ViewMatchers.withId(R.id.login_button)

    fun checkLoginInputDisplayed(text: String? = null, hint : String? = null) {
        val loginInteraction = Espresso.onView(loginInputViewMatcher)
        val matchers = mutableListOf<Matcher<View>>(ViewMatchers.isDisplayed())

        if(hint != null) {
            matchers.add(getTextInputHintMatcher(hint))
        }

        if(text != null) {
            matchers.add(getTextInputTextMatcher(text))
        }

        loginInteraction
            .check(
                ViewAssertions.matches(
                    Matchers.allOf(matchers)
                )
            )
    }

    fun checkPasswordInputDisplayed(text : String? = null, hint : String? = null) {
        val passwordInteraction = Espresso.onView(passwordInputViewMatcher)
        val matchers = mutableListOf<Matcher<View>>(ViewMatchers.isDisplayed())

        if(hint != null) {
            matchers.add(getTextInputHintMatcher(hint))
        }

        if(text != null) {
            matchers.add(getTextInputTextMatcher(text))
        }

        passwordInteraction
            .check(
                ViewAssertions.matches(
                    Matchers.allOf(matchers)
                )
            )
    }

    fun checkLoginButtonDisplayed(text: String? = null) {
        val loginButtonInteraction = Espresso.onView(loginButtonViewMatcher)
        val matchers = mutableListOf<Matcher<View>>(
            ViewMatchers.isDisplayed(),
            ViewMatchers.isEnabled(),
            ViewMatchers.isClickable()
        )

        if(text != null) {
            matchers.add(ViewMatchers.withText(text))
        }

        loginButtonInteraction
            .check(
                ViewAssertions.matches(
                    Matchers.allOf(matchers)
                )
            )
    }

    fun clickLoginButton() {
        Espresso.onView(loginButtonViewMatcher)
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
                ViewAssertions.matches(ViewMatchers.isDisplayed())
            )
            .perform(
                ViewActions.typeText(text)
            )
    }

    private fun getTextInputEditFieldInteraction(textInputMatcher : Matcher<View>) : ViewInteraction =
        Espresso.onView(
            Matchers.allOf(
                ViewMatchers.supportsInputMethods(),
                ViewMatchers.isDescendantOfA(textInputMatcher))
        )

    private fun getTextInputHintMatcher(hint: String) : Matcher<View> = ViewMatchers.hasDescendant(ViewMatchers.withHint(hint))
    private fun getTextInputTextMatcher(text: String) : Matcher<View> = ViewMatchers.hasDescendant(ViewMatchers.withText(text))
}