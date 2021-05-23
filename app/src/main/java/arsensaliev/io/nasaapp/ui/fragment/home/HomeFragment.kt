package arsensaliev.io.nasaapp.ui.fragment.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import arsensaliev.io.nasaapp.R
import arsensaliev.io.nasaapp.databinding.FragmentHomeBinding
import arsensaliev.io.nasaapp.mvp.presenter.home.HomePresenter
import arsensaliev.io.nasaapp.mvp.view.home.HomeView
import arsensaliev.io.nasaapp.ui.App
import arsensaliev.io.nasaapp.ui.BackButtonListener
import coil.load
import com.google.android.material.bottomsheet.BottomSheetBehavior
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

    private var ui: FragmentHomeBinding? = null
    lateinit var bottomSheetUi: ConstraintLayout

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentHomeBinding.inflate(inflater, container, false).also { ui = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bottomSheetUi = view.findViewById(R.id.bottom_sheet_container)
        setBottomSheetBehavior(bottomSheetUi)
        setOnClickBtnFilter(view)
        ui?.inputLayout?.setEndIconOnClickListener { searchWiki() }
    }

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

    override fun setDescription(text: String) {
        bottomSheetUi.findViewById<TextView>(R.id.bottom_sheet_description).text = text
    }

    override fun setTitle(text: String) {
        bottomSheetUi.findViewById<TextView>(R.id.bottom_sheet_description_header).text = text
    }

    fun searchWiki() {
        val wikiText = ui?.inputEditText?.text.toString()
        startActivity(Intent(Intent.ACTION_VIEW).apply {
            data =
                Uri.parse("https://en.wikipedia.org/wiki/${wikiText}")
        })
    }

    private fun setBottomSheetBehavior(bottomSheet: ConstraintLayout) {
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
    }

    fun setOnClickBtnFilter(view: View) {
        view.findViewById<Button>(R.id.btn_open_filter).setOnClickListener {
            presenter.openFilterPage()
        }
    }

    init {
        App.instance.appComponent.inject(this)
    }
}