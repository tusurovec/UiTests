package sharaev.slava.ra.espresso.screenobjects

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.Matchers.*
import sharaev.slava.ra.espresso.R
import sharaev.slava.ra.espresso.screenobjects.screenObjectsUtils.layoutOrTextViewWithHint

object LoginScreen {

    fun checkLoginLayout() {
        onView(withId(R.id.login_input))
            .check(
                matches(
                    allOf(
                        isDisplayed(),
                        hasDescendant(
                            withId(R.id.login_et)
                        )
                    )
                )
            )
    }

    fun checkLoginHint(hint: String) {
        onView(withId(R.id.login_et))
            .check(
                matches(
                    allOf(
                        isDisplayed(),
                        withHint(hint)
                    )
                )
            )
    }

    fun checkLoginInput(text: String) {
        onView(withId(R.id.login_et))
            .perform(typeText(text))
            .check(
                matches(
                    allOf(
                        isDisplayed(),
                        withText(text)
                    )
                )
            )
    }

    fun checkPasswordLayout() {
        onView(withId(R.id.password_input))
            .check(
                matches(layoutOrTextViewWithHint("password"))
            )
    }

    fun checkPasswordHint(hint: String) {
        onView(withChild(withHint(hint)))
            .check(
                matches(
                    allOf(
                        isDisplayed()
                    )
                )
            )
    }

    fun checkPasswordInput(text: String) {
        onView(allOf(withHint("password"), isDescendantOfA(withId(R.id.password_input))))
            .perform(ViewActions.click())
            .perform(typeText(text))
            .check(
                matches(
                    allOf(
                        withText(text)
                    )
                )
            )
    }

    fun checkLoginButton(buttonText: String) {
        onView(withId(R.id.login_button))
            .check(
                matches(
                    allOf(
                        isDisplayed(),
                        withText(buttonText)
                    )
                )
            )
    }
}