package sharaev.slava.ra.di

import dagger.BindsInstance
import dagger.Subcomponent
import sharaev.slava.ra.ui.MainActivity

@ActivityScope
@Subcomponent(modules = [MainModule::class])
interface MainComponent {

    // Factory to create instances of LoginComponent
    @Subcomponent.Factory
    interface Factory {
        fun create(@BindsInstance userName: String): MainComponent
    }

    // Classes that can be injected by this Component
    fun inject(activity: MainActivity)
}