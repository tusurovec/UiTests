package shatravin.espresso.screens

import android.view.View
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import sharaev.slava.ra.espresso.R

object MainScreen {

    private val loadingTextMatcher : Matcher<View> = ViewMatchers.withId(R.id.loading_view)

    fun checkIsLoadingTextVisible() {
        Espresso.onView(loadingTextMatcher)
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