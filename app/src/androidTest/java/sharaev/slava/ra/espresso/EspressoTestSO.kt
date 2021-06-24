package sharaev.slava.ra.espresso

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import sharaev.slava.ra.espresso.screenobjects.LoginScreen
import sharaev.slava.ra.ui.LoginActivity

@RunWith(AndroidJUnit4::class)
class EspressoTestSO {

    @get:Rule
    val activityRule = ActivityScenarioRule(LoginActivity::class.java)

    @Test
    fun checkLogin() {
        LoginScreen.apply {
            checkLoginLayout()
            checkLoginHint("login")
            checkLoginInput("admin")
        }
    }

    @Test
    fun checkPassword() {
        LoginScreen.apply {
            checkPasswordLayout()
            checkPasswordHint("password")
            checkPasswordInput("admin")
        }
    }

    @Test
    fun checkLoginButtonTextAndVisibility() {
        LoginScreen.apply {
            checkLoginButton("LOGIN")
        }
    }
}