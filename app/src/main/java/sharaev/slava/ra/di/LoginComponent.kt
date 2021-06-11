package sharaev.slava.ra.di

import dagger.Subcomponent
import sharaev.slava.ra.ui.LoginActivity

@ActivityScope
@Subcomponent(modules = [LoginModule::class])
interface LoginComponent {

    // Factory to create instances of LoginComponent
    @Subcomponent.Factory
    interface Factory {
        fun create(): LoginComponent
    }

    // Classes that can be injected by this Component
    fun inject(activity: LoginActivity)
}