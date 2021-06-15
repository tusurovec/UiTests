package shatravin.espresso

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import sharaev.slava.ra.espresso.R
import sharaev.slava.ra.ui.LoginActivity

@RunWith(AndroidJUnit4::class)
class LoginTests {

    @get:Rule
    val activityRule = ActivityScenarioRule(LoginActivity::class.java)

    @Test
    fun checkPasswordFieldDisplayed() {
        Espresso.onView(ViewMatchers.withId(R.id.password_input))
            .check(
                ViewAssertions.matches(
                    Matchers.allOf(
                        ViewMatchers.isDisplayed(),
                        ViewMatchers.hasDescendant(
                            ViewMatchers.withHint("password")
                        )
                    )
                )
            )
    }

    @Test
    fun checkLoginButtonDisplayed() {
        Espresso.onView(ViewMatchers.withId(R.id.login_button))
            .check(
                ViewAssertions.matches(
                    Matchers.allOf(
                        ViewMatchers.isDisplayed(),
                        ViewMatchers.isEnabled(),
                        ViewMatchers.isClickable(),
                        ViewMatchers.withText("Login")
                    )
                )
            )
    }

    @Test
    fun checkLoginButtonLoginsWithLoginAndPassword() {
        Espresso.onView(
            Matchers.allOf(
                ViewMatchers.supportsInputMethods(),
                ViewMatchers.isDescendantOfA(ViewMatchers.withId(R.id.login_input)))
            )
            .check(
                ViewAssertions.matches(ViewMatchers.isDisplayed())
            )
            .perform(
                typeText("login")
            )

        Espresso.onView(
            Matchers.allOf(
                ViewMatchers.supportsInputMethods(),
                ViewMatchers.isDescendantOfA(ViewMatchers.withId(R.id.password_input)))
            )
            .check(
                ViewAssertions.matches(ViewMatchers.isDisplayed())
            )
            .perform(
                typeText("pwd")
            )

        Espresso.onView(ViewMatchers.withId(R.id.login_button))
            .perform(
                click()
            )

        Espresso.onView(ViewMatchers.withId(R.id.loading_view))
            .check(
                ViewAssertions.matches(
                    Matchers.allOf(
                        ViewMatchers.isDisplayed(),
                        ViewMatchers.withText(R.string.loading)
                    )
                )
            )
    }

    @Test
    fun checkLoginButtonKeepsLoginScreenIfLoginEmpty() {
        val password = "pwd"

        Espresso.onView(
            Matchers.allOf(
                ViewMatchers.supportsInputMethods(),
                ViewMatchers.isDescendantOfA(ViewMatchers.withId(R.id.password_input)))
            )
            .check(
                ViewAssertions.matches(ViewMatchers.isDisplayed())
            )
            .perform(
                typeText(password)
            )

        Espresso.onView(ViewMatchers.withId(R.id.login_button))
            .perform(
                click()
            )

        Espresso.onView(ViewMatchers.withId(R.id.login_input))
            .check(
                ViewAssertions.matches(
                    Matchers.allOf(
                        ViewMatchers.isDisplayed(),
                        ViewMatchers.hasDescendant(
                            ViewMatchers.withHint("login")
                        )
                    )
                )
            )

        Espresso.onView(ViewMatchers.withId(R.id.password_input))
            .check(
                ViewAssertions.matches(
                    Matchers.allOf(
                        ViewMatchers.isDisplayed(),
                        ViewMatchers.hasDescendant(
                            ViewMatchers.withText(password)
                        )
                    )
                )
            )
    }

    @Test
    fun checkLoginButtonLoginsIfPasswordEmpty() {

        Espresso.onView(
            Matchers.allOf(
                ViewMatchers.supportsInputMethods(),
                ViewMatchers.isDescendantOfA(ViewMatchers.withId(R.id.login_input)))
            )
            .check(
                ViewAssertions.matches(ViewMatchers.isDisplayed())
            )
            .perform(
                typeText("login")
            )

        Espresso.onView(ViewMatchers.withId(R.id.login_button))
            .perform(
                click()
            )

        Espresso.onView(ViewMatchers.withId(R.id.loading_view))
            .check(
                ViewAssertions.matches(
                    Matchers.allOf(
                        ViewMatchers.isDisplayed(),
                        ViewMatchers.withText(R.string.loading)
                    )
                )
            )
    }
}