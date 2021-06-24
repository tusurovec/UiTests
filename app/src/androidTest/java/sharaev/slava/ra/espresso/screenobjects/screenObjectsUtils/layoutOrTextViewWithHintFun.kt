package sharaev.slava.ra.espresso.screenobjects.screenObjectsUtils

import android.view.View
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout
import org.hamcrest.Description
import org.hamcrest.TypeSafeMatcher

fun layoutOrTextViewWithHint(expected: String) = object : TypeSafeMatcher<View>() {
    override fun describeTo(description: Description) {
        description.appendText("TextView or TextInputLayout with hint '$expected'")
    }

    override fun matchesSafely(item: View?) =
        item is TextInputLayout && expected == item.hint || item is TextView && expected == item.hint
}