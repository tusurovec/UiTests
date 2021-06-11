package sharaev.slava.ra

import android.app.Application
import sharaev.slava.ra.di.AppComponent
import sharaev.slava.ra.di.DaggerAppComponent

open class App : Application() {

    // Instance of the AppComponent that will be used by all the Activities in the project
    val appComponent: AppComponent by lazy {
        // Creates an instance of AppComponent using its Factory constructor
        // We pass the applicationContext that will be used as Context in the graph
        DaggerAppComponent.factory().create(applicationContext)
    }
}
