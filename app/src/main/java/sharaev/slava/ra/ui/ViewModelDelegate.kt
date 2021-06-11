package sharaev.slava.ra.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class ViewModelDelegate<VM : ViewModel>(
    private val vmClass: Class<VM>,
    private val ownerProducer: () -> ViewModelStoreOwner,
    private val factoryProducer: () -> ViewModelProvider.Factory
) : ReadOnlyProperty<ViewModelStoreOwner, VM> {

    private var viewModel: VM? = null

    override fun getValue(thisRef: ViewModelStoreOwner, property: KProperty<*>): VM =
        viewModel ?: ViewModelProvider(ownerProducer(), factoryProducer())
            .get(vmClass)
            .also { viewModel = it }
}

inline fun <reified VM : ViewModel> BaseActivity.viewModels(
    noinline ownerProducer: () -> ViewModelStoreOwner = { this },
    noinline factoryProducer: () -> ViewModelProvider.Factory = { viewModelFactory }
): ViewModelDelegate<VM> =
    ViewModelDelegate(VM::class.java, ownerProducer, factoryProducer)
