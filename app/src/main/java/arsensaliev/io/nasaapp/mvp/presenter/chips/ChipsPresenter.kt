package arsensaliev.io.nasaapp.mvp.presenter.chips

import arsensaliev.io.nasaapp.mvp.view.chips.ChipsView
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import javax.inject.Inject

class ChipsPresenter @Inject constructor(
    private val router: Router
) : MvpPresenter<ChipsView>() {

    fun backClick(): Boolean {
        router.exit()
        return true
    }
}