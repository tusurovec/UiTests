package sharaev.slava.ra.espresso.workshop03tests

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import sharaev.slava.ra.espresso.workshop03tests.screenobjects.LoginScreen
import sharaev.slava.ra.ui.LoginActivity

@RunWith(AndroidJUnit4::class)
class LoginActivitySoUITests {

    @get:Rule
    val activityRule = ActivityScenarioRule(LoginActivity::class.java)

    @Test
    fun checkLoginTextLayout() {
        LoginScreen.apply {
            checkLoginLayout()
            checkLoginTextInputHint("login")
            typeLogin("test login")
        }
    }

    @Test
    fun checkPasswordTExtLayout() {
        LoginScreen.apply {
            checkPasswordLayout()
            checkPasswordTextInput()
        }
    }

    @Test
    fun checkLoginButton() {
        LoginScreen.checkLoginButton("LOGIN")
    }

    @Test
    fun clickLoginButton() {
        LoginScreen.clickLoginButton()
    }
}