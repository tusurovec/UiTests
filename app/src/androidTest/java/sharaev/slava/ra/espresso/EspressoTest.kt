package sharaev.slava.ra.espresso

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
import sharaev.slava.ra.espresso.screenobjects.screenObjectsUtils.waitForView
import sharaev.slava.ra.ui.LoginActivity

@RunWith(AndroidJUnit4::class)
class EspressoTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(LoginActivity::class.java)

    @Test
    fun checkLoginFieldDisplayed() {
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
    }

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
                        withText("LOGIN"),
                        isClickable()
                    )
                )
            )
    }

    @Test
    fun checkLoginInput() {
        onView(withId(R.id.login_et))
            .perform(click())
            .perform(typeText("admin"))
            .check(
                matches(
                    allOf(
                        withText("admin")
                    )
                )
            )
    }

    @Test
    fun checkPasswordInput() {
        onView(allOf(withHint("password"), isDescendantOfA(withId(R.id.password_input))))
            .perform(click())
            .perform(typeText("admin"))
            .check(
                matches(
                    allOf(
                        withText("admin")
                    )
                )
            )
    }

    @Test
    fun followToTransactionScreen() {
        onView(withId(R.id.login_et))
            .perform(click())
            .perform(typeText("admin"))
        onView(allOf(withHint("password"), isDescendantOfA(withId(R.id.password_input))))
            .perform(click())
            .perform(typeText("admin"))
        onView(withId(R.id.login_button))
            .perform(click())
        onView(isRoot()).perform(waitForView(R.id.transactions_rv, 10000))
        onView(withId(R.id.transactions_rv))
            .check(
                matches(
                    allOf(
                        isDisplayed()
                    )
                )
            )
    }
}