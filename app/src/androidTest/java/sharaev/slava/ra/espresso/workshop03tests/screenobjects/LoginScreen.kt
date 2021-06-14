package sharaev.slava.ra.espresso.workshop03tests.screenobjects

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matchers
import org.junit.Test
import sharaev.slava.ra.espresso.R

object LoginScreen {

    fun checkLoginLayout() {
        Espresso.onView(ViewMatchers.withId(R.id.login_input))
            .check(
                ViewAssertions.matches(
                    Matchers.allOf(
                        ViewMatchers.isDisplayed(),
                        ViewMatchers.hasDescendant(
                            ViewMatchers.withId(R.id.login_et)
                        )
                    )
                )
            )
    }

    fun checkLoginTextInputHint(hint : String) {
        Espresso.onView(ViewMatchers.withId(R.id.login_et))
            .check(
                ViewAssertions.matches(
                    Matchers.allOf(
                        ViewMatchers.isDisplayed(),
                        ViewMatchers.withHint(hint)
                    )
                )
            )
    }

    fun typeLogin(text: String) {
        Espresso.onView(ViewMatchers.withId(R.id.login_et))
            .perform(
                ViewActions.typeText(text)
            )
    }

    fun checkPasswordLayout() {
        Espresso.onView((ViewMatchers.withChild(ViewMatchers.withHint("password"))))
            .check(
                ViewAssertions.matches(
                    ViewMatchers.isDisplayed()
                )
            )
    }

    fun checkPasswordTextInput() {
        Espresso.onView(ViewMatchers.withParent(ViewMatchers.withId(R.id.password_input)))
            .check(
                ViewAssertions.matches(
                    ViewMatchers.isDisplayed()
                )
            )
    }

    fun checkLoginButton(buttonText: String) {
        Espresso.onView(ViewMatchers.withId(R.id.login_button))
            .check(
                ViewAssertions.matches(
                    Matchers.allOf(
                        ViewMatchers.isDisplayed(),
                        ViewMatchers.withText(buttonText)
                    )
                )
            )
    }

    fun clickLoginButton() {
        Espresso.onView(ViewMatchers.withId(R.id.login_button))
            .perform(
                ViewActions.click()
            )
    }
}