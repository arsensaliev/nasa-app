package arsensaliev.io.nasaapp.mvp.view.earth

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface EarthView : MvpView {
    fun setImage(url: String)
    fun setDate(date: String)
    fun setLat(lat: String)
    fun setLon(lon: String)
}