package sharaev.slava.ra.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import sharaev.slava.ra.domain.entity.Balance
import sharaev.slava.ra.domain.entity.Transaction
import sharaev.slava.ra.domain.usecase.GetBalanceUseCase
import sharaev.slava.ra.domain.usecase.GetTransactionsUseCase
import javax.inject.Inject

sealed class State {
    object Loading : State()

    data class Content(val balance: Balance, val transactions: List<Transaction>) : State()
}

class MainViewModel @Inject constructor(
    private val getBalanceUseCase: GetBalanceUseCase,
    private val getTransactionsUseCase: GetTransactionsUseCase,
    val userName: String
) : ViewModel() {
    private val _state = MutableStateFlow<State>(State.Loading)
    val state = _state.asStateFlow()

    fun getBalance() {
        getBalanceUseCase()
            .zip(getTransactionsUseCase()) { balance, transactions -> balance to transactions }
            .onEach { (balance, transactions) ->
                _state.emit(State.Content(balance, transactions))
            }.launchIn(viewModelScope)
    }
}