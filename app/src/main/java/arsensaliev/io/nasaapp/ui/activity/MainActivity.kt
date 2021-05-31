package arsensaliev.io.nasaapp.ui.activity

import android.os.Bundle
import arsensaliev.io.nasaapp.R
import arsensaliev.io.nasaapp.databinding.ActivityMainBinding
import arsensaliev.io.nasaapp.mvp.model.navigation.IScreens
import arsensaliev.io.nasaapp.mvp.presenter.main.MainPresenter
import arsensaliev.io.nasaapp.mvp.view.main.MainView
import arsensaliev.io.nasaapp.ui.App
import arsensaliev.io.nasaapp.ui.BackButtonListener
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.google.android.material.bottomnavigation.BottomNavigationView
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject

class MainActivity : MvpAppCompatActivity(), MainView {

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var screen: IScreens

    val navigator = AppNavigator(this, R.id.container)

    private val ui: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    @Inject
    @InjectPresenter
    lateinit var presenter: MainPresenter

    @ProvidePresenter
    fun provide() = presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ui.root)
        init()
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if (it is BackButtonListener && it.backPressed()) {
                return
            }
        }
        presenter.backClicked()
    }

    private fun init() {
        setBottomNavigationView()
    }

    private fun setBottomNavigationView() {
        val bottomNavigationView: BottomNavigationView = ui.bottomNavigationView
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.bottom_view_earth -> presenter.navigateTo(screen.earth())
                R.id.bottom_view_settings -> presenter.navigateTo(screen.settings())
                R.id.bottom_view_apod -> presenter.navigateTo(screen.apod())
                else -> presenter.navigateTo(screen.earth())
            }
        }
    }

    init {
        App.instance.appComponent.inject(this)
    }
}