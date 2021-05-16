package arsensaliev.io.nasaapp.ui.activity

import android.os.Bundle
import arsensaliev.io.nasaapp.R
import arsensaliev.io.nasaapp.mvp.view.activity.MainActivityView
import com.github.terrakok.cicerone.NavigatorHolder
import moxy.MvpAppCompatActivity
import javax.inject.Inject

class MainActivity : MvpAppCompatActivity(), MainActivityView {

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}