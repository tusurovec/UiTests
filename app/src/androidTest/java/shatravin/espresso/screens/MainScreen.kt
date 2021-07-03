package shatravin.espresso.screens

import android.view.View
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import sharaev.slava.ra.espresso.R

object MainScreen {

    private val loadingTextMatcher : Matcher<View> = ViewMatchers.withId(R.id.loading_view)

    fun checkIsLoadingTextVisible() {
        onView(loadingTextMatcher)
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