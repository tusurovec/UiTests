package sharaev.slava.ra.ui.extension

import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import com.google.android.material.textfield.TextInputEditText
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class Binder<T>(
    scope: CoroutineScope,
    private val flow: MutableStateFlow<T>,
    private val setter: (T) -> Unit
) {

    private var settingValue = false

    init {
        flow.onEach { value ->
            if (!settingValue) {
                settingValue = true
                setter(value)
                settingValue = false
            }
        }
            .launchIn(scope)
    }

    fun setValue(value: T) {
        if (!settingValue) {
            settingValue = true
            flow.value = value
            settingValue = false
        }
    }
}

fun <T> MutableStateFlow<T>.bind(scope: CoroutineScope, setter: (T) -> Unit): Binder<T> =
    Binder(scope, this, setter)

fun MutableStateFlow<String>.bind(scope: CoroutineScope, editText: EditText) {
    val binder = bind(scope, editText::setText)
    editText.addTextChangedListener { binder.setValue(it.toString()) }
}

fun MutableStateFlow<String>.bind(scope: CoroutineScope, editText: TextInputEditText) {
    val binder = bind(scope, editText::setText)
    editText.addTextChangedListener { binder.setValue(it.toString()) }
}