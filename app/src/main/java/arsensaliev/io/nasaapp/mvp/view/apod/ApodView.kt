package arsensaliev.io.nasaapp.mvp.view.apod

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface ApodView : MvpView {
    fun setImage(url: String)
    fun setTitle(title: String)
    fun setDescription(description: String)
    fun startAnimation()
}