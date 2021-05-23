package arsensaliev.io.nasaapp.mvp.view.home

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface HomeView : MvpView {
    fun setImage(url: String)
    fun setDescription(text: String)
    fun setTitle(text: String)
}