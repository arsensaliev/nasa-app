package arsensaliev.io.nasaapp.ui.fragment.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import arsensaliev.io.nasaapp.R
import arsensaliev.io.nasaapp.databinding.FragmentHomeBinding
import arsensaliev.io.nasaapp.mvp.presenter.home.HomePresenter
import arsensaliev.io.nasaapp.mvp.view.home.HomeView
import arsensaliev.io.nasaapp.ui.App
import arsensaliev.io.nasaapp.ui.BackButtonListener
import coil.load
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject

class HomeFragment : MvpAppCompatFragment(), HomeView, BackButtonListener {
    @Inject
    @InjectPresenter
    lateinit var presenter: HomePresenter

    @ProvidePresenter
    fun provide() = presenter

    init {
        App.instance.appComponent.inject(this)
    }

    private var ui: FragmentHomeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentHomeBinding.inflate(inflater, container, false).also { ui = it }.root

    override fun onDestroyView() {
        super.onDestroyView()
        ui = null
    }

    override fun backPressed(): Boolean = presenter.backClick()

    companion object {
        fun newInstance() = HomeFragment().apply {}
    }

    override fun setImage(url: String) {
        ui?.imageView?.load(url) {
            lifecycle(this@HomeFragment)
            error(R.drawable.ic_baseline_error_outline_24)
            placeholder(R.drawable.ic_image)
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ui?.inputLayout?.setEndIconOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW).apply {
                data =
                    Uri.parse("https://en.wikipedia.org/wiki/${ui?.inputEditText?.text.toString()}")
            })
        }

    }
}