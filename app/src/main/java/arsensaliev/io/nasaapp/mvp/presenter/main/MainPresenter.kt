package arsensaliev.io.nasaapp.mvp.presenter.main

import arsensaliev.io.nasaapp.mvp.model.navigation.IScreens
import arsensaliev.io.nasaapp.mvp.view.main.MainView
import arsensaliev.io.nasaapp.ui.App
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.Screen
import moxy.MvpPresenter
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val router: Router,
    private val screens: IScreens
) : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screens.earth())
    }

    fun backClicked() {
        router.exit()
    }

    fun navigateTo(screen: Screen): Boolean {
        router.navigateTo(screen)
        return true
    }

    init {
        App.instance.appComponent.inject(this)
    }
}
