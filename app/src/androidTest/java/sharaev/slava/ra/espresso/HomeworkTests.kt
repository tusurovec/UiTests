package sharaev.slava.ra.espresso

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import sharaev.slava.ra.ui.LoginActivity



@RunWith(AndroidJUnit4::class)
class HomeworkTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(LoginActivity::class.java)

    @Test
    fun checkLoginFieldDisplayed() {
        onView(withId(R.id.login_input))
            .check(
                ViewAssertions.matches(
                    allOf(
                        isDisplayed(),
                        hasDescendant(
                            withHint("login")
                        )
                    )
                )
            )
    }

    @Test
    fun checkPasswordFieldDisplayed() {
        onView(withId(R.id.password_input))
            .check(
                ViewAssertions.matches(
                    allOf(
                        isDisplayed(),
                        hasDescendant(
                            withHint("password")
                        )
                    )
                )
            )
    }

    @Test
    fun checkLoginButtonDisplayed() {
        onView(withId(R.id.login_button))
            .check(
                ViewAssertions.matches(
                    allOf(
                        isDisplayed(),
                        withText("Login")
                    )
                )
            )
    }

    @Test
    fun checkLoginFieldFilled() {
        onView(withId(R.id.login_et))
            .perform(click(), typeText("demo"), closeSoftKeyboard())
            .check(
                matches(
                    withText("demo")
                )
            )

    }

    @Test
    fun checkPasswordFieldFilled() {
        onView(withHint("password"))
            .perform(click(), typeText("demo"), closeSoftKeyboard())
            .check(
                matches(
                    withText("demo")
                )
            )

    }
}