package sharaev.slava.ra.ui

import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import sharaev.slava.ra.App
import sharaev.slava.ra.espresso.R
import sharaev.slava.ra.presentation.Event
import sharaev.slava.ra.presentation.LoginViewModel
import sharaev.slava.ra.ui.extension.bind

class LoginActivity : BaseActivity() {

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        val loginComponent = (application as App).appComponent.loginComponent().create()
        loginComponent.inject(this)

        initListeners()
    }

    private fun initListeners() {
        val loginInput = findViewById<TextInputEditText>(R.id.login_et)
        viewModel.login.bind(lifecycleScope, loginInput)

        val loginButton = findViewById<MaterialButton>(R.id.login_button)
        loginButton.setOnClickListener {
            viewModel.doLogin()
        }
        viewModel.events.onEach { handleEvent(it) }.launchIn(lifecycleScope)
    }

    private fun handleEvent(event: Event) {
        when (event) {
            is Event.OpenMain -> startActivity(MainActivity.getIntent(this, event.login))
        }
    }
}