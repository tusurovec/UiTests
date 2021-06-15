package shatravin.espresso

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import sharaev.slava.ra.ui.LoginActivity
import shatravin.espresso.screens.LoginScreen
import shatravin.espresso.screens.MainScreen

@RunWith(AndroidJUnit4::class)
class LoginScreenObjectTests {

    @get:Rule
    val activityRule = ActivityScenarioRule(LoginActivity::class.java)

    @Test
    fun checkLoginFieldDisplayed() {
        LoginScreen.checkLoginInputDisplayed(hint = "login")
    }

    @Test
    fun checkPasswordFieldDisplayed() {
        LoginScreen.checkPasswordInputDisplayed(hint = "password")
    }

    @Test
    fun checkLoginButtonDisplayed() {
        LoginScreen.checkLoginButtonDisplayed("Login")
    }

    @Test
    fun checkLoginButtonLoginsWithLoginAndPassword() {
        LoginScreen.typeLogin("login")
        LoginScreen.typePassword("pwd")
        LoginScreen.clickLoginButton()
        MainScreen.checkIsLoadingTextVisible()
    }

    @Test
    fun checkLoginButtonKeepsLoginScreenIfLoginEmpty() {
        val password = "pwd"
        LoginScreen.typePassword(password)
        LoginScreen.clickLoginButton()
        LoginScreen.checkLoginInputDisplayed(hint = "login")
        LoginScreen.checkPasswordInputDisplayed(text = password)
    }

    @Test
    fun checkLoginButtonLoginsIfPasswordEmpty() {
        LoginScreen.typeLogin("login")
        LoginScreen.clickLoginButton()
        MainScreen.checkIsLoadingTextVisible()
    }
}