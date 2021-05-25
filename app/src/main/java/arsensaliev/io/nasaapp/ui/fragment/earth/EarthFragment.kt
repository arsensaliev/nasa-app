package arsensaliev.io.nasaapp.ui.fragment.earth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import arsensaliev.io.nasaapp.R
import arsensaliev.io.nasaapp.databinding.FragmentEarthBinding
import arsensaliev.io.nasaapp.mvp.presenter.earth.EarthPresenter
import arsensaliev.io.nasaapp.mvp.view.earth.EarthView
import arsensaliev.io.nasaapp.ui.App
import arsensaliev.io.nasaapp.ui.BackButtonListener
import coil.load
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject

class EarthFragment : MvpAppCompatFragment(), EarthView, BackButtonListener {
    @Inject
    @InjectPresenter
    lateinit var presenter: EarthPresenter

    @ProvidePresenter
    fun provide() = presenter

    private var ui: FragmentEarthBinding? = null


    override fun setImage(url: String) {
        ui?.imageView?.load(url) {
            lifecycle(this@EarthFragment)
            error(R.drawable.ic_error)
            placeholder(R.drawable.ic_no_photo_vector)
        }
    }

    override fun setDate(date: String) {
        TODO("Not yet implemented")
    }

    override fun setLat(lat: String) {
        TODO("Not yet implemented")
    }

    override fun setLon(lon: String) {
        TODO("Not yet implemented")
    }

    override fun backPressed(): Boolean = presenter.backClick()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentEarthBinding.inflate(inflater, container, false).also { ui = it }.root


    override fun onDestroyView() {
        super.onDestroyView()
        ui = null
    }

    companion object {
        fun newInstance() = EarthFragment().apply {}
    }

    init {
        App.instance.appComponent.inject(this)
    }
}