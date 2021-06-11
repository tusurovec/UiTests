package sharaev.slava.ra.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import sharaev.slava.ra.App
import sharaev.slava.ra.espresso.R
import sharaev.slava.ra.presentation.MainViewModel
import sharaev.slava.ra.presentation.State
import sharaev.slava.ra.ui.adapter.TransactionsAdapter

const val KEY_LOGIN = "Login"

class MainActivity : BaseActivity() {

    companion object {

        fun getIntent(context: Context, login: String): Intent =
            Intent(context, MainActivity::class.java).apply {
                putExtra(KEY_LOGIN, login)
            }

    }

    private val viewModel: MainViewModel by viewModels()
    private val transactionsAdapter = TransactionsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        inject()
        initView()
        initViewModelListeners()

        viewModel.getBalance()
    }

    private fun inject() {
        val userName = requireNotNull(intent.getStringExtra(KEY_LOGIN))
        val loginComponent =
            (application as App).appComponent.mainComponent().create(userName = userName)
        loginComponent.inject(this)
    }

    private fun initView() {
        val greetingView = findViewById<TextView>(R.id.greeting_view)
        val transactionsView = findViewById<RecyclerView>(R.id.transactions_rv)
        greetingView.text = getString(R.string.main_greeting, viewModel.userName)
        transactionsView.adapter = transactionsAdapter
    }

    private fun initViewModelListeners() {
        viewModel.state.onEach {
            renderState(it)
        }.launchIn(lifecycleScope)
    }

    private fun renderState(state: State) {
        val progressView = findViewById<View>(R.id.loading_view)
        val balanceView = findViewById<TextView>(R.id.balance_view)
        when (state) {
            State.Loading    -> progressView.visibility = View.VISIBLE

            is State.Content -> {
                progressView.visibility = View.GONE
                balanceView.text = getString(
                    R.string.main_balance,
                    state.balance.amount,
                    state.balance.currency.value
                )

                transactionsAdapter.transactions = state.transactions
            }
        }
    }
}