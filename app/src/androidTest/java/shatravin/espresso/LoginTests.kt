package shatravin.espresso

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
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
class LoginTests {

    @get:Rule
    val activityRule = ActivityScenarioRule(LoginActivity::class.java)

    @Test
    fun checkPasswordFieldDisplayed() {
        onView(withId(R.id.password_input))
            .check(
                matches(
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
                matches(
                    allOf(
                        isDisplayed(),
                        isEnabled(),
                        isClickable(),
                        withText("Login")
                    )
                )
            )
    }

    @Test
    fun checkLoginButtonLoginsWithLoginAndPassword() {
        onView(
            allOf(
                supportsInputMethods(),
                isDescendantOfA(withId(R.id.login_input)))
            )
            .check(
                matches(isDisplayed())
            )
            .perform(
                typeText("login")
            )

        onView(
            allOf(
                supportsInputMethods(),
                isDescendantOfA(withId(R.id.password_input)))
            )
            .check(
                matches(isDisplayed())
            )
            .perform(
                typeText("pwd")
            )

        onView(withId(R.id.login_button))
            .perform(
                click()
            )

        onView(withId(R.id.loading_view))
            .check(
                matches(
                    allOf(
                        isDisplayed(),
                        withText(R.string.loading)
                    )
                )
            )
    }

    @Test
    fun checkLoginButtonKeepsLoginScreenIfLoginEmpty() {
        onView(
            allOf(
                supportsInputMethods(),
                isDescendantOfA(withId(R.id.password_input)))
            )
            .check(
                matches(isDisplayed())
            )
            .perform(
                typeText("pwd")
            )

        onView(withId(R.id.login_button))
            .perform(
                click()
            )

        onView(withId(R.id.login_input))
            .check(
                matches(
                    allOf(
                        isDisplayed(),
                        hasDescendant(
                            withHint("login")
                        )
                    )
                )
            )

        onView(withId(R.id.password_input))
            .check(
                matches(
                    allOf(
                        isDisplayed(),
                        hasDescendant(
                            withText("pwd")
                        )
                    )
                )
            )
    }

    @Test
    fun checkLoginButtonLoginsIfPasswordEmpty() {

        onView(
            allOf(
                supportsInputMethods(),
                isDescendantOfA(withId(R.id.login_input)))
            )
            .check(
                matches(isDisplayed())
            )
            .perform(
                typeText("login")
            )

        onView(withId(R.id.login_button))
            .perform(
                click()
            )

        onView(withId(R.id.loading_view))
            .check(
                matches(
                    allOf(
                        isDisplayed(),
                        withText(R.string.loading)
                    )
                )
            )
    }
}