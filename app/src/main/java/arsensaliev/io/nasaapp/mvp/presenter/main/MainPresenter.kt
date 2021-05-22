package arsensaliev.io.nasaapp.mvp.presenter.main

import arsensaliev.io.nasaapp.mvp.model.navigation.IScreens
import arsensaliev.io.nasaapp.mvp.view.main.MainView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import javax.inject.Inject

class MainPresenter : MvpPresenter<MainView>() {
    @Inject
    lateinit var router: Router

    @Inject
    lateinit var screens: IScreens

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screens.home())
    }

    fun backClicked() {
        router.exit()
    }
}
