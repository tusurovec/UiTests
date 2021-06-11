package sharaev.slava.ra.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class Event {

    //don't do that in real life; Use router =)
    data class OpenMain(val login: String) : Event()
}

class LoginViewModel @Inject constructor() : ViewModel() {

    val login = MutableStateFlow("")
    val password = MutableStateFlow("")

    private val eventChannel = Channel<Event>(Channel.BUFFERED)
    val events = eventChannel.receiveAsFlow()

    fun doLogin() {
        if (login.value.isNotEmpty()) {
            viewModelScope.launch {
                eventChannel.send(Event.OpenMain(login = login.value))
            }
        }
    }
}