package sharaev.slava.ra.ui

import androidx.appcompat.app.AppCompatActivity
import javax.inject.Inject

open class BaseActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
}