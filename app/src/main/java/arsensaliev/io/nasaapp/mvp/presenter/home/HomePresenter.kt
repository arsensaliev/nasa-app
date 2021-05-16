package arsensaliev.io.movieapp.mvp.presenter.main

import arsensaliev.io.movieapp.mvp.model.navigation.IScreens
import arsensaliev.io.nasaapp.mvp.view.fragment.home.HomeView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import javax.inject.Inject

class HomePresenter : MvpPresenter<HomeView>() {
    @Inject
    lateinit var router: Router

    @Inject
    lateinit var screens: IScreens

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screens.main())
    }

    fun backClicked() {
        router.exit()
    }
}
