package sharaev.slava.ra.espresso.workshop03tests

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import sharaev.slava.ra.espresso.R
import sharaev.slava.ra.ui.LoginActivity

@RunWith(AndroidJUnit4::class)
class LoginActivityUITests {

    @get:Rule
    val activityRule = ActivityScenarioRule(LoginActivity::class.java)

    @Test
    fun checkLoginLayout() {
        onView(withId(R.id.login_input))
            .check(
                ViewAssertions.matches(
                    allOf(
                        isDisplayed(),
                        hasDescendant(
                            withId(R.id.login_et)
                        )
                    )
                )
            )
    }

    @Test
    fun checkLoginTextInputHint() {
        onView(withId(R.id.login_et))
            .check(
                ViewAssertions.matches(
                    allOf(
                        isDisplayed(),
                        withHint("login")
                    )
                )
            )
    }

    @Test
    fun typeLogin() {
        onView(withId(R.id.login_et))
            .perform(
                typeText("Test_login")
            )
    }

    @Test
    fun checkPasswordLayout() {
        onView((withChild(withHint("password"))))
            .check(
                ViewAssertions.matches(
                    isDisplayed()
                )
            )
    }

    @Test
    fun checkPasswordTextInput() {
        onView(withParent(withId(R.id.password_input)))
            .check(
                ViewAssertions.matches(
                    isDisplayed()
                )
            )
    }

    @Test
    fun checkLoginButton() {
        onView(withId(R.id.login_button))
            .check(
                ViewAssertions.matches(
                    allOf(
                        isDisplayed(),
                        withText("LOGIN"),
                        isClickable(),

                    )
                )
            )
    }

    @Test
    fun clickLoginButton() {
        onView(withId(R.id.login_button))
            .perform(
                click()
            )
    }
}